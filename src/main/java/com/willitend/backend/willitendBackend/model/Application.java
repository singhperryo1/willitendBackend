import java.util.*;

public class Application {
    int totalNumofDecodedUrl;
    int totalNumofHitRate;
   HashSet<String> userNames = new HashSet<>();

    public Application(int totalNumofDecodedUrl, int totalNumofHitRate, HashSet<String> userNames) {
        this.totalNumofDecodedUrl = totalNumofDecodedUrl;
        this.totalNumofHitRate = totalNumofHitRate;
        this.userNames = userNames;
    }

    public int getTotalNumofDecodedUrl() {
        return totalNumofDecodedUrl;
    }

    public void setTotalNumofDecodedUrl(int totalNumofDecodedUrl) {
        this.totalNumofDecodedUrl = totalNumofDecodedUrl;
    }

    public int getTotalNumofHitRate() {
        return totalNumofHitRate;
    }

    public void setTotalNumofHitRate(int totalNumofHitRate) {
        this.totalNumofHitRate = totalNumofHitRate;
    }

    public HashSet<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(HashSet<String> userNames) {
        this.userNames = userNames;
    }

    @Override
    public String toString() {
        return "Application{" +
                "totalNumofDecodedUrl=" + totalNumofDecodedUrl +
                ", totalNumofHitRate=" + totalNumofHitRate +
                ", userNames=" + userNames +
                '}';
    }
}
