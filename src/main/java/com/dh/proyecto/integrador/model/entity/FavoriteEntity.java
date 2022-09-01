package com.dh.proyecto.integrador.model.entity;

import com.dh.proyecto.integrador.model.entity.jwt.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dh_favorito")
@NamedQueries({
        @NamedQuery(name = "FavoriteEntity.countByProductAndCustomer", query = "SELECT COUNT(f) FROM FavoriteEntity f WHERE f.product.id = :productId AND f.customer.id = :userId"),
})
public class FavoriteEntity {

    @Id
    @Column(name = "favorito_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserEntity customer;
}
