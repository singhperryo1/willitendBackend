import java.util.*;

public class Dashboard {
    //profile --> user photo
    //static String profile;
    String urls;
    int totalRates;
    HashSet<String> rank = new HashSet<>();
    HashSet<String> encodedUrls = new HashSet<>();
    HashSet<String> Urls = new HashSet<>();

    public Dashboard(String urls, int totalRates, HashSet<String> rank, HashSet<String> encodedUrls, HashSet<String> urls1) {
        this.urls = urls;
        this.totalRates = totalRates;
        this.rank = rank;
        this.encodedUrls = encodedUrls;
        Urls = urls1;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(HashSet<String> urls) {
        Urls = urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public int getTotalRates() {
        return totalRates;
    }

    public void setTotalRates(int totalRates) {
        this.totalRates = totalRates;
    }

    public HashSet<String> getRank() {
        return rank;
    }

    public void setRank(HashSet<String> rank) {
        this.rank = rank;
    }

    public HashSet<String> getEncodedUrls() {
        return encodedUrls;
    }

    public void setEncodedUrls(HashSet<String> encodedUrls) {
        this.encodedUrls = encodedUrls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dashboard)) return false;
        Dashboard dashboard = (Dashboard) o;
        return getTotalRates() == dashboard.getTotalRates() && Objects.equals(getUrls(), dashboard.getUrls()) && Objects.equals(getRank(), dashboard.getRank()) && Objects.equals(getEncodedUrls(), dashboard.getEncodedUrls()) && Objects.equals(getUrls(), dashboard.getUrls());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrls(), getTotalRates(), getRank(), getEncodedUrls(), getUrls());
    }

    @Override
    public String toString() {
        return "Dashboard{" +
                "urls='" + urls + '\'' +
                ", totalRates=" + totalRates +
                ", rank=" + rank +
                ", encodedUrls=" + encodedUrls +
                ", Urls=" + Urls +
                '}';
    }
}
