package droids.rizz.calculator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import droids.rizz.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    // Used to load the 'calculate' library on application startup.
    static {
        System.loadLibrary("calculate");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setUp();

    }

    private void setUp() {
        mainBinding.result.setText(getString());
        mainBinding.addBtn.setOnClickListener(v -> {
            if (mainBinding.num1.getText().toString().equals("") || mainBinding.num2.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Plase enter numbers to add", Toast.LENGTH_SHORT).show();
            } else {
                int num1 = Integer.parseInt(mainBinding.num1.getText().toString());
                int num2 = Integer.parseInt(mainBinding.num2.getText().toString());
                mainBinding.result.setText("Addition:" + addNumbers(num1, num2));
            }
        });
    }

    //these methods are coming from native calculate.cpp file
    public static native int addNumbers(int a, int b);

    private native String getString();


}
