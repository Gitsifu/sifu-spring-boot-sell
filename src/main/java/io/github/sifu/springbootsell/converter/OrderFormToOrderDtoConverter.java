package io.github.sifu.springbootsell.converter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.sifu.springbootsell.dto.OrderDto;
import io.github.sifu.springbootsell.enums.ResultEnum;
import io.github.sifu.springbootsell.exception.SellException;
import io.github.sifu.springbootsell.form.OrderForm;
import io.github.sifu.springbootsell.pojo.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author sifu
 */
@Slf4j
public class OrderFormToOrderDtoConverter {
    public static OrderDto convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDto orderDto = new OrderDto();

        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setOrderId(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;
        try{
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){
                    }.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }

}
