package seafilewebapi.libraryobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author freezingrainyu
 * @version 1.5
 * @date 2019/04/18
 */
public class GettedLibraryInfo {

    private boolean encrypted;
    private String passwordNeed;
    private String mtime;
    private String owner;
    private String id;
    private long size;
    private String name;
    private String type;
    private String desc;
    private String root;

    public GettedLibraryInfo(boolean encrypted, String passwordNeed, long mtime, String owner, String id, long size, String name, String root, String desc, String type) {
        this.encrypted = encrypted;
        this.passwordNeed = passwordNeed;
        this.mtime = Instant.EPOCH.plus(mtime, SECONDS).toString();
        this.owner = owner;
        this.id = id;
        this.size = size;
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.root = root;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public String getPasswordNeed() {
        return passwordNeed;
    }

    public String getMtime() {
        return mtime;
    }

    public String getOwner() {
        return owner;
    }

    public String getId() {
        return id;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public String getRoot() {
        return root;
    }
}
