package com.fuck.viewtest.aac;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    public MutableLiveData<String > mLiveData =new MutableLiveData<>();
    public MediatorLiveData<String > mLiveData2 =new MediatorLiveData<>();

    public void getData(){
        mLiveData.postValue("柴战士太郎");
    }
}
