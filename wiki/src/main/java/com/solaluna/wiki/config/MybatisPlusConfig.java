package com.solaluna.wiki.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.solaluna.wiki.config.typeHandler.CharaTypeHandler;
import com.solaluna.wiki.config.typeHandler.GroupTypeHandler;
import com.solaluna.wiki.config.typeHandler.MapTypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement  //开启事务
@MapperScan(value = "com.solaluna.wiki.mapper")  //必须开启扫描，不然无法将生成的Mapper注入
public class MybatisPlusConfig{

    //分页器
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    public MapTypeHandler mapTypeHandler() {
        return new MapTypeHandler();
    }
    @Bean
    public CharaTypeHandler charaTypeHandler() {
        return new CharaTypeHandler();
    }
    @Bean
    public GroupTypeHandler groupTypeHandler() {
        return new GroupTypeHandler();
    }

}