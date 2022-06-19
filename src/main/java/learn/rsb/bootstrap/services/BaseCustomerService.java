package learn.rsb.bootstrap.services;

import learn.rsb.bootstrap.models.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class BaseCustomerService implements CustomerService {

    private final RowMapper<Customer> rowMapper
            = (rs, i) -> new Customer(rs.getLong("id"), rs.getString("name"));

    private final JdbcTemplate jdbcTemplate;

    protected BaseCustomerService(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
    @Override
    public Collection<Customer> save(String... names) {
        return Arrays.stream(names).map( name -> {
                KeyHolder keyHolder = new GeneratedKeyHolder();
                this.jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO CUSTOMERS (name) VALUES (?)",
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, name);
                    return ps;
                }, keyHolder);
                Long keyHolderKey = Objects.requireNonNull(keyHolder.getKey()).longValue();
                Customer customer = this.findById(keyHolderKey);
                Assert.notNull(name, "The given name must not be null");
                return customer;
            }
        ).collect(Collectors.toList());
    }

    @Override
    public Customer findById(Long id) {
        String sql = "select * from CUSTOMERS where id = ?";
        return this.jdbcTemplate.queryForObject(sql, this.rowMapper, id);
    }

    @Override
    public Collection<Customer> findAll() {
        return this.jdbcTemplate.query("select * from CUSTOMERS", rowMapper);
    }
}
