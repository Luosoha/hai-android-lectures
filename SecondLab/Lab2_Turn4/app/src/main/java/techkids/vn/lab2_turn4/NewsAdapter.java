package techkids.vn.lab2_turn4;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lush on 11/21/2016.
 */

public class NewsAdapter extends ArrayAdapter<NewsItem> {

    public NewsAdapter(Context context, int resource, List<NewsItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1:
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView = layoutInflater.inflate(R.layout.listview_item_news, parent, false);

        // 2:
        NewsItem newsItem = getItem(position);

        // 3:
        TextView tvContent = (TextView) convertView.findViewById(R.id.tv_news_content);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tv_news_time);
        ImageView ivNews = (ImageView) convertView.findViewById(R.id.iv_news_image);

        // 4:
        if (newsItem != null) {
            tvContent.setText(newsItem.getContent());
            tvTime.setText(newsItem.getTime());
            ivNews.setImageResource(newsItem.getImageResId());
        }

        return convertView;
    }

}
