package com.pjb.springbootweixinseller.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pjb.springbootweixinseller.dataobject.OrderDetail;
import com.pjb.springbootweixinseller.dto.OrderDTO;
import com.pjb.springbootweixinseller.enums.ResultEnum;
import com.pjb.springbootweixinseller.exception.SellException;
import com.pjb.springbootweixinseller.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {
    private OrderForm2OrderDTOConverter(){

    }
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
