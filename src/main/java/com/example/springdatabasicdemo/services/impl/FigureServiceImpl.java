package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.SpringDataBasicDemoApplication;
import com.example.springdatabasicdemo.dtos.BeltBoxerCollectionDto;
import com.example.springdatabasicdemo.dtos.BeltDto;
import com.example.springdatabasicdemo.dtos.FigureDto;
import com.example.springdatabasicdemo.dtos.PriceForFigureDto;
import com.example.springdatabasicdemo.models.Figure;
import com.example.springdatabasicdemo.models.FigureOfBoxer;
import com.example.springdatabasicdemo.repositories.BeltRepository;
import com.example.springdatabasicdemo.repositories.BoxerRepository;
import com.example.springdatabasicdemo.repositories.BoxingOrganizationRepository;
import com.example.springdatabasicdemo.repositories.FigureRepository;
import com.example.springdatabasicdemo.services.FigureService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FigureServiceImpl implements FigureService {

    @Autowired
    private FigureRepository figureRepository;

    @Autowired
    private BoxerRepository boxerRepository;

    @Autowired
    private BeltRepository beltRepository;

    @Autowired
    private BoxingOrganizationRepository boxingOrganizationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FigureDto create(FigureDto figure) {
        Figure s = modelMapper.map(figure, Figure.class);
//        if (figure.getBoxerDto().getId() != 0) {
//            Boxer g = boxerRepository.findById(figure.getBoxerDto().getId()).get();
//            s(g);
//        }
        return modelMapper.map(figureRepository.save(s), FigureDto.class);
    }

    @Override
    public Optional<FigureDto> find(Long id) {
        return Optional.ofNullable(modelMapper.map(figureRepository.findById(id), FigureDto.class));
    }


    @Override
    public void destroyById(Long id) {
        figureRepository.deleteById(id);
    }

    @Override
    public void destroy(FigureDto figure) {
        figureRepository.deleteById(figure.getId());
    }


    @Override
    public List<FigureDto> getAll() {
        return figureRepository.findAll().stream().map((s) -> modelMapper.map(s, FigureDto.class)).collect(Collectors.toList());
    }

//    @Override
//    public List<FigureDto> findPriceOfFigureByNickname(String nickname) {
//        return null;
//    }

    @Override
    public List<BeltBoxerCollectionDto> findFiguresByOrganization(String org) {
        List<BeltBoxerCollectionDto> beltBoxerCollectionDtos = new ArrayList<>();
        for (FigureOfBoxer s: figureRepository.findAllByBelt(org)) {
                beltBoxerCollectionDtos.add(SpringDataBasicDemoApplication.typeMap.map(s));
        }
        return beltBoxerCollectionDtos;
    }

    @Override
    public List<PriceForFigureDto> findPriceOfFigureByNickname(String nickname) {
        return figureRepository
                .findAllByNickname(nickname).stream()
                .map((s) -> modelMapper.map(s, PriceForFigureDto.class))
                .collect(Collectors.toList());
    }

}
