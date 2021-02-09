package student.inheritance;

import java.time.LocalTime;

public interface IO {
    void logMessage(String message);
    int getInt(String message);
    String getCode(String message, String regex );
    LocalTime getTime(String message);
    double getDouble(String message);
    String getString(String message);
}
