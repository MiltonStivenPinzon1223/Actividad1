package co.edu.ue.actividad1;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class IMCCalculator extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularIMCIngles(View view) {
        EditText etHeightIn = findViewById(R.id.etHeightIn);
        EditText etWeightPd = findViewById(R.id.etWeightPd);
        TextView tvResult = findViewById(R.id.tvResultEnglish);

        // Convertir a valores numéricos
        double heightInches = Double.parseDouble(etHeightIn.getText().toString());
        double weightPounds = Double.parseDouble(etWeightPd.getText().toString());

        // Calcular el IMC
        double bmi = calculateBMIImperial(heightInches, weightPounds);

        // Mostrar el resultado
        displayResult(tvResult, bmi);
    }

    public void calcularIMCMetrico(View view) {
        EditText editTextHeightCm = findViewById(R.id.etHeightIn);
        EditText editTextWeightKg = findViewById(R.id.etWeightKg);
        TextView textViewResultMetrico = findViewById(R.id.tvResultMetric);

        // Convertir a valores numéricos
        double heightCm = Double.parseDouble(editTextHeightCm.getText().toString());
        double weightKg = Double.parseDouble(editTextWeightKg.getText().toString());

        // Calcular el IMC
        double bmi = calculateBMIMetric(heightCm, weightKg);

        // Mostrar el resultado
        displayResult(textViewResultMetrico, bmi);
    }

    private double calculateBMIImperial(double heightInches, double weightPounds) {
        return (weightPounds / (heightInches * heightInches)) * 703;
    }

    private double calculateBMIMetric(double heightCm, double weightKg) {
        return weightKg / ((heightCm / 100) * (heightCm / 100));
    }

    private void displayResult(TextView textView, double bmi) {
        String result;

        if (bmi < 18.5) {
            result = "Peso inferior al normal: Menos de 18.5";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            result = "Normal: 18.5 - 24.9";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            result = "Peso superior al normal: 25.0 - 29.9";
        } else {
            result = "Obesidad: Más de 30.0";
        }

        textView.setText("Resultado: " + result);
    }
}
