import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemCall {

    public static void Echo(boolean permsRequired,String cmd, String action) {
        //I did lists and strings for the packages so that they could be mass installed or individually.
        //The issue is that when packages are installed, they hold the apt process for a moment,
        // I need to add an interval that checks if the process is currently being held.

        //Install history can be found in /var/log/apt/history.log for troubleshooting apt
        //why it has to be done this way provided below(still broken though lmao)
        //https://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html#exec%28java.lang.String[],%20java.lang.String[],%20java.io.File%29
        String perms = null;
        if(permsRequired){
           perms = "sudo ";
        }
        try{
        String[] args = new String[] {"/bin/bash", "-c", perms + cmd + " " + action};
        Process proc = new ProcessBuilder(args).start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String cmdResult = "";
        while ((cmdResult = reader.readLine()) != null) {
            System.out.println(cmdResult);
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
