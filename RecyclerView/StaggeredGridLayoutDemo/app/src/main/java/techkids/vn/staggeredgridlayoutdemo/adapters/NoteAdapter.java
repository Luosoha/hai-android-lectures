package techkids.vn.staggeredgridlayoutdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import techkids.vn.staggeredgridlayoutdemo.R;
import techkids.vn.staggeredgridlayoutdemo.models.Note;
import techkids.vn.staggeredgridlayoutdemo.viewholders.NoteViewHolder;

import static techkids.vn.staggeredgridlayoutdemo.models.Note.NOTES;

/**
 * Created by Lush on 12/16/2016.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_note, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(view);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.bind(NOTES[position]);
    }

    @Override
    public int getItemCount() {
        return Note.NOTES.length;
    }

}
