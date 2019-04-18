package seafilewebapi;

/**
 * @author freezingrainyu
 * @version 1.0
 * @date 2019/04/18
 */
public abstract class AbstractLibraryInfoCreateOrFetch {

    private String encrypted;
    private String repoId;
    private String relayId;
    private String relayAddr;
    private String token;
    private String relayPort;
    private String email;
    private String repoName;

    public AbstractLibraryInfoCreateOrFetch(String encrypted, String repoId, String relayId, String relayAddr, String token, String relayPort, String email, String repoName) {
        this.encrypted = encrypted;
        this.repoId = repoId;
        this.relayId = relayId;
        this.relayAddr = relayAddr;
        this.token = token;
        this.relayPort = relayPort;
        this.email = email;
        this.repoName = repoName;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public String getRepoId() {
        return repoId;
    }

    public String getRelayId() {
        return relayId;
    }

    public String getRelayAddr() {
        return relayAddr;
    }

    public String getToken() {
        return token;
    }

    public String getRelayPort() {
        return relayPort;
    }

    public String getEmail() {
        return email;
    }

    public String getRepoName() {
        return repoName;
    }
}
