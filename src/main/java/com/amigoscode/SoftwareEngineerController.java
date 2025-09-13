package com.amigoscode;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anything that accepts request from client or exposess REST endpoints its a REST controller
@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @PostMapping
    public void addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @GetMapping("{id}")
    public SoftwareEngineer getSoftwareEngineerBYId(@PathVariable int id) {

        return softwareEngineerService.getSoftwareEngineerById(id);

    }

    @DeleteMapping("{id}")
    public void DeleteSoftwareEngineerByID(@PathVariable int id) {

        softwareEngineerService.DeleteSoftwareEngineerById(id);

    }

    }


