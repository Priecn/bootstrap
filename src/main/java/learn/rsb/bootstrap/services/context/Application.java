package learn.rsb.bootstrap.services.context;

import learn.rsb.bootstrap.DataSourceConfiguration;
import learn.rsb.bootstrap.Demo;
import learn.rsb.bootstrap.SpringUtils;
import learn.rsb.bootstrap.services.CustomerService;
import learn.rsb.bootstrap.services.templates.TransactionTemplateCustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfiguration.class)
public class Application {

    @Bean
    PlatformTransactionManager transactionManager (DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean
    TransactionTemplateCustomerService customerService(DataSource ds, TransactionTemplate tt) {
        return new TransactionTemplateCustomerService(ds, tt);
    }

    @Bean
    TransactionTemplate transactionTemplate (PlatformTransactionManager tm) {
        return new TransactionTemplate(tm);
    }

    public static void main(String[] args) {
        ApplicationContext ac = SpringUtils.run(Application.class, "prod");
        CustomerService cs = ac.getBean(CustomerService.class);
        Demo.workWithCustomerService(Application.class, cs);
    }
}
