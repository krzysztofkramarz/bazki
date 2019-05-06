package com.github.wojtechm.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Wojciech Makiela
 */
@SpringBootApplication
class App implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        DataSourceConfig config = new DataSourceConfig();
        JdbcTemplateWrapper jdbcTemplate = new JdbcTemplateWrapper(config);
        jdbcTemplate.playWithPokemon();

        JooqWrapper jooq = new JooqWrapper(config);
        jooq.playWithPokemon();
    }
}
