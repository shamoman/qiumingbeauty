package com.qiuming.beauty.controller;

import com.alibaba.fastjson.JSON;
import com.qiuming.beauty.dto.CommentAddDto;
import com.qiuming.beauty.dto.OrderSubmitDto;
import com.qiuming.beauty.dto.RestResponse;
import com.qiuming.beauty.dto.UserDto;
import com.qiuming.beauty.eo.ItItemEo;
import com.qiuming.beauty.eo.ItShopBarberEo;
import com.qiuming.beauty.eo.ItShopEo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author shilei
 * @Date 2017/6/9.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String heelo(){
        return "HELLO, THIS IS QIU MING BEAUTY SHOPPING CART";
    }

    @RequestMapping("/users")
    public String getUsers() {
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }

    public static void main(String[] args) {
        CommentAddDto commentAddDto = new CommentAddDto();
        commentAddDto.setCommentImage(new ArrayList<>());
        commentAddDto.setOrderId(1l);
        commentAddDto.setRemark("店长很热心，洗头很舒服，造型也很合适，5星");
        commentAddDto.setScore(new BigDecimal(5));
        commentAddDto.setShopId(1l);
        System.out.println(JSON.toJSONString(commentAddDto));
        OrderSubmitDto orderSubmitDto = new OrderSubmitDto();
        orderSubmitDto.setItemId(1L);
        orderSubmitDto.setShopId(13L);
        orderSubmitDto.setRemark("请一位美女给我洗头");
        orderSubmitDto.setPayAmount(new BigDecimal(80));
        orderSubmitDto.setCouponAmount(new BigDecimal(20));
        orderSubmitDto.setMoneyFee(new BigDecimal(100));
        orderSubmitDto.setItemAmoun(new BigDecimal(100));
        System.out.println(JSON.toJSONString(orderSubmitDto));

        ItItemEo itItemEo = new ItItemEo();

        itItemEo.setName("单人日式高端丝绸睫毛嫁接");
        itItemEo.setShopId(1l);
        itItemEo.setPrice(new BigDecimal(100));
        itItemEo.setShopPrice(new BigDecimal(800));
        System.out.println(JSON.toJSONString(itItemEo));

        /**
         * 单人日式高端丝绸睫毛嫁接
         * 已售0截止日期: 2018年8月26日
         * ¥198门店价528
         */

        UserDto dto = new UserDto();
        dto.setAccountId(1l);
        dto.setAvatarUrl(new String("hah"));
        dto.setCreateTime(new Date());
        dto.setMobile("18814187970");
        dto.setUsername("jiyongiangusername");
        RestResponse restResponse = new RestResponse(dto);
        System.out.println(JSON.toJSONString(restResponse));


        ItShopBarberEo shopBarberEo = new ItShopBarberEo();

        shopBarberEo.setShopId(1L);
        shopBarberEo.setMotto("天生我才必有用，我就是个人才");
        shopBarberEo.setAppointTips(new BigDecimal(20));
        shopBarberEo.setGrade("经理");
        shopBarberEo.setTimes("三年");
        shopBarberEo.setName("pingTang");
//        shopBarberEo.set
        shopBarberEo.setWorkTime("周一至周六下午 9：00 -- 21：00");
        System.out.println(JSON.toJSONString(shopBarberEo));

        ItShopEo eo = new ItShopEo();
        eo.setShopName("东方发");
        eo.setBrandName("东方");
        eo.setAddress("鱼珠智谷");
        eo.setProvinceCode("");
        eo.setCityCode("");
        eo.setAreaCode("");
        eo.setStreetCode("");
        eo.setIntroduction("时尚 前沿 引领");
        System.out.println(JSON.toJSONString(eo));
    }
}
