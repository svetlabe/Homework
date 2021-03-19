package no.dnb.reskill.andyonlineretailer.jpaModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {


    private JdbcTemplate jdbcTemplate;

    public SeedDb(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
		jdbcTemplate.update("insert into PRODUCTS (description, price, inStock) values (?, ?, ?)", new Object[]{"Lamborghini Sian", 2200000, 2});
        jdbcTemplate.update("insert into PRODUCTS (description, price, inStock) values (?, ?, ?)", new Object[]{"Bugatti Divo", 4000000,1});
        jdbcTemplate.update("insert into PRODUCTS (description, price, inStock) values (?, ?, ?)", new Object[]{"Jaguar I-Pacen", 80000, 4});
        jdbcTemplate.update("insert into PRODUCTS (description, price, inStock) values (?, ?, ?)", new Object[]{"BMW 3", 50000,10});
        jdbcTemplate.update("insert into PRODUCTS (description, price, inStock) values (?, ?, ?)", new Object[]{"BMW 5", 150000,10});
        jdbcTemplate.update("insert into PRODUCTS (description, price, inStock) values (?, ?, ?)", new Object[]{"Volvo S90", 85000,15});

    }
}
