package io.github.sifu.springbootsell.dto;

import lombok.Data;

/**
 * 购物车数据传输类
 *
 * @author sifu
 */
@Data
public class CarDto {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 数量
     */
    private Integer productQuantity;

    public CarDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
