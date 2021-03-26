package com.fuck.viewtest.menu.display.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

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
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        dialog.setContentView(textView);
        dialog.setCanceledOnTouchOutside(false);
        setWindowSize(dialog);
        dialog.show();
    }

    private void setWindowAnim(Dialog pDialog) {
        Window window = pDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.windowRightToLeft);
        }
    }

    private void setWindowSize(Dialog pDialog) {
        Window window = pDialog.getWindow();
        if (window != null) {
            int screenWidth = pDialog.getContext().getResources().getDisplayMetrics().widthPixels;
            int screenHeight = pDialog.getContext().getResources().getDisplayMetrics().heightPixels;
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = screenWidth;
            layoutParams.height = screenHeight;
        }
    }

    private void setWindowType(Dialog pDialog) {
        Window window = pDialog.getWindow();
        if (window != null) {
            window.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);
        }
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
