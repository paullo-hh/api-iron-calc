package com.carvalho.ironcalc.model.bd.entities;

import com.carvalho.ironcalc.model.bd.base.AbstractBaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.io.*;

@Entity
@Table(name = ProductionOrder.TABLE_NAME, schema = ProductionOrder.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionOrder extends AbstractBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String SCHEMA_NAME = "PUBLIC";
    public static final String TABLE_NAME = "PRODUCTION_ORDER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "BUDGET_ID", nullable = false)
    private Long budgetId;

    @Column(name = "STATUS")
    private Integer status;
}




