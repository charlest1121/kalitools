import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppList {

    static String reportingToolsStr = "casefile cutycapt dos2unix dradis keepnote magictree metagoofil nipper-ng pipal";
    static List<String> reportingToolsList = Arrays.stream(reportingToolsStr.split(" ")).toList();

    static String informationGatheringToolsStr = "acccheck ace-voip amap automater braa casefile cdpsnarf " +
            "cisco-torch cookie-cadger copy-router-config dmitry dnmap dnsenum dnsmap dnsrecon dnstracer " +
            "dnswalk dotdotpwn enum4linux enumiax exploitdb fierce firewalk fragroute fragrouter ghost-phisher " +
            "golismero goofile lbd maltego-teeth masscan metagoofil miranda nmap p0f parsero recon-ng set " +
            "smtp-user-enum snmpcheck sslcaudit sslsplit sslstrip sslyze thc-ipv6 theharvester tlssled twofi " +
            "urlcrazy wireshark wol-e xplico ismtp intrace hping3";
    static List<String> informationGatheringToolsList = Arrays.stream(informationGatheringToolsStr.split(" ")).toList();

    static String vulnerabilityAnalysisToolsStr = "bbqsql bed cisco-auditing-tool cisco-global-exploiter \n" +
            "    cisco-ocs cisco-torch copy-router-config doona \n" +
            "    dotdotpwn greenbone-security-assistant hexorbase jsql \n" +
            "    lynis nmap ohrwurm openvas-cli openvas-manager \n" +
            "    openvas-scanner oscanner powerfuzzer sfuzz sidguesser \n" +
            "    siparmyknife sqlmap sqlninja sqlsus thc-ipv6 \n" +
            "    tnscmd10g unix-privesc-check yersinia";
    static List<String> vulnerabilityAnalysisToolsList = Arrays.stream(vulnerabilityAnalysisToolsStr.split(" ")).toList();

    static String wirelessAttacksToolsStr = "aircrack-ng asleap bluelog blueranger bluesnarfer bully \n" +
            "    cowpatty crackle eapmd5pass fern-wifi-cracker ghost-phisher \n" +
            "    giskismet kalibrate-rtl killerbee kismet mdk3 mfcuk \n" +
            "    mfoc mfterm multimon-ng pixiewps reaver redfang \n" +
            "    spooftooph wifi-honey wifitap wifite";
    static List<String> wirelessAttacksToolsList = Arrays.stream(wirelessAttacksToolsStr.split(" ")).toList();

    static String webApplicationSecurityToolsStr = "apache-users arachni bbqsql blindelephant burpsuite \n" +
            "    cutycapt davtest deblaze dirb dirbuster fimap \n" +
            "    funkload grabber jboss-autopwn joomscan jsql \n" +
            "    maltego-teeth padbuster paros parsero plecost \n" +
            "    powerfuzzer proxystrike recon-ng skipfish sqlmap \n" +
            "    sqlninja sqlsus ua-tester uniscan vega w3af \n" +
            "    webscarab websploit wfuzz wpscan xsser zaproxy";
    static List<String> webApplicationSecurityToolsList = Arrays.stream(webApplicationSecurityToolsStr.split(" ")).toList();

    static String networkSecurityToolsStr = "burpsuite dnschef fiked hamster-sidejack hexinject iaxflood \n" +
            "    inviteflood ismtp mitmproxy ohrwurm protos-sip rebind \n" +
            "    responder rtpbreak rtpinsertsound rtpmixsound sctpscan \n" +
            "    siparmyknife sipp sipvicious sniffjoke sslsplit sslstrip \n" +
            "    thc-ipv6 voiphopper webscarab wifi-honey wireshark xspy \n" +
            "    yersinia zaproxy";
    static List<String> networkSecurityToolsList = Arrays.stream(networkSecurityToolsStr.split(" ")).toList();

    static String networkUtilitiesToolsStr = "cryptcat cymothoa dbd dns2tcp http-tunnel httptunnel \n" +
            "    intersect nishang polenum powersploit pwnat ridenum \n" +
            "    sbd u3-pwn webshells weevely";
    static List<String> networkUtilitiesToolsList = Arrays.stream(networkUtilitiesToolsStr.split(" ")).toList();

    static String exploitationToolsStr = "armitage backdoor-factory beef-xss cisco-auditing-tool \n" +
            "    cisco-global-exploiter cisco-ocs cisco-torch crackle \n" +
            "    jboss-autopwn linux-exploit-suggester maltego-teeth set \n" +
            "    shellnoob sqlmap thc-ipv6 yersinia";
    static List<String> exploitationToolsList = Arrays.stream(exploitationToolsStr.split(" ")).toList();

    static String forensicsToolsStr = "binwalk bulk-extractor chntpw cuckoo dc3dd ddrescue \n" +
            "    dumpzilla extundelete foremost galleta guymager \n" +
            "    iphone-backup-analyzer p0f pdf-parser pdfid pdgmail \n" +
            "    peepdf volatility xplico";
    static List<String> forensicsToolsList = Arrays.stream(forensicsToolsStr.split(" ")).toList();

    static String stressTestingToolsStr = "dhcpig funkload iaxflood inviteflood ipv6-toolkit mdk3 \n" +
            "    reaver rtpflood slowhttptest t50 termineter thc-ipv6 \n" +
            "    thc-ssl-dos";
    static List<String> stressTestingToolsList = Arrays.stream(stressTestingToolsStr.split(" ")).toList();

    static String passwordAttackToolsStr = "acccheck burpsuite cewl chntpw cisco-auditing-tool \n" +
            "    cmospwd creddump crunch findmyhash gpp-decrypt \n" +
            "    hash-identifier hexorbase john johnny keimpx \n" +
            "    maltego-teeth maskprocessor multiforcer ncrack \n" +
            "    oclgausscrack pack patator polenum rainbowcrack \n" +
            "    rcracki-mt rsmangler statsprocessor thc-pptp-bruter \n" +
            "    truecrack webscarab wordlists zaproxy";
    static List<String> passwordAttackToolsList = Arrays.stream(passwordAttackToolsStr.split(" ")).toList();

    static String reverseEngineeringToolsStr = "apktool dex2jar python-distorm3 edb-debugger jad \n" +
            "    javasnoop jd ollydbg smali valgrind yara";
    static List<String> reverseEngineeringToolsList = Arrays.stream(reverseEngineeringToolsStr.split(" ")).toList();

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

