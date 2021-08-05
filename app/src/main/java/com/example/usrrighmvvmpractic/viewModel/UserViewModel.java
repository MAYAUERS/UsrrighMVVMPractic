package com.example.usrrighmvvmpractic.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.usrrighmvvmpractic.model.SucessResponse;
import com.example.usrrighmvvmpractic.repository.UserRepository;

public class UserViewModel  extends AndroidViewModel {

    private LiveData<SucessResponse> liveData;

    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
    }


    public void init(){
        userRepository=new UserRepository();
        liveData=userRepository.getAPILiveDatafromRepository();
    }


    public void getAllData(){
        userRepository.getApi();
    }

    public LiveData<SucessResponse> getLiveData(){
        return liveData;
    }

}








/*AndroidViewModel {

 private LiveData<SucessResponse> liveData;
 private UserRepository userRepository;


    public UserViewModel(@NonNull Application application) {
        super(application);
    }


    public void init() {
        userRepository=new UserRepository();
        liveData=userRepository.getAPILiveDatafromRepository();
    }
    public void getAllResponse(){
        userRepository.getApi();
    }

    public LiveData<SucessResponse>getLiveData(){
        return liveData;
    }

}*/
