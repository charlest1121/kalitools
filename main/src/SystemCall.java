import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SystemCall {
    String output = "";

    public static ArrayList<String> Echo(boolean silent, String cmd, String action) {
        ArrayList<String> allActions = new ArrayList<>();
        String cmdResult = "";
        //I did lists and strings for the packages so that they could be mass installed or individually.
        //The issue is that when packages are installed, they hold the apt process for a moment,
        // I need to add an interval that checks if the process is currently being held.
        //SystemCall.Echo(false, "apt", "install -y nmap");
        //Install history can be found in /var/log/apt/history.log for troubleshooting apt
        //why it has to be done this way provided below(still broken though lmao)
        //https://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html#exec%28java.lang.String[],%20java.lang.String[],%20java.io.File%29
        try {
            String[] args = new String[]{"/bin/bash", "-c", cmd + " " + action.replace(",", "").replace("[", "").replace("]", "")};
            Process proc = new ProcessBuilder(args).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((cmdResult = reader.readLine()) != null) {
                if (!silent) {
                    System.out.println(cmdResult);
                }
                allActions.add(cmdResult);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return allActions;
    }

    public static void CheckPermissions() {
        try {
            if (Echo(true,"id", "-u").contains("0")) {
                System.out.println("""                     
                        Admin privileges verified
                        ***WARNING***
                        installation modifies your packages/repositories
                        """);
            } else {
                System.out.println("""
                        Admin privileges could not be verified
                                                          
                        You will not be able to install packages
                        or manage repositories
                        """);
            }
        } catch (Exception e) {
            System.out.println("Error confirming root privileges");
        }
    }
}