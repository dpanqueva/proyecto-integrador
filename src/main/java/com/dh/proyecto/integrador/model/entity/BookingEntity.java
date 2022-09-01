package com.dh.proyecto.integrador.model.entity;

import com.dh.proyecto.integrador.model.entity.jwt.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dh_reserva")
public class BookingEntity {

    @Id
    @Column(name = "reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "feinicio_reserva")
    private Date checkIn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fefin_reserva")
    private Date checkOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserEntity customer;
}
