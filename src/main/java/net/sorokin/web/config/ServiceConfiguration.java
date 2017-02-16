package net.sorokin.web.config;


import net.sorokin.dao.cardao.CarDao;
import net.sorokin.dao.cardao.CarDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("net.sorokin.dao")
public class ServiceConfiguration {

    @Bean
    public CarDao carDao() {
        return new CarDaoImpl();
    }
}
