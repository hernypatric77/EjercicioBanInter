package com.her.prueba.banco.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class MovimientoDetalleDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String tipoMovimiento;
    private String descripcion;
    private BigDecimal valor;
}