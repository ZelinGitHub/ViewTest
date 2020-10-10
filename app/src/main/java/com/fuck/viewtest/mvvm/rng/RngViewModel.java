package com.fuck.viewtest.mvvm.rng;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class RngViewModel extends ViewModel {
    public MutableLiveData<String> mMutableLiveData = new MutableLiveData<>();
    public MediatorLiveData<Integer> mMediatorLiveData = new MediatorLiveData<>();

    public MutableLiveData<Integer> mMutableLiveData2 = new MutableLiveData<>();


    RngViewModel() {
        mMediatorLiveData.setValue(0);
        mMutableLiveData2.setValue(0);
        mMediatorLiveData.addSource(mMutableLiveData, new Observer<String>() {
            @Override
            public void onChanged(String pS) {
                if (pS != null) {
                    int count = pS.length();
                    mMediatorLiveData.setValue(count);
                }
            }
        });
    }

    public void postValue(String pValue) {
        mMutableLiveData.postValue(pValue);
    }

}
