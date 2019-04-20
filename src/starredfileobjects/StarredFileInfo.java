package starredfileobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author freezingrainyu
 * @version 1.5
 * @date 2019/04/17
 */
public class StarredFileInfo {

    private String repo;
    private String mtime;
    private int org;
    private String path;
    private boolean dir;
    private long size;

    public StarredFileInfo(String repo, long mtime, int org, String path, boolean dir, long size) {
        this.repo = repo;
        this.mtime = Instant.EPOCH.plus(mtime, SECONDS).toString();
        this.org = org;
        this.path = path;
        this.dir = dir;
        this.size = size;
    }

    public String getRepo() {
        return repo;
    }

    public String getMtime() {
        return mtime;
    }

    public int getOrg() {
        return org;
    }

    public String getPath() {
        return path;
    }

    public boolean isDir() {
        return dir;
    }

    public long getSize() {
        return size;
    }
}
