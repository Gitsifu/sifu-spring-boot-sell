package io.github.sifu.springbootsell.enums;

import lombok.Getter;

/**
 * 订单状态枚举类
 *
 * @author sifu
 */
@Getter
public enum  OrderStatusEnum {
    NEW(0,"新下单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
