package hzero.train.eureka;
import org.hzero.autoconfigure.register.EnableHZeroRegister;
import org.hzero.autoconfigure.gateway.EnableHZeroGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableHZeroRegister
@EnableHZeroGateway
@EnableEurekaServer
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TrainEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainEurekaApplication.class, args);
    }
}
