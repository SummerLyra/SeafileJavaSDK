package seafilewebapi.fileobjects;

import java.util.List;

/**
 * @author freezingrainyu
 * @version 1.2
 * @date 2019/04/18
 */
public class FileHistory{

    private String nextStartCommit;
    private List<FileCommit> data;

    public FileHistory(String nextStartCommit,List<FileCommit> data) {
        this.nextStartCommit=nextStartCommit;
        this.data = data;
    }

    public String getNextStartCommit() {
        return nextStartCommit;
    }

    public List<FileCommit> getData() {
        return data;
    }
}
