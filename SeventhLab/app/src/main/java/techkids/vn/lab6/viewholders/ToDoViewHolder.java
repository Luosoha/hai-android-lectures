package techkids.vn.lab6.viewholders;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab6.R;
import techkids.vn.lab6.events.EditNoteEvent;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;

/**
 * Created by Lush on 12/20/2016.
 */

public class ToDoViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = ToDoViewHolder.class.toString();

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.ll_container)
    LinearLayout llContainer;

    public ToDoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(ToDoResponseBody toDoResponseBody) {
        tvTitle.setText(toDoResponseBody.getTitle());
        tvContent.setText(toDoResponseBody.getContent());
//        if(toDoResponseBody.getColor() == null) {
//            Log.d(TAG, "Oh ho");
//            Log.d(TAG, toDoResponseBody.getId());
//        }
//        Log.d(TAG, toDoResponseBody.getColor());
        llContainer.setBackgroundColor(Color.parseColor(toDoResponseBody.getColor()));
    }

}
