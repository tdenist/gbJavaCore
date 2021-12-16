package lesson1;

import java.util.Arrays;

public class Team {

    private String teamName;
    private Animal[] teamGroup;
    private String result;

    public Team(String teamName, Animal[] teamGroup) {
        this.teamName = teamName;
        this.teamGroup = teamGroup;
        this.result = "Результат:\n";
    }

    public String showResults(){
        return this.result;
    }

    public void addResults(String result){
        this.result = this.result + result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + getTeamName() + '\'' +
                ", teamGroup=" + Arrays.toString(teamGroup) +
                '}';
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Animal[] getTeamGroup() {
        return teamGroup;
    }

    public void setTeamGroup(Animal[] teamGroup) {
        this.teamGroup = teamGroup;
    }
}
