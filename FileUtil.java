package com.zh.io;

import java.io.*;

public class FileUtil {
    public static  void copyFile(String srcFilePath,String destFilePath) throws FileNotFoundException {
        //1.String path->file,把路径变为file
        if(srcFilePath==null||srcFilePath.isEmpty()){
            throw new IllegalArgumentException("srcFile must be not null");
        }
        File scrFile=new File(srcFilePath);
        File destFile=new File(destFilePath);
//        FileInputStream fileInputStream=null;
//        FileOutputStream fileOutputStream=null;
        //2.检验工作： srcFile必须存在;dest目录必须存在，不存在创建
        if(!scrFile.isFile()||!scrFile.exists()){
            throw new IllegalArgumentException(scrFile+"is not File or exists");
        }

        File parent=destFile.getParentFile();
        if(!parent.exists()){
            parent.mkdirs();   //若父目录不存在，创造
        }
        //3.文件读取和写入 srcFile->输入流    destFile->输出流
        //用字节流
        try(InputStream in=new FileInputStream(scrFile); OutputStream out=new FileOutputStream(destFile)){
            byte[] buff=new byte[1024*1024];  //文件小用1kb 1024  文件大用1m  1024*1024  .但不要太大
            int len=-1;
            while((len=in.read(buff))!=-1){
                out.write(buff,0,len);
            }
               out.flush();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
String destFilePath="D:\\test5.25\\A\\datax.text";//目标文件地址
        String srcFilePath="D:\\zhfut\\AB\\a.txt";//源文件地址
      try {
            copyFile(srcFilePath,destFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
