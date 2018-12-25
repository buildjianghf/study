package com.study.web;



import javax.annotation.Resource;

import com.study.service.CommonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


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


    @Test
    public void processSuccess() {
        CommonServiceImpl.processSuccess(false);

    }


}
