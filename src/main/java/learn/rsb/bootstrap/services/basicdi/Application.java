package learn.rsb.bootstrap.services.basicdi;

import learn.rsb.bootstrap.DataSourceUtils;
import learn.rsb.bootstrap.Demo;
import learn.rsb.bootstrap.services.CustomerService;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

class Application {
    public static void main(String[] args) {
        DataSource dataSource
                = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                    .build();
        DataSource initialized = DataSourceUtils.initializeDdl(dataSource);
        CustomerService customerService = new DataSourceCustomerService(initialized);
        Demo.workWithCustomerService(Application.class, customerService);
    }
}
