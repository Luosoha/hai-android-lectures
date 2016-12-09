package techkids.vn.lab3_turn3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
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
import techkids.vn.lab3_turn3.R;
import techkids.vn.lab3_turn3.json.models.HairStyle;

/**
 * Created by Lush on 11/27/2016.
 */

public class HairAdapter extends ArrayAdapter {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.iv_hair)
    ImageView ivHair;

    public HairAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_hair, parent, false);
        }

        ButterKnife.bind(this, convertView);

        HairStyle hairStyle = (HairStyle) getItem(position);

        Picasso.with(this.getContext()).load(hairStyle.getImageUrl()).into(ivHair);
        tvTitle.setText(hairStyle.getTitle());
        tvDescription.setText(hairStyle.getDescription());

        return convertView;
    }
}
