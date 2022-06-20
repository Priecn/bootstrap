package learn.rsb.bootstrap.services.bootiful;

import learn.rsb.bootstrap.models.Customer;
import learn.rsb.bootstrap.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BootifulRestController {

    private final CustomerService customerService;

    public BootifulRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    Collection<Customer> get() {
        return this.customerService.findAll();
    }
}
