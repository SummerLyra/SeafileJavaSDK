package seafilewebapi;

import java.io.File;
import java.util.List;

/**
 * @version 1.0
 * @date 2019/04/16
 */
public interface SeafileWebApi {

    /** Ping */
    String ping();

    String obtainAuthToken(String username, String password);

    String authPing(String token);

    /** Account */
    List<String> listAccounts(String token);

    AccountInfo getAccountInfo(String token);

    boolean createAccount(String token, String username, String password);

    boolean updateAccount(String token);

    boolean migrateAccount(String token, String fromUser, String toUser);

    boolean deleteAccount(String token, String username);

    boolean force2FactorAuth(String token, String username, int force);

    AccountInfo checkAccountInfo(String token);

    ServerInfo getServerInfo();

    /** Starred File */
    List<StarredFileInfo> listStarredFiles(String token);

    boolean starFile(String token, String repoId);

    boolean unStarFile(String token, String repoId);

    /** Library */
    String getDefaultLibrary(String token);

    String createDefaultLibrary(String token);

    List<LibraryInfo> listLibraries(String token);

    LibraryInfo getLibraryInfo(String token, String repoId);

    String getLibraryOwner(String token, String repoId);

    List<LibraryHistory> getLibraryHistory(String token, String repoId);

    LibraryInfo createLibrary(String token, String name, String desc, String password);

    boolean deleteLibrary(String token, String repoId);

    boolean renameLibrary(String token, String repoId, String newName);

    boolean createPublicLibrary(String token, String repoId);

    boolean removePublicLibrary(String token, String repoId);

    LibraryDownloadInfo fetchLibraryDownloadInfo(String token, String repoId);

    List<LibraryInfo> searchLibraries(String token, String keyword);

    /** File */
    ViewInfo viewFile(String token, String repoId, String path);

    String downloadFile(String token, String repoId, String path, int reuse);

    FileInfo getFileDetail(String token, String repoId, String path);

    List<FileHistory> getFileHistory(String token, String repoId, String path);

    String downloadFileFromRevision(String token, String repoId, String path, String commitId);

    boolean createFile(String token, String repoId, String path);

    boolean renameFile(String token, String repoId, String path, String newName);

    boolean lockFile(String token, String repoId, String path);

    boolean unLockFile(String token, String repoId, String path);

    boolean moveFile(String token, String repoId, String path, String dstRepo, String dstDir);

    boolean copyFile(String token, String repoId, String path, String dstRepo, String dstDir);

    boolean revertFile(String token, String repoId, String path, String commitId);

    boolean deleteFile(String token, String repoId, String path);

    String getUploadLink(String token, String repoId, String path, int replace);

    boolean uploadFile(String token, String uploadLink, String parentDir, File... files);

    String getUpdateLink(String token, String repoId, String path);

    boolean updateFile(String token, String updateLink, String targetFile, File file);

    /** Directory */
    List<DirectoryEntry> listDirectoryEntries(String token, String repoId, String path);

    boolean createNewDirectory(String token, String repoId, String path);

    boolean renameDirectory(String token, String repoId, String path, String newName);

    boolean deleteDirectory(String token, String repoId, String path);

    String downloadDirectory(String token, String repoId, String path);

    /** Multiple Files / Directories */
    boolean multiCopy(String token, String path, String dstRepo, String dstDir, String... fileNames);

    boolean multiMove(String token, String path, String dstRepo, String dstDir, String... fileNames);

    boolean multiDelete(String token, String path, String... fileNames);

    /** Avatar */
    String getUserAvatar(String token, String username, String size);

    /** File Activity */
    List<FileActivity> getFileActivities(String token);
}
