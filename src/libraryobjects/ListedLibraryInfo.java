package libraryobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author freezingrainyu
 * @version 1.5
 * @date 2019/04/18
 */
public class ListedLibraryInfo {

    private String permission;
    private boolean encrypted;
    private String mtime;
    private String owner;
    private String id;
    private long size;
    private String name;
    private String type;
    private boolean virtual;
    private String desc;
    private String root;


    public ListedLibraryInfo(String permission, boolean encrypted, long mtime, String owner, String id, long size, String name, String type, boolean virtual, String desc, String root) {
        this.permission = permission;
        this.encrypted = encrypted;
        this.mtime = Instant.EPOCH.plus(mtime, SECONDS).toString();
        this.owner = owner;
        this.id = id;
        this.size = size;
        this.name = name;
        this.type = type;
        this.virtual = virtual;
        this.desc = desc;
        this.root = root;
    }

    public String getPermission() {
        return permission;
    }

    public boolean isEncrypted() {
        return encrypted;
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

    public boolean isVirtual() {
        return virtual;
    }

    public String getDesc() {
        return desc;
    }

    public String getRoot() {
        return root;
    }
}
