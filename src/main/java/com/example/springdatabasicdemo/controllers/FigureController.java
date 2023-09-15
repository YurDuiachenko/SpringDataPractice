package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.BeltBoxerCollectionDto;
import com.example.springdatabasicdemo.dtos.BeltDto;
import com.example.springdatabasicdemo.dtos.FigureDto;
import com.example.springdatabasicdemo.dtos.PriceForFigureDto;
import com.example.springdatabasicdemo.exeptions.FigureNotFoundAdvice;
import com.example.springdatabasicdemo.exeptions.FigureNotFoundException;
import com.example.springdatabasicdemo.services.FigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FigureController {

    @Autowired
    private FigureService figureService;

    @GetMapping("/figures")
    Iterable<FigureDto> all() {
        return figureService.getAll();
    }

    @PostMapping("/figures")
    FigureDto newFigure(@RequestBody FigureDto newFigure) {  return figureService.create(newFigure); }

    @GetMapping("/figures/{id}")
    Optional<FigureDto> one(@PathVariable Integer id) throws Throwable {
        return Optional.ofNullable((FigureDto) figureService.find(Long.parseLong(String.valueOf(id)))
                .orElseThrow(() -> new FigureNotFoundException(
                        Long.parseLong(String.valueOf(id)))));
//        return (StudentDto) studentService.findStudent(id)
//                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @RequestMapping(value = "/figures/getBy", method = RequestMethod.GET)
    List<PriceForFigureDto> oneByNickname(
            @RequestParam(name = "nickname") String nickname) throws Throwable {
        return figureService.findPriceOfFigureByNickname(nickname);
//        return (StudentDto) studentService.findStudent(id)
//                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @RequestMapping(value = "/figures/byOrg", method = RequestMethod.GET)
    List<BeltBoxerCollectionDto> oneByOrg(
            @RequestParam(name = "name") String name) throws Throwable {
        return figureService.findFiguresByOrganization(name);
//        return (StudentDto) studentService.findStudent(id)
//                .orElseThrow(() -> new StudentNotFoundException(id));
    }

//    @RequestMapping(value = "/figures/getBy", method = RequestMethod.GET)
//    List<PriceForFigureDto> oneByNickname(
//            @RequestParam(name = "nickname") String nickname) throws Throwable {
//        return figureService.findPriceOfFigureByNickname(nickname);
////        return (StudentDto) studentService.findStudent(id)
////                .orElseThrow(() -> new StudentNotFoundException(id));
//    }

    @DeleteMapping("/figures/{id}")
    void deleteStudent(@PathVariable Integer id) {
        figureService.destroyById(Long.parseLong(String.valueOf(id)));
    }
}
