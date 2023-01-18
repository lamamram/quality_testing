package testing.regex;

public class SLowDependency {

    private String param;

    public SLowDependency() {
        this.param = "param";
    }
    
    public String slowMethod() throws InterruptedException {
        Thread.sleep(3000);
        return this.param;
    }
}
