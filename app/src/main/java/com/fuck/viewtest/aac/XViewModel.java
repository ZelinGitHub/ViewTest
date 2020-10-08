package com.fuck.viewtest.aac;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class XViewModel extends ViewModel {
    public MutableLiveData<String> mMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> mMutableLiveData2 = new MutableLiveData<>();
    public MutableLiveData<String> mMutableLiveData3 = new MutableLiveData<>();
    public MediatorLiveData<String> mMediatorLiveData = new MediatorLiveData<>();

    XViewModel() {
        MyObserver myObserver = new MyObserver();
        mMediatorLiveData.addSource(mMutableLiveData, myObserver);
        mMediatorLiveData.addSource(mMutableLiveData2, myObserver);
        mMediatorLiveData.addSource(mMutableLiveData3, myObserver);
    }

    public void getData() {
        mMutableLiveData.postValue("数据1");
        mMutableLiveData2.postValue("数据2");
        mMutableLiveData3.postValue("数据3");
    }

    class MyObserver implements Observer<String> {

        @Override
        public void onChanged(String pS) {
            mMediatorLiveData.postValue("得到数据" + pS);
        }
    }
}
