package ch.bfh.frauen.dj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DjServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DjServiceApplication.class, args);
	}
}
