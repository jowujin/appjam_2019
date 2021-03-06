package com.sk.appjam_2019.view;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sk.appjam_2019.R;
import com.sk.appjam_2019.network.RetrofitClient;
import com.sk.appjam_2019.network.RetrofitService;
import com.sk.appjam_2019.util.TokenManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity {
    @BindView(R.id.tv_auth_signIn)
    TextView tv_auth_signIn;
    @BindView(R.id.tv_auth_signUp)
    TextView tv_auth_signUp;
    @BindView(R.id.et_auth_inputId)
    EditText et_auth_inputId;
    @BindView(R.id.et_auth_inputPw)
    EditText et_auth_inputPw;
    @BindView(R.id.et_auth_inputNick)
    EditText et_auth_inputNick;
    @BindView(R.id.tv_auth_confirm)
    TextView tv_auth_confirm;
    @BindView(R.id.ll_auth_inputContainer)
    LinearLayout ll_auth_inputContainer;
    @BindView(R.id.et_auth_inputAddress)
    EditText et_auth_inputAddress;
    @BindView(R.id.et_auth_inputBirthDay)
    EditText et_auth_inputBirthDay;

    Typeface sans_bold;
    Typeface sans_regular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        // set Font
        sans_bold = ResourcesCompat.getFont(getApplicationContext(), R.font.product_sans_bold);
        sans_regular = ResourcesCompat.getFont(getApplicationContext(), R.font.product_sans_regular);
    }

    @OnClick(R.id.tv_auth_signIn)
    void showSignIn() {
        et_auth_inputNick.setVisibility(View.INVISIBLE);
        ll_auth_inputContainer.setVisibility(View.GONE);
        tv_auth_confirm.setText(getString(R.string.signIn));

        tv_auth_signIn.setTypeface(sans_bold);
        tv_auth_signIn.setTextColor(getColor(R.color.auth_textview_focus));

        tv_auth_signUp.setTypeface(sans_regular);
        tv_auth_signUp.setTextColor(getColor(R.color.auth_textview_unfocus));
    }

    @OnClick(R.id.tv_auth_signUp)
    void showSignUp() {
        et_auth_inputNick.setVisibility(View.VISIBLE);
        ll_auth_inputContainer.setVisibility(View.VISIBLE);
        tv_auth_confirm.setText(getString(R.string.signUp));

        tv_auth_signIn.setTypeface(sans_regular);
        tv_auth_signIn.setTextColor(getColor(R.color.auth_textview_unfocus));

        tv_auth_signUp.setTypeface(sans_bold);
        tv_auth_signUp.setTextColor(getColor(R.color.auth_textview_focus));
    }

    private void signUp(String id, String pw, String name, String address, String birthday) {
        RetrofitService service = RetrofitClient.createService(RetrofitService.class);
        Call<JsonObject> call = service.signUp(id, pw, name, address, birthday);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonElement element = new JsonParser().parse(response.body().toString())
                            .getAsJsonObject().get("token");

                    Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                    TokenManager.getInstance().saveToken(getApplicationContext(), element.getAsString());
                    finish();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    private void login(String id, String pw) {
        RetrofitService service = RetrofitClient.createService(RetrofitService.class);
        Call<JsonObject> call = service.login(id, pw);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonElement element = new JsonParser().parse(response.body().toString())
                            .getAsJsonObject().get("token");
                    Log.d("SignIn_Token", "onResponse: " + response.body().toString());

                    Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                    TokenManager.getInstance().saveToken(getApplicationContext(), element.getAsString());
                    finish();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.tv_auth_confirm)
    void sendRequest() {
        if (tv_auth_confirm.getText().equals(getString(R.string.signUp))) {
            if (et_auth_inputId.getText() != null && et_auth_inputPw.getText() != null
                    && et_auth_inputNick.getText() != null && et_auth_inputAddress.getText() != null
                    && et_auth_inputBirthDay.getText() != null) {

                signUp(et_auth_inputId.getText().toString(), et_auth_inputPw.getText().toString(),
                        et_auth_inputNick.getText().toString(), et_auth_inputAddress.getText().toString(),
                        et_auth_inputBirthDay.getText().toString());
            }
        } else {
            if (et_auth_inputId.getText() != null && et_auth_inputPw.getText() != null) {
                login(et_auth_inputId.getText().toString(), et_auth_inputPw.getText().toString());
            }
        }
    }
}
