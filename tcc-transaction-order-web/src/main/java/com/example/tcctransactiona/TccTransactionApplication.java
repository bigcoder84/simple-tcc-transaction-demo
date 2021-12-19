package com.example.tcctransactiona;

import org.mengyun.tcctransaction.spring.annotation.EnableTccTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTccTransaction
public class TccTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TccTransactionApplication.class, args);
    }

}
