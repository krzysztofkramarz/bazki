package com.github.wojtechm;

import java.util.ResourceBundle;

/**
 * @author Wojciech Makiela
 */
public class DataSourceConfig {
    public String url;
    public String username;
    public String password;
    public String driverName;

    public DataSourceConfig() {
        ResourceBundle config = ResourceBundle.getBundle("application");
        url = config.getString("spring.datasource.url");
        username = config.getString("spring.datasource.username");
        password = config.getString("spring.datasource.password");
        driverName = config.getString("datasource.driverName");
    }
}
