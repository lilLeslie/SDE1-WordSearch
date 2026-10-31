package be;

public class HistoryEntry {
    private String query;
    private boolean found;

    public HistoryEntry(String query, Boolean found){
        this.query = query;
        this.found = found;
    }

    public void setQuery(String query){
        this.query = query;
    }

    public void setFound(boolean found){
        this.found = found;
    }

    public String getQuery(){
        return query;
    }

    public Boolean isFound(){
        return found;
    }

    public String toString(){
        return "Search for '" + query + "' and found " + (found ? "" : "no") + " results";
    }

    public String toCsvString(){
        return query+","+found;
    }
}
