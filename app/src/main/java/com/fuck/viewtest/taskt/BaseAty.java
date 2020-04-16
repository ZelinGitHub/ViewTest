package com.fuck.viewtest.taskt;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseAty extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********************** " + getTag() + " onCreate");
        System.out.println("*********************** " + getTag() +" TaskId "+ getTaskId());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("*********************** " + getTag() + " onNewIntent");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("*********************** "+getTag()+ " onActivityResult");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("*********************** "+getTag()+ " onStart");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("*********************** "+getTag()+ " onRestoreInstanceState");

    }


    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("*********************** "+getTag()+ " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("*********************** "+getTag()+ " onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("*********************** "+getTag()+ " onSaveInstanceState");

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("*********************** "+getTag()+ " onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("*********************** "+getTag()+ " onDestroy");

    }
    
    
    
    private String getTag(){
        return " "+initTag()+" ";
    }
    
    protected abstract String initTag();
}
