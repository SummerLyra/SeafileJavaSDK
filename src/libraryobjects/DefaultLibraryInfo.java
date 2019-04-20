package libraryobjects;

/**
 * @author freezingrainyu
 * @version 1.5
 * @date 2019/04/17
 */
public class DefaultLibraryInfo {

    private String repoId;
    private boolean exists;

    public DefaultLibraryInfo(String repoId, boolean exists) {
        this.repoId = repoId;
        this.exists = exists;
    }

    public String getRepoId() {
        return repoId;
    }

    public boolean isExists() {
        return exists;
    }
}
