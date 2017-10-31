package io.github.sifu.springbootsell.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**

 * 定单详情实体
 *
 * @author sifu
 */
@Entity
@Data
public class OrderDetail {
    /**
     * 详情ID
     */
    @Id
    private String detailId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品ID
     */
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
     * 数量
     */
    private Integer productQuantity;

    /**
     * 商品小图
     */
    private String productIcon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
