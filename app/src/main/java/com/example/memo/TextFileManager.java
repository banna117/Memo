package com.example.memo;

import java.io.FileOutputStream;

public class TextFileManager {
    private static final String FILE_NAME="memo.txt"; //메모 내용을 저장할 파일 이름
    Context mContext = Null;

    public TextFileManager(Context context){
        mContext = context;
    }

    //메모 저장
    public void save(String strData){
        if(strData==Null||strData.equals("")){
            return;
        }
        FileOutputStream
    }

}
