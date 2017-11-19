
/**
 * Program: NFLDraft
 * File: NFLPlayerDriver.java
 * Summary: Test class for NFL Player
 * Author: James Ray
 * Date: Nov 18, 2017
 */
import java.util.Iterator;
import nfldraft.classes.NFLPlayer;
import nfldraft.manager.NFLPlayerManager;

/**
 *
 * @author james
 */
public class NFLPlayerManagerDriver extends AbstractDriver {

    private static int errorCount = 0;
    private static int successCount = 0;
    private static final int NUMBER_OF_PLAYERS_TO_CREATE = 2;

    public static void main(String[] args) {
        logOut("Begining tests for NFLPlayerManager.");
        logOut("");
        logOut("Checking NFLPlayerManager dependencies.");
        try {
            NFLPlayerDriver.main(args);
            logOut("NFLPlayerManager dependencies are working as expected.");
            successCount++;
            if (createManagerTest()) {
                logOut("NFLPlayerManager is working as expected.");
                successCount++;
            } else {
                logError("NFLPlayerManager failed.");
                errorCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logError("NFLPlayerManager dependencies are not working as expected. Aborted the rest of the test.");
            errorCount++;
        }
        logOut("");
        logOut("Tests are complete with the following stats.");
        logOut("Successes: " + Integer.toString(successCount));
        logError("Errors: " + Integer.toString(errorCount));

    }

    //Tests the constructors for a team.
    private static boolean createManagerTest() {
        boolean testStatus = false;
        try {
            NFLPlayerManager manager = new NFLPlayerManager();
            logOut("Manager created with " + manager.getPlayers().size() + " players.");
            manager.createPlayers();
            logOut("Manager created default count of players and now has " + manager.getPlayers().size() + " players.");
            manager.createPlayers(NUMBER_OF_PLAYERS_TO_CREATE);
            logOut("Manager created "+NUMBER_OF_PLAYERS_TO_CREATE+" players and now has " + manager.getPlayers().size() + " players.");
            logOut("");
            logOut("Printing all stats");
            logOut(manager.toString());
            Iterator<NFLPlayer> playerIterator = manager.getPlayers().iterator();
            while (playerIterator.hasNext()) {
                NFLPlayer player = playerIterator.next();
                logOut("Removing player with name: " + player.getFullName());
                manager.removePlayer(player);
                break;
            }
            logOut("Manager now has " + manager.getPlayers().size() + " players.");
            manager.removeAllPlayers();
            logOut("Removing all players from manager.");
            logOut("Manager now has " + manager.getPlayers().size() + " players.");
            testStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testStatus;
    }
}
