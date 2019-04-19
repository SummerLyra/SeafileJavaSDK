package seafilewebapi.libraryobjects;

import java.util.List;

/**
 * @author freezingrainyu
 * @version 1.2
 * @date 2019/04/18
 */
public class LibraryHistory {

    private List<LibraryCommit> commits;
    private boolean more;

    public LibraryHistory(List<LibraryCommit> commits, boolean more) {
        this.commits = commits;
        this.more = more;
    }

    public List<LibraryCommit> getCommits() {
        return commits;
    }

    public boolean isMore() {
        return more;
    }
}
