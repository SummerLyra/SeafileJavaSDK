package seafilewebapi;

import okhttp3.OkHttpClient;
import seafilewebapi.accountobjects.*;
import seafilewebapi.directoryobjects.*;
import seafilewebapi.fileobjects.*;
import seafilewebapi.libraryobjects.*;
import seafilewebapi.starredfileobjects.*;

import java.io.File;
import java.util.List;

/**
 * @author freezingrainyu
 * @version 1.3
 * @date 2019/04/16
 */
public interface SeafileWebApi {

    /* module Ping */

    /**
     * ping
     * TESTED
     *
     * @param client OkHttpClient object
     * @return "pong"
     */
    String ping(OkHttpClient client);

    /**
     * obtain the token of a specified account
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param username username whose token will be obtained
     * @param password password of the account
     * @return token of specified user
     */
    String obtainAuthToken(OkHttpClient client, String username, String password);

    /**
     * ping with a valid token
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token
     * @return "pong"
     */
    String authPing(OkHttpClient client, String token);

    /* module Account */

    /**
     * obtain a list of all usernames
     * ADMIN ONLY
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of admin
     * @return list of ListedAccountInfo objects with usernames in
     */
    List<ListedAccountInfo> listAccounts(OkHttpClient client, String token);

    /**
     * get the info of a specified account
     * ADMIN ONLY
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param token    token of admin
     * @param username username whose info will be getted
     * @return GettedAccountInfo object with info in
     */
    GettedAccountInfo getAccountInfo(OkHttpClient client, String token, String username);

    /**
     * create a new account
     * ADMIN ONLY
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param token    token of admin
     * @param username username of new account
     * @param password password of new account
     * @return create successfully or not
     */
    boolean createAccount(OkHttpClient client, String token, String username, String password);

    /**
     * migrate all libraries of one account to another one
     * ADMIN ONLY
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param token    token of admin
     * @param fromUser username whose libraries will be migrated
     * @param toUser   username of account where libraries will be placed
     * @return migrate successfully or not
     */
    boolean migrateAccount(OkHttpClient client, String token, String fromUser, String toUser);

    /**
     * delete an existed account
     * ADMIN ONLY
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param token    token of admin
     * @param username username whose account will be deleted
     * @return delete successfully or not
     */
    boolean deleteAccount(OkHttpClient client, String token, String username);

    /**
     * check the info of a specified account
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @return CheckedAccountInfo object with info in
     */
    CheckedAccountInfo checkAccountInfo(OkHttpClient client, String token);

    /**
     * get the info of the server
     * TESTED
     *
     * @param client OkHttpClient object
     * @return ServerInfo object with info in
     */
    ServerInfo getServerInfo(OkHttpClient client);

    /* module Starred File */

    /**
     * obtain a list of all starred files
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @return list of StarredFileInfo objects with info in
     */
    List<StarredFileInfo> listStarredFiles(OkHttpClient client, String token);

    /**
     * star a specified file
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id which includes the file to be starred
     * @param path   file path
     * @return star successfully or not
     */
    boolean starFile(OkHttpClient client, String token, String repoId, String path);

    /**
     * unstar a starred file
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id which includes the file to be unstarred
     * @param path   file path
     * @return unstar successfully or not
     */
    boolean unStarFile(OkHttpClient client, String token, String repoId, String path);

    /* module Library */

    /**
     * get the info of default library
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @return DefaultLibraryInfo object with info in
     */
    DefaultLibraryInfo getDefaultLibrary(OkHttpClient client, String token);

    /**
     * create a default library
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @return DefaultLibraryInfo object with info in
     */
    DefaultLibraryInfo createDefaultLibrary(OkHttpClient client, String token);

    /**
     * obtain a list of all libraries
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @return list of ListedLibraryInfo objects with info in
     */
    List<ListedLibraryInfo> listLibraries(OkHttpClient client, String token);

