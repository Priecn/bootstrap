package learn.rsb.bootstrap.services.templates;

import learn.rsb.bootstrap.models.Customer;
import learn.rsb.bootstrap.services.BaseCustomerService;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class TransactionTemplateCustomerService extends BaseCustomerService {

    private TransactionTemplate transactionTemplate;
    public TransactionTemplateCustomerService(DataSource ds, TransactionTemplate tt) {
        super(ds);
        this.transactionTemplate = tt;
    }

    @Override
    public Collection<Customer> save(String... names) {
        return this.transactionTemplate.execute(s -> super.save(names));
    }

    @Override
    public Customer findById(Long id) {
        return this.transactionTemplate.execute(s -> super.findById(id));
    }

    @Override
    public Collection<Customer> findAll() {
        return this.transactionTemplate.execute(s -> super.findAll());
    }
}
