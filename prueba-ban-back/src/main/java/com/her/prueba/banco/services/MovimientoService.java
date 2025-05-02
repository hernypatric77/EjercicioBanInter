package com.her.prueba.banco.services;

import com.her.prueba.banco.dtos.MovimientoInternoDto;
import com.her.prueba.banco.models.entity.Movimiento;
import com.her.prueba.banco.services.common.CommonService;

import java.math.BigDecimal;

public interface MovimientoService extends CommonService<Movimiento> {


    public MovimientoInternoDto crearTransaccion(String identiOrdenante, String identiBeneficiario, BigDecimal valor);

}
