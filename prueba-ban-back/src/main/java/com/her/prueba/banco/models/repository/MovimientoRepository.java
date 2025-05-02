package com.her.prueba.banco.models.repository;

import com.her.prueba.banco.models.entity.Movimiento;
import com.her.prueba.banco.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    @Query("select a from Movimiento a where a.codTransaccion = ?1")
    public List<Usuario> findByCodTransaccion(String term);

}
