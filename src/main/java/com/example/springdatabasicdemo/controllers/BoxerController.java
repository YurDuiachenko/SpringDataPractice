package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.BoxerDto;
import com.example.springdatabasicdemo.dtos.FigureDto;
import com.example.springdatabasicdemo.models.Boxer;
import com.example.springdatabasicdemo.services.BoxerService;
import com.example.springdatabasicdemo.services.FigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BoxerController {

    @Autowired
    private BoxerService boxerService;

    @GetMapping("/boxers")
    Iterable<BoxerDto> all() {
        return boxerService.getAll();
    }

    @PostMapping("/boxers")
    BoxerDto newBoxer(@RequestBody BoxerDto newBoxer) {  return boxerService.create(newBoxer); }

    @GetMapping("/boxers/{id}")
    Optional<BoxerDto> one(@PathVariable Integer id) throws Throwable {
        return boxerService.find(Long.parseLong(String.valueOf(id)));
//        return (StudentDto) studentService.findStudent(id)
//                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/boxers/{id}")
    void deleteBoxer(@PathVariable Integer id) {
        boxerService.destroyById(Long.parseLong(String.valueOf(id)));
    }
}