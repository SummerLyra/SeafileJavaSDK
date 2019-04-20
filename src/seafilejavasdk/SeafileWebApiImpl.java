package seafilejavasdk;

import seafilejavasdk.accountobjects.*;
import seafilejavasdk.avatarobjects.*;
import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.util.List;

import seafilejavasdk.directoryobjects.*;
import seafilejavasdk.fileobjects.*;
import seafilejavasdk.libraryobjects.*;
import okhttp3.*;
import seafilejavasdk.starredfileobjects.*;

/**
 * @author freezingrainyu
 * @version 1.5
 * @date 2019/04/16
 */
public class SeafileWebApiImpl implements SeafileWebApi {

    private final String SERVICE_URL;
    private final String FILE_SERVER_ROOT;

    public SeafileWebApiImpl(String serviceUrl, String fileServerRoot) {
        SERVICE_URL = serviceUrl;
        FILE_SERVER_ROOT = fileServerRoot;
    }

    private boolean parseBooleanResponse(OkHttpClient client, Request request) {
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return true;
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String parseStringResponse(OkHttpClient client, Request request) {
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String parsePartStringResponse(OkHttpClient client, Request request, String key) {
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string()).getString(key);
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private <T> T parseObjectResponse(OkHttpClient client, Request request, Class<T> clazz) {
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), clazz);
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private <T> List<T> parseArrayResponse(OkHttpClient client, Request request, Class<T> clazz) {
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseArray(response.body().string(), clazz);
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private <T> List<T> parsePartArrayResponse(OkHttpClient client, Request request, Class<T> clazz, String key) {
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseArray(JSON.parseObject(response.body().string()).getString(key), clazz);
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String linkFilenames(String... filenames) {
        StringBuffer linkingFilenames = new StringBuffer();
        for (String f : filenames) {
            linkingFilenames.append(f).append(":");
        }
        return linkingFilenames.delete(linkingFilenames.length() - 1, linkingFilenames.length()).toString();
    }

    @Override
    public String ping(OkHttpClient client) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/ping/")
                .get()
                .build();
        return parseStringResponse(client, request);
    }

    @Override
    public String obtainAuthToken(OkHttpClient client, String username, String password) {
        RequestBody requestBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/auth-token/")
                .post(requestBody)
                .build();
        return parsePartStringResponse(client, request, "token");
    }

    @Override
    public String authPing(OkHttpClient client, String token) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/auth/ping/")
                .header("Authorization", "Token " + token)
                .get()
                .build();
        return parseStringResponse(client, request);
    }

    @Override
    public List<ListedAccountInfo> listAccounts(OkHttpClient client, String token) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/accounts/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parseArrayResponse(client, request, ListedAccountInfo.class);
    }

