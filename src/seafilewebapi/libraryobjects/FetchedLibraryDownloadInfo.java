package seafilewebapi.libraryobjects;

/**
 * @author freezingrainyu
 * @version 1.1
 * @date 2019/04/18
 */
public class FetchedLibraryDownloadInfo {

    private String appletRoot;
    private String relayAddr;
    private String token;
    private String repoId;
    private String relayPort;
    private String encrypted;
    private String repoName;
    private String relayId;
    private String email;

    public FetchedLibraryDownloadInfo(String appletRoot, String relayAddr, String token, String repoId, String relayPort, String encrypted, String repoName, String relayId, String email) {
        this.encrypted = encrypted;
        this.repoId = repoId;
        this.relayId = relayId;
        this.relayAddr = relayAddr;
        this.token = token;
        this.relayPort = relayPort;
        this.email = email;
        this.repoName = repoName;
        this.appletRoot = appletRoot;
    }

    public String getAppletRoot() {
        return appletRoot;
    }

    public String getRelayAddr() {
        return relayAddr;
    }

    public String getToken() {
        return token;
    }

    public String getRepoId() {
        return repoId;
    }

    public String getRelayPort() {
        return relayPort;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getRelayId() {
        return relayId;
    }

    public String getEmail() {
        return email;
    }
}
