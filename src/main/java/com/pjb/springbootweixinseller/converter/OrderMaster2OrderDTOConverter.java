package com.pjb.springbootweixinseller.converter;

import com.pjb.springbootweixinseller.dataobject.OrderMaster;
import com.pjb.springbootweixinseller.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;


public class OrderMaster2OrderDTOConverter {
    private OrderMaster2OrderDTOConverter(){

    }
    private static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(OrderMaster2OrderDTOConverter::convert).collect(Collectors.toList());
    }
}