    @Override
    public GettedAccountInfo getAccountInfo(OkHttpClient client, String token, String username) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/accounts/" + username + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parseObjectResponse(client, request, GettedAccountInfo.class);
    }

    @Override
    public boolean createAccount(OkHttpClient client, String token, String username, String password) {
        RequestBody requestBody = new FormBody.Builder()
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/accounts/" + username + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .put(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean migrateAccount(OkHttpClient client, String token, String fromUser, String toUser) {
        RequestBody requestBody = new FormBody.Builder()
                .add("op", "migrate")
                .add("to_user", toUser)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/accounts/" + fromUser + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean deleteAccount(OkHttpClient client, String token, String username) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/accounts/" + username + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .delete()
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public CheckedAccountInfo checkAccountInfo(OkHttpClient client, String token) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/account/info/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parseObjectResponse(client, request, CheckedAccountInfo.class);
    }

    @Override
    public ServerInfo getServerInfo(OkHttpClient client) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/server-info/")
                .get()
                .build();
        return parseObjectResponse(client, request, ServerInfo.class);
    }

    @Override
    public List<StarredFileInfo> listStarredFiles(OkHttpClient client, String token) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/starredfiles/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parseArrayResponse(client, request, StarredFileInfo.class);
    }

    @Override
    public boolean starFile(OkHttpClient client, String token, String repoId, String path) {
        RequestBody requestBody = new FormBody.Builder()
                .add("repo_id", repoId)
                .add("p", path)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/starredfiles/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean unStarFile(OkHttpClient client, String token, String repoId, String path) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/starredfiles/?repo_id=" + repoId + "&p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .delete()
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public DefaultLibraryInfo getDefaultLibrary(OkHttpClient client, String token) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/default-repo/")
                .header("Authorization", "Token " + token)
                .get()
                .build();
        return parseObjectResponse(client, request, DefaultLibraryInfo.class);
    }

    @Override
    public DefaultLibraryInfo createDefaultLibrary(OkHttpClient client, String token) {
        RequestBody requestBody = new FormBody.Builder()
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/default-repo/")
                .header("Authorization", "Token " + token)
                .post(requestBody)
                .build();
        return parseObjectResponse(client, request, DefaultLibraryInfo.class);
    }

    @Override
    public List<ListedLibraryInfo> listLibraries(OkHttpClient client, String token) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parseArrayResponse(client, request, ListedLibraryInfo.class);
    }

    @Override
    public GettedLibraryInfo getLibraryInfo(OkHttpClient client, String token, String repoId) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parseObjectResponse(client, request, GettedLibraryInfo.class);
    }

    @Override
    public String getLibraryOwner(OkHttpClient client, String token, String repoId) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/owner/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parsePartStringResponse(client, request, "owner");
    }

    @Override
    public List<LibraryHistory> getLibraryHistory(OkHttpClient client, String token, String repoId) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/history/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parsePartArrayResponse(client, request, LibraryHistory.class, "commits");
    }

    @Override
    public CreatedLibraryInfo createLibrary(OkHttpClient client, String token, String name) {
        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseObjectResponse(client, request, CreatedLibraryInfo.class);
    }

    @Override
    public CreatedLibraryInfo createEncryptedLibrary(OkHttpClient client, String token, String name, String password) {
        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("passwd", password)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseObjectResponse(client, request, CreatedLibraryInfo.class);
    }

    @Override
    public boolean deleteLibrary(OkHttpClient client, String token, String repoId) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .delete()
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean renameLibrary(OkHttpClient client, String token, String repoId, String newname) {
        RequestBody requestBody = new FormBody.Builder()
                .add("repo_name", newname)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/?op=rename")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean decryptLibrary(OkHttpClient client, String token, String repoId, String password) {
        RequestBody requestBody = new FormBody.Builder()
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public FetchedLibraryDownloadInfo fetchLibraryDownloadInfo(OkHttpClient client, String token, String repoId) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/download-info/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parseObjectResponse(client, request, FetchedLibraryDownloadInfo.class);
    }

    @Override
    public ViewInfo viewFile(OkHttpClient client, String token, String repoId, String path) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/owa-file/?path=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .get()
                .build();
        return parseObjectResponse(client, request, ViewInfo.class);
    }

    @Override
    public String downloadFile(OkHttpClient client, String token, String repoId, String path) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/?p=" + path + "&reuse=1")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .get()
                .build();
        return parseStringResponse(client, request);
    }

    @Override
    public FileDetail getFileDetail(OkHttpClient client, String token, String repoId, String path) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/detail/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .get()
                .build();
        return parseObjectResponse(client, request, FileDetail.class);
    }

    @Override
    public List<FileHistory> getFileHistory(OkHttpClient client, String token, String repoId, String path) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/history/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .get()
                .build();
        return parsePartArrayResponse(client, request, FileHistory.class, "commits");
    }

    @Override
    public String downloadFileFromRevision(OkHttpClient client, String token, String repoId, String path, String commitId) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/revision/?p=" + path + "&commit_id=" + commitId)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .get()
                .build();
        return parseStringResponse(client, request);
    }

    @Override
    public boolean createFile(OkHttpClient client, String token, String repoId, String path) {
        RequestBody requestBody = new FormBody.Builder()
                .add("operation", "create")
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean renameFile(OkHttpClient client, String token, String repoId, String path, String newname) {
        RequestBody requestBody = new FormBody.Builder()
                .add("operation", "rename")
                .add("newname", newname)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean lockFile(OkHttpClient client, String token, String repoId, String path) {
        RequestBody requestBody = new FormBody.Builder()
                .add("operation", "lock")
                .add("p", path)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .put(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean unLockFile(OkHttpClient client, String token, String repoId, String path) {
        RequestBody requestBody = new FormBody.Builder()
                .add("operation", "unlock")
                .add("p", path)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .put(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean moveFile(OkHttpClient client, String token, String repoId, String path, String dstRepo, String dstDir) {
        RequestBody requestBody = new FormBody.Builder()
                .add("operation", "move")
                .add("dst_repo", dstRepo)
                .add("dst_dir", dstDir)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean copyFile(OkHttpClient client, String token, String repoId, String path, String dstRepo, String dstDir, String filename) {
        RequestBody requestBody = new FormBody.Builder()
                .add("operation", "copy")
                .add("dst_repo", dstRepo)
                .add("dst_dir", dstDir)
                .add("file_names", filename)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean revertFile(OkHttpClient client, String token, String repoId, String path, String commitId) {
        RequestBody requestBody = new FormBody.Builder()
                .add("commit_id", commitId)
                .add("p", path)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/revert/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .put(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean deleteFile(OkHttpClient client, String token, String repoId, String path) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/file/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .delete()
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean uploadFile(OkHttpClient client, String token, String repoId, String parentDir, String replace, File file) {
        Request linkRequest = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/upload-link/?p=" + parentDir)
                .header("Authorization", "Token " + token)
                .get()
                .build();
        String uploadLink = parseStringResponse(client, linkRequest);
        assert uploadLink != null;
        uploadLink = uploadLink.substring(1, uploadLink.length() - 1);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .addFormDataPart("parent_dir", parentDir)
                .addFormDataPart("replace", replace)
                .build();
        Request uploadRequest = new Request.Builder()
                .url(uploadLink)
                .header("Authorization", "Token " + token)
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, uploadRequest);
    }

    @Override
    public boolean updateFile(OkHttpClient client, String token, String repoId, String updateDir, File file) {
        Request linkRequest = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/update-link/?p=" + updateDir)
                .header("Authorization", "Token " + token)
                .get()
                .build();
        String updateLink = parseStringResponse(client, linkRequest);
        assert updateLink != null;
        updateLink = updateLink.substring(1, updateLink.length() - 1);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .addFormDataPart("filenames", file.getName())
                .addFormDataPart("target_file", updateDir + "/" + file.getName())
                .build();
        Request uploadRequest = new Request.Builder()
                .url(updateLink)
                .header("Authorization", "Token " + token)
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, uploadRequest);
    }

    @Override
    public List<DirectoryEntry> listDirectoryEntries(OkHttpClient client, String token, String repoId, String path) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/dir/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        return parseArrayResponse(client, request, DirectoryEntry.class);
    }

    @Override
    public boolean createNewDirectory(OkHttpClient client, String token, String repoId, String path) {
        RequestBody requestBody = new FormBody.Builder()
                .add("operation", "mkdir")
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/dir/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean renameDirectory(OkHttpClient client, String token, String repoId, String path, String newname) {
        RequestBody requestBody = new FormBody.Builder()
                .add("operation", "rename")
                .add("newname", newname)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/dir/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean deleteDirectory(OkHttpClient client, String token, String repoId, String path) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/dir/?p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .delete()
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public String downloadDirectory(OkHttpClient client, String token, String repoId, String parentDir, String dirname) {
        Request zipTokenRequest = new Request.Builder()
                .url(SERVICE_URL + "/api/v2.1/repos/" + repoId + "/zip-task/?parent_dir=" + parentDir + "&dirents=" + dirname)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .get()
                .build();
        String zipToken = parsePartStringResponse(client, zipTokenRequest, "zip_token");
        assert zipToken != null;
        String zipped, total;
        do {
            Request zipRequest = new Request.Builder()
                    .url(SERVICE_URL + "/api/v2.1/query-zip-progress/?token=" + zipToken)
                    .header("Authorization", "Token " + token)
                    .header("Accept", "application/json")
                    .header("charset", "utf-8")
                    .header("indent", "4")
                    .get()
                    .build();
            zipped = parsePartStringResponse(client, zipRequest, "zipped");
            total = parsePartStringResponse(client, zipRequest, "total");
            assert zipped != null;
            assert total != null;
        } while (!zipped.equals(total));
        return FILE_SERVER_ROOT + "/zip/" + zipToken;
    }

    @Override
    public boolean multiCopy(OkHttpClient client, String token, String repoId, String path, String dstRepo, String dstDir, String... filenames) {
        String linkedFilenames = linkFilenames(filenames);
        RequestBody requestBody = new FormBody.Builder()
                .add("dst_repo", dstRepo)
                .add("dst_dir", dstDir)
                .add("file_names", linkedFilenames)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/fileops/copy/?p=" + path)
                .header("Authorization", "Token " + token)
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean multiMove(OkHttpClient client, String token, String repoId, String path, String dstRepo, String dstDir, String... filenames) {
        String linkedFilenames = linkFilenames(filenames);
        RequestBody requestBody = new FormBody.Builder()
                .add("dst_repo", dstRepo)
                .add("dst_dir", dstDir)
                .add("file_names", linkedFilenames)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/fileops/move/?p=" + path)
                .header("Authorization", "Token " + token)
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean multiDelete(OkHttpClient client, String token, String repoId, String path, String... filenames) {
        String linkedFilenames = linkFilenames(filenames);
        RequestBody requestBody = new FormBody.Builder()
                .add("file_names", linkedFilenames)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/fileops/delete/?p=" + path)
                .header("Authorization", "Token " + token)
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, request);
    }

    @Override
    public boolean updateUserAvatar(OkHttpClient client, String token, File avatar) {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("avatar", avatar.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), avatar))
                .build();
        Request uploadRequest = new Request.Builder()
                .url(SERVICE_URL + "/api/v2.1/user-avatar/")
                .header("Authorization", "Token " + token)
                .post(requestBody)
                .build();
        return parseBooleanResponse(client, uploadRequest);
    }

    @Override
    public AvatarInfo getUserAvatar(OkHttpClient client, String token, String username, String size) {
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/avatars/user/" + username + "/resized/" + size + "/")
                .header("Authorization", "Token " + token)
                .get()
                .build();
        return parseObjectResponse(client, request, AvatarInfo.class);
    }
}
