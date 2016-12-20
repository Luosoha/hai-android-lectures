package techkids.vn.lab6.viewholders;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab6.R;
import techkids.vn.lab6.networks.jsonmodels.ToDoResponseBody;

/**
 * Created by Lush on 12/20/2016.
 */

public class ToDoViewHolder extends RecyclerView.ViewHolder {

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
        llContainer.setBackgroundColor(Color.parseColor(toDoResponseBody.getColor()));
    }
}
