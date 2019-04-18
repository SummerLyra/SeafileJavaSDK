package seafilewebapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import seafilewebapi.accountobjects.*;
import seafilewebapi.directoryobjects.DirectoryEntry;
import seafilewebapi.fileobjects.FileActivity;
import seafilewebapi.fileobjects.FileHistory;
import seafilewebapi.fileobjects.FileInfo;
import seafilewebapi.fileobjects.ViewInfo;
import seafilewebapi.libraryobjects.*;
import seafilewebapi.starredfileobjects.*;

/**
 * @author freezingrainyu
 * @version 1.2
 * @date 2019/04/16
 */
public class SeafileWebApiImpl implements SeafileWebApi {

    private final String SERVICE_URL;
    private final String FILE_SERVER_ROOT;

    public SeafileWebApiImpl(String serviceUrl, String fileServerRoot) {
        SERVICE_URL = serviceUrl;
        FILE_SERVER_ROOT = fileServerRoot;
    }

    @Override
    public String ping() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/ping/")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String obtainAuthToken(String username, String password) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/auth-token/")
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                JSONObject jsonObject = JSON.parseObject(response.body().string());
                return jsonObject.getString("token");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String authPing(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/auth/ping/")
                .header("Authorization", "Token " + token)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ListedAccountInfo> listAccounts(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/accounts/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseArray(response.body().string(), ListedAccountInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GettedAccountInfo getAccountInfo(String token, String username) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/accounts/" + username + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), GettedAccountInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createAccount(String token, String username, String password) {
        OkHttpClient client = new OkHttpClient();
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
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean migrateAccount(String token, String fromUser, String toUser) {
        OkHttpClient client = new OkHttpClient();
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
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAccount(String token, String username) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/accounts/" + username + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .delete()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public CheckedAccountInfo checkAccountInfo(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/account/info/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), CheckedAccountInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ServerInfo getServerInfo() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/server-info/")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), ServerInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<StarredFileInfo> listStarredFiles(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/starredfiles/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseArray(response.body().string(), StarredFileInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** TODO : 500 */
    @Override
    public boolean starFile(String token, String repoId, String path) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("repo_id", "repoId")
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
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean unStarFile(String token, String repoId, String path) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/starredfiles/?repo_id=" + repoId + "&p=" + path)
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("charset", "utf-8")
                .header("indent", "4")
                .delete()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public DefaultLibraryInfo getDefaultLibrary(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/default-repo/")
                .header("Authorization", "Token " + token)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), DefaultLibraryInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DefaultLibraryInfo createDefaultLibrary(String token) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/default-repo/")
                .header("Authorization", "Token " + token)
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), DefaultLibraryInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ListedLibraryInfo> listLibraries(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseArray(response.body().string(), ListedLibraryInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GettedLibraryInfo getLibraryInfo(String token, String repoId) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), GettedLibraryInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getLibraryOwner(String token, String repoId) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/owner/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                JSONObject jsonObject = JSON.parseObject(response.body().string());
                return jsonObject.getString("owner");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LibraryHistory getLibraryHistory(String token, String repoId) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/history/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), LibraryHistory.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CreatedLibraryInfo createLibrary(String token, String name) {
        OkHttpClient client = new OkHttpClient();
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
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), CreatedLibraryInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CreatedLibraryInfo createEncryptedLibrary(String token, String name, String password) {
        OkHttpClient client = new OkHttpClient();
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
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), CreatedLibraryInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteLibrary(String token, String repoId) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .delete()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean renameLibrary(String token, String repoId, String newName) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("repo_name", newName)
                .build();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/?op=rename")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean decryptLibrary(String token, String repoId, String password) {
        OkHttpClient client = new OkHttpClient();
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
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public FetchedLibraryDownloadInfo fetchLibraryDownloadInfo(String token, String repoId) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/repos/" + repoId + "/download-info/")
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                return JSON.parseObject(response.body().string(), FetchedLibraryDownloadInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ViewInfo viewFile(String token, String repoId, String path) {
        return null;
    }

    @Override
    public String downloadFile(String token, String repoId, String path, int reuse) {
        return null;
    }

    @Override
    public FileInfo getFileDetail(String token, String repoId, String path) {
        return null;
    }

    @Override
    public List<FileHistory> getFileHistory(String token, String repoId, String path) {
        return null;
    }

    @Override
    public String downloadFileFromRevision(String token, String repoId, String path, String commitId) {
        return null;
    }

    @Override
    public boolean createFile(String token, String repoId, String path) {
        return false;
    }

    @Override
    public boolean renameFile(String token, String repoId, String path, String newName) {
        return false;
    }

    @Override
    public boolean lockFile(String token, String repoId, String path) {
        return false;
    }

    @Override
    public boolean unLockFile(String token, String repoId, String path) {
        return false;
    }

    @Override
    public boolean moveFile(String token, String repoId, String path, String dstRepo, String dstDir) {
        return false;
    }

    @Override
    public boolean copyFile(String token, String repoId, String path, String dstRepo, String dstDir) {
        return false;
    }

    @Override
    public boolean revertFile(String token, String repoId, String path, String commitId) {
        return false;
    }

    @Override
    public boolean deleteFile(String token, String repoId, String path) {
        return false;
    }

    @Override
    public String getUploadLink(String token, String repoId, String path, int replace) {
        return null;
    }

    @Override
    public boolean uploadFile(String token, String uploadLink, String parentDir, File... files) {
        return false;
    }

    @Override
    public String getUpdateLink(String token, String repoId, String path) {
        return null;
    }

    @Override
    public boolean updateFile(String token, String updateLink, String targetFile, File file) {
        return false;
    }

    @Override
    public List<DirectoryEntry> listDirectoryEntries(String token, String repoId, String path) {
        return null;
    }

    @Override
    public boolean createNewDirectory(String token, String repoId, String path) {
        return false;
    }

    @Override
    public boolean renameDirectory(String token, String repoId, String path, String newName) {
        return false;
    }

    @Override
    public boolean deleteDirectory(String token, String repoId, String path) {
        return false;
    }

    @Override
    public String downloadDirectory(String token, String repoId, String path) {
        return null;
    }

    @Override
    public boolean multiCopy(String token, String path, String dstRepo, String dstDir, String... fileNames) {
        return false;
    }

    @Override
    public boolean multiMove(String token, String path, String dstRepo, String dstDir, String... fileNames) {
        return false;
    }

    @Override
    public boolean multiDelete(String token, String path, String... fileNames) {
        return false;
    }

    @Override
    public String getUserAvatar(String token, String username, String size) {
        return null;
    }

    @Override
    public List<FileActivity> getFileActivities(String token) {
        return null;
    }
}
