package seafilewebapi.libraryobjects;

import seafilewebapi.AbstractCommit;

/**
 * @author freezingrainyu
 * @version 1.0
 * @date 2019/04/18
 */
public class LibraryCommit extends AbstractCommit {

    public LibraryCommit(long revFileSize, String revFileId, long ctime, String creatorName, String creator, String rootId, String revRenamedOldPath, String parentId, boolean newMerge, String repoId, String desc, String id, boolean conflict, String secondParentId) {
        super(revFileSize, revFileId, ctime, creatorName, creator, rootId, revRenamedOldPath, parentId, newMerge, repoId, desc, id, conflict, secondParentId);
    }
}
