package com.example.t.coffeecounter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

class ListDataActivity extends AppCompatActivity {

    public static final String TAG = "ListDataActivity";
    DataBaseHelper mDataBaseHelper;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
    }
}
