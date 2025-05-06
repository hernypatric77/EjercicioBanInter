package com.her.prueba.banco.services;

import com.her.prueba.banco.dtos.MovimientoDto;
import com.her.prueba.banco.models.entity.Usuario;
import com.her.prueba.banco.services.common.CommonService;

import java.util.List;

public interface UsuarioService extends CommonService<Usuario> {

    public List<Usuario> findByNombreOrApellido(String term);

    public MovimientoDto findMovimientoByUsuario(String codigo);

    public Usuario findByCodigo(String movimiento);

}
