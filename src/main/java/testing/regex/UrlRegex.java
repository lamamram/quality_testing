package testing.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlRegex {
    private Pattern pattern;
    
    public UrlRegex(String patternString, String flags) {
        int compileFlags = 0;
        for (String f : flags.split("")) {
            if ("m".equals(f)) {
                compileFlags |= Pattern.MULTILINE;
            }
            else if ("i".equals(f)){
                compileFlags |= Pattern.CASE_INSENSITIVE;
            }
        }
        this.pattern = Pattern.compile(patternString, compileFlags);
    }
    
    public List<String> captureMatch(String target){
        Matcher matcher = pattern.matcher(target);
        List<String>lst = new ArrayList<>();
        if (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                lst.add(matcher.group(i));
            }
        }
        return lst;
    }
//    
//    public String replace(String target, String repl) {
//        Matcher matcher = pattern.matcher(target);
//        return matcher.replaceAll(repl);
//    }
}
