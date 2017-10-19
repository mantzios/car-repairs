package com.teamnine.carrepairs;

import com.teamnine.carrepairs.converter.OwnerConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {
    
    @Bean
    public OwnerConverter ownerConverter(){
        return new OwnerConverter();
    }
}
