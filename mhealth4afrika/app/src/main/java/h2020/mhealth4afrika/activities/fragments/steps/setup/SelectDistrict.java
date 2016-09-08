package h2020.mhealth4afrika.activities.fragments.steps.setup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.github.fcannizzaro.materialstepper.AbstractStep;

import h2020.mhealth4afrika.R;

public class SelectDistrict extends AbstractStep {
    private final static String CLICK = "click";
    private Button button;
    private int i = 1;
    ListView languageList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_select_district, container, false);

        if (savedInstanceState != null)
            i = savedInstanceState.getInt(CLICK, 0);

        languageList = (ListView) rootView.findViewById(R.id.simpleListView);


        String[] languages = new String[]{"Eastern Cape", "Free State", "Guateng", "Kwazulu Natal", "Limpopo", "Mpumalanga"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_single_choice, languages);
        languageList.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt(CLICK, i);
    }

    @Override
    public String name() {
        return "Select District";
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
        return "Select District";
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


