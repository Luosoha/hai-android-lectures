package techkids.vn.music.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import techkids.vn.music.R;
import techkids.vn.music.networks.json_models.Song;

/**
 * Created by Lush on 1/10/2017.
 */

public class TopSongViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.civ_top_song)
    CircleImageView civTopSong;

    @BindView(R.id.tv_top_song_name)
    TextView tvTopSongName;

    @BindView(R.id.tv_top_song_artist)
    TextView tvTopSongArtist;

    public TopSongViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Song song) {
        tvTopSongName.setText(song.getName());
        tvTopSongArtist.setText(song.getArtist());
        Picasso.with(this.itemView.getContext()).load(song.getImageUrl()).into(civTopSong);
    }

}
