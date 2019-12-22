package cn.china.wxprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controller","serviceimpl","util"})
@MapperScan("mapper")
public class WxprogramApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxprogramApplication.class, args);
    }

}
