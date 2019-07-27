package com.myapplicationdev.android.fypcgh;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddPatientDetails extends Fragment {

    public RadioGroup rg1;
    public RadioButton rbNotSigned, rbSigned;
    public EditText etName, etNRIC, etDOB, etContact, etDrugAllergy;
    Calendar calander = Calendar.getInstance();

    int Year = calander.get(Calendar.YEAR);
    int Day = calander.get(Calendar.DAY_OF_MONTH);;
    int Month = calander.get(Calendar.MONTH);;


    int Hour = calander.get(Calendar.HOUR_OF_DAY);
    int Minute = calander.get(Calendar.MINUTE);
    public AddPatientDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_add_patient_details, container, false);

        etName = rootView.findViewById(R.id.etName);
        etNRIC = rootView.findViewById(R.id.etNRIC);
        etContact = rootView.findViewById(R.id.etFamilyContact);
        etDOB = rootView.findViewById(R.id.etAge);
        etDrugAllergy = rootView.findViewById(R.id.etDrugAllergy);

        etDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etDOB.setText("Date: " + dayOfMonth +"/"+(month+1)+"/"+year);
                        Year = year;
                        Month = month;
                        Day = dayOfMonth;
                    }
                };

                DatePickerDialog myDateDialog = new DatePickerDialog(getContext(), myDateListener, Year, Month, Day);
                myDateDialog.show();
//                tvDay.setText(Integer.toString(calculateDay(calander.getTimeInMillis())));
            }
        });

        rg1 = rootView.findViewById(R.id.radioGroup1);
        rbNotSigned = rootView.findViewById(R.id.rbNotSigned);
        rbSigned = rootView.findViewById(R.id.rbSigned);
        rg1.check(R.id.rbSigned);

        return rootView;
    }

}
