package com.qiuming.beauty.repository;

import com.qiuming.beauty.dto.ShopListRequestDto;
import com.qiuming.beauty.eo.ItShopEo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 店铺Repository
 */
public interface ItShopRepository extends JpaRepository<ItShopEo, Long>, JpaSpecificationExecutor {
    /**
     * 根据餐厨查询列表
     * @param address - 地址
     * @param provinceName - 省名
     * @param cityName - 城市名
     * @param AreaName - 地区名
     * @param ShopName - 店铺名
     * @return
     */
    List<ItShopEo> findAllByAddressContainingOrProvinceNameContainingOrCityNameContainingOrAreaNameContainingOrShopNameContaining(String address,
                                                                                                                                  String provinceName,
                                                                                                                                  String cityName,
                                                                                                                                  String AreaName,
                                                                                                                                  String ShopName,
                                                                                                                                  Sort sort);
    @Query("select t from ItShopEo t where 1=1 " +
        "")
    List<ItShopEo> findByParams(ShopListRequestDto dto);
}
