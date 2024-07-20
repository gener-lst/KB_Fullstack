package org.scoula.todo.config;

import org.scoula.todo.common.JDBCUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@Configuration
@ComponentScan({"org.scoula.todo"})
public class ProjectConfig {
    @Bean
    Connection conn() throws Exception {
        Properties prop = new Properties();
        prop.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String id = prop.getProperty("id");
        String password = prop.getProperty("password");

        Class.forName(driver);
        return DriverManager.getConnection(url, id, password);
    }
}
