package mans.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import mans.firstapp.models.UserModel;

public class DetailsActivity extends AppCompatActivity
{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initViews();
    }

    private void initViews()
    {
        textView = findViewById(R.id.number_text);

        UserModel userModel = (UserModel) getIntent().getSerializableExtra("user");

        textView.setText(userModel.getNumber());
    }
}