    /**
     * get the info of a specified library
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id whose info will be getted
     * @return GettedLibraryInfo object with info in
     */
    GettedLibraryInfo getLibraryInfo(OkHttpClient client, String token, String repoId);

    /**
     * get owner username of a specified library
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id whose owner username will be getted
     * @return owner username of library
     */
    String getLibraryOwner(OkHttpClient client, String token, String repoId);

    /**
     * get the commit history of a specified library
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id whose commit history will be getted
     * @return LibraryHistory object with commit history in
     */
    LibraryHistory getLibraryHistory(OkHttpClient client, String token, String repoId);

    /**
     * create a new library
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param name   name of new library
     * @return CreatedLibraryInfo object with info in
     */
    CreatedLibraryInfo createLibrary(OkHttpClient client, String token, String name);

    /**
     * create a new encrypted library
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param token    token of current account
     * @param name     name of new library
     * @param password password of new library
     * @return CreatedLibraryInfo object with info in
     */
    CreatedLibraryInfo createEncryptedLibrary(OkHttpClient client, String token, String name, String password);

    /**
     * delete an existed library
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id which will be deleted
     * @return delete successfully or not
     */
    boolean deleteLibrary(OkHttpClient client, String token, String repoId);

    /**
     * rename an existed library
     * TESTED
     *
     * @param client  OkHttpClient object
     * @param token   token of current account
     * @param repoId  library id which will be renamed
     * @param newname new name of the library
     * @return rename successfully or not
     */
    boolean renameLibrary(OkHttpClient client, String token, String repoId, String newname);

    /**
     * decrypt an encrypted library
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param token    token of current account
     * @param repoId   library id which will be decrypted
     * @param password password of the library
     * @return decrypt successfully or not
     */
    boolean decryptLibrary(OkHttpClient client, String token, String repoId, String password);

    /**
     * fetch download info of a specified library
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current user
     * @param repoId library id whose download info will be fetched
     * @return FetchedLibraryDownloadInfo object with info in
     */
    FetchedLibraryDownloadInfo fetchLibraryDownloadInfo(OkHttpClient client, String token, String repoId);

    /* module File */

    /**
     * fetch a Office Web Apps (OWA) view link of a specified Microsoft Office file
     * TO BE TESTED
     * PRO EDITION ONLY
     *
     * @param client OkHttpClient object
     * @param token  token of current user
     * @param repoId library id where the file will be viewed in
     * @param path   file path which will be viewed
     * @return ViewInfo object with info in
     */
    ViewInfo viewFile(OkHttpClient client, String token, String repoId, String path);

    /**
     * fetch a download link of a specified file
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current user
     * @param repoId library id where the file will be downloaded in
     * @param path   file path which will be downloaded
     * @return download link of file
     */
    String downloadFile(OkHttpClient client, String token, String repoId, String path);

    /**
     * get the detail of a specified file
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current user
     * @param repoId library id where the file whose details will be getted in
     * @param path   file path whose details will be getted
     * @return FileDetail object with details in
     */
    FileDetail getFileDetail(OkHttpClient client, String token, String repoId, String path);

    /**
     * get the commit history of a specified file
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current user
     * @param repoId library id where the file whose commit history will be getted in
     * @param path   file path whose commit history will be getted
     * @return list of FileHistory objects with commit history in
     */
    List<FileHistory> getFileHistory(OkHttpClient client, String token, String repoId, String path);

    /**
     * fetch a download link of a specified file from a revision
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param token    token of current user
     * @param repoId   library id where the file will be downloaded in
     * @param path     file path which will be downloaded
     * @param commitId commit id of the revision
     * @return download link of file
     */
    String downloadFileFromRevision(OkHttpClient client, String token, String repoId, String path, String commitId);

    /**
     * create a new file
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id where the new file will be placed in
     * @param path   path and filename of the new file
     * @return create successfully or not
     */
    boolean createFile(OkHttpClient client, String token, String repoId, String path);

