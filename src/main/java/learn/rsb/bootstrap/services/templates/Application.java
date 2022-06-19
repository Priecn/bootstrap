package learn.rsb.bootstrap.services.templates;

import learn.rsb.bootstrap.DataSourceUtils;
import learn.rsb.bootstrap.Demo;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

class Application {
    public static void main(String[] args) {
        DataSource ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .build();
        DataSource initialized = DataSourceUtils.initializeDdl(ds);
        PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(initialized);
        TransactionTemplate tt = new TransactionTemplate(platformTransactionManager);
        TransactionTemplateCustomerService service = new TransactionTemplateCustomerService(initialized, tt);
        Demo.workWithCustomerService(Application.class, service);
    }
}
