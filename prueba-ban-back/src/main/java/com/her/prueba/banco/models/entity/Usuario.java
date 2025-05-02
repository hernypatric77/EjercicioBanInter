package com.her.prueba.banco.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    @NotEmpty(message = "{NotEmpty.es}")
    private String nombre;

    @Getter
    @Setter
    @NotEmpty(message = "{NotEmpty.es}")
    private String apellido;

    @Getter
    @Setter
    private Integer edad;

    @Getter
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Getter
    @JsonIgnoreProperties(value = { "usuario" }, allowSetters = true)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cuenta> cuentas;

    @PrePersist
    public void prePeresit() {
        this.createAt = LocalDateTime.now();
    }

    public Usuario() {
        this.cuentas = new ArrayList<>();
    }

    public void setCuentaList(List<Cuenta> cuentas) {
        this.cuentas.clear();
        cuentas.forEach(this::addCuenta);
    }

    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
        cuenta.setUsuario(this);
    }

    public void removeCuenta(Cuenta cuenta) {
        this.cuentas.remove(cuenta);
        cuenta.setUsuario(null);
    }

}
