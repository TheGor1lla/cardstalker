package de.gor1lla.cardstalker;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MapperConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
