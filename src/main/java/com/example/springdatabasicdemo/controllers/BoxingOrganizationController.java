package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.BeltDto;
import com.example.springdatabasicdemo.dtos.BoxingOrganizationDto;
import com.example.springdatabasicdemo.services.BeltService;
import com.example.springdatabasicdemo.services.BoxingOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class BoxingOrganizationController {

    @Autowired
    private BoxingOrganizationService boxingOrganizationService;

    @GetMapping("/organizations")
    Iterable<BoxingOrganizationDto> all() {
        return boxingOrganizationService.getAll();
    }

    @PostMapping("/organizations")
    BoxingOrganizationDto newBoxingOrganization(@RequestBody BoxingOrganizationDto newBoxingOrganization) {
        return boxingOrganizationService.create(newBoxingOrganization);
    }

    @GetMapping("/organizations/{id}")
    Optional<BoxingOrganizationDto> one(@PathVariable Integer id) throws Throwable {
        return boxingOrganizationService.find(Long.parseLong(String.valueOf(id)));
//        return (StudentDto) studentService.findStudent(id)
//                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/organizations/{id}")
    void deleteBelt(@PathVariable Integer id) {
        boxingOrganizationService.destroyById(Long.parseLong(String.valueOf(id)));
    }
}