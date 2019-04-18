package seafilewebapi.fileobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author freezingrainnyu
 * @version 1.0
 * @date 2019/04/18
 */
public class FileDetail {

    private String id;
    private Instant mtime;
    private String type;
    private String name;
    private long size;

    public FileDetail(String id, long mtime, String type, String name, long size) {
        this.id = id;
        this.mtime = Instant.EPOCH.plus(mtime, SECONDS);
        this.type = type;
        this.name = name;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public Instant getMtime() {
        return mtime;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }
}
