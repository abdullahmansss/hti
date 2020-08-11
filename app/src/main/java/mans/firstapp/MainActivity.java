package mans.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView resultText;
    Button btnAddition,btnSubtraction,btnResult;
    int first,second;
    char op;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews()
    {
        resultText = findViewById(R.id.result_text);
        btnAddition = findViewById(R.id.addition_btn);
        btnSubtraction = findViewById(R.id.subtraction_btn);
        btnResult = findViewById(R.id.result_btn);
    }

    public void change(View view)
    {
        Button b = (Button) view;
        resultText.append(b.getText().toString());
    }

    public void operator(View view)
    {
        Button button = (Button) view;

        switch (button.getText().toString())
        {
            case "+":
                first = Integer.valueOf(resultText.getText().toString());
                resultText.setText("");
                op = '+';
                break;
            case "-":
                first = Integer.valueOf(resultText.getText().toString());
                resultText.setText("");
                op = '-';
                break;
            case "=":
                second = Integer.valueOf(resultText.getText().toString());
                operation(first, second, op);
                break;
        }
    }

    public void operation(int f, int s, char op)
    {
        switch (op)
        {
            case '+':
                resultText.setText(f + s + "");
                break;
            case '-':
                resultText.setText(f - s + "");
                break;
        }
    }

    public void newOperation(View view)
    {
        resultText.setText("");
        first = 0;
        second = 0;
    }
}