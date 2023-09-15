package com.example.springdatabasicdemo;

import com.example.springdatabasicdemo.dtos.BeltBoxerCollectionDto;
import com.example.springdatabasicdemo.models.FigureOfBoxer;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataBasicDemoApplication {

    public static TypeMap<FigureOfBoxer, BeltBoxerCollectionDto> typeMap;

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        typeMap = modelMapper.createTypeMap(
                FigureOfBoxer.class, BeltBoxerCollectionDto.class);
        typeMap.addMapping((src -> src.getBoxer().getNickname()),BeltBoxerCollectionDto::setNickname);
        typeMap.addMapping((src -> src.getFigure().getPrice()), BeltBoxerCollectionDto::setPrice);
        typeMap.addMapping((src -> src.getFigure().getSize()), BeltBoxerCollectionDto::setSize);
        typeMap.addMapping((src -> src.getBoxer().getName()), BeltBoxerCollectionDto::setName);
        typeMap.addMapping((src -> src.getBoxer().getSurname()), BeltBoxerCollectionDto::setSurname);
        return modelMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataBasicDemoApplication.class, args);
    }

}
