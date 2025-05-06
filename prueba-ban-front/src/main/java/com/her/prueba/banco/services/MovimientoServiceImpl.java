package com.her.prueba.banco.services;

import com.her.prueba.banco.dtos.MovimientoInternoDto;
import com.her.prueba.banco.models.entity.Movimiento;
import com.her.prueba.banco.models.entity.Usuario;
import com.her.prueba.banco.models.repository.MovimientoRepository;
import com.her.prueba.banco.services.common.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.ibm.icu.text.RuleBasedNumberFormat;
import java.math.BigDecimal;
import java.util.Locale;


@Service
public class MovimientoServiceImpl extends CommonServiceImpl<Movimiento, MovimientoRepository> implements MovimientoService {

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    @Override
    public MovimientoInternoDto crearTransaccion(String identiOrdenante, String identiBeneficiario, BigDecimal valor) {

        Usuario ordenante = usuarioService.findByCodigo(identiOrdenante);
        Usuario beneficiario = usuarioService.findByCodigo(identiBeneficiario);
        if (ordenante == null || beneficiario == null) {
            return MovimientoInternoDto.builder()
                    .codError("002")
                    .descError("Usuario no encontrado")
                    .build();
        } else if (valor.compareTo(new BigDecimal(500)) > 0) {
            return MovimientoInternoDto.builder()
                    .codError("003")
                    .descError("Valor a transferir no debe ser mayor que 500")
                    .build();
        }
        Long idTransaccion = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        Movimiento movOrdenante = new Movimiento();
        movOrdenante.setTipoMovimiento("D");
        movOrdenante.setDescripcion("Transferencia interna");
        movOrdenante.setValor(valor);
        movOrdenante.setCuenta(ordenante.getCuentas().get(0));
        movOrdenante.setCodTransaccion(idTransaccion);
        Movimiento movBeneficiario = new Movimiento();
        movBeneficiario.setTipoMovimiento("C");
        movBeneficiario.setDescripcion("Transferencia interna");
        movBeneficiario.setValor(valor);
        movBeneficiario.setCuenta(beneficiario.getCuentas().get(0));
        movBeneficiario.setCodTransaccion(idTransaccion);
        repository.save(movOrdenante);
        repository.save(movBeneficiario);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return MovimientoInternoDto.builder()
                .fecha(movBeneficiario.getCreateAt().format(formatter))
                .ctaBeneficiario(movBeneficiario.getCuenta().getNumeroCuenta())
                .ctaOrdenante(movOrdenante.getCuenta().getNumeroCuenta())
                .nomBeneficiario(beneficiario.getApellido().concat(" ").concat(beneficiario.getNombre()))
                .nomOrdenante(ordenante.getApellido().concat(" ").concat(ordenante.getNombre()))
                .mailBeneficiario("hernypatric77@gmail.com")
                .valor(valor)
                .valorTexto(numeroATexto(valor))
                .build();
    }

    private String numeroATexto(BigDecimal valor) {

        RuleBasedNumberFormat formato = new RuleBasedNumberFormat(new Locale("es", "ES"), RuleBasedNumberFormat.SPELLOUT);
        String parteEntera = formato.format(valor.intValue());
        int centavos = valor.remainder(BigDecimal.ONE).movePointRight(2).intValue();
        String parteDecimal = centavos > 0 ? " con " + formato.format(centavos) + " centavos" : "";

        return parteEntera + parteDecimal;
    }
}
