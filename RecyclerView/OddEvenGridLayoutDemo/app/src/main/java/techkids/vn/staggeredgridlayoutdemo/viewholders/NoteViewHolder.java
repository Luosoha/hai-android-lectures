package techkids.vn.staggeredgridlayoutdemo.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.staggeredgridlayoutdemo.R;
import techkids.vn.staggeredgridlayoutdemo.models.Note;

/**
 * Created by Lush on 12/16/2016.
 */

public class NoteViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.ll_container)
    LinearLayout llContainer;

    public NoteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Note note) {
        tvTitle.setText(note.getTitle());
        tvContent.setText(note.getContent());
        llContainer.setBackgroundColor(note.getColor());
    }

}
