package com.fuck.viewtest.menu.codeframe.mvvm.rng2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class Rng2ViewModel extends ViewModel {
    public MutableLiveData<String> mMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Integer> mMutableLiveData2 = new MutableLiveData<>();

    Rng2ViewModel() {
        mMutableLiveData2.setValue(0);
        mMutableLiveData.observeForever(new Observer<String>() {
            @Override
            public void onChanged(String pS) {
                if (pS != null) {
                    int count = pS.length();
                    mMutableLiveData2.setValue(count);
                }
            }
        });
    }
    //使用MutableLiveData发送数据
    public void postValue(String pValue) {
        mMutableLiveData.postValue(pValue);
    }

}
