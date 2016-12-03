package techkids.vn.dailyquote.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.dailyquote.MainActivity;
import techkids.vn.dailyquote.R;
import techkids.vn.dailyquote.constants.Constants;
import techkids.vn.dailyquote.managers.Preferences;
import techkids.vn.dailyquote.models.Quote;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.toString();
    @BindView(R.id.iv_background)
    ImageView ivBackground;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_user_name)
    TextView tvUserName;

    public QuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        sendGET();
        return view;
    }

    private void setupUI() {
        tvUserName.setText(String.format("Hi, %s!", Preferences.getInstance().getUserName()));

        ImageLoader.getInstance().displayImage(Constants.UNPLASH_API, ivBackground);
    }

    private void updateQuote(final Quote quote) {
        Activity parent = getActivity();

        if (parent != null) {
            parent.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvContent.setText(Html.fromHtml(quote.getContent()));
                    tvTitle.setText(quote.getTitle());
                }
            });
        }
    }

    private void sendGET() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Constants.QUOTE_API)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, body);

                Gson gson = new Gson();
                Quote[] quotes = gson.fromJson(body, Quote[].class);

                if (quotes.length > 0) {
                    QuoteFragment.this.updateQuote(quotes[0]);
                }
            }
        });
    }

}
