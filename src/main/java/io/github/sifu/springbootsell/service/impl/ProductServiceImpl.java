package io.github.sifu.springbootsell.service.impl;

import io.github.sifu.springbootsell.dto.CarDto;
import io.github.sifu.springbootsell.pojo.ProductInfo;
import io.github.sifu.springbootsell.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 *
 * @author sifu
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductInfo findOne(String productId) {
        return null;
    }

    @Override
    public List<ProductInfo> findeUpAll() {
        return null;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return null;
    }

    @Override
    public void increaseStock(List<CarDto> carDtoList) {

    }

    @Override
    public void decreaseStock(List<CarDto> carDtoList) {

    }
}
