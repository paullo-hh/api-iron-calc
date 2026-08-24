package com.carvalho.ironcalc.model.bd.entities;

import com.carvalho.ironcalc.model.bd.base.AbstractBaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.io.*;
import java.math.BigDecimal;

@Entity
@Table(name = Product.TABLE_NAME, schema = Product.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String SCHEMA_NAME = "PUBLIC";
    public static final String TABLE_NAME = "PRODUCT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "PRODUCT_TYPE")
    private Integer productType;

    @Column(name = "DESCRIPTION", length = 250)
    private String description;

    @Column(name = "WIDTH")
    private Float width;

    @Column(name = "LENGTH")
    private Float value;

    @Column(name = "PRICE_COST_PER_UNIT_OF_MEASUREMENT", length = 14, precision = 4)
    private BigDecimal priceCostPerUnitOfMeasurement;

    @Column(name = "PRICE_COST", length = 14, precision = 4)
    private BigDecimal priceCost;

    @Column(name = "WIDTH_SHAPE")
    private Float widthShape;

    @Column(name = "IS_ACTIVE")
    private Boolean active;
}



