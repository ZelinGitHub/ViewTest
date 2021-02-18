package com.fuck.viewtest.menu.mvvm.rng;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class RngViewModel extends ViewModel {
    public MutableLiveData<String> mMutableLiveData = new MutableLiveData<>();
    public MediatorLiveData<Integer> mMediatorLiveData = new MediatorLiveData<>();



    RngViewModel() {
        mMediatorLiveData.setValue(0);
        mMediatorLiveData.addSource(mMutableLiveData, new Observer<String>() {
            //得到文本大小
            //使用MediatorLiveData发送数据
            @Override
            public void onChanged(String pS) {
                if (pS != null) {
                    int count = pS.length();
                    mMediatorLiveData.setValue(count);
                }
            }
        });
    }
    //使用MutableLiveData发送数据
    public void postValue(String pValue) {
        mMutableLiveData.postValue(pValue);
    }

}
