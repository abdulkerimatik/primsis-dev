package com.primsis.smm.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.primsis.smm.ws.config.SmmWSConfig;

/**
 * @author abdulkerim.ATIK
 *
 */
@Import(SmmWSConfig.class)
@SpringBootApplication
public class SmmWSApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmmWSApplication.class, args);
    }
}




