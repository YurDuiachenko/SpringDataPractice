package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.BeltDto;
import com.example.springdatabasicdemo.services.BeltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BeltController {

    @Autowired
    private BeltService beltService;

    @GetMapping("/belts")
    Iterable<BeltDto> all() {
        return beltService.getAll();
    }

    @PostMapping("/belts")
    BeltDto newBelt(@RequestBody BeltDto newBelt) {  return beltService.create(newBelt); }

    @GetMapping("/belts/{id}")
    Optional<BeltDto> one(@PathVariable Integer id) throws Throwable {
        return beltService.find(Long.parseLong(String.valueOf(id)));
//        return (StudentDto) studentService.findStudent(id)
//                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/belts/{id}")
    void deleteBelt(@PathVariable Integer id) {
        beltService.destroyById(Long.parseLong(String.valueOf(id)));
    }
}