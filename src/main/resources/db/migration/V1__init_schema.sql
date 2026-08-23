-- Iron Calc — initial schema
-- Convention: BIGINT identity for PK, NUMERIC for monetary values
-- (avoids floating-point rounding error), REAL for physical measurements.

CREATE TABLE company
(
    id                   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name                 TEXT        NOT NULL,
    cnpj                 VARCHAR(18) NOT NULL UNIQUE,
    address_street       VARCHAR(250),
    address_number       VARCHAR(10),
    address_neighborhood VARCHAR(150),
    address_city         VARCHAR(250),
    address_state        VARCHAR(25),
    address_zipcode      VARCHAR(10),
    logo                 BYTEA,
    is_active            INTEGER     NOT NULL DEFAULT 1,
    created_by           VARCHAR(50) NOT NULL,
    created_at           TIMESTAMPTZ NOT NULL DEFAULT now(),
    version              INTEGER     NOT NULL DEFAULT 0,
    updated_by           VARCHAR(50),
    updated_at           TIMESTAMPTZ
);

CREATE TABLE "user"
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    company_id BIGINT       NOT NULL REFERENCES company (id),
    name       VARCHAR(100) NOT NULL,
    login      VARCHAR(50)  NOT NULL UNIQUE,
    password   VARCHAR(250) NOT NULL,
    position   VARCHAR(50),
    sector     VARCHAR(50),
    is_active  INTEGER      NOT NULL DEFAULT 1,
    created_by VARCHAR(50)  NOT NULL,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT now(),
    version    INTEGER      NOT NULL DEFAULT 0,
    updated_by VARCHAR(50),
    updated_at TIMESTAMPTZ
);
CREATE INDEX idx_user_company ON "user" (company_id);

CREATE TABLE customer
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    company_id BIGINT       NOT NULL REFERENCES company (id),
    name       VARCHAR(100) NOT NULL,
    is_active  INTEGER      NOT NULL DEFAULT 1,
    created_by VARCHAR(50)  NOT NULL,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT now(),
    version    INTEGER      NOT NULL DEFAULT 0,
    updated_by VARCHAR(50),
    updated_at TIMESTAMPTZ
);
CREATE INDEX idx_company_user ON customer (company_id);

CREATE TABLE product
(
    id                             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    company_id                     BIGINT       NOT NULL REFERENCES company (id),
    product_type                   INTEGER NOT NULL,
    description                    VARCHAR(250) NOT NULL,
    width                          REAL,
    length                         REAL,
    price_cost_per_unit_of_measure NUMERIC(14, 4),
    price_cost                     NUMERIC(14, 4),
    width_shape                    REAL,
    is_active                      INTEGER      NOT NULL DEFAULT 1,
    created_by                     VARCHAR(50)  NOT NULL,
    created_at                     TIMESTAMPTZ  NOT NULL DEFAULT now(),
    version                        INTEGER      NOT NULL DEFAULT 0,
    updated_by                     VARCHAR(50),
    updated_at                     TIMESTAMPTZ
);
CREATE INDEX idx_product_company ON product (company_id);
CREATE INDEX idx_product_type ON product (product_type);

CREATE TABLE parameters
(
    id                  BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    company_id          BIGINT       NOT NULL REFERENCES company (id),
    value_text          VARCHAR(250),
    value_number        INTEGER,
    description         VARCHAR(250) NOT NULL,
    value               NUMERIC(14, 4),
    unit_of_measurement VARCHAR(10),
    width_shape         REAL,
    is_active           INTEGER      NOT NULL DEFAULT 1,
    created_by          VARCHAR(50)  NOT NULL,
    created_at          TIMESTAMPTZ  NOT NULL DEFAULT now(),
    version             INTEGER      NOT NULL DEFAULT 0,
    updated_by          VARCHAR(50),
    updated_at          TIMESTAMPTZ
);
CREATE INDEX idx_parameters_company ON parameters (company_id);

