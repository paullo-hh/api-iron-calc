package com.carvalho.ironcalc.model.bd.entities;

import com.carvalho.ironcalc.model.bd.base.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;

@Entity
@Table(name = Company.TABLE_NAME, schema = Company.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company extends AbstractBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String SCHEMA_NAME = "PUBLIC";
    public static final String TABLE_NAME = "COMPANY";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 250)
    private String name;

    @Column(name = "CNPJ", length = 18)
    private String cnpj;

    @Column(name = "ADDRESS_STREET", length = 250)
    private String addressStreet;

    @Column(name = "ADDRESS_NUMBER", length = 10)
    private String addressNumber;

    @Column(name = "ADDRESS_NEIGHBORHOOD", length = 150)
    private String addressNeighborhood;

    @Column(name = "ADDRESS_CITY", length = 250)
    private String addressCity;

    @Column(name = "ADDRESS_STATE", length = 25)
    private String addressState;

    @Column(name = "ADDRESS_ZIPCODE", length = 9)
    private String addressZipcode;

    @Lob
    @Column(name = "LOGO")
    private byte[] logo;

    @Column(name = "IS_ACTIVE")
    private Boolean active;
}
