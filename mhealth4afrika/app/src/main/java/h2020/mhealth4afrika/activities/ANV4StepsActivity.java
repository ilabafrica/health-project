package h2020.mhealth4afrika.activities;

import android.os.Bundle;

import h2020.mhealth4afrika.activities.fragments.steps.anv4.ANV4ClinicalAssessmentStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv4.ANV4ImmunizationsAndSupplementsStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv4.ANV4ScreeningStep;

public class ANV4StepsActivity extends BaseStepperActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Antenatal Visit 4");

        addStep(createFragment(new ANV4ClinicalAssessmentStep()));
        addStep(createFragment(new ANV4ScreeningStep()));
        addStep(createFragment(new ANV4ImmunizationsAndSupplementsStep()));

        super.onCreate(savedInstanceState);
    }
}


