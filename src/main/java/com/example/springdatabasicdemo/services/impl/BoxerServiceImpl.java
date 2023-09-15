package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BoxerDto;
import com.example.springdatabasicdemo.dtos.FigureDto;
import com.example.springdatabasicdemo.models.Boxer;
import com.example.springdatabasicdemo.models.Boxer;
import com.example.springdatabasicdemo.repositories.BeltRepository;
import com.example.springdatabasicdemo.repositories.BoxerRepository;
import com.example.springdatabasicdemo.repositories.BoxingOrganizationRepository;
import com.example.springdatabasicdemo.repositories.FigureRepository;
import com.example.springdatabasicdemo.services.BoxerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoxerServiceImpl implements BoxerService {
    @Autowired
    private BoxerRepository boxerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BoxerDto create(BoxerDto boxerDto) {
        Boxer s = modelMapper.map(boxerDto, Boxer.class);
        return modelMapper.map(boxerRepository.save(s), BoxerDto.class);
    }

    @Override
    public void destroyById(Long id) {
        boxerRepository.deleteById(id);
    }

    @Override
    public void destroy(BoxerDto figure) {
        boxerRepository.deleteById(figure.getId());
    }

    @Override
    public Optional<BoxerDto> find(Long id) {
        return Optional.ofNullable(modelMapper.map(boxerRepository.findById(id), BoxerDto.class));
    }

    @Override
    public List<BoxerDto> getAll() {
        return boxerRepository.findAll().stream().map((s) -> modelMapper.map(s, BoxerDto.class)).collect(Collectors.toList());
    }
}
