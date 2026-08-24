package com.carvalho.ironcalc.model.bd.entities;

import com.carvalho.ironcalc.model.bd.base.AbstractBaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.*;
import java.math.BigDecimal;

@Entity
@Table(name = Parameters.TABLE_NAME, schema = Parameters.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parameters extends AbstractBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String SCHEMA_NAME = "PUBLIC";
    public static final String TABLE_NAME = "PARAMETERS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "VALUE_TEXT", length = 250)
    private String valueText;

    @Column(name = "VALUE_NUMBER")
    private Integer valueNumber;

    @Column(name = "DESCRIPTION", length = 250)
    private String description;

    @Column(name = "VALUE", length = 14, precision = 4)
    private BigDecimal value;

    @Column(name = "UNIT_OF_MEASUREMENT", length = 10)
    private String unitOfMeasurement;

    @Column(name = "WIDTH_SHAPE")
    private Float widthShape;

    @Column(name = "IS_ACTIVE")
    private Boolean active;
}



