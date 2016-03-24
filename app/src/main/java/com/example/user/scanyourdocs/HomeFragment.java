package com.example.user.scanyourdocs;


import android.animation.AnimatorSet;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;


public class HomeFragment extends DialogFragment{
    final String LOG_TAG="myLog";
    Context mContext;
    FragmentTransaction fragmentTransaction;
    FolderFragment folderFragment;

    AlertDialog.Builder ad;
    String title = "Имя папки";
    EditText nameText;
    String editText;
    ListView listView;
    Resources myResources;
    String delete="Удалить?";
    String rename="Переименовать";
    String cancel = "Отмена";
    String optionLong = "Документ";
    String ok= "ОК";
    TextView folderName;
    ImageView folder;
    ImageView plus;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public HomeFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        folderFragment=new FolderFragment();

        if (getArguments() != null){
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        final View v;
        v = inflater.inflate(R.layout.fragment_home, null);
        mContext=container.getContext();
        folder=(ImageView)v.findViewById(R.id.folder);
        plus=(ImageView)v.findViewById(R.id.plus);
        nameText=(EditText)v.findViewById(R.id.nameText);
        listView=(ListView)v.findViewById(R.id.listView);
        final String[] options ={"Переименовать", "Удалить"};
        folderName=(TextView)v.findViewById(R.id.folderName);

        folder.setLongClickable(true);
        folder.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                ad = new AlertDialog.Builder(mContext);
                myResources = getResources();
                ad.setTitle(optionLong);
                ad.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        for (int i = 0; i < 2; i++) {
                            switch (options[item]) {
                                case "Переименовать":
                                    fragmentTransaction = getFragmentManager().beginTransaction();
                                    ad = new AlertDialog.Builder(mContext);
                                    Toast.makeText(mContext.getApplicationContext(),
                                            options[item],
                                            Toast.LENGTH_SHORT).show();
                                    ad.setTitle(rename);
                                    ad.setView(inflater.inflate(R.layout.dialog, null));
                                    ad.setPositiveButton(ok, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int arg1) {
                                            //editText=myResources.getText(editText);
                                            folderName.setText(editText);
                                            Toast.makeText(mContext, "Переименовано",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    });
                                    ad.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int arg1) {
                                            Toast.makeText(mContext, "Отмена", Toast.LENGTH_LONG)
                                                    .show();
                                        }
                                    });
                                    ad.setCancelable(true);
                                    ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                        public void onCancel(DialogInterface dialog) {
                                            Toast.makeText(mContext, "Вы ничего не выбрали",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    });
                                    ad.show();
                                    break;
                                case "Удалить":
                                    fragmentTransaction = getFragmentManager().beginTransaction();
                                    ad = new AlertDialog.Builder(mContext);
                                    ad.setTitle(delete);
                                    ad.setPositiveButton(ok, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int arg1) {
                                            Toast.makeText(mContext, "Удалено",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    });
                                    ad.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int arg1) {
                                            Toast.makeText(mContext, "Отмена", Toast.LENGTH_LONG)
                                                    .show();
                                        }
                                    });
                                    ad.setCancelable(true);
                                    ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                        public void onCancel(DialogInterface dialog) {
                                            Toast.makeText(mContext, "Вы ничего не выбрали",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    });
                                    ad.show();
                            }
                        }
                    }
                });
                ad.setCancelable(true);
                ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(mContext, "Вы ничего не выбрали",
                                Toast.LENGTH_LONG).show();
                    }
                });
                ad.show();
                Log.d(LOG_TAG, "Long Click!!!!");
                return false;
            }
        });

        folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                Intent intent = new Intent();
                intent.setClass(getActivity(), FolderActivity.class);
                getActivity().startActivity(intent);
                Log.d(LOG_TAG, "Button click in Home Fragment!!!!");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                ad = new AlertDialog.Builder(mContext);
                ad.setTitle(title);
                ad.setView(inflater.inflate(R.layout.dialog, null));
                ad.setPositiveButton(cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        String folderName = nameText.toString();
                        Toast.makeText(mContext, "Вы сделали правильный выбор"+folderName,
                                Toast.LENGTH_LONG).show();
                    }
                });
                ad.setNegativeButton(ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        Toast.makeText(mContext, "Возможно вы правы", Toast.LENGTH_LONG)
                                .show();
                    }
                });
                ad.setCancelable(true);
                ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(mContext, "Вы ничего не выбрали",
                                Toast.LENGTH_LONG).show();
                    }
                });
                ad.show();

                Log.d(LOG_TAG, "Alert Dialog!!!!");
            }
        });
        return v;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
