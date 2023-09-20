package az.mybank.ms.customer.config;

import az.mybank.ms.customer.mapper.CustomerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MapperConfiguration {

    @Bean
    public CustomerMapper customerMapper() {
        return CustomerMapper.INSTANCE;
    }

}