CREATE TABLE budget
(
    id                           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    company_id                   BIGINT      NOT NULL REFERENCES company (id),
    user_id                      BIGINT      NOT NULL REFERENCES "user" (id),
    customer_id                  BIGINT      NOT NULL REFERENCES customer (id),
    markup                       NUMERIC(6, 4),
    total_production_cost        NUMERIC(14, 2),
    sale_price                   NUMERIC(14, 2),
    discounted_sale_price        NUMERIC(14, 2),
    critical_discount_sale_price NUMERIC(14, 2),
    profit                       NUMERIC(14, 2),
    status                       INTEGER     NOT NULL DEFAULT 0,
    created_by                   VARCHAR(50) NOT NULL,
    created_at                   TIMESTAMPTZ NOT NULL DEFAULT now(),
    version                      INTEGER     NOT NULL DEFAULT 0,
    updated_by                   VARCHAR(50),
    updated_at                   TIMESTAMPTZ
);
CREATE INDEX idx_budget_company ON budget (company_id);
CREATE INDEX idx_budget_user ON budget (user_id);
CREATE INDEX idx_budget_customer ON budget (customer_id);

CREATE TABLE budget_item
(
    id                                          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    budget_id                                   BIGINT      NOT NULL REFERENCES budget (id) ON DELETE CASCADE,
    type                                        INTEGER     NOT NULL,
    product_verg_longitudinal_id                BIGINT REFERENCES product (id),
    product_verg_estribo_id                     BIGINT REFERENCES product (id),
    product_arame_id                            BIGINT REFERENCES product (id),
    product_trilho_id                           BIGINT REFERENCES product (id),
    product_lajota_id                           BIGINT REFERENCES product (id),
    laje_comprimento                            REAL,
    laje_largura                                REAL,
    laje_area                                   REAL,
    laje_qtd_trilhos                            REAL,
    laje_qtd_lajotas                            REAL,
    laje_orientacao                             REAL,
    ferragem_qtd_verg_longitudinais             INTEGER,
    ferragem_comprimento                        REAL,
    ferragem_top_estribo                        REAL,
    ferragem_right_estribo                      REAL,
    ferragem_bottom_estribo                     REAL,
    ferragem_left_estribo                       REAL,
    ferragem_sobra_estribo                      REAL,
    ferragem_comprimento_estribo                REAL,
    ferragem_qtd_pontos_amarracao_estribo       INTEGER,
    ferragem_qtd_arame_por_ponto_amarracao      REAL,
    ferragem_qtd_estribos                       INTEGER,
    ferragem_comprimento_total_estribos         INTEGER,
    ferragem_qtd_total_pontos_amarracao_estribo INTEGER,
    quantity                                    REAL,
    ferragem_qtd_total_arame                    REAL,
    item_cost_value                             NUMERIC(14, 2),
    item_sale_value                             NUMERIC(14, 2),
    status                                      INTEGER     NOT NULL DEFAULT 0,
    created_by                                  VARCHAR(50) NOT NULL,
    created_at                                  TIMESTAMPTZ NOT NULL DEFAULT now(),
    version                                     INTEGER     NOT NULL DEFAULT 0,
    updated_by                                  VARCHAR(50),
    updated_at                                  TIMESTAMPTZ
);
CREATE INDEX idx_budget_item_budget ON budget_item (budget_id);
CREATE INDEX idx_budget_item_status ON budget_item (status);

CREATE TABLE production_order
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    company_id  BIGINT      NOT NULL REFERENCES company (id),
    user_id     BIGINT      NOT NULL REFERENCES "user" (id),
    customer_id BIGINT      NOT NULL REFERENCES customer (id),
    budget_id   BIGINT      NOT NULL REFERENCES budget (id),
    status      INTEGER     NOT NULL DEFAULT 0,
    created_by  VARCHAR(50) NOT NULL,
    created_at  TIMESTAMPTZ NOT NULL DEFAULT now(),
    version     INTEGER     NOT NULL DEFAULT 0,
    updated_by  VARCHAR(50),
    updated_at  TIMESTAMPTZ
);
CREATE INDEX idx_production_order_budget ON production_order (budget_id);