package io.github.sifu.springbootsell.repository;

import io.github.sifu.springbootsell.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    /**
     * 通过订单ID获取订单详情列表
     *
     * @param orderId orderId
     * @author sifu
     */
    List<OrderDetail> findByOrderId(String orderId);

}
