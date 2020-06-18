package entities;

public class RateLimit {
    private int coreLimit;
    private String searchLimit;

    public int getCoreLimit(){
        return coreLimit;
    }
    public String getSearchLimit(){
        return searchLimit;
    }
}
