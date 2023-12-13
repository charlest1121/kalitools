import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AppList {
    //https://www.kali.org/docs/general-use/kali-linux-sources-list-repositories/
    //https://http.kali.org/kali/
    //https://www.debian.org/doc/manuals/maint-guide/build.en.html
    static String reportingToolsStr = "casefile cutycapt dos2unix dradis keepnote magictree metagoofil nipper-ng pipal";
    static  List<String> reportingToolsList =  Arrays.stream(reportingToolsStr.split(" ")).toList();

    static String informationGatheringToolsStr = "acccheck ace-voip amap automater braa casefile cdpsnarf " +
            "cisco-torch cookie-cadger copy-router-config dmitry dnmap dnsenum dnsmap dnsrecon dnstracer " +
            "dnswalk dotdotpwn enum4linux enumiax exploitdb fierce firewalk fragroute fragrouter ghost-phisher " +
            "golismero goofile lbd maltego-teeth masscan metagoofil miranda nmap p0f parsero recon-ng set " +
            "smtp-user-enum snmpcheck sslcaudit sslsplit sslstrip sslyze thc-ipv6 theharvester tlssled twofi " +
            "urlcrazy wireshark wol-e xplico ismtp intrace hping3";
    static  List<String> informationGatheringToolsList =  Arrays.stream(informationGatheringToolsStr.split(" ")).toList();

    static String vulnerabilityAnalysisToolsStr = "bbqsql bed cisco-auditing-tool cisco-global-exploiter " +
            "cisco-ocs cisco-torch copy-router-config doona " +
            "dotdotpwn greenbone-security-assistant hexorbase jsql " +
            "lynis nmap ohrwurm openvas-cli openvas-manager " +
            "openvas-scanner oscanner powerfuzzer sfuzz sidguesser " +
            "siparmyknife sqlmap sqlninja sqlsus thc-ipv6 " +
            "tnscmd10g unix-privesc-check yersinia";
    static  List<String> vulnerabilityAnalysisToolsList =  Arrays.stream(vulnerabilityAnalysisToolsStr.split(" ")).toList();

    static String wirelessAttacksToolsStr = "aircrack-ng asleap bluelog blueranger bluesnarfer bully " +
            "cowpatty crackle eapmd5pass fern-wifi-cracker ghost-phisher " +
            "giskismet kalibrate-rtl killerbee kismet mdk3 mfcuk " +
            "mfoc mfterm multimon-ng pixiewps reaver redfang " +
            "spooftooph wifi-honey wifitap wifite";
    static  List<String> wirelessAttacksToolsList =  Arrays.stream(wirelessAttacksToolsStr.split(" ")).toList();

    static String webApplicationSecurityToolsStr = "apache-users arachni bbqsql blindelephant burpsuite " +
            "cutycapt davtest deblaze dirb dirbuster fimap " +
            "funkload grabber jboss-autopwn joomscan jsql " +
            "maltego-teeth padbuster paros parsero plecost " +
            "powerfuzzer proxystrike recon-ng skipfish sqlmap " +
            "sqlninja sqlsus ua-tester uniscan vega w3af " +
            "webscarab websploit wfuzz wpscan xsser zaproxy";
    static  List<String> webApplicationSecurityToolsList =  Arrays.stream(webApplicationSecurityToolsStr.split(" ")).toList();

    static String networkSecurityToolsStr = "burpsuite dnschef fiked hamster-sidejack hexinject iaxflood " +
            "inviteflood ismtp mitmproxy ohrwurm protos-sip rebind " +
            "responder rtpbreak rtpinsertsound rtpmixsound sctpscan " +
            "siparmyknife sipp sipvicious sniffjoke sslsplit sslstrip " +
            "thc-ipv6 voiphopper webscarab wifi-honey wireshark xspy " +
            "yersinia zaproxy";
    static  List<String> networkSecurityToolsList =  Arrays.stream(networkSecurityToolsStr.split(" ")).toList();

    static String networkUtilitiesToolsStr = "cryptcat cymothoa dbd dns2tcp http-tunnel httptunnel " +
            "intersect nishang polenum powersploit pwnat ridenum " +
            "sbd u3-pwn webshells weevely";
    static  List<String> networkUtilitiesToolsList =  Arrays.stream(networkUtilitiesToolsStr.split(" ")).toList();

    static String exploitationToolsStr = "armitage backdoor-factory beef-xss cisco-auditing-tool " +
            "cisco-global-exploiter cisco-ocs cisco-torch crackle " +
            "jboss-autopwn linux-exploit-suggester maltego-teeth set " +
            "shellnoob sqlmap thc-ipv6 yersinia";
    static  List<String> exploitationToolsList =  Arrays.stream(exploitationToolsStr.split(" ")).toList();

    static String forensicsToolsStr = "binwalk bulk-extractor chntpw cuckoo dc3dd ddrescue " +
            "dumpzilla extundelete foremost galleta guymager " +
            "iphone-backup-analyzer p0f pdf-parser pdfid pdgmail " +
            "peepdf volatility xplico";
    static  List<String> forensicsToolsList =  Arrays.stream(forensicsToolsStr.split(" ")).toList();

    static String stressTestingToolsStr = "dhcpig funkload iaxflood inviteflood ipv6-toolkit mdk3 " +
            "reaver rtpflood slowhttptest t50 termineter thc-ipv6 " +
            "thc-ssl-dos";
    static  List<String> stressTestingToolsList =  Arrays.stream(stressTestingToolsStr.split(" ")).toList();

    static String passwordAttackToolsStr = "acccheck burpsuite cewl chntpw cisco-auditing-tool " +
            "cmospwd creddump crunch findmyhash gpp-decrypt " +
            "hash-identifier hexorbase john johnny keimpx " +
            "maltego-teeth maskprocessor multiforcer ncrack " +
            "oclgausscrack pack patator polenum rainbowcrack " +
            "rcracki-mt rsmangler statsprocessor thc-pptp-bruter " +
            "truecrack webscarab wordlists zaproxy";
    static  List<String> passwordAttackToolsList =  Arrays.stream(passwordAttackToolsStr.split(" ")).toList();

    static String reverseEngineeringToolsStr = "apktool dex2jar python-distorm3 edb-debugger jad " +
            "javasnoop jd ollydbg smali valgrind yara";
    static  List<String> reverseEngineeringToolsList =  Arrays.stream(reverseEngineeringToolsStr.split(" ")).toList();

public static List<String> GetApplicationSelection(Integer userInput){
     List<String> selection = new ArrayList<>();
    if(userInput == 1){
        selection = reportingToolsList;
    }
    if(userInput == 2){
        selection = vulnerabilityAnalysisToolsList;
    }
    if(userInput == 3){
        selection = wirelessAttacksToolsList;
    }
    if(userInput == 4){
        selection = webApplicationSecurityToolsList;
    }
    if(userInput == 5){
        selection = networkSecurityToolsList;
    }if(userInput == 6){
        selection = networkUtilitiesToolsList;
    }
    if(userInput == 7){
        selection = exploitationToolsList;
    }
    if(userInput == 8){
        selection = forensicsToolsList;
    }
    if(userInput == 9){
        selection = stressTestingToolsList;
    }
    if(userInput == 10){
        selection = passwordAttackToolsList;
    }
    if(userInput == 11){
        selection = reverseEngineeringToolsList;
    }
    if(userInput == 0){
        Stream.of(reportingToolsList,vulnerabilityAnalysisToolsList,wirelessAttacksToolsList,webApplicationSecurityToolsList,networkSecurityToolsList,networkUtilitiesToolsList,exploitationToolsList,forensicsToolsList,stressTestingToolsList,passwordAttackToolsList,reverseEngineeringToolsList).forEach(selection::addAll);
    }


    return selection;
}
}

