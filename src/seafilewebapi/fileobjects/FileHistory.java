package seafilewebapi.fileobjects;

import java.util.List;

/**
 * @author freezingrainyu
 * @version 1.0
 * @date 2019/04/18
 */
public class FileHistory {

    private List<FileCommit> commits;

    public FileHistory(List<FileCommit> commits, boolean pageNext) {
        this.commits = commits;
    }

    public List<FileCommit> getCommits() {
        return commits;
    }
}
