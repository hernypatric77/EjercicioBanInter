package com.her.prueba.banco.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class MovimientoDto implements Serializable {

    private static final long serialVersionUID = -297538510579145963L;

    private String codUsuario;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String fechaCreacion;
    private String numCuenta;
    private List<MovimientoDetalleDto> movimientos;
}
