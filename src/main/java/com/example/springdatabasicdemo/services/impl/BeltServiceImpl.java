package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BeltDto;
import com.example.springdatabasicdemo.dtos.BoxerDto;
import com.example.springdatabasicdemo.models.Belt;
import com.example.springdatabasicdemo.models.Boxer;
import com.example.springdatabasicdemo.models.BoxingOrganization;
import com.example.springdatabasicdemo.repositories.BeltRepository;
import com.example.springdatabasicdemo.repositories.BoxerRepository;
import com.example.springdatabasicdemo.repositories.BoxingOrganizationRepository;
import com.example.springdatabasicdemo.repositories.FigureRepository;
import com.example.springdatabasicdemo.services.BeltService;
import com.example.springdatabasicdemo.services.BoxerService;
import com.example.springdatabasicdemo.services.BoxingOrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeltServiceImpl implements BeltService {

    @Autowired
    private FigureRepository figureRepository;

    @Autowired
    private BoxerRepository boxerRepository;
    @Autowired
    BoxerService boxerService;

    @Autowired
    private BeltRepository beltRepository;

    @Autowired
    private BoxingOrganizationRepository boxingOrganizationRepository;
    @Autowired
    BoxingOrganizationService boxingOrganizationService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public BeltDto create(BeltDto beltDto) {
        BoxerDto b = beltDto.getBoxer();
        b.setId(Long.parseLong(String.valueOf(boxerService.getAll().size())));
        if (!boxerService.getAll().contains(b)){
            beltDto.setBoxer(boxerService.create(beltDto.getBoxer()));
            beltDto.setBoxer_id(beltDto.getBoxer().getId());
        }
        if (!boxingOrganizationService.getAll().contains(beltDto.getOrg())){
            beltDto.setOrg(boxingOrganizationService.create(beltDto.getOrg()));
            beltDto.setOrg_id(beltDto.getOrg().getId());
        }

        Belt s = modelMapper.map(beltDto, Belt.class);
        return modelMapper.map(beltRepository.save(s), BeltDto.class);
    }

    @Override
    public void destroyById(Long id) {
        beltRepository.deleteById(id.intValue());
    }

    @Override
    public void destroy(BeltDto figure) {
        beltRepository.deleteById(figure.getId().intValue());
    }

    @Override
    public Optional<BeltDto> find(Long id) {
        return Optional.ofNullable(modelMapper.map(beltRepository.findById(id.intValue()), BeltDto.class));
    }

    @Override
    public List<BeltDto> getAll() {
        return beltRepository.findAll().stream().map((s) -> modelMapper.map(s, BeltDto.class)).collect(Collectors.toList());
    }
}
