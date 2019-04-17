package seafilewebapi;

/**
 * @author freezingrainyu
 * @version 1.0
 * @date 2019/04/18
 */
public class GettedLibraryInfo extends LibraryInfo {

    private String passwordNeed;

    public GettedLibraryInfo(String passwordNeed, boolean encrypted, long mtime, String owner, String id, long size, String name, String type, String desc, String root) {
        super(encrypted, mtime, owner, id, size, name, type, desc, root);
        this.passwordNeed = passwordNeed;
    }

    public String getPasswordNeed() {
        return passwordNeed;
    }
}
