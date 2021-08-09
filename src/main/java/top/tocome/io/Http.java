package top.tocome.io;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {
    /**
     * 浏览器代理
     */
    public static String agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36";

    /**
     * 获取网络字符串
     *
     * @param url http链接
     * @return 字符串
     */
    public static String get(String url) {
        try {
            return Stream.readString(getInputStream(url, true));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载网络文件
     *
     * @param url      http链接
     * @param filepath 保存文件路径
     * @return 执行结果
     */
    public static boolean download(String url, String filepath) {
        try {
            return Stream.copy(getInputStream(url, true), new FileOutputStream(filepath, false));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static InputStream getInputStream(String url, boolean setAgent) throws Exception {
        return setAgent ? setAgent(url, agent).getInputStream() : new URL(url).openStream();
    }

    private static HttpURLConnection setAgent(String url, String agent) throws Exception {
        URL url1 = new URL(url);
        HttpURLConnection connect = (HttpURLConnection) url1.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("User-Agent", agent);
        return connect;
    }
}
