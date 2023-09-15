package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;

import com.example.springdatabasicdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private final FigureService figureService;
    @Autowired
    private final BoxerService boxerService;
    @Autowired
    BoxingOrganizationService boxingOrganizationService;
    @Autowired
    private final BeltService beltService;

    FigureOfBoxerService figureOfBoxerService;

    public CommandLineRunnerImpl(FigureService figureService, BoxerService boxerService, BeltService beltService, FigureOfBoxerService figureOfBoxerService) {
        this.figureService = figureService;
        this.boxerService = boxerService;
        this.beltService = beltService;
        this.figureOfBoxerService = figureOfBoxerService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        printAllPriceByNickname("Money");
        figureService.findFiguresByOrganization("WBC").forEach(System.out::println);;
    }

    private void printAllPriceByNickname(String nickname) {
        figureService.findPriceOfFigureByNickname(nickname)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {

        BoxerDto boxer1 = new BoxerDto("Money", "Floyd", "Maywether", 173, 75, "phily shell");
        FigureDto figure1 = new FigureDto(100.0, "small");
        FigureOfBoxerDto figureOfBoxer1 = new FigureOfBoxerDto(boxerService.create(boxer1), figureService.create(figure1));
//        FigureOfBoxerDto figureOfBoxer1 = new FigureOfBoxerDto(boxer1, figure1);
        figureOfBoxerService.create(figureOfBoxer1);

        BoxingOrganizationDto boxingOrganizationDto = new BoxingOrganizationDto("WBC", 1961);
        BeltDto beltDto = new BeltDto(boxer1, boxingOrganizationService.create(boxingOrganizationDto), 1998);
        beltService.create(beltDto);

    }
}

