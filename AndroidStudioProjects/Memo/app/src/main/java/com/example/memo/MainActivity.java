package com.example.memo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText memoEdit = null;
    TextFileManager tfm = new TextFileManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memoEdit = (EditText) findViewById(R.id.editTextTextMultiLine); //memoEdit 이라는 녀석은 edittextmultiline이라는 아이디를 가진 화면에 텍스트를 보여주는 아이다.
    }

    public void onClick(View v){        //아마도 뷰 안에 있는 어떤 것이 눌렸을 때! 를 onClick이라는 메소드를 통해 표현한다.
        switch(v.getId()){
            //저장
            case R.id.saveBtn : {
                String memoData = memoEdit.getText().toString();
                if(memoData.equals("")) {       //아무것도 안 적었는데 저장하려고 한다면, 멈춘다.
                    Toast.makeText(this, "내용을 입력해주세요.", Toast.LENGTH_LONG).show();
                    break;
                }
                tfm.save(memoData);
                memoEdit.setText("");
                Toast.makeText(this, "저장 완료", Toast.LENGTH_LONG).show();
                break;
            }
            //불러오기
            case R.id.loadBtn : {
                String memoData = tfm.load();
                memoEdit.setText(memoData);

                Toast.makeText(this, "불러오기 완료", Toast.LENGTH_LONG).show();
                break;
            }
            //지우기
            case R.id.deleteBtn : {
                tfm.delete();
                memoEdit.setText("");

                Toast.makeText(this, "삭제 완료", Toast.LENGTH_LONG).show();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

}