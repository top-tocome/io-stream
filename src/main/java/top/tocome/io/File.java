package top.tocome.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class File {

    public static String read(String filePath) {
        try {
            return Stream.read(new FileInputStream(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean write(String filePath, byte[] contents, boolean append) {
        try {
            return Stream.write(new FileOutputStream(filePath, append), contents);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean copy(String filePath, String savePath,boolean append) {
        try {
            return Stream.copy(new FileInputStream(filePath), new FileOutputStream(savePath, append));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
