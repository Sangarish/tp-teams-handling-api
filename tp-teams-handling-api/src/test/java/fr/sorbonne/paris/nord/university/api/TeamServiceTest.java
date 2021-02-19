package fr.sorbonne.paris.nord.university.api;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TeamServiceTest  {


    @Autowired
    private TeamService teamService;

    @Test
    public void shouldReturnTrueWhenGetTeamsIsFine(){

        List<TeamEntity> teams = teamService.getTeams();
        assertThat(teams).isNotNull().isNotEmpty();
    }

    @Test
    public void shouldReturnTheExpectedTeam_whenGetTeamByExistingId(){
        // Given.
        String name = "PSG";
        // When.
        Optional <TeamEntity> result = teamService.getTeamById(1L);
        // Then.
        assertThat(result.get().getName()).isEqualTo(name);

    }

    @Test
    public void givenExistingId_whenGetTeamById_thenExpectedTeamInResult(){
        // Given.
        long id = 2L;
        // When.
        Optional <TeamEntity> result = teamService.getTeamById(id);
        // Then.
        assertThat(result.get().getName());
        //System.out.println(result.get().getName());
    }

}
