package techkids.vn.lab6.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab6.R;
import techkids.vn.lab6.models.ColorChoosen;

/**
 * Created by Lush on 12/20/2016.
 */

public class ColorAdapter extends ArrayAdapter<ColorChoosen> {

    @BindView(R.id.iv_color)
    View ivColor;

    @BindView(R.id.tv_color)
    TextView tvColor;

    public ColorAdapter(Context context, int resource, List<ColorChoosen> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_color, parent, false);
        }

        ButterKnife.bind(this, convertView);

        ivColor.setBackgroundColor(Color.parseColor(ColorChoosen.COLORS[position].getColorSrc()));
        tvColor.setText(ColorChoosen.COLORS[position].getColorName());

        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_color, parent, false);
        }

        ButterKnife.bind(this, convertView);

        if (position < 0) {
            ivColor.setBackgroundColor(Color.parseColor(ColorChoosen.COLORS[position].getColorSrc()));
        }
        ivColor.setBackgroundColor(Color.parseColor(ColorChoosen.COLORS[position].getColorSrc()));
        tvColor.setText(ColorChoosen.COLORS[position].getColorName());

        return convertView;
    }


}
