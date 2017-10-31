package io.github.sifu.springbootsell.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.sifu.springbootsell.pojo.OrderDetail;
import io.github.sifu.springbootsell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * 订单数据传输对象
 *
 * @author sifu
 */
@Data
public class OrderDto {
    /**
     * 订单ID
     */
    @Id
    private String orderId;

    /**
     * 买家名称
     */
    private String buyerName;

    /**
     * 买家手机号
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信Openid
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private Integer orderAmount;

    /**
     * 订单状态，默认为新下单
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /**
     * 商品详情列表
     */
    private List<OrderDetail> orderDetailList;

}
