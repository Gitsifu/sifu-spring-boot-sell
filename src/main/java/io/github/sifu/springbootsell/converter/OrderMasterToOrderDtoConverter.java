package io.github.sifu.springbootsell.converter;

import io.github.sifu.springbootsell.dto.OrderDto;
import io.github.sifu.springbootsell.pojo.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMaster转OrderDto
 *
 * @author sifu
 */
public class OrderMasterToOrderDtoConverter {
    public static OrderDto convert(OrderMaster orderMaster) {
        OrderDto orderDto = new OrderDto();

        BeanUtils.copyProperties(orderMaster, orderDto);

        return orderDto;
    }

    public static List<OrderDto> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(
                e -> convert(e)
        ).collect(Collectors.toList());
    }
}
