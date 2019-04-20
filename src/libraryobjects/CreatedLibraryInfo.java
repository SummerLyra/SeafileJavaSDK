package libraryobjects;

/**
 * @author freezingrainyu
 * @version 1.5
 * @date 2019/04/18
 */
public class CreatedLibraryInfo {

    private String encrypted;
    private int evcVersion;
    private String repoId;
    private String magic;
    private String relayId;
    private int repoVersion;
    private String relayAddr;
    private String token;
    private String relayPort;
    private String randomKey;
    private String email;
    private String repoName;

    public CreatedLibraryInfo(String encrypted, int evcVersion, String repoId, String magic, String relayId, int repoVersion, String relayAddr, String token, String relayPort, String randomKey, String email, String repoName) {
        this.encrypted = encrypted;
        this.evcVersion = evcVersion;
        this.repoId = repoId;
        this.magic = magic;
        this.relayId = relayId;
        this.repoVersion = repoVersion;
        this.relayAddr = relayAddr;
        this.token = token;
        this.relayPort = relayPort;
        this.randomKey = randomKey;
        this.email = email;
        this.repoName = repoName;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public int getEvcVersion() {
        return evcVersion;
    }

    public String getRepoId() {
        return repoId;
    }

    public String getMagic() {
        return magic;
    }

    public String getRelayId() {
        return relayId;
    }

    public int getRepoVersion() {
        return repoVersion;
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

    public String getRandomKey() {
        return randomKey;
    }

    public String getEmail() {
        return email;
    }

    public String getRepoName() {
        return repoName;
    }
}
