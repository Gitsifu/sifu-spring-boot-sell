package io.github.sifu.springbootsell.repository;

import io.github.sifu.springbootsell.pojo.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单主表查询接口
 *
 * @author sifu
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    /**
     * 通过openid发现订单
     *
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
