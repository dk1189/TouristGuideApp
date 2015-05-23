package pvc.applikation;

import android.app.*;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Parkzeit_ErfassungActivity extends Activity implements View.OnClickListener{

    private Chronometer chronometer;
    private TextView textView_preis, textView_preis_pro_zeitintervall, textView_parkgebuehren;
    private EditText editText__preis;
    private Spinner spinner_zeitintervall;
    private Button button_start;
    private Timer timer;
    private double endBetrag;
    private double getBetragFromEditText;
    private int spinnerMinuten;
    Integer[] array_minuten_spinner={1,10,15,20,30,60};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parkzeit_erfassung);

        initWidget();
    }

    // Initialisierung von Widgets
    public void initWidget() {
        chronometer = (Chronometer) findViewById(R.id.chronometer_parkzeit);
        chronometer.setFormat("00:%s");
        textView_preis = (TextView) findViewById(R.id.txt_preis);
        textView_preis_pro_zeitintervall = (TextView) findViewById(R.id.txt_preis_pro_zeitintervall);
        textView_parkgebuehren = (TextView) findViewById(R.id.txt_zu_bezahlender_betrag);
        editText__preis = (EditText) findViewById(R.id.editText_preis);
        spinner_zeitintervall = (Spinner) findViewById(R.id.spinner_zeitintervall);
        ArrayAdapter<Integer> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,array_minuten_spinner);
        spinner_zeitintervall.setAdapter(adapter);
        spinner_zeitintervall.setOnItemSelectedListener(new mySpinnerClickListener());
        button_start = (Button) findViewById(R.id.button_start);
        button_start.setOnClickListener(this);
    }

    // OnClickListener
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start:
                getBetragFromEditText=Double.parseDouble(editText__preis.getText().toString());
                chronometer.setBase(SystemClock.elapsedRealtime() + 0);
                chronometer.start();
                if (timer != null) {
                    timer.cancel();
                }
                timer = new Timer();
                timer.schedule(new UpdateTimeTask(), 0, 1000 * (spinnerMinuten *60));
                break;
            default:
                break;
        }
    }

    // Update TimerTask
    public class UpdateTimeTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    endBetrag=endBetrag+getBetragFromEditText;
                    Date date = new Date(SystemClock.elapsedRealtime() - chronometer.getBase());
                    textView_parkgebuehren.setText("Betrag: " + endBetrag);
                }
            });

        }
    }

    public double getBetrag(double preis, int preisProZeitIntervall, Date date) {

        endBetrag = endBetrag == 0 ? preis : endBetrag;
        if (preisProZeitIntervall >= date.getMinutes()) {
            endBetrag = +preis;
        }
        Toast.makeText(this, "EndBetrag: " + endBetrag + " Time: " + date.getMinutes(), Toast.LENGTH_SHORT).show();
        return endBetrag;
    }

    public class mySpinnerClickListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            spinnerMinuten=array_minuten_spinner[position];
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
