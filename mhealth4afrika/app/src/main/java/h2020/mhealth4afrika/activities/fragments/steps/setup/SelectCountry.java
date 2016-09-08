package h2020.mhealth4afrika.activities.fragments.steps.setup;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.github.fcannizzaro.materialstepper.AbstractStep;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.adapters.CustomAdapterFlags;

public class SelectCountry extends AbstractStep {
    private final static String CLICK = "click";
    private Button button;
    private int i = 1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_select_counrty, container, false);

        ListView simpleList;
        String countryList[] = {"Kenya", "Malawi", "South Africa", "Ethiopia"};
        int flags[] = {R.drawable.australia, R.drawable.australia, R.drawable.australia, R.drawable.australia, R.drawable.australia, R.drawable.australia};


        simpleList = (ListView) rootView.findViewById(R.id.simpleListView);
        CustomAdapterFlags customAdapter = new CustomAdapterFlags(rootView.getContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);



        if (savedInstanceState != null)
            i = savedInstanceState.getInt(CLICK, 0);

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt(CLICK, i);
    }

    @Override
    public String name() {
        return "Select Country";
    }

    @Override
    public boolean isOptional() {
        return true;
    }


    @Override
    public void onStepVisible() {
    }

    @Override
    public void onNext() {
        System.out.println("onNext");
    }

    @Override
    public void onPrevious() {
        System.out.println("onPrevious");
    }

    @Override
    public String optional() {
        return "Select Country";
    }

    @Override
    public boolean nextIf() {
        return i > 1;
    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }
}


