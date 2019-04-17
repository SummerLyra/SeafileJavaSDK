package seafilewebapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author freezingrainyu
 * @version 1.0
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
    public List<String> listAccounts(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(SERVICE_URL + "/api2/accounts/")
                .header("Authorization", "Token " + token)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                List<String> listedAccounts = new ArrayList<>();
                JSONArray jsonArray = JSON.parseArray(response.body().string());
                for (Object object : jsonArray) {
                    JSONObject jsonObject = (JSONObject) object;
                    listedAccounts.add(jsonObject.getString("email"));
                }
                return listedAccounts;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AccountInfo getAccountInfo(String token) {
        return null;
    }

    @Override
    public boolean createAccount(String token, String username, String password) {
        return false;
    }

    @Override
    public boolean updateAccount(String token) {
        return false;
    }

    @Override
    public boolean migrateAccount(String token, String fromUser, String toUser) {
        return false;
    }

    @Override
    public boolean deleteAccount(String token, String username) {
        return false;
    }

    @Override
    public boolean force2FactorAuth(String token, String username, int force) {
        return false;
    }

    @Override
    public AccountInfo checkAccountInfo(String token) {
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
                JSONObject jsonObject = JSON.parseObject(response.body().string());
                String usage = jsonObject.getString("usage");
                String total = jsonObject.getString("total");
                String email = jsonObject.getString("email");
                return new AccountInfo(usage, total, email);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ServerInfo getServerInfo() {
        return null;
    }

    @Override
    public List<StarredFileInfo> listStarredFiles(String token) {
        return null;
    }

    @Override
    public boolean starFile(String token, String repoId) {
        return false;
    }

    @Override
    public boolean unStarFile(String token, String repoId) {
        return false;
    }

    @Override
    public String getDefaultLibrary(String token) {
        return null;
    }

    @Override
    public String createDefaultLibrary(String token) {
        return null;
    }

    @Override
    public List<LibraryInfo> listLibraries(String token) {
        return null;
    }

    @Override
    public LibraryInfo getLibraryInfo(String token, String repoId) {
        return null;
    }

    @Override
    public String getLibraryOwner(String token, String repoId) {
        return null;
    }

    @Override
    public List<LibraryHistory> getLibraryHistory(String token, String repoId) {
        return null;
    }

    @Override
    public LibraryInfo createLibrary(String token, String name, String desc, String password) {
        return null;
    }

    @Override
    public boolean deleteLibrary(String token, String repoId) {
        return false;
    }

    @Override
    public boolean renameLibrary(String token, String repoId, String newName) {
        return false;
    }

    @Override
    public boolean createPublicLibrary(String token, String repoId) {
        return false;
    }

    @Override
    public boolean removePublicLibrary(String token, String repoId) {
        return false;
    }

    @Override
    public LibraryDownloadInfo fetchLibraryDownloadInfo(String token, String repoId) {
        return null;
    }

    @Override
    public List<LibraryInfo> searchLibraries(String token, String keyword) {
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
