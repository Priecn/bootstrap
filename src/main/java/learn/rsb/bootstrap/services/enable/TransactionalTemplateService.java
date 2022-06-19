package learn.rsb.bootstrap.services.enable;

import learn.rsb.bootstrap.models.Customer;
import learn.rsb.bootstrap.services.BaseCustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Collection;

@Service
@Transactional
class TransactionalTemplateService extends BaseCustomerService {
    protected TransactionalTemplateService(DataSource ds) {
        super(ds);
    }

    @Override
    public Collection<Customer> save(String... names) {
        return super.save(names);
    }

    @Override
    public Customer findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Collection<Customer> findAll() {
        return super.findAll();
    }
}
