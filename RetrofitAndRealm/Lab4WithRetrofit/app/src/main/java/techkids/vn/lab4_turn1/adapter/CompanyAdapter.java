package techkids.vn.lab4_turn1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab4_turn1.R;
import techkids.vn.lab4_turn1.models.Company;

/**
 * Created by Lush on 12/5/2016.
 */

public class CompanyAdapter extends ArrayAdapter {

    public static final String TAG = CompanyAdapter.class.toString();

    @BindView(R.id.tv_name)
    TextView tvCompanyName;

    @BindView(R.id.iv_company_logo)
    ImageView ivCompanyLogo;

    public CompanyAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_company, parent, false);
        }

        ButterKnife.bind(this, convertView);

        Company company = (Company) getItem(position);
        Log.d(TAG, company.getLogo());

        Picasso.with(this.getContext()).load(company.getLogo()).into(ivCompanyLogo);
        tvCompanyName.setText(company.getName());

        return convertView;
    }
}
