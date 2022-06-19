package learn.rsb.bootstrap.services.scan;

import learn.rsb.bootstrap.services.templates.TransactionTemplateCustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Service
class DiscoveredCustomerService extends TransactionTemplateCustomerService {
    public DiscoveredCustomerService(DataSource ds, TransactionTemplate tt) {
        super(ds, tt);
    }
}
