package io.github.sifu.springbootsell.repository;

import io.github.sifu.springbootsell.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品DAO
 *
 * @author sifu
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    /**
     * 列出所有相同状态的商品信息
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
