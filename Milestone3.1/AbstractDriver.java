/**
 * Program: NFLDraft
 * File: AbstractDriver.java
 * Summary: Common usage on Drivers
 * Author: James Ray
 * Date: Nov 18, 2017
 */
abstract class AbstractDriver {

    //Print line to System out and wait 500 ms to make sure text is in the right order.
    protected final static void logOut(String message) {
        System.out.println(message);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Print line to System err and wait 500 ms to make sure text is in the right order.
    protected final static void logError(String message) {
        System.err.println(message);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
