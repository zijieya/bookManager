package bookmanager.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration

public class DataSourceConfiguration {
    @Bean
    public DataSource dataSource(){
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://119.29.151.185:3306/spring_BookManager");
        ds.setUsername("spring");
        ds.setPassword("741258963");
        return ds;
    }
    //构造器方式注入bean
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
