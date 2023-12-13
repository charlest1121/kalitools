import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CLI {

    static boolean isSafeInstall;
    static boolean safeInstallCheck = false;
    static boolean categoryListCalled = false;
    static List<String> currentApplicationList = new ArrayList<>();
    static String yesNoStr = "Yes No";
    static List<String> yesNoList = Arrays.stream(yesNoStr.split(" ")).toList();
    static String categoryStr = "Reporting_Tools_,Vulnerability_Analysis_,Wireless_Attacks_" +
            ",Web_Application_Security_,Network_Security_,Network_Utilities_,Exploitation_,Forensics_,Stress_Testing_" +
            ",Password_Attack_,Reverse_Engineering_";
    static List<String> categoryList = Arrays.stream(categoryStr.split(",")).toList();

    public static void Header() {
        System.out.println("""
                              
                              Kali Linux Tool Installation Utility
                                CLI produced by Charles Thompson
                                    https://charles.social/
                    This utility should allow you to access and install various
                   industry standard tools for cyber security focused operations.
                       
                """);
    }

    public static void StartScreen() throws InterruptedException {
        CLI.SelectionScreen(categoryList);
        categoryListCalled = true;
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

    public static void ApplicationSelectionOptions(Integer selection) throws InterruptedException {
        currentApplicationList = AppList.GetApplicationSelection(selection);
        SelectionScreen(AppList.GetApplicationSelection(selection));
        ApplicationInstallationPrompt(PromptUserSelectionMulti(), currentApplicationList);
    }

    public static void ApplicationInstallationPrompt(List<Integer> selectionNumbers, List<String> applicationList) throws InterruptedException {
        //add methods of installation using apt
        List<String> applicationsSelected = new ArrayList<>();
        for (int i = 0; i < selectionNumbers.size(); i++) {
            if (1 < selectionNumbers.size()) {
                applicationsSelected.add(applicationList.get(selectionNumbers.get(i)));
            } else {
                applicationsSelected.add(applicationList.get(selectionNumbers.get(i)));
            }
        }
        System.out.println("You have selected to install:\n");
        for (String s : applicationsSelected) {
            System.out.println(s);
        }
        System.out.println("\nWould you like to continue?");
        SelectionScreen(yesNoList);
        InstallApplications(PromptUserSelectionSingle(), applicationsSelected);


    }

    public static void InstallApplications(Integer choice, List<String> applicationsSelected) throws InterruptedException {
        //1 = yes
        //0 = no
        if (choice == 1) {
            for(String app : applicationsSelected) {
                SystemCall.Echo(false, "apt install -y", app);
            }
        } else {
            System.out.println("You have successfully installed:\n");
            for (String s : applicationsSelected) {
                System.out.println(s);
            }
            System.out.println("Returning to Start Screen");
        }
    }

    public static void SafeInstallPrompt() throws InterruptedException {
        System.out.println("""
                                
                                
                Would you like to safe install?
                                
                What is safe install?:
                                
                *Safe install provides packages available in Kali Linux that are
                 available on your base distro package repository.(Recommended)*
                """);
        SelectionScreen(yesNoList);
        SafeInstallActions(PromptUserSelectionSingle());
        safeInstallCheck = true;

    }

    public static void SafeInstallActions(Integer choice) throws InterruptedException {
        //1 = yes
        //0 = no
        if (choice == 1) {
            System.out.println("You have selected to safe install. \n" +
                    "Packages marked with (*) are available for installation");
            isSafeInstall = true;
        } else {
            System.out.println("Proceed with caution. " +
                    "\nInstalling foreign packages can adversely affect your system.");
            StartScreen();
        }
        safeInstallCheck = true;
    }

    public static void SelectionScreen(List<String> applicationList) throws InterruptedException {
        //return installation screens after selection from start screen
        int numOfSpaces = 12;
        if (isSafeInstall && !applicationList.contains("Yes")) {
            applicationList = Sources.Check(applicationList);
        }
        for (int i = 0; i < applicationList.size(); i += 2) {
            String optionRowPrint;
            if (applicationList.size() > 2) {
                if (i + 2 > applicationList.size()) {
                    optionRowPrint = i + 1 + ") " + applicationList.get(i) + " ".repeat(numOfSpaces);
                } else {
                    if(i+1>applicationList.size()){
                        optionRowPrint = i + 1 + ") " + applicationList.get(i);
                    }else {
                        optionRowPrint = i + 1 + ") " + applicationList.get(i) + " ".repeat(numOfSpaces) +
                                (i + 2) + ") " + applicationList.get(i + 1);
                    }
                }
            } else {
                optionRowPrint = i + 1 + ") " + applicationList.get(i) + " ".repeat(numOfSpaces) +
                        (i + 2) + ") " + applicationList.get(i + 1);
            }
            System.out.println(optionRowPrint);
        }

        if (applicationList.size() >= 2) {
            System.out.println("\n\nE) Exit");
        } else {
            System.out.println("\n\n0) All");
        }

    }

}
