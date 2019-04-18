package seafilewebapi.fileobjects;

import seafilewebapi.AbstractCommit;

/**
 * @author freezingrainyu
 * @version 1.0
 * @date 2019/04/18
 */
public class FileCommit extends AbstractCommit {

    private int version;

    public FileCommit(long revFileSize, String repoId, long ctime, String creatorName, String creator, String rootId, String revRenamedOldPath, String parentId, boolean newMerge, int version, boolean conflict, String desc, String id, String revFileId, String secondParentId) {
        super(revFileSize, revFileId, ctime, creatorName, creator, rootId, revRenamedOldPath, parentId, newMerge, repoId, desc, id, conflict, secondParentId);
        this.version = version;
    }

    public int getVersion() {
        return version;
    }
}
