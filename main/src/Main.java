import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SystemCall.CheckPermissions();
        CLI.Header();
        while(true){
            if(!CLI.safeInstallCheck){
                CLI.SafeInstallPrompt();
                TimeUnit.SECONDS.sleep(10);
            }else{
                CLI.StartScreen();
            }
        }




    }
}