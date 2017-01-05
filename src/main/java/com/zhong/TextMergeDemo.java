package com.zhong;

import java.io.*;

/**
 * Created by zhong on 2016/9/9.
 */
enum TextTypeCodeEnum{
    TEXT("txt"),
    JAVA("java"),
    LOG("log"),
    SQL("sql");
    String name;
    private TextTypeCodeEnum(String name){
        this.name=name;
    }
    public String toString(){
        return this.name;
    }
}

public class TextMergeDemo {

    public static void main(String[] args) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("d:out.txt")));
        String path="F:\\Demo\\ssh\\src\\main\\java";
        new TextMergeDemo().mergeText(new File(path),writer,new TextTypeCodeEnum[]{TextTypeCodeEnum.JAVA});
        writer.close();
    }

    public void mergeText(File files, BufferedWriter newFile, TextTypeCodeEnum[] types) throws Exception {
        if(files==null||!files.exists()||newFile==null||types==null||types.length==0){
            throw new RuntimeException("三个参数不能为空");
        }
        if(files.isDirectory()){
            File[] fileArr = files.listFiles();
            for (File file:fileArr) {
                mergeText(file,newFile,types);
            }
        }else {
            if(isNeed(files, types)){
                read2NewFile(files,newFile);
            }
        }
    }

    private void read2NewFile(File files, BufferedWriter newFile) throws Exception {
        if(!files.exists())
            return;
       BufferedReader reader = new BufferedReader(new FileReader(files));
        String line=null;
        while ((line=reader.readLine())!=null){
            newFile.write(line);
            newFile.newLine();
        }
        newFile.flush();
        reader.close();
    }

    private boolean isNeed(File files, TextTypeCodeEnum[] types) {
        String name = files.getName();
        String fileType=name.substring(name.lastIndexOf(".")+1,name.length());
        boolean isNeet=false;
        for (TextTypeCodeEnum e:types) {
          if(fileType.equals(e.toString())){
              isNeet=true;
          }
        }
        return isNeet;
    }
}
