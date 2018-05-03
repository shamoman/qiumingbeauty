/**
 * @(#) ${FILE_NAME} 1.0  2018:04:20
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service.impl;

import com.qiuming.beauty.constants.Constants;
import com.qiuming.beauty.dto.*;
import com.qiuming.beauty.eo.ItItemEo;
import com.qiuming.beauty.eo.ItShopBarberEo;
import com.qiuming.beauty.eo.ItShopCoupon;
import com.qiuming.beauty.eo.ItShopEo;
import com.qiuming.beauty.repository.ItShopRepository;
import com.qiuming.beauty.service.IItItemService;
import com.qiuming.beauty.service.IShopBarberService;
import com.qiuming.beauty.service.IShopService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @description: 店铺service层
 * @author: ji.shamo
 * @create: 2018-04-20 23:05
 **/
@Service("shopService")
public class ShopServiceImpl implements IShopService {

    @Resource
    private ItShopRepository itShopRepository;
    @Resource
    private IItItemService itItemService;
    @Resource
    private IShopBarberService shopBarberService;


    @Override
    public void addShop(ItShopEo shopEo) {
        itShopRepository.save(shopEo);
    }

    @Override
    public void addShopDto(ShopAddDto shopEo) {
        ItShopEo itShopEo = new ItShopEo();
        BeanUtils.copyProperties(shopEo, itShopEo);
        List<byte[]> images = shopEo.getEnvironmentImageList();
        if (!CollectionUtils.isEmpty(images)) {
            for (int i =0 ; i < images.size(); i++) {
                if (i == 0){
                    itShopEo.setUrl1(images.get(0));
                }else if (i == 1){
                    itShopEo.setUrl2(images.get(1));
                }else if (i == 2){
                    itShopEo.setUrl3(images.get(2));
                }
            }
        }
        itShopEo.setCommentScore(new BigDecimal(0));
        itShopEo.setCreateTime(new Date());
        itShopEo.setUpdateTime(new Date());
        itShopEo.setCommentCount(0l);
        itShopEo.setSaleCount(0l);
        itShopEo.setWatchCount(0l);
        this.addShop(itShopEo);
        List<ShopItemDto> itItemEos = shopEo.getItemList();
        List<ItShopBarberEo> itShopBarberEos = shopEo.getShopBarberList();
        List<ItItemEo> list = new ArrayList<>();
        ItItemEo itItemEo = null;
        if (!CollectionUtils.isEmpty(itItemEos)) {
            for (ShopItemDto item : itItemEos) {
                itItemEo = new ItItemEo();
                BeanUtils.copyProperties(item, itItemEo);
                itItemEo.setShopId(itShopEo.getId());
                itItemEo.setSalesCount(0l);
                itItemEo.setUrl1(Constants.ITEM_IMAGE);
                list.add(itItemEo);
            }
            itItemService.addItemList(list);
        }
        if (!CollectionUtils.isEmpty(itShopBarberEos)) {
            for (ItShopBarberEo item : itShopBarberEos) {
                item.setShopId(itShopEo.getId());
                item.setOrderCount(0);
                item.setBarberImage(Constants.BARBER_IMAGE);
            }
            shopBarberService.addShopBarberList(itShopBarberEos);
        }
    }

//    private List<ItShopCoupon> transShopCoupon(ShopAddDto dto){
//        List<ItShopCoupon> shopCouponList = new ArrayList<>();
//        if (null != dto.getDiscount()){
//            ItShopCoupon itShopCoupon = new ItShopCoupon();
//            itShopCoupon.setCoupon();
//        }
//    }

    @Override
    public void updateShop(ItShopEo shopEo) {
        itShopRepository.save(shopEo);
    }

    @Override
    public void deleteShopById(Long shopId) {
        itShopRepository.delete(shopId);
    }

