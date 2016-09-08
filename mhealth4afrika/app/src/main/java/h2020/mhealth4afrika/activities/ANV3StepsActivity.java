package h2020.mhealth4afrika.activities;

import android.os.Bundle;

import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1ClinicalAssessmentStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1ImmunizationsAndSupplementsStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1MedicalHistoryStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1PregnanciesStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1RegistrationStep;
import h2020.mhealth4afrika.activities.fragments.steps.anv1.ANV1ScreeningStep;

public class ANV3StepsActivity extends BaseStepperActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean linear = false;

        setErrorTimeout(1500);
        setLinear(linear);
        setTitle("Antenatal Visit 3");
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
}


