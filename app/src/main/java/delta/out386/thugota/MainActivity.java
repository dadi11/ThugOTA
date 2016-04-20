package delta.out386.thugota;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import java.util.List;
import android.support.v4.widget.DrawerLayout;
import eu.chainfire.libsuperuser.Shell;
import android.util.Log;

public class MainActivity extends Activity
implements NavigationDrawerFragment.NavigationDrawerCallbacks
{
	final String TAG = Constants.TAG;
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> rrVersion = Shell.SH.run("getprop ro.rr.version");
        if(rrVersion == null || rrVersion.size() == 0) {
            Intent notRrDialog = new Intent(Constants.ACTION_NOT_RR_DIALOG);
            startActivity(new Intent(this, DeltaDialogActivity.class)
               .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        /* Delay needed as the dialog activity needs time to register
          * the broadcast receiver
          */
        try {
            Thread.sleep(90);
        }
        catch(InterruptedException e) {
            Log.e(TAG, e.toString());
        }
            sendBroadcast(notRrDialog);
            onDestroy();
        }

        mNavigationDrawerFragment = (NavigationDrawerFragment)
			getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position)
	{
        // update the main content by replacing fragments
        Fragment fragment=new Fragment();
        switch (position)
        {
            case 0: fragment = BaseFragment.newInstance(position + 1);
				break;
            case 1: fragment = BaseFragment.newInstance(position + 1);
                break;
            case 2: fragment = BaseFragment.newInstance(position + 1);
                break;
            case 3: fragment = BaseFragment.newInstance(position + 1);
                break;
            case 4: fragment = QueueFragment.newInstance(position + 1);
                break;
        }
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
			.replace(R.id.container, fragment)
			.commit();
    }
    @Override
    public void onRequestPermissionsResult(int code, String[] permissions, int[] result) {
        if(result.length > 0 && result[0] == PackageManager.PERMISSION_GRANTED)
        {
            FragmentManager fragmentManager = getFragmentManager();
            BaseFragment fragment = BaseFragment.newInstance(1);
            View mFragmentContainerView = findViewById(R.id.navigation_drawer);
            DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mDrawerLayout.closeDrawer(mFragmentContainerView);
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }
}
