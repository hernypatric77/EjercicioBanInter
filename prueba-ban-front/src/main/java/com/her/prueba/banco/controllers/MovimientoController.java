package com.her.prueba.banco.controllers;

import com.her.prueba.banco.controllers.common.CommonController;
import com.her.prueba.banco.dtos.MovimientoInternoDto;
import com.her.prueba.banco.dtos.ReqMovInternoDto;
import com.her.prueba.banco.models.entity.Movimiento;
import com.her.prueba.banco.models.entity.Usuario;
import com.her.prueba.banco.services.MovimientoService;
import com.her.prueba.banco.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movimientos/")
public class MovimientoController extends CommonController<Movimiento, MovimientoService> {


    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ReqMovInternoDto dto) {
        MovimientoInternoDto resp = this.service.crearTransaccion(dto.getIdentiOrdenante(),
                dto.getIdentiBeneficiario(), dto.getValor());
        if (resp == null) {
            return new ResponseEntity<>("No se pudo crear el movimiento", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }


}
