package com.study.web.common.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;

import java.math.BigInteger;

/**
 * 解决fastJson 转换long型，精度丢失的问题,把long 转换成String
 * @author jianghengfei
 * @date 2018年8月21日
 */
public class FastJsonConfigExt extends FastJsonConfig {

    public FastJsonConfigExt(){
        super();
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class,ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE,ToStringSerializer.instance);
        this.setSerializeConfig(serializeConfig);
    }

}
