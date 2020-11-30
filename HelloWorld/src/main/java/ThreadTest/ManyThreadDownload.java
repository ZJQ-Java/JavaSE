package ThreadTest;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ManyThreadDownload {
    public DownLoadThread[] threads = new DownLoadThread[5];
    public long             fileLength;

    public void downLoad(String path, String toPath) throws IOException {
        File file = new File(path);
        //总长度
        fileLength = file.length();

        //分块
        Long partCount =
                fileLength % threads.length == 0 ? fileLength / threads.length : fileLength / threads.length + 1;
        for (int i = 0; i < threads.length; i++) {
            int start = partCount.intValue() * i;
            RandomAccessFile toFile = new RandomAccessFile(toPath, "rw");
            FileInputStream fileInputStream = new FileInputStream(file);

            toFile.seek(partCount * i);
            fileInputStream.skip(partCount * i);

            threads[i] = new DownLoadThread(partCount.intValue(), start, fileInputStream, toFile);
            threads[i].start();
        }
    }

    public double getDownRate() {
        int i = 0;
        for (DownLoadThread thread : threads) {
            i += thread.readLength;
        }
        BigDecimal bigDecimal = new BigDecimal(i * 1.0 / fileLength).setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ManyThreadDownload t = new ManyThreadDownload();
        String path = "D:\\迅雷下载\\ideaIU-2019.2.3.exe";
        String toPath = "D:\\tmp1\\ideaIU-2019.2.3.exe";
        t.downLoad(path, toPath);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (t.getDownRate() < 1) {
                    System.out.println(t.getDownRate());
                    try {
                        Thread.sleep(200); // 200毫秒扫描一次
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }
}

class DownLoadThread extends Thread {
    public int              length;
    public int              startLocation;
    public InputStream      readFile;
    public RandomAccessFile writeFile;
    public int              readLength = 0;

    public DownLoadThread(int length, int startLocation, InputStream file, RandomAccessFile writeFile) {
        this.length = length;
        this.startLocation = startLocation;
        this.readFile = file;
        this.writeFile = writeFile;

    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            int hasRead = 0;
            while (readLength < length && (hasRead = readFile.read(buf)) != -1) {
                writeFile.write(buf, 0, hasRead);
                readLength += hasRead;
            }
            readFile.close();
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

