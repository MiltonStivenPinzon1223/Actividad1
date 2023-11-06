package co.edu.ue.actividad1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class AgeCalculator extends AppCompatActivity {
    private EditText etDate;
    private Button buttonCalculate;
    private TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age_calculator);

        etDate = findViewById(R.id.etDate);
        buttonCalculate = findViewById(R.id.btnCalculateAge);
        tvAge = findViewById(R.id.tvAge);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAge();
            }
        });
    }

    private void calculateAge() {
        String dateToString = etDate.getText().toString();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            Date date = dateFormat.parse(dateToString);
            Calendar dob = Calendar.getInstance();
            dob.setTime(date);

            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

            if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }

            String result = "La edad es: " + age + " años";
            tvAge.setText(result);
        } catch (ParseException e) {
            tvAge.setText("Formato incorrecto. Por favor ingresar la fecha de la siguiente manera dd/mm/aaaa");
            e.printStackTrace();
        }
    }

}
