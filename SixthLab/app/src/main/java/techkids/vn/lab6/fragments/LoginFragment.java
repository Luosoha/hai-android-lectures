package techkids.vn.lab6.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.lab6.R;
import techkids.vn.lab6.events.OnButtonClickEvent;
import techkids.vn.lab6.managers.Preferences;
import techkids.vn.lab6.networks.DbContext;
import techkids.vn.lab6.networks.jsonmodels.LoginRequestBody;
import techkids.vn.lab6.networks.jsonmodels.LoginResponseBody;
import techkids.vn.lab6.networks.jsonmodels.RegisterRequestBody;
import techkids.vn.lab6.networks.jsonmodels.RegisterResponseBody;
import techkids.vn.lab6.networks.services.LoginService;
import techkids.vn.lab6.networks.services.RegisterService;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private static final String TAG = LoginFragment.class.toString();

    @BindView(R.id.et_username)
    EditText etUsername;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.bt_login)
    Button btLogin;

    @BindView(R.id.bt_register)
    Button btRegister;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);
        addListeners();


        return view;
    }

    private void addListeners() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btLogin onClick");

                LoginService loginService = DbContext.ASERVER.create(LoginService.class);

                LoginRequestBody loginRequestBody = new LoginRequestBody(
                        etUsername.getText().toString(),
                        etPassword.getText().toString()
                );

                final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                        (new Gson()).toJson(loginRequestBody)
                );

                final Call<LoginResponseBody> login = loginService.login(requestBody);

                login.enqueue(new Callback<LoginResponseBody>() {
                    @Override
                    public void onResponse(Call<LoginResponseBody> call, Response<LoginResponseBody> response) {
                        Log.d(TAG, "onResponse");

                        if (response.body() == null) {
                            OnButtonClickEvent onButtonClickEvent = new OnButtonClickEvent("User doesn't exist!", null);
                            EventBus.getDefault().post(onButtonClickEvent);
                        } else {
                            OnButtonClickEvent onButtonClickEvent = new OnButtonClickEvent("Logged in", response.body().getToken());
                            Preferences.getInstance().putToken(response.body().getToken());
                            EventBus.getDefault().post(onButtonClickEvent);
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponseBody> call, Throwable t) {
                        Log.d(TAG, "onFailure");
                    }
                });
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btRegister onClick");

                RegisterService registerService = DbContext.ASERVER.create(RegisterService.class);

                RegisterRequestBody registerRequestBody = new RegisterRequestBody(
                        etUsername.getText().toString(),
                        etPassword.getText().toString()
                );

                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                        (new Gson()).toJson(registerRequestBody)
                );

                final Call<RegisterResponseBody> register = registerService.register(requestBody);

                register.enqueue(new Callback<RegisterResponseBody>() {
                    @Override
                    public void onResponse(Call<RegisterResponseBody> call, Response<RegisterResponseBody> response) {
                        Log.d(TAG, "onResponse");
                        if (response.code() == 400) {
                            OnButtonClickEvent onButtonClickEvent = new OnButtonClickEvent("User already exist!", null);
                            EventBus.getDefault().post(onButtonClickEvent);
                        } else {
                            OnButtonClickEvent onButtonClickEvent = new OnButtonClickEvent("Successful!", null);
                            EventBus.getDefault().post(onButtonClickEvent);
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponseBody> call, Throwable t) {
                        Log.d(TAG, "onFailure");
                    }
                });

            }
        });
    }


}
