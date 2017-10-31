package io.github.sifu.springbootsell.service;

import io.github.sifu.springbootsell.dto.CarDto;
import io.github.sifu.springbootsell.pojo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品Service接口
 *
 * @author sifu
 */
public interface ProductService {

    /**
     * 查找单个商品
     *
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查找所有在架商品
     *
     * @return
     */
    List<ProductInfo> findeUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加仓库
     * @param carDtoList
     */
    void inncreaseStock(List<CarDto> carDtoList);

    /**
     * 减仓库
     * @param carDtoList
     */
    void decreaseStock(List<CarDto> carDtoList);

}
