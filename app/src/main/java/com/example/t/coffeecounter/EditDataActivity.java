package com.example.t.coffeecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

class EditDataActivity extends AppCompatActivity {
    public static final String TAG = "EditDataActivity";

    private Button btnSave, btnDelete;
    private EditText editTextItem;

    DataBaseHelper mDataBaseHelper;

    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_layout);
        intiView();

    }

    private void intiView() {
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        editTextItem = findViewById(R.id.etEditTextLayout);
        mDataBaseHelper = new DataBaseHelper(this);

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("name");
        editTextItem.setText(selectedName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editTextItem.getText().toString();
                if (!item.equals("")) {
                    mDataBaseHelper.updateName(item, selectedID, selectedName);
                } else {
                    toastMessage("You have to enter the name");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataBaseHelper.deleteName(selectedID, selectedName );
                editTextItem.setText("");
                toastMessage("Removed successfully");
            }
        });

    }


    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
