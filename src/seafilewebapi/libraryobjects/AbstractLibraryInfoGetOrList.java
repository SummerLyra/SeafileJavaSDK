package seafilewebapi.libraryobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author freezingrainyu
 * @version 1.1
 * @date 2019/04/17
 */
abstract class AbstractLibraryInfoGetOrList {

    private boolean encrypted;
    private Instant mtime;
    private String owner;
    private String id;
    private long size;
    private String name;
    private String type;
    private String desc;
    private String root;

    public AbstractLibraryInfoGetOrList(boolean encrypted, long mtime, String owner, String id, long size, String name, String type, String desc, String root) {
        this.encrypted = encrypted;
        this.mtime = Instant.EPOCH.plus(mtime, SECONDS);
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

    public Instant getMtime() {
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
