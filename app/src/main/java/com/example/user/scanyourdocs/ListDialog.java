package com.example.user.scanyourdocs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by user on 21.03.2016.
 */
public class ListDialog extends AppCompatActivity {
    ListView listView;
    final String[] values = new String[] {
            "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
            "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
            "Китти", "Масяня", "Симба"
    };
    public ListDialog() {
        // Empty constructor required for DialogFragment
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        //setListAdapter(adapter);

    }
    public View OnCreateView(LayoutInflater inflater,ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.dialog, container);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_dialog, values);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return view;
    }
}
