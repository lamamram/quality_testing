import java.util.List;

import testing.regex.ZipCodeRegex;

public class MainRegex {

    public static void main(String[] args) {
        String pattern = "2[0-9AB][0-9]{3}|[013456789][0-9]{4}";
        ZipCodeRegex zr = new ZipCodeRegex(pattern);
        List<String> matches= zr.findAll("mon zipcode est 44245 ou 2A345");
        for (String m : matches) {
            System.out.println(m);
        }
        System.out.println(zr.replace("mon zipcode est 44245 ou 2A345", "*****"));
    }
}
