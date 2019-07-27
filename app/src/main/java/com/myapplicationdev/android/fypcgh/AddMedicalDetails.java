package com.myapplicationdev.android.fypcgh;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddMedicalDetails extends Fragment {

    public EditText etWard, etBed, etAdmissionDate, etNRIC, etLastMeal, etLastFluid;
    public RadioGroup rg1, rg2, rg3;
    public RadioButton rbSigned, rbNotsigned, rbDone, rbNotDone, radioButtonSigned, radioButtonNotSigned;

    public AddMedicalDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_medical_details, container, false);

        etNRIC = rootView.findViewById(R.id.etNRIC);
        etBed = rootView.findViewById(R.id.etBed);
        etAdmissionDate = rootView.findViewById(R.id.etAdmissionDate);
        etLastMeal = rootView.findViewById(R.id.etLastMeal);
        etLastFluid = rootView.findViewById(R.id.etLastFluid);
        etWard = rootView.findViewById(R.id.etWard);

        rg1 = rootView.findViewById(R.id.radioGroup1);
        rg2 = rootView.findViewById(R.id.radioGroup2);
        rg3 = rootView.findViewById(R.id.radioGroup3);

        rbDone = rootView.findViewById(R.id.radioButtonDone);
        rbNotDone = rootView.findViewById(R.id.radioButtonNotDone);
        rbSigned = rootView.findViewById(R.id.rbSigned);
        rbNotsigned = rootView.findViewById(R.id.rbNotSigned);
        radioButtonSigned = rootView.findViewById(R.id.radioButtonSigned);
        radioButtonNotSigned = rootView.findViewById(R.id.radioButtonNotSigned);

        return rootView;
    }

}
