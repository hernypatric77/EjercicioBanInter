package com.her.prueba.banco.controllers;

import com.her.prueba.banco.controllers.common.CommonController;
import com.her.prueba.banco.models.entity.Usuario;
import com.her.prueba.banco.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
// @RequestMapping("/banco/")
public class UsuarioController extends CommonController<Usuario, UsuarioService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario, @PathVariable Long id, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Optional<Usuario> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Usuario alumnoDb = o.get();
        alumnoDb.setNombre(usuario.getNombre());
        alumnoDb.setApellido(usuario.getApellido());
        alumnoDb.setEdad(usuario.getEdad());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }

    @GetMapping("/filtrar/{codigo}")
    public ResponseEntity<?> getMethodName(@PathVariable String codigo) {
        if (codigo == null || codigo.isEmpty() || codigo.length() < 10) {
            return ResponseEntity.badRequest().body("El código debe tener al menos 9 caracteres");
        }
        return ResponseEntity.ok(service.findMovimientoByUsuario(codigo));
    }

}
