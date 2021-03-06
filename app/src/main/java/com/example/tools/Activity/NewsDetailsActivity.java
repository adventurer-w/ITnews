package com.example.tools.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tools.Adapter.CommentAdapter;
import com.example.tools.Data;
import com.example.tools.R;
import com.example.tools.tools.InputTextMsgDialog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SmartRefreshLayout smartRefreshLayout;
    private CommentAdapter commentAdapter;
    private boolean like,collection;
    private Button btn_like,btn_collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news_details);
        btn_like=findViewById(R.id.news_like);
        btn_collection=findViewById(R.id.news_collection);



        recyclerView=this.findViewById(R.id.details_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(NewsDetailsActivity.this));
      //  List<Data> comments = new ArrayList<>();


        List<String> comments = new ArrayList<>();

        comments.add("zhhkbdfhbh");
        for (int i=0;i<14;i++){
            comments.add(i+"水电费不会吧");
        }
        Log.i("asd",comments.toString());
        commentAdapter = new CommentAdapter(NewsDetailsActivity.this, comments);
        recyclerView.setAdapter(commentAdapter);








        //评论
        findViewById(R.id.edittext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final InputTextMsgDialog inputTextMsgDialog = new InputTextMsgDialog(NewsDetailsActivity.this, R.style.dialog_center);
                inputTextMsgDialog.setmOnTextSendListener(new InputTextMsgDialog.OnTextSendListener() {
                    @Override
                    public void onTextSend(String msg) {
                        //点击发送按钮后，回调此方法，msg为输入的值
                    }
                });
                inputTextMsgDialog.setMaxNumber(60);
                inputTextMsgDialog .show();
            }
        });
        //点赞
        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like){like=false;  btn_like.setBackgroundResource(R.drawable.like_nor);
                }else {like=true;  btn_like.setBackgroundResource(R.drawable.like_fill);}
            }
        });
        //收藏
        btn_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (collection){collection=false;  btn_collection.setBackgroundResource(R.drawable.collection_nor);
                }else {collection=true;  btn_collection.setBackgroundResource(R.drawable.collection_fill);}
            }
        });
        //返回
        findViewById(R.id.news_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}