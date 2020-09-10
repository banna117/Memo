package com.example.memo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileManager {
    private static final String FILE_NAME="memo.txt"; //메모 내용을 저장할 파일 이름
    Context mContext = null;

    public TextFileManager(Context context){
        mContext = context;
    } //생성자

    //메모 저장
    public void save(String strData){
        if(strData==null||strData.equals("")){
            return;
        }
        FileOutputStream fosMemo = null;
        try{
            fosMemo=mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fosMemo.write(strData.getBytes());
            fosMemo.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //메모 불러오기
    public String load(){
        try{
            FileInputStream fisMemo = mContext.openFileInput(FILE_NAME);
            byte[] memoData = new byte[fisMemo.available()];
            while(fisMemo.read(memoData)!=-1){}
            return new String(memoData);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return "";
    }

    //메모 지우기
    public void delete(){
        mContext.deleteFile(FILE_NAME);
    }

}
