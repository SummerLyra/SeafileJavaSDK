package seafilewebapi;

import seafilewebapi.accountobjects.*;
import seafilewebapi.directoryobjects.*;
import seafilewebapi.fileobjects.*;
import seafilewebapi.libraryobjects.*;
import seafilewebapi.starredfileobjects.*;

import java.io.File;
import java.util.List;

/**
 * @author freezingrainyu
 * @version 1.2
 * @date 2019/04/16
 */
public interface SeafileWebApi {

    /* module Ping */

    /**
     * ping
     * TESTED
     *
     * @return "pong"
     */
    String ping();

    /**
     * obtain the token of a specified account
     * TESTED
     *
     * @param username username whose token will be obtained
     * @param password password of the account
     * @return token of specified user
     */
    String obtainAuthToken(String username, String password);

    /**
     * ping with a valid token
     * TESTED
     *
     * @param token token
     * @return "pong"
     */
    String authPing(String token);

    /* module Account */

    /**
     * obtain a list of all usernames
     * ADMIN ONLY
     * TESTED
     *
     * @param token token of admin
     * @return list of ListedAccountInfo objects with usernames in
     */
    List<ListedAccountInfo> listAccounts(String token);

    /**
     * get the info of a specified account
     * ADMIN ONLY
     * TESTED
     *
     * @param token    token of admin
     * @param username username whose info will be getted
     * @return GettedAccountInfo object with info in
     */
    GettedAccountInfo getAccountInfo(String token, String username);

    /**
     * create a new account
     * ADMIN ONLY
     * TESTED
     *
     * @param token    token of admin
     * @param username username of new account
     * @param password password of new account
     * @return create successfully or not
     */
    boolean createAccount(String token, String username, String password);

    /**
     * migrate all libraries of one account to another one
     * ADMIN ONLY
     * TESTED
     *
     * @param token    token of admin
     * @param fromUser username whose libraries will be migrated
     * @param toUser   username of account where libraries will be placed
     * @return migrate successfully or not
     */
    boolean migrateAccount(String token, String fromUser, String toUser);

    /**
     * delete an existed account
     * ADMIN ONLY
     * TESTED
     *
     * @param token    token of admin
     * @param username username whose account will be deleted
     * @return delete successfully or not
     */
    boolean deleteAccount(String token, String username);

    /**
     * check the info of a specified account
     * TESTED
     *
     * @param token token of current account
     * @return CheckedAccountInfo object with info in
     */
    CheckedAccountInfo checkAccountInfo(String token);

    /**
     * get the info of the server
     * TESTED
     *
     * @return ServerInfo object with info in
     */
    ServerInfo getServerInfo();

    /* module Starred File */

    /**
     * obtain a list of all starred files
     * TESTED
     *
     * @param token token of current account
     * @return list of StarredFileInfo objects with info in
     */
    List<StarredFileInfo> listStarredFiles(String token);

    /**
     * star a specified file
     * TESTED
     *
     * @param token  token of current account
     * @param repoId library id which includes the file to be starred
     * @param path   file path
     * @return star successfully or not
     */
    boolean starFile(String token, String repoId, String path);

    /**
     * unstar a starred file
     * TESTED
     *
     * @param token  token of current account
     * @param repoId library id which includes the file to be unstarred
     * @param path   file path
     * @return unstar successfully or not
     */
    boolean unStarFile(String token, String repoId, String path);

    /* module Library */

    /**
     * get the info of default library
     * TESTED
     *
     * @param token token of current account
     * @return DefaultLibraryInfo object with info in
     */
    DefaultLibraryInfo getDefaultLibrary(String token);

    /**
     * create a default library
     * TESTED
     *
     * @param token token of current account
     * @return DefaultLibraryInfo object with info in
     */
    DefaultLibraryInfo createDefaultLibrary(String token);

    /**
     * obtain a list of all libraries
     * TESTED
     *
     * @param token token of current account
     * @return list of ListedLibraryInfo objects with info in
     */
    List<ListedLibraryInfo> listLibraries(String token);

    /**
     * get the info of a specified library
     * TESTED
     *
     * @param token  token of current account
     * @param repoId library id whose info will be getted
     * @return GettedLibraryInfo object with info in
     */
    GettedLibraryInfo getLibraryInfo(String token, String repoId);

    /**
     * get owner username of a specified library
     * TESTED
     *
     * @param token  token of current account
     * @param repoId library id whose owner username will be getted
     * @return owner username of library
     */
    String getLibraryOwner(String token, String repoId);

    /**
     * get the commit history of a specified library
     * TESTED
     *
     * @param token  token of current account
     * @param repoId library id whose commit history will be getted
     * @return LibraryHistory object with commit history in
     */
    LibraryHistory getLibraryHistory(String token, String repoId);

    /**
     * create a new library
     * TESTED
     *
     * @param token token of current account
     * @param name  name of new library
     * @return CreatedLibraryInfo object with info in
     */
    CreatedLibraryInfo createLibrary(String token, String name);

    /**
     * create a new encrypted library
     * TESTED
     *
     * @param token    token of current account
     * @param name     name of new library
     * @param password password of new library
     * @return CreatedLibraryInfo object with info in
     */
    CreatedLibraryInfo createEncryptedLibrary(String token, String name, String password);

    /**
     * delete an existed library
     * TESTED
     *
     * @param token  token of current account
     * @param repoId library id which will be deleted
     * @return delete successfully or not
     */
    boolean deleteLibrary(String token, String repoId);

    /**
     * rename an existed library
     * TESTED
     *
     * @param token   token of current account
     * @param repoId  library id which will be renamed
     * @param newname new name of the library
     * @return rename successfully or not
     */
    boolean renameLibrary(String token, String repoId, String newname);

