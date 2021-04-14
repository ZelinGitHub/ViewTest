package com.fuck.viewtest.menu.codeframe.mvvm.mediatorLivedata.geng2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
//模拟MediatorLiveData
public class GenG2ViewModel extends ViewModel {
    //源LiveData
    private MutableLiveData<String> mMutableLiveData = new MutableLiveData<>();
    //源LiveData
    private MutableLiveData<String> mMutableLiveData2 = new MutableLiveData<>();
    //源LiveData
    private MutableLiveData<String> mMutableLiveData3 = new MutableLiveData<>();
    //末LiveData
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
        System.out.println("获取数据成功");
        mMutableLiveData.postValue("ABC");
        mMutableLiveData2.postValue("BBC");
        mMutableLiveData3.postValue("CBC");
    }
}
