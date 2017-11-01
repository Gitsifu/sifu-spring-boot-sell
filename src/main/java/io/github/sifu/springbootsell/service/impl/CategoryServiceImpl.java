package io.github.sifu.springbootsell.service.impl;

import io.github.sifu.springbootsell.pojo.ProductCategory;
import io.github.sifu.springbootsell.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author sifu
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return null;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return null;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return null;
    }
}
