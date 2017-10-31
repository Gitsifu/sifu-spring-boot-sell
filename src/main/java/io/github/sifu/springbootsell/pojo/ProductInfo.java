package io.github.sifu.springbootsell.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品实体
 *
 * @author sifu
 */
@Data
@Entity
@DynamicUpdate
public class ProductInfo {
    /**
     * 商品编号
     */
    @Id
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 商品状态，0正常，1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;
}
