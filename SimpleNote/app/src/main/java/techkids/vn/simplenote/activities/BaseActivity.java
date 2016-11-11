package techkids.vn.simplenote.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Lush on 11/11/2016.
 */

public class BaseActivity extends AppCompatActivity {

    public void changeFragment(int resID, Fragment fragment, boolean addToBackStack) {
        // 3: Get FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 4: Start replacing
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 5:
        fragmentTransaction.replace(resID, fragment);

        // 6: (Optional)
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        // 7:
        fragmentTransaction.commit();
    }

}
