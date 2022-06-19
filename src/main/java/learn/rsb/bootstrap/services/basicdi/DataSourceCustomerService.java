package learn.rsb.bootstrap.services.basicdi;

import learn.rsb.bootstrap.services.BaseCustomerService;

import javax.sql.DataSource;

class DataSourceCustomerService extends BaseCustomerService {
    protected DataSourceCustomerService(DataSource ds) {
        super(ds);
    }
}
