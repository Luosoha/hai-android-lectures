package techkids.vn.dailyquote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import techkids.vn.dailyquote.R;
import techkids.vn.dailyquote.managers.Preferences;
import techkids.vn.dailyquote.models.FragmentEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.et_user_name)
    EditText etUserName;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.bt_save)
    public void onClick(View view) {
        String userName = etUserName.getText().toString();

        Preferences.getInstance().putUserName(userName);

        EventBus.getDefault().post(new FragmentEvent(
                new QuoteFragment(),
                false
        ));
    }

}
