package techkids.vn.lab4_turn1.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab4_turn1.R;
import techkids.vn.lab4_turn1.activities.DetailActivity;
import techkids.vn.lab4_turn1.activities.MainActivity;
import techkids.vn.lab4_turn1.dialog.PictureDialog;
import techkids.vn.lab4_turn1.models.Company;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private Company company;

    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;

    @BindView(R.id.tv_company_phone)
    TextView tvCompanyPhone;

    @BindView(R.id.tv_company_website)
    TextView tvCompanyWebsite;

    @BindView(R.id.iv_image_icon)
    ImageView ivIcon;

    public DetailFragment() {
        // Required empty public constructor
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);

        setupUI();
        addListener();

        return view;
    }

    private void setupUI() {
        tvCompanyName.setText(company.getName());
        tvCompanyPhone.setText(company.getPhone());
        tvCompanyWebsite.setText(company.getWebsite());
    }

    public static DetailFragment create(Company company) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setCompany(company);
        return detailFragment;
    }

    private void addListener() {
        tvCompanyWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvCompanyWebsite.getText().toString()));
                startActivity(browserIntent);
            }
        });

        tvCompanyPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tvCompanyPhone.getText().toString()));
                startActivity(callIntent);
            }
        });

        ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureDialog pictureDialog = new PictureDialog(getActivity());
                pictureDialog.setCompanyName(company.getName());
                pictureDialog.setCompanyPictureUrl(company.getPicture());
                pictureDialog.show();
            }
        });
    }

}
