package top.tocome.io;

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

}
