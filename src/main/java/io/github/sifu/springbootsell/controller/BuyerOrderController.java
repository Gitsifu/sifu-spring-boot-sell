package io.github.sifu.springbootsell.controller;

import io.github.sifu.springbootsell.converter.OrderFormToOrderDtoConverter;
import io.github.sifu.springbootsell.dto.OrderDto;
import io.github.sifu.springbootsell.enums.ResultEnum;
import io.github.sifu.springbootsell.exception.SellException;
import io.github.sifu.springbootsell.form.OrderForm;
import io.github.sifu.springbootsell.service.BuyerService;
import io.github.sifu.springbootsell.service.OrderService;
import io.github.sifu.springbootsell.utils.ResultVOUtil;
import io.github.sifu.springbootsell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单API
 *
 * @author sifu
 */
@Slf4j
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    private final OrderService orderService;
    private final BuyerService buyerService;

    @Autowired
    public BuyerOrderController(OrderService orderService, BuyerService buyerService) {
        this.orderService = orderService;
        this.buyerService = buyerService;
    }

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDto orderDto = OrderFormToOrderDtoConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDto createResult = orderService.create(orderDto);
        Map<String ,String > map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("list")
    public ResultVO<OrderDto> list(
        @RequestParam("openid") String openid,
        @RequestParam("orderId") String orderId){
//        TODO: 不安全的做法，改进
        OrderDto orderDto = buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(orderDto);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(
            @RequestParam("openid") String openid,
            @RequestParam("orderId") String orderId){
//          TODO: 不安全的做法，改进
        buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success();
    }



}
