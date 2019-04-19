package seafilewebapi.fileobjects;

import java.time.Instant;

/**
 * @author freezingrainyu
 * @version 1.2
 * @date 2019/04/18
 */
public class FileCommit {

    private String commitId;
    private String revFileId;
    private String ctime;
    private String creatorName;
    private String creatorEmail;
    private String revRenamedOldPath;
    private String creatorAvatarUrl;
    private String path;
    private String creatorContactEmail;
    private long size;
    private String description;

    public FileCommit(String commitId, String revFileId, String ctime, String creatorName, String creatorEmail, String revRenamedOldPath, String creatorAvatarUrl, String path, String creatorContactEmail, long size, String description) {
        this.commitId = commitId;
        this.revFileId = revFileId;
        this.ctime = ctime;
        this.creatorName = creatorName;
        this.creatorEmail = creatorEmail;
        this.revRenamedOldPath = revRenamedOldPath;
        this.creatorAvatarUrl = creatorAvatarUrl;
        this.path = path;
        this.creatorContactEmail = creatorContactEmail;
        this.size = size;
        this.description = description;
    }

    public String getCommitId() {
        return commitId;
    }

    public String getRevFileId() {
        return revFileId;
    }

    public String getCtime() {
        return ctime;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public String getRevRenamedOldPath() {
        return revRenamedOldPath;
    }

    public String getCreatorAvatarUrl() {
        return creatorAvatarUrl;
    }

    public String getPath() {
        return path;
    }

    public String getCreatorContactEmail() {
        return creatorContactEmail;
    }

    public long getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }
}
