package com.fuck.viewtest.menu.mvvm.dragonx;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DragonXViewModel extends ViewModel {
    public MutableLiveData<String > mMutableLiveData =new MutableLiveData<>();

    public void getData(){
        mMutableLiveData.postValue("柴战士太郎");
    }

}
