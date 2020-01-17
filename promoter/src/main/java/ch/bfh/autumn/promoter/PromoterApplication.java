package ch.bfh.autumn.promoter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PromoterApplication {

  public static void main(String[] args) {
    SpringApplication.run(PromoterApplication.class, args);
  }

}
