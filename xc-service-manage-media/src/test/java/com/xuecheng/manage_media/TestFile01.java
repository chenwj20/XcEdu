package com.xuecheng.manage_media;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Comparator;

public class TestFile01 {
    @Test
    public void testChunk() throws IOException {
        //源文件
        File file = new File("F:\\xuechenglog\\ffmpeg\\lucene.avi");
        //快文件目录
        String chunkFileFolder = "F:\\xuechenglog\\ffmpeg\\chunks\\";
        //定义块文件大小
        long chunkFileSize = 1*1024*1024;
        //块数
        long chunkFileNum = (long)Math.ceil(file.length()*1.0/chunkFileSize);

        //
        RandomAccessFile raf_read = new RandomAccessFile(file,"r");

        //缓存数组
        byte[] b = new byte[1024];
        for (int i = 0; i < chunkFileNum; i++) {
            //块文件
            File chunkFile = new File(chunkFileFolder+i);

            boolean newFile = chunkFile.createNewFile();

            if (newFile){
                RandomAccessFile raf_write = new RandomAccessFile(chunkFile,"rw");
                int len = -1;
                while ((len = raf_read.read(b))!=-1){
                    raf_write.write(b,0,len);
                    if (chunkFile.length()>=chunkFileSize){
                        break;
                    }
                }
                raf_write.close();
            }
        }
        raf_read.close();
    }
    @Test
    public void testHeBin() throws FileNotFoundException {
        File file1 = new File("F:\\xuechenglog\\ffmpeg\\hui\\lucene.avi");
        long chunkFileSize = 1*1024*1024;
        RandomAccessFile randomAccessFile01 = new RandomAccessFile(file1,"rw");
        File file2 = new File("F:\\xuechenglog\\ffmpeg\\chunks\\");
        File[] files = file2.listFiles();

        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Integer.parseInt(o1.getName())- Integer.getInteger(o2.getName());
            }
        });
        System.out.println(Arrays.toString(files));

    }
}
