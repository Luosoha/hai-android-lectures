package techkids.vn.music.fragments;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.music.MainActivity;
import techkids.vn.music.R;
import techkids.vn.music.networks.json_models.Subgenres;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopsongsFragment extends Fragment {

    private static final String TAG = TopsongsFragment.class.toString();

    @BindView(R.id.view_back)
    View viewBack;

    @BindView(R.id.iv_category)
    ImageView ivCategory;

    @BindView(R.id.tv_category_name)
    TextView tvCategoryName;

    private Subgenres subgenres;

    public TopsongsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_topsongs, container, false);

        this.setHasOptionsMenu(true);
        ((MainActivity)getActivity()).getSupportActionBar().hide();
        ButterKnife.bind(this, view);
        setupUI();
        addListeners();

        return view;
    }

    private void addListeners() {
        viewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    private void setupUI() {
        if (subgenres != null) {
            tvCategoryName.setText(subgenres.getTranslationKey());
            String src = "genre_" + subgenres.getId();
            int rid = this.ivCategory.getResources().getIdentifier(src,
                    "drawable", this.ivCategory.getContext().getPackageName());
            if (rid != 0) {
                Picasso.with(this.getContext()).load(rid).into(ivCategory);
            }
        }
    }

    public void setSubgenres(Subgenres subgenres) {
        this.subgenres = subgenres;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_top_songs, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
        }
        return false;
    }
}
