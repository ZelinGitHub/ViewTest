package com.fuck.viewtest.menu.codeframe.mvvm.geng2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class GenG2ViewModel extends ViewModel {
    private MutableLiveData<String> mMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> mMutableLiveData2 = new MutableLiveData<>();
    private MutableLiveData<String> mMutableLiveData3 = new MutableLiveData<>();
    public MutableLiveData<String> mMutableLiveData4 = new MutableLiveData<>();

    GenG2ViewModel() {
        mMutableLiveData.observeForever(new Observer<String>() {
            @Override
            public void onChanged(String pS) {
                mMutableLiveData4.setValue(pS);
            }
        });
        mMutableLiveData2.observeForever(new Observer<String>() {
            @Override
            public void onChanged(String pS) {
                mMutableLiveData4.setValue(pS);
            }
        });
        mMutableLiveData3.observeForever(new Observer<String>() {
            @Override
            public void onChanged(String pS) {
                mMutableLiveData4.setValue(pS);
            }
        });
    }

    //源LiveData发送数据
    public void getData() {
        mMutableLiveData.postValue("ABC");
        mMutableLiveData2.postValue("BBC");
        mMutableLiveData3.postValue("CBC");
    }
}
