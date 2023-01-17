package testing.spotBugsSamples;

public class OfConcernRankBugs {

    private String placeholder = null;

    /**
     * Constructor
     */
    public OfConcernRankBugs() {
        this.placeholder = "Test String";
    }

    /**
     * Getter
     */
    private String getPlaceholder() {
        return this.placeholder;
    }

    @Override
    public boolean equals(Object obj) {
        OfConcernRankBugs object = (OfConcernRankBugs) obj;
        return this.getPlaceholder().equals(object.getPlaceholder());
    }
}
