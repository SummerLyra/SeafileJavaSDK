package seafilewebapi.avatarobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author freezingrainnyu
 * @version 1.1
 * @date 2019/04/18
 */
public class AvatarInfo {

    private String url;
    private boolean isDefault;
    private String mtime;

    public AvatarInfo(String url,boolean isDefault,long mtime){
        this.url=url;
        this.isDefault=isDefault;
        this.mtime= Instant.EPOCH.plus(mtime, SECONDS).toString();
    }

    public String getUrl() {
        return url;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public String getMtime() {
        return mtime;
    }
}
