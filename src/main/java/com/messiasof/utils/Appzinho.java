package com.messiasof.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/** 
 * @author MessiasOF
 * Forked on FalvoJr
 */
@EnableFeignClients
@SpringBootApplication
public class Appzinho {

	public static void main(String[] args) {
		SpringApplication.run(Appzinho.class, args);
	}

}
