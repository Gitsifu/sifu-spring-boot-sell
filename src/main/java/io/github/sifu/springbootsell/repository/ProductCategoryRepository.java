package io.github.sifu.springbootsell.repository;

import io.github.sifu.springbootsell.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目DAO
 *
 * @author sifu
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    /**
     * 列出所有类型的商品类别
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
