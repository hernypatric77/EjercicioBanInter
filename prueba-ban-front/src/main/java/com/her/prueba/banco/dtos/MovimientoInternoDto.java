package com.her.prueba.banco.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class MovimientoInternoDto implements Serializable {

    private static final long serialVersionUID = -297538510579145963L;

    private String nomBeneficiario;
    private String nomOrdenante;
    private String mailBeneficiario;
    private String fecha;
    private String ctaBeneficiario;
    private String ctaOrdenante;
    private BigDecimal valor;
    private String valorTexto;
    private String codError;
    private String descError;

}
