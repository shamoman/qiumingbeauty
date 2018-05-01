package com.qiuming.beauty.repository;

import com.qiuming.beauty.eo.ItShopBarberEo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShopBarberRepository extends JpaRepository<ItShopBarberEo, Long> {
    /**
     * 根据店铺id查询店铺发型师
     * @param shopId
     * @return
     */
    List<ItShopBarberEo> findAllByShopId(Long shopId);
}
