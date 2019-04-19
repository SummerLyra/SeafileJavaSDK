package seafilewebapi.libraryobjects;

/**
 * @author freezingrainyu
 * @version 1.1
 * @date 2019/04/18
 */
public class LibraryCommit {

    private String commitId;
    private String time;
    private String description;
    private String creator;

    public LibraryCommit(String commitId, String time, String description, String creator) {
        this.commitId = commitId;
        this.time =
        this.description = description;
        this.creator = creator;
    }

    public String getCommitId() {
        return commitId;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getCreator() {
        return creator;
    }
}
