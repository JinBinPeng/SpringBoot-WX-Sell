package com.pjb.springbootweixinseller.service;

import com.pjb.springbootweixinseller.dto.OrderDTO;

/**
 * 推送消息
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     */
    void orderStatus(OrderDTO orderDTO);
}
