package top.tocome.io;

import java.io.FileOutputStream;
import java.net.URL;

public class Http {

    public static String get(String url) {
        try {
            return Stream.read(new URL(url).openStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean download(String url, String filepath, boolean append) {
        try {
            return Stream.copy(new URL(url).openStream(), new FileOutputStream(filepath, append));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
