package learn.rsb.bootstrap.services.bootiful;

import learn.rsb.bootstrap.services.enable.TransactionalTemplateService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class BootifulCustomerService extends TransactionalTemplateService {
    public BootifulCustomerService(DataSource ds) {
        super(ds);
    }
}
