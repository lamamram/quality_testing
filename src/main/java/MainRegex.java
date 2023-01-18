import java.util.List;
import java.util.regex.Matcher;

import testing.regex.UrlRegex;
import testing.regex.ZipCodeRegex;

public class MainRegex {

    public static void main(String[] args) {
        String zpPattern = "2[0-9AB][0-9]{3}|[013456789][0-9]{4}";
        String urlPattern = "(https?|s?ftp|ftps?|ssh):\\/\\/((?:[a-z0-9_\\-]+\\.)+[a-z]{2,})((?:\\/[a-z0-9_\\-]+)+\\/?)";
        //processZipcode(zpPattern);
        processUrl(urlPattern);        
    }
    
    public static void processZipcode(String pattern) {
        ZipCodeRegex zr = new ZipCodeRegex(pattern);
        List<String> matches= zr.findAll("mon zipcode est 44245 ou 2A345");
        for (String m : matches) {
            System.out.println(m);
        }
        System.out.println(zr.replace("mon zipcode est 44245 ou 2A345", "*****"));
    }
    
    public static void processUrl(String pattern) {
        UrlRegex ur = new UrlRegex(pattern);
        String target = "https://www.dawan.fr/trainings/qualite-du-code";
        List<String> groups = ur.captureMatch(target);
        for (String g : groups) {
            System.out.println(g);
        }
        // remplacement qui réinjecte des groupes de capture
        System.out.println(ur.replace(target, "$1://$2/login.php"));
    }
}
