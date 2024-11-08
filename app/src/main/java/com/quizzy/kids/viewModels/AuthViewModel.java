package com.quizzy.kids.viewModels;

import android.app.Application;
import android.credentials.GetCredentialRequest;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.quizzy.kids.R;

public class AuthViewModel extends AndroidViewModel {

//    public MutableLiveData<User> userMutableLiveData;
    public MutableLiveData<Boolean> loginStatus;

    public AuthViewModel(@NonNull Application application) {
        super(application);

//        GetCredentialRequest signInRequest = GetCredentialRequest.Builder()
//                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
//                        .setSupported(true)
//                        .setServerClientId(application.getString(R.string.default_web_client_id))
//                        .setFilterByAuthorizedAccounts(false)
//                        .build())
//                .setAutoSelectEnabled(true)
//                .build();

    }
}
