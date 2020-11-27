package com.ticketsMgrSysWayClient_8522;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages ="com.ticketsMgrSysWayClient_8522.feignClientService")
public class TicketsMgrSysWayClient8522Application {

	public static void main(String[] args) {
		SpringApplication.run(TicketsMgrSysWayClient8522Application.class, args);
	}

}
