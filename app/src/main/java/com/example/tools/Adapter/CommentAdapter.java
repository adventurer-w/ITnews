package com.example.tools.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tools.R;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0; //说明是带有Header的
    public static final int TYPE_NORMAL = 1;
    private boolean focus;
    private Context context;
    //private List<Data> comments;
    private List<String> comments;
    private View mHeaderView;
    public CommentAdapter(Context context,List<String> comments /*List<Data> comments*/) {
        this.context=context;
        this.comments=comments;
    }



    /** 重写这个方法,通过判断item的类型，从而绑定不同的view * */
    @Override
    public int getItemViewType(int i) {
        if (i>0 ){
            return TYPE_NORMAL;
        }
        if (i == 0){
            return TYPE_HEADER;
        }
        return super.getItemViewType(i);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        if (i==TYPE_NORMAL){
            view= LayoutInflater.from(context).inflate(R.layout.item_comments,viewGroup,false);
            holder= new ViewHolderComments(view);}
        else if (i==TYPE_HEADER){
            view= LayoutInflater.from(context).inflate(R.layout.comment_header,viewGroup,false);
            holder= new ViewHolderNews(view);}
        return holder;

    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int i) {

        if (holder instanceof ViewHolderComments){
            ( (ViewHolderComments)holder).comment.setText(comments.get(i));


        }else if (holder instanceof ViewHolderNews){


            ( (ViewHolderNews)holder).writer.setText(comments.get(i));
            //关注按钮
            ( (ViewHolderNews)holder).btn_focus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (focus){focus=false;
                    ( (ViewHolderNews)holder).btn_focus.setBackgroundResource(R.drawable.btn_focus_fill);
                    ( (ViewHolderNews)holder).btn_focus.setText("关注");
                    ( (ViewHolderNews)holder).btn_focus.setTextColor(context.getResources().getColor(R.color.white));
                    }else {focus=true;
                    ( (ViewHolderNews)holder).btn_focus.setBackgroundResource(R.drawable.button_focus);
                    ( (ViewHolderNews)holder).btn_focus.setText("已关注");
                    ( (ViewHolderNews)holder).btn_focus.setTextColor(context.getResources().getColor(R.color.gradientstart));}
                }
            });
        }


    }


    public int getItemCount() {

        return comments.size();
    }





    public static class ViewHolderComments extends RecyclerView.ViewHolder {
        TextView writer,comment;
        public ViewHolderComments(@NonNull View itemView) {
            super(itemView);
            comment=itemView.findViewById(R.id.comments);
        }
    }

    public static class ViewHolderNews extends RecyclerView.ViewHolder {

        TextView writer;
        Button btn_focus;
        public ViewHolderNews(@NonNull View itemView) {
            super(itemView);
            writer=itemView.findViewById(R.id.tital);
            btn_focus=itemView.findViewById(R.id.details_btn);
        }
    }
     }

