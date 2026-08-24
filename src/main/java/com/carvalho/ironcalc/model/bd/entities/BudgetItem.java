package com.carvalho.ironcalc.model.bd.entities;

import com.carvalho.ironcalc.model.bd.base.AbstractBaseEntity;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import java.io.*;
import java.math.BigDecimal;

@Entity
@Table(name = BudgetItem.TABLE_NAME, schema = BudgetItem.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetItem extends AbstractBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String SCHEMA_NAME = "PUBLIC";
    public static final String TABLE_NAME = "BUDGET_ITEM";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BUDGET_ID", nullable = false)
    private Long budgetId;

    @Column(name = "TYPE")
    private Integer type;

    @Column(name = "PRODUCT_VERG_LONGITUDINAL_ID")
    private Long productVergLongitudinalId;

    @Column(name = "PRODUCT_VERG_ESTRIBO_ID")
    private Long productVergEstraboId;

    @Column(name = "PRODUCT_ARAME_ID")
    private Long productArameId;

    @Column(name = "PRODUCT_TRILHO_ID")
    private Long productTrilhoId;

    @Column(name = "PRODUCT_LAJOTA_ID")
    private Long productLajotaId;

    @Column(name = "LAJE_COMPRIMENTO")
    private Float lajeComprimento;

    @Column(name = "LAJE_LARGURA")
    private Float lajeLargura;

    @Column(name = "LAJE_AREA")
    private Float lajeArea;

    @Column(name = "LAJE_QTD_TRILHOS")
    private Float lajeQtdTrilhos;

    @Column(name = "LAJE_QTD_LAJOTAS")
    private Float lajeQtdLajotas;

    @Column(name = "LAJE_ORIENTACAO")
    private Float lajeOrientacao;

    @Column(name = "FERRAGEM_QTD_VERG_LONGITUDINAIS")
    private Integer ferragemQtdVergLongitudinais;

    @Column(name = "FERRAGEM_COMPRIMENTO")
    private Float ferragemComprimento;

    @Column(name = "FERRAGEM_TOP_ESTRIBO")
    private Float ferragemTopEstribo;

    @Column(name = "FERRAGEM_RIGHT_ESTRIBO")
    private Float ferragemRightEstribo;

    @Column(name = "FERRAGEM_BOTTOM_ESTRIBO")
    private Float ferragemBottomEstribo;

    @Column(name = "FERRAGEM_LEFT_ESTRIBO")
    private Float ferragemLeftEstribo;

    @Column(name = "FERRAGEM_SOBRA_ESTRIBO")
    private Float ferragemSobraEstribo;

    @Column(name = "FERRAGEM_COMPRIMENTO_ESTRIBO")
    private Float ferragemComprimentoEstribo;

    @Column(name = "FERRAGEM_QTD_PONTOS_AMARRACAO_ESTRIBO")
    private Integer ferragemQtdPontosAmarracaoEstribo;

    @Column(name = "FERRAGEM_QTD_ARAME_POR_PONTO_AMARRACAO")
    private Float ferragemQtdAramePorPontoAmarracao;

    @Column(name = "FERRAGEM_QTD_ESTRIBOS")
    private Integer ferragemQuantidadeEstribos;

    @Column(name = "FERRAGEM_COMPRIMENTO_TOTAL_ESTRIBO")
    private Float ferragemComprimentoTotalEstribo;

    @Column(name = "FERRAGEM_QTD_TOTAL_PONTOS_AMARRACAO_ESTRIBOS")
    private Integer ferragemQtdTotalPontosAmarracaoEstribos;

    @Column(name = "QUANTITY")
    private Float quantity;

    @Column(name = "FERRAGEM_QTD_TOTAL_ARAME")
    private Float ferragemQtdTotalArame;

    @Column(name = "ITEM_COST_VALUE", length = 14, precision = 2)
    private BigDecimal itemCostValue;

    @Column(name = "ITEM_SALE_VALUE", length = 14, precision = 2)
    private BigDecimal itemSaleValue;

    @Column(name = "STATUS")
    private Integer status;
}




