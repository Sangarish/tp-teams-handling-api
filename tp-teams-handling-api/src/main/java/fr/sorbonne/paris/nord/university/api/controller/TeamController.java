package fr.sorbonne.paris.nord.university.api.controller;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/Teams")
    public List<TeamEntity> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping("/TeamById")
    public Optional getTeamById(){
        long id = 1L;
        return teamService.getTeamById(id);

    }

    @GetMapping("/insTeam")
    public void insertTeam(){
        Long id= 0L;
        String name= "Aroul";
        String slogan ="What ever";
        teamService.insertTeam(id, name,slogan);
    }

    @GetMapping("/upTeam")
    public void updateTeam(){
        Long id= 0L;
        String name= "Aroul";
        String slogan ="";
         teamService.updateTeam(id, name, slogan);
    }

    @GetMapping("/delTeam")
    public void deleteTeam(TeamEntity team){
        teamService.deleteTeam(team);
    }

    @GetMapping("/delTeambyId")
    public void deleteTeamById(){
        Long id=1l;
        teamService.deleteTeamById(id);
    }
}