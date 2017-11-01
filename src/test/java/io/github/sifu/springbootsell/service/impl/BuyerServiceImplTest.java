package io.github.sifu.springbootsell.service.impl;

import io.github.sifu.springbootsell.dto.OrderDto;
import io.github.sifu.springbootsell.service.BuyerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuyerServiceImplTest {
    @Autowired
    private BuyerService service;

    @Test
    public void findOrderOne() throws Exception {
        OrderDto orderDto = service.findOrderOne("1","1");
        Assert.assertNotNull(orderDto);
    }

    @Test
    public void cancelOrder() throws Exception {

    }

}