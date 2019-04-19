package seafilejavasdk.directoryobjects;

/**
 * @author freezingrainnyu
 * @version 1.5
 * @date 2019/04/19
 */
public class DirectoryEntry {

    private String id;
    private String type;
    private String name;
    private long size;

    public DirectoryEntry(String id, String type, String name, long size) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }
}
