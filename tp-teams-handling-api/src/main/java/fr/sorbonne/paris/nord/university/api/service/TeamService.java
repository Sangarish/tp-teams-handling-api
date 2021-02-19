package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService{
    private TeamRepository teamRepository;

    @Autowired
    public void TeamService(TeamRepository teamRepository){
        this.teamRepository=teamRepository;
    }


    public List<TeamEntity> getTeams(){
        return teamRepository.findAll();
    }

    public Optional getTeamById(Long id){
        if(teamRepository.findById(id)!=null){
            return teamRepository.findById(id);
        }
        else{
            return Optional.empty();
        }
    }


    public void insertTeam(Long id, String name,String slogan){
        TeamEntity document = new TeamEntity(id,name,slogan);
        teamRepository.save(document);
    }

    public void updateTeam(Long id, String name,String slogan){
        TeamEntity document = new TeamEntity(id,name,slogan);
        teamRepository.save(document);
    }

    public void deleteTeamById(Long id){
        teamRepository.deleteById(id);
    }

    public void deleteTeam(TeamEntity team){
        teamRepository.delete(team);
    }
}
