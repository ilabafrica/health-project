package h2020.mhealth4afrika.activities;

import android.os.Bundle;

import h2020.mhealth4afrika.activities.fragments.steps.anv3.ANV3ClinicalAssessmentStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv3.ANV3ImmunizationsAndSupplementsStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv3.ANV3ScreeningStep;

public class ANV3StepsActivity extends BaseStepperActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Antenatal Visit 3");

        addStep(createFragment(new ANV3ClinicalAssessmentStep()));
        addStep(createFragment(new ANV3ScreeningStep()));
        addStep(createFragment(new ANV3ImmunizationsAndSupplementsStep()));

        super.onCreate(savedInstanceState);
    }
}


