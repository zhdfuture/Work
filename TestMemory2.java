package com.zh.io;

import java.io.*;

public class TestMemory2 {
    public static void join(String[] file1,String FIle2Path ){
        if(file1==null||FIle2Path==null){
            throw new IllegalArgumentException("不存在");
        }
        File file2=new File(FIle2Path);  //将路径转换成文件
        File parent=file2.getParentFile();
        if(!parent.exists()){
            parent.mkdirs();
        }
        for(int i=0;i<file1.length;i++){
            if(file1[i]==null){
                throw new IllegalArgumentException();
            }
            File files1=new File(file1[i]);
            try(FileInputStream in=new FileInputStream(files1); FileOutputStream out=new FileOutputStream(file2,true)) {
                byte[] buff=new byte[1024];
                int len=-1;
              while((len=in.read(buff))!=-1){
                  out.write(buff,0,len);
              }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] file1= {"D:"+ File.separator+"test5.25"+File.separator+"A"+File.separator+"data_a.txt","D:"+ File.separator+"test5.25"+File.separator+"A"+File.separator+"data_b.txt"};
        String file2= "D:"+ File.separator+"test5.25"+File.separator+"A"+File.separator+"data.txt";
       join(file1,file2);
    }
}
