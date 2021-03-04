package com.fuck.viewtest.menu.mvvm.geng;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class GenGViewModel extends ViewModel {
    private MutableLiveData<String> mMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> mMutableLiveData2 = new MutableLiveData<>();
    private MutableLiveData<String> mMutableLiveData3 = new MutableLiveData<>();
    public MediatorLiveData<String> mMediatorLiveData = new MediatorLiveData<>();

    GenGViewModel() {
        SourceObserver sourceObserver = new SourceObserver();
        mMediatorLiveData.addSource(mMutableLiveData, sourceObserver);
        mMediatorLiveData.addSource(mMutableLiveData2, sourceObserver);
        mMediatorLiveData.addSource(mMutableLiveData3, sourceObserver);
    }

    //源LiveData发送数据
    public void getData() {
        mMutableLiveData.postValue("ABC");
        mMutableLiveData2.postValue("BBC");
        mMutableLiveData3.postValue("CBC");
    }

    //用户设置的源LiveData的观察者
    class SourceObserver implements Observer<String> {
        //使用MediatorLiveData发送数据
        @Override
        public void onChanged(String pS) {
            mMediatorLiveData.setValue("Value：" + pS);
        }
    }
}
