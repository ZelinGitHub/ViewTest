package com.fuck.viewtest.menu.vpfrg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fuck.viewtest.R;

public class TwoFrg extends Fragment {
    private final String TAG="TwoFrg";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        System.out.println("******************"+TAG+"  onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("******************"+TAG+"  onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("******************"+TAG+"  onCreateView");
        return inflater.inflate(R.layout.frg_two,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("******************"+TAG+"  onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("******************"+TAG+"  onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("******************"+TAG+"  onResume");

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        System.out.println("******************"+TAG+"  setUserVisibleHint");

    }


    @Override
    public void onPause() {
        super.onPause();
        System.out.println("******************"+TAG+"  onPause");

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("******************"+TAG+"  onSaveInstanceState");

    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("******************"+TAG+"  onStop");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("******************"+TAG+"  onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("******************"+TAG+"  onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("******************"+TAG+"  onDetach");

    }
}
