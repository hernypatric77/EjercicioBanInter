package com.her.prueba.banco.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cuentas")
@Data
public class Cuenta {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cta")
    private String numeroCuenta;

    @Getter
    @Setter
    @Column(name = "tipo_cta")
    private String tipoCuenta;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Getter
    @JsonIgnoreProperties(value = { "cuenta", "usuario" }, allowSetters = true)
    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movimiento> movimientos;

    @PrePersist
    public void prePeresit() {
        this.createAt = LocalDateTime.now();
    }
}
