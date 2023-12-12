import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sources {
    public static void Add(String repository) {
        //method to add required repositories
        SystemCall.Echo(false,"add-apt-repository ", repository);
    }

    public static List<String> Check(List<String> applicationListSafe) throws InterruptedException {
        for (String entry : applicationListSafe) {

                if (SystemCall.Echo(true, "apt search ", entry).contains(entry)) {
                    System.out.println(entry + " found, can be installed in safemode*");
                    entry.replace(entry, entry + "*");
                }
        }
        return applicationListSafe;
    }
}
