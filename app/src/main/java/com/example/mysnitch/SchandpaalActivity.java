package com.example.mysnitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SchandpaalActivity extends AppCompatActivity
{
    LinearLayout schandpaalLayout;

    Button backToMenuFromSchandpaal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schandpaal);

        schandpaalLayout = findViewById(R.id.schandpaalLayout);

        backToMenuFromSchandpaal = findViewById(R.id.backToMenuFromSchandpaal);
        backToMenuFromSchandpaal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(SchandpaalActivity.this, MenuActivity.class));
            }
        });

        addContent();
    }

    private void addContent()
    {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT );

        ArrayList<Vehicle> orderedVehicles = orderVehicles( Vehicle.getVehicles() ); // TODO Vehicle.getVehicles() should be loaded from database

        for (int i = 0; i < orderedVehicles.size(); i++)
        {
            TextView reportTitle = new TextView(this);
            reportTitle.setLayoutParams(layoutParams);
            reportTitle.setText(i + ": " + orderedVehicles.get(i).getLicensePlate() + ", " + orderedVehicles.get(i).getTimesReported() + " times");
            reportTitle.setBackgroundColor(0xff_ebebeb);
            reportTitle.setWidth(reportTitle.getMaxWidth());
            schandpaalLayout.addView(reportTitle);
        }
    }

    private ArrayList<Vehicle> orderVehicles( ArrayList<Vehicle> unorderedVehicles )
    {
        // create copy of the vehicle ArrayList so it does not actually remove all vehicles from Vehicle.vehicles
        ArrayList<Vehicle> unorderedVehiclesCopy = new ArrayList<>();
        for( Vehicle vehicle : unorderedVehicles )
            unorderedVehiclesCopy.add(vehicle);

        ArrayList<Vehicle> orderedVehicles = new ArrayList<>();

        while(unorderedVehiclesCopy.size() > 0)
        {
            int indexOfBiggest = 0;
            int biggest = unorderedVehiclesCopy.get(0).getTimesReported();

            for (int i = 0; i < unorderedVehiclesCopy.size(); i++)
            {
                if( unorderedVehiclesCopy.get(i).getTimesReported() > biggest )
                {
                    indexOfBiggest = i;
                    biggest = unorderedVehiclesCopy.get(i).getTimesReported();
                }
            }

            orderedVehicles.add(unorderedVehiclesCopy.get(indexOfBiggest));
            unorderedVehiclesCopy.remove(indexOfBiggest);
        }

        return orderedVehicles;
    }
}
