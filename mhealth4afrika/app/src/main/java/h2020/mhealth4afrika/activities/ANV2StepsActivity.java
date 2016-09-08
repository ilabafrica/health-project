package h2020.mhealth4afrika.activities;

import android.os.Bundle;

import h2020.mhealth4afrika.activities.fragments.steps.anv2.ANV2ClinicalAssessmentStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv2.ANV2ImmunizationsAndSupplementsStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv2.ANV2ScreeningStep;

public class ANV2StepsActivity extends BaseStepperActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Antenatal Visit 2");

        addStep(createFragment(new ANV2ClinicalAssessmentStep()));
        addStep(createFragment(new ANV2ScreeningStep()));
        addStep(createFragment(new ANV2ImmunizationsAndSupplementsStep()));

        super.onCreate(savedInstanceState);
    }
}


