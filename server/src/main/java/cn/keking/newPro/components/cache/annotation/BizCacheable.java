package cn.keking.newPro.components.cache.annotation;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Cacheable
public @interface BizCacheable {

    @AliasFor("cacheNames")
    String[] value() default {"MODULE_BIZ_DEFAULT"};

    @AliasFor("value")
    String[] cacheNames() default {"MODULE_BIZ_DEFAULT"};

    String key() default "";

    String keyGenerator() default "";

    String cacheManager() default "";

    String cacheResolver() default "";

    String condition() default "";

    String unless() default "";

    String table() default "";

    String desc() default "";

    int timeToIdleSeconds() default 0;

    int timeToLiveSeconds() default 0;

}
