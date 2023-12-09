import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CLI {
    boolean categoryListCalled = false;
    static List<String> currentApplicationList = new ArrayList<>();
    static AppList app = new AppList();

    static String yesNoStr = "Yes No";
    static List<String> yesNoList = Arrays.stream(yesNoStr.split(" ")).toList();
    static String categoryStr = "Reporting Tools,Vulnerability Analysis,Wireless Attacks" +
            ",Web Application Security,Network Security,Network Utilities,Exploitation,Forensics,Stress Testing" +
            ",Password Attack,Reverse Engineering";
    static List<String> categoryList = Arrays.stream(categoryStr.split(",")).toList();

    public static void Header() {
        System.out.println("""
                              
                              Kali Linux Tool Installation Utility
                                CLI produced by Charles Thompson
                                    https://charles.social/
                """);
    }

    public static void StartScreen() {
        CLI.SelectionScreen(categoryList);
        ApplicationSelectionOptions(PromptUserSelectionSingle());
    }

    public static Integer PromptUserSelectionSingle() {
        Scanner input = new Scanner(System.in);
        System.out.println("Make Selection:");
        System.out.println("Example: 1");
        String userSelection = input.nextLine();
        return Integer.parseInt(userSelection);
    }

    public static List<Integer> PromptUserSelectionMulti() {
        Scanner input = new Scanner(System.in);
        System.out.println("Make selections(separate with spaces):");
        System.out.println("Example: 1 4 8 10");
        String userSelectionStr = input.nextLine();
        List<String> userSelectionListStr = Arrays.stream(userSelectionStr.split(" ")).toList();
        List<Integer> userSelectionListInt = new ArrayList<>();
        for (String s : userSelectionListStr) {
            if (!userSelectionStr.equals("0")) {
                //minus 1 to match the lists starting at 0
                userSelectionListInt.add(Integer.parseInt(s) - 1);
            }
        }
        return userSelectionListInt;
    }

    public static void ApplicationSelectionOptions(Integer selection) {
        int applicationMenuSelection = selection;
        currentApplicationList = AppList.GetApplicationSelection(selection);
        SelectionScreen(AppList.GetApplicationSelection(selection));
        ApplicationInstallationPrompt(PromptUserSelectionMulti(), currentApplicationList);
    }

    public static void ApplicationInstallationPrompt(List<Integer> selectionNumbers, List<String> applicationList) {
        //add methods of installation using apt
        String applicationsSelected = "";
        for (int i = 0; i < selectionNumbers.size(); i++) {
            if (i == selectionNumbers.size()) {
                applicationsSelected = applicationList.get(selectionNumbers.get(i));
            } else {
                applicationsSelected = applicationList.get(selectionNumbers.get(i)) + " ";
            }
        }
        System.out.println("You have selected to install:\n" + applicationsSelected + "\n\n" + "Would you like to continue?");
        SelectionScreen(yesNoList);
        InstallApplications(PromptUserSelectionSingle());


    }

    public static void InstallApplications(Integer choice) {
        if(choice==1){
            SystemCall.Echo(true, "apt -y", String.valueOf(currentApplicationList));
        } else{
            System.out.println("Returning to Start Screen");
            StartScreen();
        }
    }

    public static void SelectionScreen(List<String> applicationList) {
        //return installation screens after selection from start screen
        int numOfRows = applicationList.size() / 2;
        int numOfSpaces = 12;
        Header();
        for (int i = 0; i < applicationList.size(); i += 2) {
            String optionRowPrint = "";
            if (applicationList.size() > 2) {
                if (i + 2 > applicationList.size()) {
                    optionRowPrint = i + 1 + ") " + applicationList.get(i) + " ".repeat(numOfSpaces);
                } else {
                    optionRowPrint = i + 1 + ") " + applicationList.get(i) + " ".repeat(numOfSpaces) +
                            (i + 2) + ") " + applicationList.get(i + 2);
                }
            } else {
                optionRowPrint = i + 1 + ") " + applicationList.get(i) + " ".repeat(numOfSpaces) +
                        (i + 2) + ") " + applicationList.get(i + 1);
            }
            System.out.println(optionRowPrint);
        }
        if (applicationList.size() >= 2) {
            System.out.println("\n\nE) Exit");
        }else{
            System.out.println("\n\n0) All");
        }

    }

}
