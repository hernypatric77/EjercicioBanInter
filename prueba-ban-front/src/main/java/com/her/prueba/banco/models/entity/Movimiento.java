package com.her.prueba.banco.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    @Getter
    @Setter
    private String descripcion;

    @Getter
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Getter
    @Setter
    private BigDecimal valor;

    @Getter
    @Setter
    @JsonIgnoreProperties(value = { "usuario", "movimientos" })
    @JoinColumn(name = "cuenta_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuenta cuenta;

    @Getter
    @Setter
    @Column(name = "cod_trasaccion")
    private Long codTransaccion;

    @PrePersist
    public void prePeresit() {
        this.createAt = LocalDateTime.now();
    }
}
