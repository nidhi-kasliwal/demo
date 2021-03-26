package com.decathlon.alertSystem.service.impl;

import com.decathlon.alertSystem.entity.Developer;
import com.decathlon.alertSystem.entity.Team;
import com.decathlon.alertSystem.repository.DeveloperRepository;
import com.decathlon.alertSystem.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    DeveloperRepository developerRepository;

    @Override
    public Developer addDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public void removeDeveloper(Long developerId) {
        developerRepository.deleteById(developerId);
    }

    @Override
    public Developer updateDeveloper(Developer developer)
    {
        return developerRepository.save(developer);
    }

    @Override
    public Team getTeam(Long developerId) {
        Developer developer = developerRepository.findById(developerId).get();
        return developer==null?null:developer.getTeam();
    }

    @Override
    public Developer getDeveloper(Long developerId) {
        return developerRepository.findById(developerId).get();
    }

    @Override
    public List<Developer> getDevelopers() {
        return developerRepository.findAll();
    }

    @Override
    public Developer getDeveloperByPhoneNumber(String phoneNumber) {
        return developerRepository.findDeveloperByPhoneNumber(phoneNumber);
    }
}
