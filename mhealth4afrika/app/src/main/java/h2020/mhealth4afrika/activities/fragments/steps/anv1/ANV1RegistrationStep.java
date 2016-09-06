package h2020.mhealth4afrika.activities.fragments.steps.anv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.fcannizzaro.materialstepper.AbstractStep;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.activities.AddNextOfKinActivity;

public class ANV1RegistrationStep extends AbstractStep {
    private final static String CLICK = "click";
    private Button button;
    private int i = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_anv_registration, container, false);

        if (savedInstanceState != null)
            i = savedInstanceState.getInt(CLICK, 0);

        Button btnAddNextOfKin = (Button) rootView.findViewById(R.id.btnAddNextOfKin);
        btnAddNextOfKin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityChangeIntent = new Intent(ANV1RegistrationStep.this.getActivity(), AddNextOfKinActivity.class);
            }
        });

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt(CLICK, i);
    }

    @Override
    public String name() {
        return "Registration";
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
        return "Patient registration";
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


