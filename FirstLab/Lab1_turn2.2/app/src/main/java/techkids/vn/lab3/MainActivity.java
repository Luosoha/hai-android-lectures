package techkids.vn.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        addListeners();
    }

    private void getReferences() {
        btAddToCart = (Button) findViewById(R.id.bt_add_to_cart);
    }

    private void addListeners() {
        btAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartDialog cartDialog = new CartDialog(MainActivity.this);
                cartDialog.show();
            }
        });
    }
}
