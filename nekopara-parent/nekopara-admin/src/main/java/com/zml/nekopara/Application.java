package com.zml.nekopara;/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/6/30
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/6/30
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
//@EnableCaching//使用缓存
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
