package techkids.vn.hackathon.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.hackathon.R;
import techkids.vn.hackathon.models.Friend;

/**
 * Created by Lush on 12/31/2016.
 */

public class FriendViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = FriendViewHolder.class.toString();

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;

    @BindView(R.id.tv_name)
    TextView tvName;

    public FriendViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Friend friend) {
        Log.d(TAG, friend.getUrl());
        Picasso.with(this.itemView.getContext()).load(friend.getUrl()).into(ivAvatar);
        tvName.setText(friend.getName());
    }

}
