package cn.keking.newPro.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching // 确保缓存注解驱动已开启
public class RedisCacheConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        // 1. 定义默认配置（作为基础）
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1)) // 默认缓存1小时
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

        // 2. 定义特定缓存名称的配置（核心，比默认配置优先级高）
        Map<String, RedisCacheConfiguration> specificConfigs = new HashMap<>();

        // 为 fileInfoCache 设置 10 分钟的 TTL
        specificConfigs.put(
                "fileInfoCache",
                defaultCacheConfig.entryTtl(Duration.ofMinutes(10))
        );

        // 3. 构建 CacheManager
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaultCacheConfig)
                .withInitialCacheConfigurations(specificConfigs) // 加载特定名称的配置
                .build();
    }
}