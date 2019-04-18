package seafilewebapi.libraryobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author freezingrainyu
 * @version 1.1
 * @date 2019/04/18
 */
public abstract class AbstractCommit {

    private long revFileSize;
    private String revFileId;
    private Instant ctime;
    private String creatorName;
    private String creator;
    private String rootId;
    private String revRenamedOldPath;
    private String parentId;
    private boolean newMerge;
    private String repoId;
    private String desc;
    private String id;
    private boolean conflict;
    private String secondParentId;

    public AbstractCommit(long revFileSize, String revFileId, long ctime, String creatorName, String creator, String rootId, String revRenamedOldPath, String parentId, boolean newMerge, String repoId, String desc, String id, boolean conflict, String secondParentId) {
        this.revFileSize = revFileSize;
        this.revFileId = revFileId;
        this.ctime = Instant.EPOCH.plus(ctime, SECONDS);
        this.creatorName = creatorName;
        this.creator = creator;
        this.rootId = rootId;
        this.revRenamedOldPath = revRenamedOldPath;
        this.parentId = parentId;
        this.newMerge = newMerge;
        this.repoId = repoId;
        this.desc = desc;
        this.id = id;
        this.conflict = conflict;
        this.secondParentId = secondParentId;
    }

    public long getRevFileSize() {
        return revFileSize;
    }

    public String getRevFileId() {
        return revFileId;
    }

    public Instant getCtime() {
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

    public String getRepoId() {
        return repoId;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public boolean isConflict() {
        return conflict;
    }

    public String getSecondParentId() {
        return secondParentId;
    }
}
