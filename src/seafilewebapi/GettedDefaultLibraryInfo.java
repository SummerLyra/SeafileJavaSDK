package seafilewebapi;

/**
 * @author freezingrainyu
 * @version 1.0
 * @date 2019/04/17
 */
public class GettedDefaultLibraryInfo {

    private String repoId;
    private boolean exists;

    public GettedDefaultLibraryInfo(String repoId, boolean exists) {
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
