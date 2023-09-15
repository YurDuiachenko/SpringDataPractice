package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.FigureDto;
import com.example.springdatabasicdemo.dtos.FigureOfBoxerDto;
import com.example.springdatabasicdemo.models.FigureOfBoxer;
import com.example.springdatabasicdemo.services.FigureOfBoxerService;
import com.example.springdatabasicdemo.services.FigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class FigureOfBoxerController {

    @Autowired
    private FigureOfBoxerService figureOfBoxerService;

    @GetMapping("/figureOfBoxers")
    Iterable<FigureOfBoxerDto> all() {
        return figureOfBoxerService.getAll();
    }

    @PostMapping("/figureOfBoxers")
    FigureOfBoxerDto newFigure(@RequestBody FigureOfBoxerDto newFigure) {  return figureOfBoxerService.create(newFigure); }

    @GetMapping("/figureOfBoxers/{id}")
    Optional<FigureOfBoxerDto> one(@PathVariable Integer id) throws Throwable {
        return figureOfBoxerService.find(Long.parseLong(String.valueOf(id)));
//        return (StudentDto) studentService.findStudent(id)
//                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/figureOfBoxers/{id}")
    void deleteStudent(@PathVariable Integer id) {
        figureOfBoxerService.destroyById(Long.parseLong(String.valueOf(id)));
    }
}
