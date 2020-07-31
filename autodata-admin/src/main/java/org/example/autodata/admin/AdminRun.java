package org.example.autodata.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * author:north
 * Date:2020/7/31 ：15:02
 */
@SpringBootApplication(scanBasePackages = {"org.example.autodata.admin","org.example.autodata.core"})
@EnableJpaRepositories(basePackages = {"org.example.autodata.dao.repository"})
@EntityScan(basePackages = {"org.example.autodata.dao.domain"})
@EnableTransactionManagement
public class AdminRun {
    public static void main(String[] args) {
        SpringApplication.run(AdminRun.class, args);
    }
}
