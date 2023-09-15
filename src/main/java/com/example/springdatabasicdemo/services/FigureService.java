package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BeltBoxerCollectionDto;
import com.example.springdatabasicdemo.dtos.BeltDto;
import com.example.springdatabasicdemo.dtos.FigureDto;
import com.example.springdatabasicdemo.dtos.PriceForFigureDto;

import java.util.List;

public interface FigureService extends BaseService<FigureDto, Long> {

    List<PriceForFigureDto> findPriceOfFigureByNickname(String nickname);

    List<BeltBoxerCollectionDto> findFiguresByOrganization(String org);

}

