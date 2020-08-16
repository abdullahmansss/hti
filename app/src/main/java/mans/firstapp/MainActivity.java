package mans.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    NumberPicker numberPicker;
    CheckBox chocolateCheck,caramelCheck;
    EditText nameField;
    Button orderBtn;

    int cups = 0, type = 0, chocolate = 0, caramel = 0, result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews()
    {
        numberPicker = findViewById(R.id.number_picker);
        chocolateCheck = findViewById(R.id.chocolate_cb);
        caramelCheck = findViewById(R.id.caramel_cb);
        nameField = findViewById(R.id.name_field);
        orderBtn = findViewById(R.id.order_btn);

        numberPicker.setMaxValue(10);
        numberPicker.setMinValue(0);

        orderBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(chocolateCheck.isChecked())
                {
                    chocolate = 5;
                } else
                    {
                        chocolate = 0;
                    }

                if(caramelCheck.isChecked())
                {
                    caramel = 3;
                } else
                    {
                        caramel = 0;
                    }

                String name = nameField.getText().toString();

                if (name.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }

                cups = numberPicker.getValue();

                String res = name + "\n"
                        + ((chocolate + caramel) * cups) + "\n"
                        + (type * cups);

                Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void selectType(View view)
    {
        RadioButton radioButton = (RadioButton) view;
        boolean checked = radioButton.isChecked();

        switch (view.getId())
        {
            case R.id.french_rb:
                if(checked)
                type = 7;
                break;
            case R.id.turkish_rb:
                if (checked)
                type = 5;
                break;
            case R.id.espresso_rb:
                if (checked)
                type = 10;
                break;
        }
    }
}