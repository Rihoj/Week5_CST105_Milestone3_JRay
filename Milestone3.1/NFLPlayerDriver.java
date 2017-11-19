/**
 * Program: NFLDraft
 * File: NFLPlayerDriver.java
 * Summary: Test class for NFL Player
 * Author: James Ray
 * Date: Nov 18, 2017
 */

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import nfldraft.classes.*;

/**
 *
 * @author james
 */
public class NFLPlayerDriver extends AbstractDriver{

    private static int errorCount = 0;
    private static int successCount = 0;
    private static final int NUMBER_OF_TEAMS = 1;
    private static final int NUMBER_OF_PLAYERS = 2;

    public static void main(String[] args) {
        logOut("Begining tests for NFLPlayer.");
        logOut("");
        logOut("Checking NFLPlayer dependencies.");
        if (createTeamTest()) {
            logOut("Create Team Test succeded.");
            successCount++;
        } else {
            logError("Failed create Team Test.");
            errorCount++;
        }
        if (errorCount == 0) {
            logOut("");
            logOut("Begining Create Player constructor test.");
            if (createPlayerTest()) {
                logOut("Create Player Test succeded");
                successCount++;
                continueTest();
            } else {
                logError("Create Player Test Failed. Full test was cancled.");
                errorCount++;
            }
        } else {
            logError("Could not continue as dependencies failed.");
        }
        logOut("");
        logOut("Tests are complete with the following stats.");
        logOut("Successes: " + Integer.toString(successCount));
        logError("Errors: " + Integer.toString(errorCount));

    }

    //Tests the constructors for a team.
    private static boolean createTeamTest() {
        boolean testStatus = false;
        try {
            Team team = new Team();
            logOut("Team with name: " + team.getName() + " and owner: " + team.getOwner() + " created");
            testStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testStatus;
    }

    private static void continueTest() {
        if(fullTest()){
            logOut("Full test succeeded");
            successCount++;
        }else{
            errorCount++;
        }
    }

    //Test NFLPlayer constructors
    private static boolean createPlayerTest() {
        boolean testStatus = false;
        try {
            NFLPlayer player = new NFLPlayer();
            logOut("Player created.");
            logOut(player.toString());
            Team team = new Team();
            NFLPlayer playerWithData = new NFLPlayer("James", "Ray", 25, team, 10, 15, 20, 25, 30, 35, 40, 45);
            logOut("Player with data created.");
            logOut(playerWithData.toString());
            testStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testStatus;
    }

    //Run a full test to make sure the everything functions as expected.
    private static boolean fullTest() {
        boolean testStatus = false;
        logOut("");
        logOut("");
        logOut("BeginingFull Test.");
        try {
            Team[] teams = new Team[NUMBER_OF_TEAMS];
            logOut("");
            logOut("");
            logOut("Creating teams.");
            for(int i=0; i < NUMBER_OF_TEAMS; i++){
                logOut("");
                teams[i] = new Team();
                logOut("Team created." + teams[i].toString());
                logOut("Creating players and adding them to a team.");
                logOut("");
                for (int j = 0; j < NUMBER_OF_PLAYERS; j++) {
                    teams[i].addPlayer(new NFLPlayer());
                }
                logOut("Players created and added to team.");
                logOut("Listing players in team.");
                logOut("");
                List<NFLPlayer> players = new CopyOnWriteArrayList<>();
                teams[i].getPlayers().forEach((player)->{
                    players.add(player);
                    logOut(player.toString());
                    logOut("");
                });

                logOut("Fire all players.");
                Iterator<NFLPlayer> playerIterator = players.iterator();
                while(playerIterator.hasNext()){
                    NFLPlayer player = playerIterator.next();
                    logOut("Removing player with name: "+player.getFullName());
                    teams[i].firePlayer(player);
                }
            }
            testStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testStatus;
    }
}
