package com.fuck.viewtest.aac;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    public MutableLiveData<String > mMutableLiveData =new MutableLiveData<>();
    public MutableLiveData<String > mMutableLiveData2 =new MutableLiveData<>();
    public MediatorLiveData<String > mMediatorLiveData =new MediatorLiveData<>();

    MyViewModel(){
        MyObserver myObserver=new MyObserver();
        mMediatorLiveData.addSource(mMutableLiveData,myObserver);
    }

    public void getData(){
        mMutableLiveData.postValue("柴战士太郎");
        mMutableLiveData2.postValue("狗急跳墙");
    }

    class MyObserver implements Observer<String>{

        @Override
        public void onChanged(String pS) {
            mMediatorLiveData.postValue("闻见狗肉香");
        }
    }
}
