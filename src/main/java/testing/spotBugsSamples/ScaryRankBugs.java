package testing.spotBugsSamples;

/**
 *  * Scary Rank Bugs Sample  
 */
public class ScaryRankBugs {

    /** The check str value. */
    private String checkStrValue = null;

    /**
     *      * The Constructor.      
     */
    public ScaryRankBugs() {
        this.checkStrValue = "someValue";
    }

    /**
     *      * Execute some conditions.      
     */
    private void SomeCondition() {
        if ("someValue".equals(this.checkStrValue)) {
            System.out.println("displayed");
        } else if ("someValue".equals(this.checkStrValue)) {
            System.out.println("always displayed");
        }
    }

    /**
     *      * Incorrect assignment in if condition.      
     */
    private static void IncorrectAssignmentInIf() {
        boolean value = false;
        if (value = true) {
            System.out.println("always displayed");
        }
    }
}
