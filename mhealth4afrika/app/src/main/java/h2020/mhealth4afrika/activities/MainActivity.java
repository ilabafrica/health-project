package h2020.mhealth4afrika.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.adapters.CustomAdapter;
import h2020.mhealth4afrika.adapters.ExpandableListAdapter;
import h2020.mhealth4afrika.helpers.WidgetHelper;
import h2020.mhealth4afrika.utils.SessionManager;
import h2020.mhealth4afrika.utils.SnackUtils;

public class MainActivity extends AppCompatActivity implements OnGroupClickListener, OnChildClickListener {


    public static String[] prgmNameList = {"Health Facilities", "ANC Visits", "Patients"};
    public static int[] prgmImages = {R.drawable.ic_launcher2, R.drawable.ic_launcher2, R.drawable.ic_launcher2};
    GridView gridView;
    private CoordinatorLayout rootLayout;

    private WidgetHelper widgets;

    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ExpandableListView mDrawerList;
    private ExpandableListAdapter adapter;
    private int lastExpandedPosition = -1;
    // nav drawer title
    private CharSequence mDrawerTitle;
    // used to store app title
    private CharSequence mTitle;
    private Toolbar toolBar;
    private TypedArray mIcons;

    private Context ctx = MainActivity.this;

    private Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);

        widgets = new WidgetHelper(ctx);

        // load the expandable list data
        prepareListData();

        // set up nav drawer
        setUpNavigationDrawer();

        // update nav drawer
        updateNavDrawer();


        // Display any messages coming from other activities navigating to home
        if (getIntent().hasExtra("message")) {

            String message = getIntent().getStringExtra("message");
            boolean success = getIntent().getBooleanExtra("success", false);
            if (success) {
                SnackUtils.confirm(rootLayout, message);
            } else {
                SnackUtils.alert(rootLayout, message);
            }

        }


        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;

                if (gridView.getItemAtPosition(position).equals(0)) {


                    intent = new Intent(getApplicationContext(), HealthFacilityActivity.class);
                    startActivity(intent);


                } else if (gridView.getItemAtPosition(position).equals(1)) {


                    intent = new Intent(getApplicationContext(), ANV1StepperActivity.class);
                    startActivity(intent);


                } else if (gridView.getItemAtPosition(position).equals(2)) {


                    intent = new Intent(getApplicationContext(), PatientsActivity.class);
                    startActivity(intent);

                }
            }
        });


    }


    /*
 * Preparing the list data
 */
    public void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding header data
        listDataHeader.add(getResources().getString(R.string.profile));


        // Adding child data

        listDataChild.put(listDataHeader.get(0), null);


    }

    public void setUpNavigationDrawer() {

        mTitle = mDrawerTitle = getTitle();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ExpandableListView) findViewById(R.id.left_drawer);
        //mIcons = getResources().obtainTypedArray(R.array.drawer_icons_array);


        if (mDrawerLayout != null) {

            // enabling action bar app icon and behaving it as toggle button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolBar, R.string.app_name, R.string.app_name) {
                public void onDrawerClosed(View view) {
                    super.onDrawerClosed(view);
                    //getSupportActionBar().setTitle(mTitle);
                    // calling onPrepareOptionsMenu() to show action bar icons
                    supportInvalidateOptionsMenu();
                }

                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                    // getSupportActionBar().setTitle(mDrawerTitle);
                    // calling onPrepareOptionsMenu() to hide action bar icons
                    supportInvalidateOptionsMenu();
                }
            };
            //mDrawerToggle.syncState();
            mDrawerLayout.setDrawerListener(mDrawerToggle);

        }

        adapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, mIcons);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnGroupClickListener(this);
        mDrawerList.setOnChildClickListener(this);


        mDrawerList.setOnGroupExpandListener(new OnGroupExpandListener() {

            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
                    mDrawerList.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });
    }

    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long arg4) {

        // Handle child click events

        if (groupPosition == 1) {


        } else if (groupPosition == 2) {


        } else if (groupPosition == 3) {


        }

        return true;
    }

    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

        Intent intent;

        if ((listDataChild.get(listDataHeader.get(groupPosition))) == null) {

            switch (groupPosition) {
                case 0:
                    intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);

                    break;


            }

            return true;
        } else
            return false;
    }


    // update nav drawer{
    public void updateNavDrawer() {
        adapter.notifyDataSetChanged();
    }


    /**
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mDrawerLayout != null) {
            // if nav drawer is opened, hide the action items
            // boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
            // menu.findItem(R.id.action_help).setVisible(!drawerOpen);
            // menu.findItem(R.id.action_about).setVisible(!drawerOpen);
            return true;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the App icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }

        Intent intent = null;
        // Handle action bar actions click
        switch (item.getItemId()) {

            case R.id.action_settings:

                widgets.goToSettingsActivity(ctx, intent);
                return true;

            case R.id.action_help:
                widgets.goToHelpActivity(ctx, intent);
                return true;

            case R.id.action_logout:

                // Prompt user to choose what they wish to do
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle(ctx.getResources().getString(R.string.action_logout));
                builder.setMessage(ctx.getResources().getString(R.string.sure_to_logout));

                builder.setPositiveButton(ctx.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Logout
                        dialog.dismiss();
                        // logout of session
                        SessionManager.clearSessionUser(ctx);
                        SessionManager.setUserLoggedOut(ctx);

                        // Move to Login Activity
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                        finish();
                    }
                });

                builder.setNegativeButton(ctx.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.create().show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

	/*
     * protected void onDestroy(){ super.onDestroy(); }
	 */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        if (mDrawerLayout != null) {
            mDrawerToggle.syncState();
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mDrawerLayout != null) {
            // Pass any configuration change to the drawer toggles
            mDrawerToggle.onConfigurationChanged(newConfig);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void loadLocale() {
        String language = SessionManager.getLanguage(ctx);
        changeLang(language);
    }

    public void changeLang(String language) {
        if (language.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(language);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

    }

}