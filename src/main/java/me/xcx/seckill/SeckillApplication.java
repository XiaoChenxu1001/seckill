package me.xcx.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@MapperScan // TODO 不能，会和ComposeScan重复扫描，起冲突！
//@MapperScan 为接口实现代理类
@MapperScan("me.xcx.seckill.mapper") // 注册指定包下的接口
public class SeckillApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SeckillApplication.class, args);

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

    }

}
