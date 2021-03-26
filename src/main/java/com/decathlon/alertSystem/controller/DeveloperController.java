package com.decathlon.alertSystem.controller;

import com.decathlon.alertSystem.entity.Developer;
import com.decathlon.alertSystem.entity.Team;
import com.decathlon.alertSystem.service.DeveloperService;
import com.decathlon.alertSystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DeveloperController {
    @Autowired
    DeveloperService developerService;
    @PostMapping("/developer")
    public Developer addDeveloper(@Valid @RequestBody Developer developer)
    {
        Developer addedDeveloper = developerService.addDeveloper(developer);
        return addedDeveloper;
    }

    @GetMapping("/developer/{developerId}")
    public Developer getDeveloper(@PathVariable Long developerId)
    {
        return developerService.getDeveloper(developerId);
    }

    @GetMapping("/developers")
    public List<Developer> getDevelopers()
    {
        return developerService.getDevelopers();
    }

}
