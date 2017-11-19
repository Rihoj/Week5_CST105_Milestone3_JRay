/**
 * Program: NFLDraft
 * File: NFLPlayerManager.java
 * Summary: Create and manage all players.
 * Author: James Ray
 * Date: Nov 19, 2017
 */
package nfldraft.manager;

import java.util.ArrayList;
import nfldraft.classes.NFLPlayer;

public class NFLPlayerManager {

    //The default number of players to create in createPlayers
    private static final int DEFAULT_CREATE_PLAYERS = 6;
    //The number of offensive players to create.
    private static final int NUMBER_OF_OFFENSIVE_PLAYERS = 2;
    //The number of defensive players to create.
    private static final int NUMBER_OF_DEFENSIVE_PLAYERS = 2;
    //Array list of all players
    private ArrayList<NFLPlayer> players = new ArrayList<>();

    //Create the default set of players.
    public NFLPlayerManager() {
        for (int i = 0; i < NUMBER_OF_OFFENSIVE_PLAYERS; i++) {
            players.add(new NFLPlayer());
        }
        for (int i = 0; i < NUMBER_OF_DEFENSIVE_PLAYERS; i++) {
            players.add(new NFLPlayer());
        }
    }

    //Return the NFLPlayerManager as a string.
    @Override
    public String toString() {
        String returnString = "Players: \n";
        for (int i = 0; i < players.size(); i++) {
            returnString += players.get(i).toString() + "\n\n";
        }
        return returnString;
    }

    //Create DEFAULT_CREATE_PLAYERS number of players
    public ArrayList<NFLPlayer> createPlayers() {
        for (int i = 0; i < DEFAULT_CREATE_PLAYERS; i++) {
            players.add(new NFLPlayer());
        }
        return players;
    }

    //Create numberOfPlayers number of players
    public ArrayList<NFLPlayer> createPlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new NFLPlayer());
        }
        return players;
    }

    //remove a specific player from the manager.
    public void removePlayer(NFLPlayer player) {
        players.remove(player);
    }

    //removes all players from manager.
    public void removeAllPlayers() {
        players.clear();
    }

    //Return all players.
    public ArrayList<NFLPlayer> getPlayers() {
        return players;
    }

}
