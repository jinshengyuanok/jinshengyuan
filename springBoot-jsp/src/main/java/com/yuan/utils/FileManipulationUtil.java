package com.yuan.utils;

import com.csvreader.CsvReader;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-08-04
 * Time: 9:18
 * description: 文件处理通用类
 **/
public class FileManipulationUtil {

    public static boolean createDirectory(String dirPath){
        boolean isOk = false;
        File file = new File(dirPath);
        if(!file.isDirectory()){
            isOk = file.mkdir();
        }
        return isOk;
    }
    /**
     * 解压文件到指定目录
     *
     * @param zipFilePath  目标文件
     * @param fileSavePath 解压目录
     * @author isDelete 是否删除目标文件,true:删除,false:不删除
     */
    public static void unZipFiles(String zipFilePath, String fileSavePath, boolean isDelete) throws IOException {
        File f = new File(zipFilePath);
        if ((!f.exists()) && (f.length() <= 0)) {
            throw new RuntimeException("要解压的文件不存在!");
        }
        //一定要加上编码，之前解压另外一个文件，没有加上编码导致不能解压
        ZipFile zipFile = new ZipFile(f, "gbk");
        String strPath, gbkPath, strTemp;
        strPath = fileSavePath;// 输出的绝对位置
        Enumeration<ZipEntry> e = zipFile.getEntries();
        while (e.hasMoreElements()) {
            ZipEntry zipEnt = e.nextElement();
            gbkPath = zipEnt.getName();
            strTemp = strPath + File.separator + gbkPath;
            if (zipEnt.isDirectory()) { //目录
                File dir = new File(strTemp);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                continue;
            } else {
                // 读写文件
                InputStream is = zipFile.getInputStream(zipEnt);
                BufferedInputStream bis = new BufferedInputStream(is);
                // 建目录
                String strSubDir = gbkPath;
                for (int i = 0; i < strSubDir.length(); i++) {
                    if (strSubDir.substring(i, i + 1).equalsIgnoreCase("/")) {
                        String temp = strPath + File.separator
                                + strSubDir.substring(0, i);
                        File subDir = new File(temp);
                        if (!subDir.exists())
                            subDir.mkdir();
                    }
                }
                FileOutputStream fos = new FileOutputStream(strTemp);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                int len;
                byte[] buff = new byte[1024];
                while ((len = bis.read(buff)) != -1) {
                    bos.write(buff, 0, len);
                }
                bos.close();
                fos.close();
            }
        }
        zipFile.close();//关闭

        /**
         * 文件不能删除的原因：
         * 1.看看是否被别的进程引用，手工删除试试(删除不了就是被别的进程占用)
         2.file是文件夹 并且不为空，有别的文件夹或文件，
         3.极有可能有可能自己前面没有关闭此文件的流(我遇到的情况)
         */
        if (isDelete) {
            boolean flag = new File(zipFilePath).delete();
            System.out.println("删除源文件结果: " + flag);
        }

    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     */
    public static  boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下所有目录及文件
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录为空，可以删除
        return dir.delete();
    }

    /**
     * 读取CSV文件
     * @param csvFilePath 文件路径
     * @param splitChar  分割符
     * @param encode  编码
     * @return
     */
    public static List<String[]> readerCsvFile(String csvFilePath,char splitChar,String encode) throws IOException {
        List<String[]> list = new ArrayList<>();
        // 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
        CsvReader reader = new CsvReader(csvFilePath, splitChar, Charset.forName(encode));
        // 跳过表头 如果需要表头的话，这句可以忽略
        reader.readHeaders();
        // 逐行读入除表头的数据
        while (reader.readRecord()) {
            //System.out.println(reader.getRawRecord());
            list.add(reader.getValues());
        }
        reader.close();
        return list;
    }
}
