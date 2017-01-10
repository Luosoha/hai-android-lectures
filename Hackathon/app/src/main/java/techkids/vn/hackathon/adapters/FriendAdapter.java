package techkids.vn.hackathon.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import techkids.vn.hackathon.R;
import techkids.vn.hackathon.models.Friend;
import techkids.vn.hackathon.viewholders.FriendViewHolder;

/**
 * Created by Lush on 12/31/2016.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendViewHolder> {
    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType) {
            case 0:
                view = layoutInflater.inflate(R.layout.item_friend_left, parent, false);
                break;
            case 1:
                view = layoutInflater.inflate(R.layout.item_friend_right, parent, false);
                break;
        }
        FriendViewHolder companyViewHolder = new FriendViewHolder(view);
        return companyViewHolder;
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, int position) {
        holder.bind(Friend.FRIENDS[position]);
    }

    @Override
    public int getItemCount() {
        return Friend.FRIENDS.length;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

}
