package techkids.vn.lab6.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import techkids.vn.lab6.R;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;
import techkids.vn.lab6.viewholders.ToDoViewHolder;

/**
 * Created by Lush on 12/20/2016.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {
    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_to_do, parent, false);
        ToDoViewHolder toDoViewHolder = new ToDoViewHolder(view);
        return toDoViewHolder;
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, int position) {
        holder.bind(ToDoResponseBody.toDoList.get(position));
    }

    @Override
    public int getItemCount() {
        return ToDoResponseBody.toDoList.size();
    }
}
