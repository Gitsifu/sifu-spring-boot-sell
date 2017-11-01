package io.github.sifu.springbootsell.service.impl;

import io.github.sifu.springbootsell.dto.OrderDto;
import io.github.sifu.springbootsell.enums.ResultEnum;
import io.github.sifu.springbootsell.exception.SellException;
import io.github.sifu.springbootsell.service.BuyerService;
import io.github.sifu.springbootsell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sifu
 */
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {

    private final OrderService orderService;

    @Autowired
    public BuyerServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public OrderDto findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderId) {
        OrderDto orderDto = checkOrderOwner(openid,orderId);
        if (orderDto == null){
            log.error("【取消订单】擦还不到该订单，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return null;
    }

    private OrderDto checkOrderOwner(String openid,String orderId){
        OrderDto orderDto = orderService.findOne(orderId);
        if (orderDto == null){
            return null;
        }
        //判断是否是自己的订单
        if (!orderDto.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单的openid不一致，openid={},orderId={}",openid,orderId);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROER);
        }
        return orderDto;
    }
}
