/**
 * Program: NFLDraft
 * File: Player.java
 * Summary: Controls the player and allows players to be generated.
 * Author: James Ray
 * Date: Nov 18, 2017
 */
package nfldraft.classes;

import java.util.HashMap;
import java.util.Map;
import nfldraft.helpers.NameHelper;
import java.util.concurrent.ThreadLocalRandom;

public class NFLPlayer {

    //First name of the player.
    private String firstName;
    //Last name of the player.
    private String lastName;
    //Age of the player.
    private int age;
    //Team class the player belongs to.
    private Team team;

    //Number of tackles the player has made.
    private int tackles;
    //Number of rushing yards for player.
    private int rushingYards;
    //Number of Interceptions the player has made.
    private int interceptions;
    //Number of kick returns the player has made.
    private int kickReturns;
    //Number of sacks the player has made.
    private int sacks;
    //Number of passing yards a player has.
    private int passingYards;
    //number of receiving yards a player has.
    private int receivingYards;
    //Number of touch downs a player has made.
    private int touchDowns;
    //A map of all stats for the player.
    private final Map<String, Integer> stats = new HashMap<>();

    //Generate a new player with random data without a team.
    public NFLPlayer() {
        firstName = NameHelper.generateFirstName();
        lastName = NameHelper.generateLastName();
        age = ThreadLocalRandom.current().nextInt(18, 46);
        tackles = ThreadLocalRandom.current().nextInt(0, 300);
        rushingYards = ThreadLocalRandom.current().nextInt(0, 500);
        interceptions = ThreadLocalRandom.current().nextInt(0, 200);
        kickReturns = ThreadLocalRandom.current().nextInt(0, 50);
        sacks = ThreadLocalRandom.current().nextInt(0, 75);
        passingYards = ThreadLocalRandom.current().nextInt(0, 500);
        receivingYards = ThreadLocalRandom.current().nextInt(0, 500);
        touchDowns = ThreadLocalRandom.current().nextInt(0, 50);
    }

    //Create custom NFLPlayer
    public NFLPlayer(String firstName, String lastName, int age, Team team, int tackles, int rushingYards, int interceptions, int kickReturns, int sacks, int passingYards, int receivingYards, int touchDowns) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
        this.tackles = tackles;
        this.rushingYards = rushingYards;
        this.interceptions = interceptions;
        this.kickReturns = kickReturns;
        this.sacks = sacks;
        this.passingYards = passingYards;
        this.receivingYards = receivingYards;
        this.touchDowns = touchDowns;
    }

    @Override
    public String toString() {
        String returnString = "Player Name: " + getFullName() + "\n"
                + "Player Age: " + getAge() + "\n"
                + "Player Stats: " + getStats() + "\n";
        if (getTeam() != null) {
            returnString += getTeam();
        }
        return returnString;
    }

    //return the first name of the player
    public String getFirstName() {
        return firstName;
    }

    //return the last name of the player
    public String getLastName() {
        return lastName;
    }

    //return the full name of the player
    public String getFullName() {
        return firstName + " " + lastName;
    }

    //return the age of the player.
    public int getAge() {
        return age;
    }

    //Return the team the player belongs to.
    public Team getTeam() {
        return team;
    }

    //Return the statistics for this player.
    public Map<String, Integer> getStats() {
        stats.clear();
        stats.put("Tackles", tackles);
        stats.put("Rushing Yards", rushingYards);
        stats.put("Interceptions", interceptions);
        stats.put("Kick Returns", kickReturns);
        stats.put("Sacks", sacks);
        stats.put("Passing Yards", passingYards);
        stats.put("Receiving Yards", receivingYards);
        stats.put("Touch Downs", touchDowns);
        return stats;
    }

    //Get tackles for player
    public int getTackles() {
        return tackles;
    }

    //Get rushingYards for player
    public int getRushingYards() {
        return rushingYards;
    }

    //Get interceptions for player
    public int getInterceptions() {
        return interceptions;
    }

    //Get kick returns for player
    public int getKickReturns() {
        return kickReturns;
    }

    //Get sacks for player
    public int getSacks() {
        return sacks;
    }

    //Get passing yards for player
    public int getPassingYards() {
        return passingYards;
    }

    //Get receiving yards for player
    public int getReceivingYards() {
        return receivingYards;
    }

    //Get touchdowns for player
    public int getTouchDowns() {
        return touchDowns;
    }

    //set the team the player belongs to.
    public void setTeam(Team team) {
        this.team = team;
    }

    //set first name for player
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //set last name for player
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //set age for player
    public void setAge(int age) {
        this.age = age;
    }

    //set tackles for player
    public void setTackles(int tackles) {
        this.tackles = tackles;
    }

    //set rushing yards for player
    public void setRushingYards(int rushingYards) {
        this.rushingYards = rushingYards;
    }

    //set interceptions for player
    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    //set kick returns for player
    public void setKickReturns(int kickReturns) {
        this.kickReturns = kickReturns;
    }

    //set sacks for player
    public void setSacks(int sacks) {
        this.sacks = sacks;
    }

    //set passing yards for player
    public void setPassingYards(int passingYards) {
        this.passingYards = passingYards;
    }

    //set receiving yards for player
    public void setReceivingYards(int receivingYards) {
        this.receivingYards = receivingYards;
    }

    //set touchdowns for player
    public void setTouchDowns(int touchDowns) {
        this.touchDowns = touchDowns;
    }

    //Removes player from team.
    public void leaveTeam() {
        if (team != null) {
            team.removePlayer(this);
            team = null;
        }
    }
}
