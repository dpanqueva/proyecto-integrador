package com.dh.proyecto.integrador.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dh_producto")
@NamedQueries({
        @NamedQuery(name = "ProductEntity.findByCity", query = "SELECT p FROM ProductEntity p WHERE p.city.id = :cityId"),
        @NamedQuery(name = "ProductEntity.findByPolicy", query = "SELECT p FROM ProductEntity p WHERE p.policy.id = :policyId"),
        @NamedQuery(name = "ProductEntity.findByCategory", query = "SELECT p FROM ProductEntity p WHERE p.category.id = :categoryId"),
        @NamedQuery(name = "ProductEntity.findProductByCityAndDates", query = "SELECT p FROM ProductEntity p " +
                "WHERE NOT EXISTS(" +
                "SELECT 1 FROM BookingEntity b WHERE b.product.id = p.id " +
                "AND :feFin <= b.checkOut AND :feInit <= b.checkIn"  +
                ") AND p.city.id = :cityId"),
        @NamedQuery(name = "ProductEntity.findProductByDates", query = "SELECT p FROM ProductEntity p " +
                "WHERE NOT EXISTS(" +
                "SELECT 1 FROM BookingEntity b WHERE b.product.id = p.id " +
                "AND :feFin <= b.checkOut AND :feInit <= b.checkIn"  +
                ")")
})
public class ProductEntity {

    @Id
    @Column(name = "producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "anio_estreno")
    private String year;
    @Column(name = "descripcion")
    private String description;
    /**
     * Relaciones
     * */
    // ciudad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad_id")
    private CityEntity city;

    // categoria
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private CategoryEntity category;

    // politica
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "politica_id")
    private PolicyEntity policy;

    // imagenes
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imagen_id")
    private ImageEntity image;

    /*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private List<ProductFeatureEntity> features;*/

}
