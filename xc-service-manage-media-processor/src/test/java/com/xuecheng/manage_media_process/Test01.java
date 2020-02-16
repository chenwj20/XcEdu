package com.xuecheng.manage_media_process;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test01 {
    @Test
    public void testProcessBuilder() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("ping","127.0.0.1");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        InputStream inputStream = process.getInputStream();
        int len = -1;
        byte[] b = new byte[1024];
        while ((len = inputStream.read(b))!=-1){
            System.out.println(new String(b,"GBK"));
        }
        inputStream.close();
    }
}
