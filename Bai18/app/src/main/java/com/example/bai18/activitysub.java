package com.example.bai18;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activitysub extends AppCompatActivity{
        TextView tvTitle,txtbaihat,txtloibaihat,txttacgia,txtmaso, tvMaSo;
        ImageButton btnthich,btnkhongthich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);
        txtmaso =(TextView)findViewById(R.id.tvMaSo);
        txtbaihat =(TextView)findViewById(R.id.editTim);
        btnthich =(ImageButton)findViewById(R.id.btnLove);
        btnkhongthich = (ImageButton) findViewById(R.id.btnUnlike);
    //Nhận Intent từ myarrayAdapter, lấy dữ liệu khỏi Bundle
        Intent callerIntent1 = getIntent();
        Bundle backagecaller1 = callerIntent1.getBundleExtra("package");
        String maso = backagecaller1.getString("maso");
    //Truy vấn dữ liệu từ maso nhận được; Hiển thị dữ liệu Mã bài hát, Tên bài hát, Lời bài
    //hát, Tác giả, Trạng thái Thích lên activitysub
        Cursor c = MainActivity.database.rawQuery("SELECT * FROM ArirangSongList WHERE MABH LIKE'"+maso+"'", null);
        txtmaso.setText(maso);
        c.moveToFirst();
        txtbaihat.setText(c.getString(2));
        txtloibaihat.setText(c.getString(3));
        txttacgia.setText(c.getString(4));
        if (c.getInt(6)==0) {
            btnthich.setVisibility(View.INVISIBLE);
            btnkhongthich.setVisibility(View.VISIBLE);
        } else {
            btnkhongthich.setVisibility(View.INVISIBLE);
            btnthich.setVisibility(View.VISIBLE);
        }
        c.close();
    //Xử lý sự kiện khi click vào Button btnthich và btnkhongthich
    //Cập nhật dữ liệu vào CSDL, thay đổi trạng thái hiển thị cho Button btnthich và
    //btnkhongthich
        btnthich.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH", 0);
                MainActivity.database.update("ArirangSongList", values,
                        "MABH=?", new String[]{txtmaso.getText().toString()});
                btnthich.setVisibility(View.INVISIBLE);
                btnkhongthich.setVisibility(View.VISIBLE);
            }
        });
        btnkhongthich.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("YEUTHICH", 1);
                MainActivity.database.update("ArirangSongList", values,
                        "MABH=?", new String[]{txtmaso.getText().toString()});
                btnkhongthich.setVisibility(View.INVISIBLE);
                btnthich.setVisibility(View.VISIBLE);
            }
    });
}
}