    @Override
    public ShopDetailDto getShopById(Long shopId) {
        ItShopEo shopEo = itShopRepository.findOne(shopId);
        shopEo.setWatchCount(null == shopEo.getWatchCount() ? 1 : shopEo.getWatchCount() + 1l);
        ShopDetailDto detailDto = new ShopDetailDto();
        BeanUtils.copyProperties(shopEo, detailDto);
        List<ItItemEo> itItemEos = itItemService.findItemList(shopId);
        detailDto.setItemList(itItemEos);
        detailDto.setEnvironmentImageList(getShopEnvironmentImage(shopEo));
        List<ItShopBarberEo> itShopBarberEos = shopBarberService.findShopBarberList(shopId);
        detailDto.setShopBarberList(itShopBarberEos);
        itShopRepository.save(shopEo);
        return detailDto;
    }

    @Override
    public List<ShopListDto> findShopList() {
        Sort sortx = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));
        List<ItShopEo> list = itShopRepository.findAll(sortx);
        return transShopDtos(list);
    }
    private List<ShopListDto> transShopDtos(List<ItShopEo> list){
        List<ShopListDto> listDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)){
            ShopListDto dto;
            for (ItShopEo item : list){
                dto = new ShopListDto();
                BeanUtils.copyProperties(item, dto);
                dto.setEnvironmentImageList(getShopEnvironmentImage(item));
                listDtos.add(dto);
            }
        }
        return listDtos;
    }
    private List<byte[]> getShopEnvironmentImage(ItShopEo shopEo){
        List<byte[]> environmentImagelist= new ArrayList<>();
        if (null != shopEo.getUrl1())
            environmentImagelist.add(shopEo.getUrl1());
        if (null != shopEo.getUrl2())
            environmentImagelist.add(shopEo.getUrl2());
        if (null != shopEo.getUrl3())
            environmentImagelist.add(shopEo.getUrl3());
        return environmentImagelist;
    }

    @Override
    public List<ShopListDto> findShopListByParams(ShopListRequestDto dto) {
        Sort sortx = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));
//        List<ItShopEo> list =  itShopRepository.findAllByAddressContainingOrProvinceNameContainingOrCityNameContainingOrAreaNameContainingOrShopNameContaining(
//                 dto.getAddress(),dto.getProvinceName(),dto.getCityName(),dto.getAreaName(),dto.getShopName(),sortx
//        );
        Specification querySpecifi = new Specification<ItShopEo>() {
            @Override
            public Predicate toPredicate(Root<ItShopEo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(!StringUtils.isEmpty(dto.getAddress())){
                    predicates.add(criteriaBuilder.like(root.get("address"), "" + dto.getAddress() + "%"));
                }
                if(!StringUtils.isEmpty(dto.getAreaName())){
                    predicates.add(criteriaBuilder.like(root.get("areaName"), "%" + dto.getAreaName() +"%"));
                }
                if(!StringUtils.isEmpty(dto.getCityName())){
                    predicates.add(criteriaBuilder.like(root.get("cityName"), "%"+ dto.getCityName() +"%"));
                }
                if(!StringUtils.isEmpty(dto.getProvinceName())){
                    predicates.add(criteriaBuilder.like(root.get("provinceName"), "%"+ dto.getProvinceName() +"%"));
                }
                if(!StringUtils.isEmpty(dto.getStreetName())){
                    predicates.add(criteriaBuilder.like(root.get("streetName"), "%"+ dto.getStreetName() +"%"));
                }
                if(!StringUtils.isEmpty(dto.getShopName())){
                    predicates.add(criteriaBuilder.like(root.get("shopName"), "%"+ dto.getShopName() +"%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<ItShopEo> list =  itShopRepository.findAll(querySpecifi, sortx);
        return transShopDtos(list);
    }

    @Override
    public List<ShopListDto> findShopListOrderByCommonScore() {
        Sort sortx = new Sort(new Sort.Order(Sort.Direction.DESC,"commentScore"));
        List<ItShopEo> list = itShopRepository.findAll(sortx);
        return transShopDtos(list);
    }
}

