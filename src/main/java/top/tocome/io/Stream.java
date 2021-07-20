package top.tocome.io;

import java.io.InputStream;
import java.io.OutputStream;

public class Stream {

    public static String read(InputStream inputStream) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                int t = inputStream.read();
                if (t == -1) {
                    break;
                } else {
                    stringBuilder.append(t);
                }
            }
            inputStream.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean write(OutputStream outputStream, byte[] contents) {
        try {
            outputStream.write(contents);
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
