package com.always.learner.DocPortalSD;

import com.always.learner.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@RibbonClient(name = "doctor-service")

//to customize ribbon client with eureka only
@RibbonClient(name = "doctor-service-app", configuration = RibbonConfiguration.class)
@EnableDiscoveryClient
public class DocPortalSdApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocPortalSdApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
