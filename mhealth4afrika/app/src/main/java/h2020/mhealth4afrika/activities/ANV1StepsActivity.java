package h2020.mhealth4afrika.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

public class ANV1StepsActivity extends BaseStepperActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean linear = false;

        setErrorTimeout(1500);
        setLinear(linear);
        setTitle("Antenatal Visit");
        setAlternativeTab(false);
        setStartPreviousButton();
        setPreviousVisible();

        addStep(createFragment(new ANV1RegistrationStep()));
        addStep(createFragment(new ANV1MedicalHistoryStep()));
        addStep(createFragment(new ANV1PregnanciesStep()));
        addStep(createFragment(new ANV1ClinicalAssessmentStep()));
        addStep(createFragment(new ANV1ScreeningStep()));
        addStep(createFragment(new ANV1ImmunizationsAndSupplementsStep()));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        super.onCreate(savedInstanceState);
    }
}


