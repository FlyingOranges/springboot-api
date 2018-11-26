package com.vue.api.utils;

import com.vue.api.CallInterface.RedisListInterface;
import com.vue.api.CallInterface.RedisObjectInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个 redis 工具类
 */
@Component
public class RedisUtils<T> {

    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 封装存储记录方案(字符串)
     *
     * @param key
     * @param time
     * @param data
     * @return
     */
    public String setRedisString(String key, long time, String data) {

        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        operations.set(key, data, time, TimeUnit.SECONDS);

        return data;
    }

    /**
     * 获取存储记录方案(字符串)
     *
     * @param key
     * @return
     */
    public String getRedisString(String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)) {
            return operations.get(key);
        }

        return null;
    }

    /**
     * 封装缓存记录方案(单记录)
     *
     * @param key                  标示
     * @param time                 秒
     * @param redisObjectInterface 接口类
     * @return
     */
    public Object remember(String key, long time, RedisObjectInterface redisObjectInterface) {

        ValueOperations<String, Object> operations = redisTemplate.opsForValue();

        if (redisTemplate.hasKey(key)) {
            return operations.get(key);
        }

        Object data = redisObjectInterface.getData();
        operations.set(key, data, time, TimeUnit.SECONDS);

        return data;
    }

    /**
     * 封装缓存记录方案(多记录)
     *
     * @param key                标示
     * @param time               秒
     * @param redisListInterface 接口类
     * @return
     */
    public List<T> remember(String key, long time, RedisListInterface redisListInterface) {

        ValueOperations<String, List> operations = redisTemplate.opsForValue();

        if (redisTemplate.hasKey(key)) {
            return operations.get(key);
        }

        List<T> data = redisListInterface.getData();
        operations.set(key, data, time, TimeUnit.SECONDS);

        return data;
    }

}
