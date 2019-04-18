package seafilewebapi.libraryobjects;

/**
 * @author freezingrainyu
 * @version 1.1
 * @date 2019/04/18
 */
public class CreatedLibraryInfo extends AbstractLibraryInfoCreateOrFetch {

    private int evcVersion;
    private String magic;
    private int repoVersion;
    private String randomKey;

    public CreatedLibraryInfo(String encrypted, int evcVersion, String repoId, String magic, String relayId, int repoVersion, String relayAddr, String token, String relayPort, String randomKey, String email, String repoName) {
        super(encrypted, repoId, relayId, relayAddr, token, relayPort, email, repoName);
        this.evcVersion = evcVersion;
        this.magic = magic;
        this.repoVersion = repoVersion;
        this.randomKey = randomKey;
    }

    public int getEvcVersion() {
        return evcVersion;
    }

    public String getMagic() {
        return magic;
    }

    public int getRepoVersion() {
        return repoVersion;
    }

    public String getRandomKey() {
        return randomKey;
    }
}
