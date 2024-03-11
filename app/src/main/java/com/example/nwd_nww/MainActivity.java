package com.example.nwd_nww;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // objects references
    Button btn_nwd ;
    Button btn_nww ;

    // input fields
    TextView txt_a ;
    TextView txt_b ;

    // result
    TextView txt_out ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // objects references
        btn_nwd = findViewById(R.id.btn_nwd);
        btn_nww = findViewById(R.id.btn_nww);
        txt_a = findViewById(R.id.txt_a);
        txt_b = findViewById(R.id.txt_b);
        txt_out = findViewById(R.id.txt_out);

        // listener, btn_nwd = com.example.nwd_nww.MainActivity.NWD; btn_nww = com.example.nwd_nww.MainActivity.NWW
        btn_nwd.setOnClickListener(v -> {
            if ( chceckType(txt_a.getText().toString(), txt_b.getText().toString()) ) {
                int a = Integer.parseInt(txt_a.getText().toString());
                int b = Integer.parseInt(txt_b.getText().toString());
                txt_out.setText("NWD(" + a + ", " + b + ") = " + NWD.nwd(a, b));
            }
        });

        btn_nww.setOnClickListener(v -> {
            if ( chceckType(txt_a.getText().toString(), txt_b.getText().toString()) ) {
                int a = Integer.parseInt(txt_a.getText().toString());
                int b = Integer.parseInt(txt_b.getText().toString());
                txt_out.setText("NWW(" + a + ", " + b + ") = " + NWW.nww(a, b));
            }
        });

    }

    protected boolean chceckType(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            txt_out.setText("Wprowadź obie liczby");
            return false;
        } else {
            try {
                Integer.parseInt(a);
                Integer.parseInt(b);
                return true;
            } catch (NumberFormatException e) {
                txt_out.setText("Wprowadź liczby całkowite");
                return false;
            }
        }
    }

    public static class NWW {
        public static int nww(int a, int b) {
            return a * b / NWD.nwd(a, b);
        }
    }

    public static class NWD {
        public static int nwd(int a, int b) {
            while (a != b) {
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }
            return a;
        }
    }
}