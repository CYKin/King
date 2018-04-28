package com.king.test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author King
 * @date 2017/12/5
 */
public class IOTest {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        FileOutputStream fileOutputStream = null;

        try {

            File file1 = new File("D:/file1.txt");
            if (!file1.exists()) {
                System.out.println("要读取的文件不存在！");
                return;
            }

            File file2 = new File("D:/file2.txt");
            if (!file2.exists()) {
                file2.createNewFile();
            }


            fileInputStream = new FileInputStream(file1);

            fileOutputStream = new FileOutputStream(file2);

            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream,"UTF-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream,"UTF-8"));

            String s;

            while ((s = bufferedReader.readLine()) != null) {
                // TODO: 2017/12/11 中文乱码问题                 
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            bufferedReader.close();
            fileOutputStream.close();
            fileInputStream.close();
        }
    }
}
