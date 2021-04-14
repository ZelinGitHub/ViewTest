package com.fuck.viewtest.menu.codeframe.mvvm.simplemvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SimpleMvvmViewModel extends ViewModel {
    public MutableLiveData<String > mMutableLiveData =new MutableLiveData<>();

    public void getData(){
        mMutableLiveData.postValue("柴战士太郎");
    }

}
