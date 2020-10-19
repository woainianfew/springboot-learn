/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.common.config;

import com.huyang.common.realm.AuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置
 *
 * @author huayng
 * @since 1.0
 */
@Configuration
public class ShiroConfig {

    /**
     * 功能描述: 路径过滤规则
     * @param: securityManager
     * @return: ShiroFilterFactoryBean
     * @auther: huyang
     * @date: 2020/10/16 15:23
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置 默认会寻找web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        // 拦截器
        Map<String,String> map = new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        map.put("/login","anon");
        // 过滤链定义，从上向下顺序执行，一般将 /**放在最下边
        // 进行身份认证后才能访问
        // authc:所有url都必须通过认证才可以访问； anon: 所有url都可以匿名访问
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 功能描述: 自定义身份认证Realm（包含用户名密码校验、权限校验）
     * @return:
     * @auther: huyang
     * @date: 2020/10/16 15:42
     */
    @Bean
    public AuthRealm authRealm(){
        return new AuthRealm();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm());
        return securityManager;
    }
    
    /**
     *
     * 功能描述: 开启Shiro注解模式，可以在Controller中的方法上添加注解
     * @param: securityManager
     * @return: AuthorizationAttributeSourceAdvisor
     * @auther: huyang
     * @date: 2020/10/16 16:07
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
    