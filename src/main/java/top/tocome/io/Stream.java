package top.tocome.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Stream {

    public static int byteBufferSize = 1024;

    public static String read(InputStream inputStream) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            byte[] b = new byte[byteBufferSize];
            int t;
            while (true) {
                t = inputStream.read(b);
                if (t == -1) {
                    break;
                } else {
                    stringBuilder.append(new String(b));
                }
            }
            inputStream.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readLine() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            return bufferedReader.readLine();
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

    public static boolean copy(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] b = new byte[byteBufferSize];
            int t;
            while (true) {
                t = inputStream.read(b);
                if (t == -1) {
                    break;
                } else {
                    outputStream.write(b, 0, t);
                }
            }
            inputStream.close();
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
