package reskillAssignmentOne;
/*
Vi skal vurdere om vi trenger interface for input.
beholder alle opprinnelige metodene foreløpig
 */

//import java.time.LocalTime;

public interface IO {
    void logMessage(String message);
    int getInt(String message);
    /*String getCode(String message, String regex ); // check if we can use only this
    LocalTime getTime(String message);

     */
    long getLong(String message);


    String getString(String message);
}
