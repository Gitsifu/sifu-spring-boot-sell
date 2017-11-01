package io.github.sifu.springbootsell.service.impl;

import io.github.sifu.springbootsell.dto.CarDto;
import io.github.sifu.springbootsell.enums.ProductStatusEnum;
import io.github.sifu.springbootsell.enums.ResultEnum;
import io.github.sifu.springbootsell.exception.SellException;
import io.github.sifu.springbootsell.pojo.ProductInfo;
import io.github.sifu.springbootsell.repository.ProductInfoRepository;
import io.github.sifu.springbootsell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 商品Service接口实现类
 *
 * @author sifu
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductInfoRepository repository;

    @Autowired
    public ProductServiceImpl(ProductInfoRepository repository) {
        this.repository = repository;
    }


    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CarDto> carDtoList) {
        for (CarDto carDto : carDtoList) {
            ProductInfo productInfo = repository.findOne(carDto.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + carDto.getProductQuantity();
            productInfo.setProductStock(result);

            repository.save(productInfo);

        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CarDto> carDtoList) {
        for (CarDto carDto : carDtoList) {
            ProductInfo productInfo = repository.findOne(carDto.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            Integer result = productInfo.getProductStock() - carDto.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