    /**
     * rename an existed file
     * TESTED
     *
     * @param client  OkHttpClient object
     * @param token   token of current account
     * @param repoId  library id where the file will be renamed in
     * @param path    file path which will be renamed
     * @param newname new name of the file
     * @return rename successfully or not
     */
    boolean renameFile(OkHttpClient client, String token, String repoId, String path, String newname);

    /**
     * lock a specified file
     * TO BE TESTED
     * PRO EDITION ONLY
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id where the file will be locked in
     * @param path   file path which will be locked
     * @return lock successfully or not
     */
    boolean lockFile(OkHttpClient client, String token, String repoId, String path);

    /**
     * unlock a locked file
     * TO BE TESTED
     * PRO EDITION ONLY
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id where the file will be unlocked in
     * @param path   file path which will be unlocked
     * @return unlock successfully or not
     */
    boolean unLockFile(OkHttpClient client, String token, String repoId, String path);

    /**
     * move a specified file
     * TESTED
     *
     * @param client  OkHttpClient object
     * @param token   token of current account
     * @param repoId  library id where the file will be move in
     * @param path    file path which will be moved
     * @param dstRepo library id where the file will be moved to
     * @param dstDir  file path where will be moved to
     * @return move successfully or not
     */
    boolean moveFile(OkHttpClient client, String token, String repoId, String path, String dstRepo, String dstDir);

    /**
     * copy a specified file
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param token    token of current account
     * @param repoId   library id where the file will be copied in
     * @param path     file path which will be copied
     * @param filename filename which will be copied
     * @param dstRepo  library id where the file will be copied to
     * @param dstDir   file path where will be copied to
     * @return copy successfully or not
     */
    boolean copyFile(OkHttpClient client, String token, String repoId, String path, String filename, String dstRepo, String dstDir);

    /**
     * revert a specified file
     * TESTED
     *
     * @param client   OkHttpClient object
     * @param token    token of current account
     * @param repoId   library id where the file will be reverted in
     * @param path     file path which will be reverted
     * @param commitId commit id of the revision
     * @return revert successfully or not
     */
    boolean revertFile(OkHttpClient client, String token, String repoId, String path, String commitId);

    /**
     * delete an existed file
     * TESTED
     *
     * @param client OkHttpClient object
     * @param token  token of current account
     * @param repoId library id where the file will be deleted in
     * @param path   file path which will be deleted
     * @return delete successfully or not
     */
    boolean deleteFile(OkHttpClient client, String token, String repoId, String path);

    String getUploadLink(OkHttpClient client, String token, String repoId, String path, int replace);

    boolean uploadFile(OkHttpClient client, String token, String uploadLink, String parentDir, File files);

    String getUpdateLink(OkHttpClient client, String token, String repoId, String path);

    boolean updateFile(OkHttpClient client, String token, String updateLink, String targetFile, File file);

    /* module Directory */

    List<DirectoryEntry> listDirectoryEntries(OkHttpClient client, String token, String repoId, String path);

    boolean createNewDirectory(OkHttpClient client, String token, String repoId, String path);

    boolean renameDirectory(OkHttpClient client, String token, String repoId, String path, String newname);

    boolean deleteDirectory(OkHttpClient client, String token, String repoId, String path);

    String downloadDirectory(OkHttpClient client, String token, String repoId, String path);

    /* module Multiple Files or Directories */

    boolean multiCopy(OkHttpClient client, String token, String path, String dstRepo, String dstDir, String... fileNames);

    boolean multiMove(OkHttpClient client, String token, String path, String dstRepo, String dstDir, String... fileNames);

    boolean multiDelete(OkHttpClient client, String token, String path, String... fileNames);

    /* module Avatar */

    String getUserAvatar(OkHttpClient client, String token, String username, String size);

    /* module File Activity */

    List<FileActivity> getFileActivities(OkHttpClient client, String token);
}
