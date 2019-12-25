package seafilejavasdk.avatarobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author liudongyu1119@outlook.com
 * @version 1.5
 * @date 2019/04/19
 */
public class AvatarInfo {

    private String url;
    private boolean isDefault;
    private String mtime;

    public AvatarInfo(String url, boolean isDefault, long mtime) {
        this.url = url;
        this.isDefault = isDefault;
        this.mtime = Instant.EPOCH.plus(mtime, SECONDS).toString();
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
