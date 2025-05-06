package com.her.prueba.banco.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ReqMovInternoDto implements Serializable {

    private static final long serialVersionUID = -297538510679145963L;

    private String identiBeneficiario;
    private String identiOrdenante;
    private BigDecimal valor;
}
