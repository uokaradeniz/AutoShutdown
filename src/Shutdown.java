import java.io.IOException;
import java.util.Scanner;

public class Shutdown{
    public int time;
    Runtime runtimeInstance;
    public int exitValue;

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

    public void RestartWithTimer(int time) {
        int calculatedTime = ConvertTimeUnitToSeconds(time);
        try
        {
            runtimeInstance.exec("shutdown -r -t " + calculatedTime);
        }
        catch(IOException e)
        {

        }
    }


    public void CancelShutdownTimer() {
        try {
            Process process = runtimeInstance.exec("shutdown -a");
            exitValue = process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
