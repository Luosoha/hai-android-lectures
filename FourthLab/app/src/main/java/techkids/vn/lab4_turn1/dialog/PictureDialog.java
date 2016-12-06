package techkids.vn.lab4_turn1.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab4_turn1.R;

/**
 * Created by Lush on 12/6/2016.
 */

public class PictureDialog extends Dialog {

    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;

    @BindView(R.id.iv_company_picture)
    ImageView ivCompanyPicture;

    private String companyName;
    private String companyPictureUrl;

    public PictureDialog(Context context) {
        super(context);
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyPictureUrl(String companyPictureUrl) {
        this.companyPictureUrl = companyPictureUrl;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_picture);
        ButterKnife.bind(this);
        tvCompanyName.setText(companyName);
        Picasso.with(this.getContext()).load(companyPictureUrl).into(ivCompanyPicture);
    }
}
