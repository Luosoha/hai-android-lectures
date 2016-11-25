package techkids.vn.foodlistview;

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

/**
 * Created by Lush on 11/24/2016.
 */

public class FoodAdapter extends ArrayAdapter {

    @BindView(R.id.iv_food)
    ImageView ivFood;

    @BindView(R.id.tv_food_name)
    TextView tvFoodName;

    @BindView(R.id.tv_food_detail)
    TextView tvFoodDetail;

    @BindView(R.id.tv_food_price)
    TextView tvFoodPrice;

    public FoodAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_food, parent, false);
        }

        ButterKnife.bind(this, convertView);

        FoodItem foodItem = (FoodItem) getItem(position);

        Picasso.with(this.getContext()).load(foodItem.getImage()).into(ivFood);
        tvFoodName.setText(foodItem.getName());
        tvFoodDetail.setText(foodItem.getDetail());
        tvFoodPrice.setText(String.format("%s VNĐ", foodItem.getPrice()));

        return convertView;
    }
}
