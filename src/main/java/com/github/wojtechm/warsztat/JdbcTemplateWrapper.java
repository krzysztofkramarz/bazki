package com.github.wojtechm.warsztat;

import com.github.wojtechm.DataSourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        jdbcTemplate.execute("DROP TABLE  integrated_development IF EXISTS");
        jdbcTemplate.execute("create table integrated_development (id SERIAL NOT NULL AUTO_INCREMENT, nazwa VARCHAR(255), licencja  VARCHAR(255), java BOOL,  linux BOOL )");
    }

    private void dodajIde() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"BlueJ", "GPL2+GNU linking exception", true, true});
        objects.add(new Object[]{"IntelliJ IDEA", "Community Edition: Apache License v2.0", true, true});

        jdbcTemplate.batchUpdate("INSERT INTO integrated_development ( nazwa, licencja, java, linux) VALUES (?,?,?,?)", objects);
    }

    private void wyświetlIde() {

        RowMapper<IntegratedDevelopmentEnvironment> rowMapper = new RowMapper<IntegratedDevelopmentEnvironment>() {
            @Override
            public IntegratedDevelopmentEnvironment mapRow(ResultSet rs, int rowNum) throws SQLException {
                IntegratedDevelopmentEnvironment integratedDevelopmentEnvironment = new IntegratedDevelopmentEnvironment();
                integratedDevelopmentEnvironment.setId(rs.getLong("id"));
                integratedDevelopmentEnvironment.setNazwa(rs.getString("nazwa"));
                integratedDevelopmentEnvironment.setLicencja(rs.getString("licencja"));
                integratedDevelopmentEnvironment.setCzyNapisanyWJavie(rs.getBoolean("java"));
                integratedDevelopmentEnvironment.setCzyWspieraLinux(rs.getBoolean("linux"));
                return integratedDevelopmentEnvironment;
            }
        };
        List<IntegratedDevelopmentEnvironment> query = jdbcTemplate.query("SELECT * FROM integrated_development", rowMapper);
        for (IntegratedDevelopmentEnvironment integratedDevelopmentEnvironment : query) {
            System.out.println(integratedDevelopmentEnvironment);
        }
        System.out.println("");
        System.out.println("##################################");
    }

    private IntegratedDevelopmentEnvironment dawajIntellidżejke() {

        RowMapper<IntegratedDevelopmentEnvironment> rowMapper = new RowMapper<IntegratedDevelopmentEnvironment>() {
            @Override
            public IntegratedDevelopmentEnvironment mapRow(ResultSet rs, int rowNum) throws SQLException {
                IntegratedDevelopmentEnvironment integratedDevelopmentEnvironment = new IntegratedDevelopmentEnvironment();
                integratedDevelopmentEnvironment.setId(rs.getLong("id"));
                integratedDevelopmentEnvironment.setNazwa(rs.getString("nazwa"));
                integratedDevelopmentEnvironment.setLicencja(rs.getString("licencja"));
                integratedDevelopmentEnvironment.setCzyNapisanyWJavie(rs.getBoolean("java"));
                integratedDevelopmentEnvironment.setCzyWspieraLinux(rs.getBoolean("linux"));
                return integratedDevelopmentEnvironment;
            }
        };
        List<IntegratedDevelopmentEnvironment> query = jdbcTemplate.query("SELECT * FROM integrated_development WHERE nazwa = 'IntelliJ IDEA'", rowMapper);
        return query.get(0);
    }

    private void zaktualizuj(IntegratedDevelopmentEnvironment integratedDevelopmentEnvironment) {
        jdbcTemplate.update("UPDATE integrated_development SET licencja = ?  WHERE nazwa = 'IntelliJ IDEA'", integratedDevelopmentEnvironment.getLicencja());
    }
}
