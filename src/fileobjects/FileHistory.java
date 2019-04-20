package fileobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author freezingrainyu
 * @version 1.5
 * @date 2019/04/18
 */
public class FileHistory {

    private long revFileSize;
    private String repoId;
    private String ctime;
    private String creatorName;
    private String creator;
    private String rootId;
    private String revRenamedOldPath;
    private String parentId;
    private boolean newMerge;
    private int version;
    private boolean conflict;
    private String desc;
    private String id;
    private String revFileId;
    private String secondParentId;

    public FileHistory(long revFileSize, String repoId, long ctime, String creatorName, String creator, String rootId, String revRenamedOldPath, String parentId, boolean newMerge, int version, boolean conflict, String desc, String id, String revFileId, String secondParentId) {
        this.revFileSize = revFileSize;
        this.repoId = repoId;
        this.ctime = Instant.EPOCH.plus(ctime, SECONDS).toString();
        this.creatorName = creatorName;
        this.creator = creator;
        this.rootId = rootId;
        this.revRenamedOldPath = revRenamedOldPath;
        this.parentId = parentId;
        this.newMerge = newMerge;
        this.version = version;
        this.conflict = conflict;
        this.desc = desc;
        this.id = id;
        this.revFileId = revFileId;
        this.secondParentId = secondParentId;
    }

    public long getRevFileSize() {
        return revFileSize;
    }

    public String getRepoId() {
        return repoId;
    }

    public String getCtime() {
        return ctime;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getCreator() {
        return creator;
    }

    public String getRootId() {
        return rootId;
    }

    public String getRevRenamedOldPath() {
        return revRenamedOldPath;
    }

    public String getParentId() {
        return parentId;
    }

    public boolean isNewMerge() {
        return newMerge;
    }

    public int getVersion() {
        return version;
    }

    public boolean isConflict() {
        return conflict;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public String getRevFileId() {
        return revFileId;
    }

    public String getSecondParentId() {
        return secondParentId;
    }
}
