package com.qiuming.beauty.repository;

import com.qiuming.beauty.eo.ItItemEo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ItItemRepository extends JpaRepository<ItItemEo, Long> {
    /**
     * 根据店铺id查询商品列表
     * @param shopId - 店铺id
     * @return
     */
    List<ItItemEo> findByShopId(Long shopId);
}
