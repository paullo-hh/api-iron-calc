package com.carvalho.ironcalc.model.bd.entities;

import com.carvalho.ironcalc.model.bd.base.AbstractBaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.io.*;
import java.math.BigDecimal;

@Entity
@Table(name = Budget.TABLE_NAME, schema = Budget.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Budget extends AbstractBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String SCHEMA_NAME = "PUBLIC";
    public static final String TABLE_NAME = "BUDGET";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "MARKUP", length = 6, precision = 4)
    private BigDecimal markup;

    @Column(name = "TOTAL_PRODUCTION_COST", length = 14, precision = 2)
    private BigDecimal totalProductionCost;

    @Column(name = "SALE_PRICE", length = 14, precision = 2)
    private BigDecimal salePrice;

    @Column(name = "DISCOUNT_SALE_PRICE", length = 14, precision = 2)
    private BigDecimal discountSalePrice;

    @Column(name = "CRITICAL_DISCOUNT_SALE_PRICE", length = 14, precision = 2)
    private BigDecimal criticalDiscountSalePrice;

    @Column(name = "PROFIT", length = 14, precision = 2)
    private BigDecimal profit;

    @Column(name = "STATUS")
    private Integer status;
}




