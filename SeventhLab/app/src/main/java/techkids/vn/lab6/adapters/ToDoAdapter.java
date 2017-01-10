package techkids.vn.lab6.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import techkids.vn.lab6.R;
import techkids.vn.lab6.events.EditNoteEvent;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;
import techkids.vn.lab6.viewholders.ToDoViewHolder;

/**
 * Created by Lush on 12/20/2016.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {
    private static final String TAG = ToDoAdapter.class.toString();

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_to_do, parent, false);
        ToDoViewHolder toDoViewHolder = new ToDoViewHolder(view);
        return toDoViewHolder;
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, int position) {
        final int viewPosition = position;
        holder.bind(ToDoResponseBody.toDoList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, ToDoResponseBody.toDoList.get(viewPosition) + "onClick");
                EventBus.getDefault().post(new EditNoteEvent(ToDoResponseBody.toDoList.get(viewPosition)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return ToDoResponseBody.toDoList.size();
    }

}
