package seafilewebapi;

import java.util.List;

/**
 * @author freezingrainnyu
 * @version 1.0
 * @date 2019/04/17
 */
public class ServerInfo {

    private String version;
    private List<String> features;

    public ServerInfo(String version, List<String> features) {
        this.version = version;
        this.features = features;
    }

    public String getVersion() {
        return version;
    }

    public List<String> getFeatures() {
        return features;
    }
}
