package com.example.springdatabasicdemo.services.impl;


import com.example.springdatabasicdemo.dtos.FigureOfBoxerDto;
import com.example.springdatabasicdemo.dtos.FigureOfBoxerDto;
import com.example.springdatabasicdemo.models.Belt;
import com.example.springdatabasicdemo.models.FigureOfBoxer;
import com.example.springdatabasicdemo.repositories.*;
import com.example.springdatabasicdemo.services.BoxerService;
import com.example.springdatabasicdemo.services.FigureOfBoxerService;
import com.example.springdatabasicdemo.services.FigureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FigureOfBoxerServiceImpl implements FigureOfBoxerService {
    @Autowired
    private FigureRepository figureRepository;
    @Autowired
    private FigureService figureService;

    @Autowired
    private BoxerRepository boxerRepository;
    @Autowired
    private BoxerService boxerService;
    @Autowired
    private BeltRepository beltRepository;

    @Autowired
    private BoxingOrganizationRepository boxingOrganizationRepository;
    @Autowired
    private FigureOfBoxerRepository figureOfBoxerRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public FigureOfBoxerDto create(FigureOfBoxerDto figureOfBoxerDto) {
        if (!boxerService.getAll().contains(figureOfBoxerDto.getBoxer())){
            figureOfBoxerDto.setBoxer(boxerService.create(figureOfBoxerDto.getBoxer()));
            figureOfBoxerDto.setBoxer_id(figureOfBoxerDto.getBoxer().getId());
        }
        if (!figureService.getAll().contains(figureOfBoxerDto.getFigure())){
            figureOfBoxerDto.setFigure(figureService.create(figureOfBoxerDto.getFigure()));
            figureOfBoxerDto.setFigure_id(figureOfBoxerDto.getFigure().getId());
        }

        FigureOfBoxer s = modelMapper.map(figureOfBoxerDto, FigureOfBoxer.class);
        figureOfBoxerDto = modelMapper.map(figureOfBoxerRepository.save(s), FigureOfBoxerDto.class);
        System.out.println(figureOfBoxerDto);
        return figureOfBoxerDto;
    }

    @Override
    public void destroyById(Long id) {
        figureOfBoxerRepository.deleteById(id);
    }

    @Override
    public void destroy(FigureOfBoxerDto figure) {
        figureOfBoxerRepository.deleteById(figure.getId());
    }

    @Override
    public Optional<FigureOfBoxerDto> find(Long id) {
        return Optional.ofNullable(modelMapper.map(figureOfBoxerRepository.findById(id), FigureOfBoxerDto.class));
    }


    @Override
    public List<FigureOfBoxerDto> getAll() {
        System.out.println("PPPPPPPPPPPPPPPPPPPPPP");
        System.out.println();
        return figureOfBoxerRepository.findAll().stream().map((s) -> modelMapper.map(s, FigureOfBoxerDto.class)).collect(Collectors.toList());
    }
}
