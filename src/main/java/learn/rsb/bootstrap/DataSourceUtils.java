package learn.rsb.bootstrap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

public class DataSourceUtils {
    public static DataSource initializeDdl(DataSource dataSource) {
        ResourceDatabasePopulator resourceDatabasePopulator
                = new ResourceDatabasePopulator(new ClassPathResource("/schema.sql"));
        DatabasePopulatorUtils.execute(resourceDatabasePopulator, dataSource);
        return dataSource;
    }
}
