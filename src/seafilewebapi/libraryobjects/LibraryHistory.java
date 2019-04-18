package seafilewebapi.libraryobjects;

import java.util.List;

/**
 * @author freezingrainyu
 * @version 1.1
 * @date 2019/04/18
 */
public class LibraryHistory {

    private List<LibraryCommit> commits;
    private boolean pageNext;

    public LibraryHistory(List<LibraryCommit> commits, boolean pageNext) {
        this.commits = commits;
        this.pageNext = pageNext;
    }

    public List<LibraryCommit> getCommits() {
        return commits;
    }

    public boolean isPageNext() {
        return pageNext;
    }
}
