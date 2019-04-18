package seafilewebapi.libraryobjects;

/**
 * @author freezingrainyu
 * @version 1.1
 * @date 2019/04/18
 */
public class GettedLibraryInfo extends AbstractLibraryInfoGetOrList {

    private String passwordNeed;

    public GettedLibraryInfo(boolean encrypted, String passwordNeed, long mtime, String owner, String id, long size, String name, String root, String desc, String type) {
        super(encrypted, mtime, owner, id, size, name, type, desc, root);
        this.passwordNeed = passwordNeed;
    }

    public String getPasswordNeed() {
        return passwordNeed;
    }
}
