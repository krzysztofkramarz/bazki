package com.github.wojtechm.warsztat;

import com.github.wojtechm.DataSourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Wojciech Makiela
 */
class JdbcTemplateWrapper {

    private JdbcTemplate jdbcTemplate;

    JdbcTemplateWrapper(DataSourceConfig sourceConfig) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(sourceConfig.driverName);
        dataSource.setUrl(sourceConfig.url);
        dataSource.setUsername(sourceConfig.username);
        dataSource.setPassword(sourceConfig.password);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    void róbRzeczyZIde() {
        stwórzTabelę();
        dodajIde();
        wyświetlIde();
        IntegratedDevelopmentEnvironment intellij = dawajIntellidżejke();
        intellij.licencja = "Ultimate Edition: proprietary";
        zaktualizuj(intellij);
        wyświetlIde();
    }

    private void stwórzTabelę() {

    }

    private void dodajIde() {

    }

    private void wyświetlIde() {

    }

    private IntegratedDevelopmentEnvironment dawajIntellidżejke() {
        return null;
    }

    private void zaktualizuj(IntegratedDevelopmentEnvironment integratedDevelopmentEnvironment) {

    }
}
