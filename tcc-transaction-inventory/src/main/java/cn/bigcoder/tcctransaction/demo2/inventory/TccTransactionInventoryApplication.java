package cn.bigcoder.tcctransaction.demo2.inventory;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mengyun.tcctransaction.spring.annotation.EnableTccTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTccTransaction
@EnableDubbo(scanBasePackages = "cn.bigcoder.tcctransaction.demo2.inventory.service")
public class TccTransactionInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TccTransactionInventoryApplication.class, args);
    }

}
