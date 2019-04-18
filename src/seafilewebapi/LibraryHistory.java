package seafilewebapi;

import java.util.List;

/**
 * @author freezingrainyu
 * @version 1.0
 * @date 2019/04/18
 */
public class LibraryHistory {

    private List<Commit> commits;
    private boolean pageNext;

    public LibraryHistory(List<Commit> commits, boolean pageNext) {
        this.commits = commits;
        this.pageNext = pageNext;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public boolean isPageNext() {
        return pageNext;
    }
}
