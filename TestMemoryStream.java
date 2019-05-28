package com.zh.io;

import java.io.*;

public class TestMemoryStream {
    public static void main1(String[] args) {
        String comtent="zh love";
        //要求：内存流,将其变为大写
        byte[] data=comtent.getBytes();
        //input->convert->output(读入，转变，输出)
        ByteArrayInputStream in=new ByteArrayInputStream(data);
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        int b=-1;
        while((b=in.read())!=-1) {
            b = Character.toUpperCase(b);
            out.write(b);
        }
         byte[] newdata =  out.toByteArray();
        System.out.println(new String(newdata));
        }

    public static void main(String[] args) {

        //内存流data-a.txt->ByteArrayOutputStream  data-b.txt-ByteArrayOutputStream
        //ByteArrayOutputStream byte[]->FileOutputStream   缺陷：不知道文件多大
        try(FileInputStream fa=new FileInputStream("D:"+ File.separator+"test5.25"+File.separator+"A"+File.separator+"data_a.txt");
        FileInputStream fb=new FileInputStream("D:"+ File.separator+"test5.25"+File.separator+"A"+File.separator+"data_b.txt");
        FileOutputStream fout=new FileOutputStream("D:"+ File.separator+"test5.25"+File.separator+"A"+File.separator+"data.txt");
            ByteArrayOutputStream memorystream=new ByteArrayOutputStream())
         {
             byte[] buff=new byte[1024];
             int len=-1;
             while((len=fa.read(buff))!=-1){
                 memorystream.write(buff,0,len);
             }
             while (((len=fb.read(buff))!=-1)){
                 memorystream.write(buff,0,len);
             }

             byte[] newdata =memorystream .toByteArray();
            fout.write(newdata);
            fout.flush();
         } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    }

