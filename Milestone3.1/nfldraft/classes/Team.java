/**
 * Program: NFLDraft
 * File: Team.java
 * Summary: Creates and manages teams.
 * Author: James Ray
 * Date: Nov 18, 2017
 */
package nfldraft.classes;

import nfldraft.helpers.NameHelper;
import java.util.ArrayList;

public class Team {

    //Name of the team
    private final String name;
    //full name of the owner
    private final String owner;
    //ArrayList of the players in the team.
    private ArrayList<NFLPlayer> players = new ArrayList<>();

    //Generate a team
    public Team() {
        name = NameHelper.generateTeamName();
        owner = NameHelper.generateFullName();
    }

    @Override
    public String toString() {
        return "Team Name: "+getName()+" Owner: "+getOwner()+"\n";
    }
    //return the name of the team.
    public String getName() {
        return name;
    }

    //Get the owner of the team,
    public String getOwner() {
        return owner;
    }

    //return all players in the team.
    public ArrayList<NFLPlayer> getPlayers() {
        return players;
    }

    //Set all players for the team.
    public void setPlayers(ArrayList<NFLPlayer> players) {
        this.players = players;
    }

    //Add a single player to the team.
    public void addPlayer(NFLPlayer player) {
        player.setTeam(this);
        this.players.add(player);
    }

    //remove a signle player from the team.
    public void removePlayer(NFLPlayer player){
        players.remove(player);
    }
    public void firePlayer(NFLPlayer player) {
        players.remove(player);
        player.setTeam(null);
    }

}
