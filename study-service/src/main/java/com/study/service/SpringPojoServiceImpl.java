/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.study.service;


import com.study.dao.common.OrderItemRepository;
import com.study.dao.common.OrderRepository;
import com.study.domain.Order;
import com.study.domain.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class SpringPojoServiceImpl extends CommonServiceImpl implements SpringPojoService {
    
    @Resource
    private OrderRepository orderRepository;
    
    @Resource
    private OrderItemRepository orderItemRepository;
    
    @Override
    protected OrderRepository getOrderRepository() {
        return orderRepository;
    }
    
    @Override
    protected OrderItemRepository getOrderItemRepository() {
        return orderItemRepository;
    }
    
    @Override
    protected Order newOrder() {
        return new Order();
    }
    
    @Override
    protected OrderItem newOrderItem() {
        return new OrderItem();
    }
}
