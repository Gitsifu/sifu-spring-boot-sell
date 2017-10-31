package io.github.sifu.springbootsell.service;

import io.github.sifu.springbootsell.pojo.ProductCategory;

import java.util.List;

/**
 * 猎牧服务接口
 *
 * @author sifu
 */
public interface CategoryService {
    /**
     * 通过categoryId查找ProductCategory类目
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查找所有的ProductCategory类目
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 查找范围内的ProductCategory类目
     * @param categoryType
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

    /**
     * 存储一个类目对象
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
