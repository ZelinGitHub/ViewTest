package com.fuck.viewtest.menu.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.cons.Util;

public class DialogAty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_open_alert;
    private Button btn_open_dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_open_alert = findViewById(R.id.btn_open_alert);
        btn_open_dialog = findViewById(R.id.btn_open_dialog);
    }

    private void initUI() {
        btn_open_alert.setOnClickListener(this);
        btn_open_dialog.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(this, "abc", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_open_dialog: {
                showDlg(this);
                break;
            }
            case R.id.btn_open_alert: {
                showAlert(this);
            }
        }
    }

    private void showDlg(Context pContext) {
        Dialog dialog = new Dialog(pContext);
        TextView textView = new TextView(pContext);
        textView.setText("ABC");
        dialog.setContentView(textView);
        dialog.show();
    }

    private void showAlert(Context pContext) {
        Dialog dialog = new AlertDialog.Builder(pContext)
                .setTitle("Fuck u?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Util.toast(pContext, "Hot fuck");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Util.toast(pContext, "Go die");
                    }
                })
                .create();
        dialog.show();
    }
}
