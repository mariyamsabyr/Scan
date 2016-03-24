package com.example.user.scanyourdocs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Dialog extends AppCompatActivity {
    ListView list;
    public Dialog() {
        // Empty constructor required for DialogFragment
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_dialog);
    }
    public View OnCreateView(LayoutInflater inflater,ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.list_dialog, container);
        return view;
    }


}
