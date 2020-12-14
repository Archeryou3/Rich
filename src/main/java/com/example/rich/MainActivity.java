package com.example.rich;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.richbox.EichText.RichEditer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private RichEditer richEditer;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        richEditer=findViewById(R.id.editor_content);
        ImageView imageView=findViewById(R.id.imageView5);
        ImageView imageView1=findViewById(R.id.imageView6);
        ImageView imageView2=findViewById(R.id.imageView7);
        ImageView imageView3=findViewById(R.id.imageView8);
        ImageView imageView6=findViewById(R.id.imageView13);
        floatingActionButton=findViewById(R.id.add_note);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richEditer.bold();
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richEditer.italic();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richEditer.fontSize();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richEditer.alignment();
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paizhao1(v);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("context",richEditer.toHtml());
                startActivity(intent);
            }
        });
    }


    public void paizhao1(View v){
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 2);
        Toast.makeText(MainActivity.this,richEditer.toHtml(),Toast.LENGTH_SHORT).show();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                richEditer.insertImage(String.valueOf(uri));
                Toast.makeText(MainActivity.this, String.valueOf(uri), Toast.LENGTH_LONG).show();
            }
        }
    }
}
