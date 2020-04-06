package com.example.mysnitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mysnitch.database.AppRepository;

import java.util.concurrent.ExecutionException;

public class CreateReportActivity extends AppCompatActivity {

    EditText reportTitle;
    EditText reportDiscription;
    EditText licensePlate;

    Button createReport;
    Button backToMenu;

    TextView statusMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_report);
        final AppRepository appRepository = new AppRepository(getApplicationContext());

        reportTitle = findViewById(R.id.reportTitle);
        reportDiscription = findViewById(R.id.reportDiscription);
        licensePlate = findViewById(R.id.reportLicensePlate);
        createReport = findViewById(R.id.createReportButton);
        backToMenu = findViewById(R.id.backToMenu);
        statusMessage = findViewById(R.id.statusMessage);

        createReport.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if( reportTitle.getText().toString().length() > 0 &&
                    reportDiscription.getText().toString().length() > 0 &&
                    licensePlate.getText().toString().length() > 0
                )
                {

                    try {
                        appRepository.insertReport(reportTitle.getText().toString(), reportDiscription.getText().toString(), licensePlate.getText().toString());
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    reportTitle.setText("");
                    reportDiscription.setText("");
                    licensePlate.setText("");
                    //Report.addReport( new Report( reportTitle.getText().toString(), reportDiscription.getText().toString(), licensePlate.getText().toString() ) );
                    statusMessage.setText("Succesfuly created report!");
                }

            }
        });

        backToMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(CreateReportActivity.this, MenuActivity.class));
            }
        });
    }
}
