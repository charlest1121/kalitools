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
        if(applicationListSafe.contains("_")){
            return applicationListSafe;
        }
        ArrayList<String> modifiedList = new ArrayList<>(applicationListSafe);
        for (int i = 0;i < modifiedList.size(); i++) {
            String entry = modifiedList.get(i);
                String output = String.join(" ", SystemCall.Echo(true, "apt search ", entry));
                if (output.contains((entry + "/"))) {
                    System.out.println(entry + " found, can be installed in safemode(*)");
                    entry = entry.replace(entry, entry + "(*)");
                    modifiedList.set(i, entry);
                }
        }
        return modifiedList;
    }
}
