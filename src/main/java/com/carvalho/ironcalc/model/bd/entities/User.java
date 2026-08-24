package com.carvalho.ironcalc.model.bd.entities;

import com.carvalho.ironcalc.model.bd.base.AbstractBaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.*;

@Entity
@Table(name = User.TABLE_NAME, schema = User.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String SCHEMA_NAME = "PUBLIC";
    public static final String TABLE_NAME = "USER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "LOGIN", length = 50)
    private String login;

    @Column(name = "PASSWORD", length = 250)
    private String password;

    @Column(name = "POSITION", length = 50)
    private String position;

    @Column(name = "SECTOR", length = 50)
    private String sector;

    @Column(name = "IS_ACTIVE")
    private Boolean active;
}
