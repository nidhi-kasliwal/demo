package com.decathlon.alertSystem.service.impl;

import com.decathlon.alertSystem.entity.Developer;
import com.decathlon.alertSystem.entity.Team;
import com.decathlon.alertSystem.exception.DeveloperNotFoundException;
import com.decathlon.alertSystem.repository.DeveloperRepository;
import com.decathlon.alertSystem.repository.TeamRepository;
import com.decathlon.alertSystem.service.DeveloperService;
import com.decathlon.alertSystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    DeveloperService developerService;

    @Autowired
    DeveloperRepository developerRepository;

    @Override
    @Transactional
    public Team addTeam(Team team) throws DeveloperNotFoundException {
//        List<String> developersPhoneNumbers = team.getDevelopers().stream().map(x->x.getPhoneNumber()).collect(Collectors.toList());
//        List<Developer> developers = developersPhoneNumbers.stream().map(x->developerService.getDeveloperByPhoneNumber(x)).filter(x->x!=null).collect(Collectors.toList());
//        if(developers.size()!=developersPhoneNumbers.size())
//        {
//            throw new DeveloperNotFoundException("Some developers not found");
//        }

        Team addedTeam = teamRepository.save(team);
        Long teamId = addedTeam.getTeamId();
//        team.getDevelopers().stream().forEach(x->{
//            x.setTeam(addedTeam);
//            developerService.updateDeveloper(x);
//        });

        for(Developer d : team.getDevelopers())
        {
            d.setTeam(addedTeam);
            developerService.updateDeveloper(d);
        }


        return addedTeam;
    }

    @Override
    public void removeTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Developer> getDevelopers(Long teamId) {
        Team team=null;
        if(teamRepository.findById(teamId).isPresent())
        {
            team = teamRepository.findById(teamId).get();
        }
        return team==null?null:team.getDevelopers();
    }

    @Override
    public Team getTeam(Long teamId) {
        Team team=null;
        if(teamRepository.findById(teamId).isPresent())
        {
            team = teamRepository.findById(teamId).get();
        }
        return team;
    }

    @Override
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @Override
    public String getPhoneNumberOfRandomDeveloperFromTeam(Long teamId) throws DeveloperNotFoundException {
        Team team;
        if (teamRepository.findById(teamId).isPresent()) {
            team = teamRepository.findById(teamId).get();
            List<Developer> developers = team.getDevelopers();
            Random randomGenerator = new Random();
            if(developers.isEmpty()) throw new DeveloperNotFoundException("Developers Not found");
            int index = randomGenerator.nextInt(developers.size());
            Developer developer = developers.get(index);
            return developer.getPhoneNumber();
        }
        throw new DeveloperNotFoundException("Team Not found");
    }
}
