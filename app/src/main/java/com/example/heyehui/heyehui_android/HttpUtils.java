package com.example.heyehui.heyehui_android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {
    public static byte[] load(String path) {
        InputStream is = null;
        byte[] data = null;
        try {
            //封装一个URL对象
            URL url = new URL(path);
            //获取客户端与服务端的链接对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");

            connection.setDoInput(true);
            //发送链接网络请求
            connection.connect();
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = is.read(b)) != -1) {
                baos.write(b, 0, n);
            }
            data = baos.toByteArray();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
