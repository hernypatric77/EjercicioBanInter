package com.her.prueba.banco.models.repository;

import com.her.prueba.banco.models.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select a from Usuario a where a.nombre like %?1%or a.apellido like %?1%")
    public List<Usuario> findByNombreOrApellido(String term);

    @Query("select a from Usuario a where a.codigo = ?1")
    public Usuario findByCodigo(String term);

    public Iterable<Usuario> findAllByOrderByIdAsc();

    public Page<Usuario> findAllByOrderByIdAsc(Pageable pageable);

}
