package com.study.web;



import javax.annotation.Resource;

import com.study.dao.mapper.MybatisOrderRepository;
import com.study.domain.Order;
import com.study.domain.OrderItem;
import com.study.service.CommonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * 测试分库分表规则
 * @author liuyazhuang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class ShardingJdbcMybatisTest {


    @Resource
    CommonService CommonServiceImpl;

    @Resource
    MybatisOrderRepository mybatisOrderRepository;


    @Test
    public void processSuccess() {
        CommonServiceImpl.processSuccess(false);

    }

    @Test
    public void insert(){
        List<Long> result = new ArrayList<>(10);
        for (int i = 1; i <= 1000; i++) {
            Order order = new Order();
            order.setUserId(i);
            order.setStatus(""+i);
            mybatisOrderRepository.insert(order);

        }
    }

    @Test
    public void selectRangeByStatus(){
       List<Order> list =  mybatisOrderRepository.selectRangeByStatus();
       for (Order o :list){
           System.out.println(o.getOrderId() +"  "+o.getStatus());
       }
    }


}
