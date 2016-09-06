package h2020.mhealth4afrika.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.github.fcannizzaro.materialstepper.style.TabStepper;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1ClinicalAssessmentStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1ImmunizationsAndSupplementsStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1MedicalHistoryStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1PregnanciesStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1RegistrationStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1ScreeningStep;

public class ANV1StepperActivity extends TabStepper {
    private int i = 1;
    private Context context = ANV1StepperActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean linear = false;

        setErrorTimeout(1500);
        setLinear(linear);
        setTitle("Antenatal Visit 1");
        setAlternativeTab(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        addStep(createFragment(new ANV1RegistrationStep()));
        addStep(createFragment(new ANV1MedicalHistoryStep()));
        addStep(createFragment(new ANV1PregnanciesStep()));
        addStep(createFragment(new ANV1ClinicalAssessmentStep()));
        addStep(createFragment(new ANV1ScreeningStep()));
        addStep(createFragment(new ANV1ImmunizationsAndSupplementsStep()));

        super.onCreate(savedInstanceState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Go back?
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private AbstractStep createFragment(AbstractStep fragment) {
        Bundle b = new Bundle();
        b.putInt("position", i++);
        fragment.setArguments(b);
        return fragment;
    }
}