    /**
     * decrypt an encrypted library
     * TESTED
     *
     * @param token    token of current account
     * @param repoId   library id which will be decrypted
     * @param password password of the library
     * @return decrypt successfully or not
     */
    boolean decryptLibrary(String token, String repoId, String password);

    /**
     * fetch download info of a specified library
     * TESTED
     *
     * @param token  token of current user
     * @param repoId library id whose download info will be fetched
     * @return FetchedLibraryDownloadInfo object with info in
     */
    FetchedLibraryDownloadInfo fetchLibraryDownloadInfo(String token, String repoId);

    /* module File */

    /**
     * fetch a Office Web Apps (OWA) view link of a specified Microsoft Office file
     * TO BE TESTED
     * PRO EDITION ONLY
     *
     * @param token  token of current user
     * @param repoId library id where the file will be viewed in
     * @param path   file path which will be viewed
     * @return ViewInfo object with info in
     */
    ViewInfo viewFile(String token, String repoId, String path);

    /**
     * fetch a download link of a specified file
     * TESTED
     *
     * @param token  token of current user
     * @param repoId library id where the file will be downloaded in
     * @param path   file path which will be downloaded
     * @return download link of file
     */
    String downloadFile(String token, String repoId, String path);

    /**
     * get the detail of a specified file
     * TESTED
     *
     * @param token  token of current user
     * @param repoId library id where the file whose details will be getted in
     * @param path   file path whose details will be getted
     * @return FileDetail object with details in
     */
    FileDetail getFileDetail(String token, String repoId, String path);

    /**
     * get the commit history of a specified file
     * TESTED
     *
     * @param token  token of current user
     * @param repoId library id where the file whose commit history will be getted in
     * @param path   file path whose commit history will be getted
     * @return list of FileHistory objects with commit history in
     */
    List<FileHistory> getFileHistory(String token, String repoId, String path);

    /**
     * fetch a download link of a specified file from a revision
     * TESTED
     *
     * @param token    token of current user
     * @param repoId   library id where the file will be downloaded in
     * @param path     file path which will be downloaded
     * @param commitId commit id of the revision
     * @return download link of file
     */
    String downloadFileFromRevision(String token, String repoId, String path, String commitId);

    /**
     * create a new file
     * TESTED
     *
     * @param token  token of current account
     * @param repoId library id where the new file will be placed in
     * @param path   path and filename of the new file
     * @return create successfully or not
     */
    boolean createFile(String token, String repoId, String path);

    /**
     * rename an existed file
     * TESTED
     *
     * @param token   token of current account
     * @param repoId  library id where the file will be renamed in
     * @param path    file path which will be renamed
     * @param newname new name of the file
     * @return rename successfully or not
     */
    boolean renameFile(String token, String repoId, String path, String newname);

    /**
     * lock a specified file
     * TO BE TESTED
     * PRO EDITION ONLY
     *
     * @param token  token of current account
     * @param repoId library id where the file will be locked in
     * @param path   file path which will be locked
     * @return lock successfully or not
     */
    boolean lockFile(String token, String repoId, String path);

    /**
     * unlock a locked file
     * TO BE TESTED
     * PRO EDITION ONLY
     *
     * @param token  token of current account
     * @param repoId library id where the file will be unlocked in
     * @param path   file path which will be unlocked
     * @return unlock successfully or not
     */
    boolean unLockFile(String token, String repoId, String path);

    /**
     * move a specified file
     * TESTED
     *
     * @param token   token of current account
     * @param repoId  library id where the file will be move in
     * @param path    file path which will be moved
     * @param dstRepo library id where the file will be moved to
     * @param dstDir  file path where will be moved to
     * @return move successfully or not
     */
    boolean moveFile(String token, String repoId, String path, String dstRepo, String dstDir);

    /**
     * copy a specified file
     * TESTED
     *
     * @param token    token of current account
     * @param repoId   library id where the file will be copied in
     * @param path     file path which will be copied
     * @param filename filename which will be copied
     * @param dstRepo  library id where the file will be copied to
     * @param dstDir   file path where will be copied to
     * @return copy successfully or not
     */
    boolean copyFile(String token, String repoId, String path, String filename, String dstRepo, String dstDir);

    /**
     * revert a specified file
     * TESTED
     *
     * @param token    token of current account
     * @param repoId   library id where the file will be reverted in
     * @param path     file path which will be reverted
     * @param commitId commit id of the revision
     * @return revert successfully or not
     */
    boolean revertFile(String token, String repoId, String path, String commitId);

    boolean deleteFile(String token, String repoId, String path);

    String getUploadLink(String token, String repoId, String path, int replace);

    boolean uploadFile(String token, String uploadLink, String parentDir, File... files);

    String getUpdateLink(String token, String repoId, String path);

    boolean updateFile(String token, String updateLink, String targetFile, File file);

    /* module Directory */

    List<DirectoryEntry> listDirectoryEntries(String token, String repoId, String path);

    boolean createNewDirectory(String token, String repoId, String path);

    boolean renameDirectory(String token, String repoId, String path, String newname);

    boolean deleteDirectory(String token, String repoId, String path);

    String downloadDirectory(String token, String repoId, String path);

    /* module Multiple Files or Directories */

    boolean multiCopy(String token, String path, String dstRepo, String dstDir, String... fileNames);

    boolean multiMove(String token, String path, String dstRepo, String dstDir, String... fileNames);

    boolean multiDelete(String token, String path, String... fileNames);

    /* module Avatar */

    String getUserAvatar(String token, String username, String size);

    /* module File Activity */

    List<FileActivity> getFileActivities(String token);
}
