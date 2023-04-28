import java.io.IOException;
import java.util.Scanner;

public class Shutdown{
    public int time;
    Runtime runtimeInstance;

    enum TimeUnitMode {
        SECONDS, MINUTE, HOUR
    }

    public TimeUnitMode timeUnitMode;

    public Shutdown() {
        runtimeInstance = Runtime.getRuntime();
    }

    public int ConvertTimeUnitToSeconds(int time) {
        if(timeUnitMode == TimeUnitMode.MINUTE)
            return time*60;
        else if (timeUnitMode == TimeUnitMode.HOUR)
            return time*3600;
        else
            return time;
    }

    public void ShutdownWithTimer(int time) {
        int calculatedTime = ConvertTimeUnitToSeconds(time);
        try
        {
           runtimeInstance.exec("shutdown -s -t " + calculatedTime);
        }
        catch(IOException e)
        {

        }
    }

    public void CancelShutdownTimer() {
        try {
            runtimeInstance.exec("shutdown -a");
        } catch (IOException e) {

        }
    }
}
