package com.her.prueba.banco.services;

import com.her.prueba.banco.dtos.MovimientoDto;
import com.her.prueba.banco.dtos.MovimientoDetalleDto;
import com.her.prueba.banco.models.entity.Usuario;
import com.her.prueba.banco.models.repository.UsuarioRepository;
import com.her.prueba.banco.services.common.CommonServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.time.format.DateTimeFormatter;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService {

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findByNombreOrApellido(String term) {
        return repository.findByNombreOrApellido(term);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> findAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return repository.findAllByOrderByIdAsc(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public MovimientoDto findMovimientoByUsuario(String codigo) {
        Usuario usuario = repository.findByCodigo(codigo);
        if (usuario == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String numCuenta = "";
        if (!usuario.getCuentas().isEmpty()) {
            numCuenta = usuario.getCuentas().get(0).getNumeroCuenta();
            if (numCuenta.length() > 8) {
                numCuenta = numCuenta.substring(0, 5) + "XXX"
                        + numCuenta.substring(numCuenta.length() - 3);
            }
        }

        List<MovimientoDetalleDto> movimientosDto = usuario.getCuentas().stream()
                .flatMap(cuenta -> cuenta.getMovimientos().stream()
                        .map(movimiento -> MovimientoDetalleDto.builder()
                                .id(movimiento.getId())
                                .tipoMovimiento(movimiento.getTipoMovimiento())
                                .descripcion(movimiento.getDescripcion())
                                .valor(movimiento.getValor())
                                .build()))
                .toList();

        return MovimientoDto.builder()
                .codUsuario(usuario.getCodigo())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .edad(usuario.getEdad())
                .fechaCreacion(usuario.getCreateAt().format(formatter))
                .numCuenta(numCuenta)
                .movimientos(movimientosDto)
                .build();
    }

    @Override
    public Usuario findByCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

}
