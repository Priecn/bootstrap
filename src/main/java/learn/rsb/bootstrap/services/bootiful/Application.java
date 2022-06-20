package learn.rsb.bootstrap.services.bootiful;

import learn.rsb.bootstrap.Demo;
import learn.rsb.bootstrap.services.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "dev");
        SpringApplication.run(Application.class, args);
    }
}

@Profile("dev")
@Component
class DemoListener {
    private final CustomerService customerService;

    DemoListener(CustomerService customerService) {
        this.customerService = customerService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void exercise() {
        Demo.workWithCustomerService(Application.class, this.customerService);
    }
}