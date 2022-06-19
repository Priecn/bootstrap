package learn.rsb.bootstrap.services.hardcoded;


import learn.rsb.bootstrap.DataSourceUtils;
import learn.rsb.bootstrap.services.BaseCustomerService;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
class DevelopmentOnlyCustomerService extends BaseCustomerService {
    // Don't do this
    DevelopmentOnlyCustomerService() {
        super(buildDataSource());
    }
    private static DataSource buildDataSource() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2).build();
        return DataSourceUtils.initializeDdl(dataSource);
    }
}
