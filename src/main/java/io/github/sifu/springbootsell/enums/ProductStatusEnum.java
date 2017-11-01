package io.github.sifu.springbootsell.enums;

import lombok.Getter;

/**
 * 商品状态枚举类
 *
 * @author sifu
 */
@Getter
public enum ProductStatusEnum {

    /**
     * 商品在架状态
     */
    UP(0, "在架"),

    /**
     * 商品在架状态
     */
    DOWN(1, "下架");


    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
