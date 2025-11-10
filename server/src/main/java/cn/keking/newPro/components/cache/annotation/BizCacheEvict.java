package cn.keking.newPro.components.cache.annotation;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@CacheEvict
public @interface BizCacheEvict {

    @AliasFor("cacheNames")
    String[] value() default {"MODULE_BIZ_DEFAULT"};

    @AliasFor("value")
    String[] cacheNames() default {"MODULE_BIZ_DEFAULT"};

    String key() default "";

    String keyGenerator() default "";

    String cacheManager() default "";

    String cacheResolver() default "";

    String condition() default "";

    boolean allEntries() default false;

    boolean beforeInvocation() default false;
}
