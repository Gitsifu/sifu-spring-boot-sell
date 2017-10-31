package io.github.sifu.springbootsell.service;

import io.github.sifu.springbootsell.dto.OrderDto;

/**
 * 买家
 *
 * @author sifu
 */
public interface BuyerService {

    /**
     * 查询一个订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDto findOrderOne(String openid,String orderId);

    /**
     * 取消一个订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDto cancelOrder(String openid,String orderId);
}
