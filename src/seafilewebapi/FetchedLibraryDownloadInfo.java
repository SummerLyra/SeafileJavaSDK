package seafilewebapi;

/**
 * @author freezingrainyu
 * @version 1.0
 * @date 2019/04/18
 */
public class FetchedLibraryDownloadInfo extends AbstractLibraryInfoCreateOrFetch {

    private String appletRoot;

    public FetchedLibraryDownloadInfo(String appletRoot, String relayAddr, String token, String repoId, String relayPort, String encrypted, String repoName, String relayId, String email) {
        super(encrypted, repoId, relayId, relayAddr, token, relayPort, email, repoName);
        this.appletRoot = appletRoot;
    }

    public String getAppletRoot() {
        return appletRoot;
    }
}
