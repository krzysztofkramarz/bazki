package com.github.wojtechm.jdbc;

import java.util.ResourceBundle;

/**
 * @author Wojciech Makiela
 */
class DataSourceConfig {
    String url;
    String username;
    String password;
    String driverName;

    DataSourceConfig() {
        ResourceBundle config = ResourceBundle.getBundle("application");
        url = config.getString("spring.datasource.url");
        username = config.getString("spring.datasource.username");
        password = config.getString("spring.datasource.password");
        driverName = config.getString("datasource.driverName");
    }
}
