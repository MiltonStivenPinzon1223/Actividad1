package co.edu.ue.actividad1;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity{
    private final String[] correctAnswers = {"b", "c", "c", "c", "b", "d"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
    }

    public void calcularResultado(View view) {

        //Obtener las respuestas seleccionadas por el usuario
        String[] userAnswers = obtainUserAnswers();

        //Calcular el puntaje
        int score = calculateScore(userAnswers);

        //Mostrar el puntaje final
        showResult(score);
    }

    private String[] obtainUserAnswers() {
        // Obtener las respuestas seleccionadas por el usuario y guardarlas en otro array
        String[] answers = new String[6];

        RadioGroup rg1 = findViewById(R.id.rg1);
        answers[0] = selectedAnswer(rg1);
        RadioGroup rg2 = findViewById(R.id.rg2);
        answers[1] = selectedAnswer(rg2);
        RadioGroup rg3 = findViewById(R.id.rg3);
        answers[2] = selectedAnswer(rg3);
        RadioGroup rg4 = findViewById(R.id.rg4);
        answers[3] = selectedAnswer(rg4);
        RadioGroup rg5 = findViewById(R.id.rg5);
        answers[4] = selectedAnswer(rg5);
        RadioGroup rg6 = findViewById(R.id.rg6);
        answers[5] = selectedAnswer(rg6);

        return answers;
    }

    private String selectedAnswer(RadioGroup radioGroup){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        if (radioButton != null) {
            return radioButton.getText().toString().substring(0, 1).toLowerCase();
        }
        return "No se seleccionó ninguna opción";
    }

    private int calculateScore(String[] userAnswers) {
        int score = 0;
        for (int i = 0; i < userAnswers.length; i++) {
            if (correctAnswers[i].equals(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    private void showResult(int score) {
        Toast.makeText(this, "Respuestas correctas: " + score + " de 6", Toast.LENGTH_LONG).show();
    }
}
