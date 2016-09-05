package h2020.mhealth4afrika.activities;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;

import com.kevinomyonga.droidonboarder.DroidOnBoarderActivity;

import java.util.ArrayList;
import java.util.List;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.utils.SessionManager;


public class HelpActivity extends DroidOnBoarderActivity {

    private Context ctx = HelpActivity.this;

    @Override
    protected List<Fragment> populateOnBoarder() {

        // Create slides using the default fragment with the preset parameters
        // You can also add your own custom fragments
        List<Fragment> introSlides = new ArrayList<>();
//        introSlides.add(DroidOnBoarderFragment
//                .newInstance(R.drawable.screen1, this.ctx.getResources().getString(R.string.title1), getResources().getString(R.string.description1), Color.WHITE, Color.WHITE));
//        introSlides.add(DroidOnBoarderFragment
//                .newInstance(R.drawable.screen2, this.ctx.getResources().getString(R.string.title2), getResources().getString(R.string.description2), Color.YELLOW, Color.YELLOW));
//        introSlides.add(DroidOnBoarderFragment
//                .newInstance(R.drawable.screen3, this.ctx.getResources().getString(R.string.title3), getResources().getString(R.string.description3), Color.WHITE, Color.WHITE));
//        introSlides.add(DroidOnBoarderFragment
//                .newInstance(R.drawable.screen4, this.ctx.getResources().getString(R.string.title4), getResources().getString(R.string.description4), Color.RED, Color.RED));

        return introSlides;
    }

    @Override
    protected int setBackgroundColor() {
        return this.ctx.getResources().getColor(R.color.white);
    }

    @Override
    protected int setButtonTextColor() {
        return this.ctx.getResources().getColor(R.color.mid_green);
    }

    @Override
    protected int setIndicatorStrokeColor() {
        return Color.WHITE;
    }

    @Override
    protected int setIndicatorSelectColor() {
        return Color.WHITE;
    }

    @Override
    protected int setIndicatorUnselectColor() {
        return Color.TRANSPARENT;
    }

    @Override
    protected void finishOnBoarding() {
        //Close Activity

        finish();

        if (!SessionManager.isUserAuthenticated(ctx)) {
            Intent intent = new Intent(HelpActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        } else {
            finish();

        }


    }
}
