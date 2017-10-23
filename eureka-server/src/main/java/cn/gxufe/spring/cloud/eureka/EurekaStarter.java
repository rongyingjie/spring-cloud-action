package cn.gxufe.spring.cloud.eureka;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaStarter {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaStarter.class).web(true).run(args);
    }

}
