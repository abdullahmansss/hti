package mans.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mans.firstapp.models.UserModel;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    List<UserModel> userModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews()
    {
        recyclerView = findViewById(R.id.user_recycler);

        userModelList.add(new UserModel("Ahmed", "Ahmed@gmail.com", "01115342559"));
        userModelList.add(new UserModel("Ali", "Ahmed@gmail.com", "453453453"));
        userModelList.add(new UserModel("Muhammed", "Ahmed@gmail.com", "45345345"));
        userModelList.add(new UserModel("Abdullah", "Ahmed@gmail.com", "8983453"));
        userModelList.add(new UserModel("Abdo", "Ahmed@gmail.com", "37883453"));
        userModelList.add(new UserModel("Mansour", "Ahmed@gmail.com", "8764531"));
        userModelList.add(new UserModel("Ahmed", "Ahmed@gmail.com", "05243453"));
        userModelList.add(new UserModel("Ali", "Ahmed@gmail.com", "9783543"));
        userModelList.add(new UserModel("Muhammed", "Ahmed@gmail.com", "453783453"));
        userModelList.add(new UserModel("Abdullah", "Ahmed@gmail.com", "783453453"));
        userModelList.add(new UserModel("Abdo", "Ahmed@gmail.com", "01115342559"));
        userModelList.add(new UserModel("Mansour", "Ahmed@gmail.com", "01115342559"));
        userModelList.add(new UserModel("Ahmed", "Ahmed@gmail.com", "01115342559"));
        userModelList.add(new UserModel("Ali", "Ahmed@gmail.com", "01115342559"));

        recyclerView.setAdapter(new UsersAdapter(userModelList));
    }

    class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder>
    {
        List<UserModel> list;

        public UsersAdapter(List<UserModel> list)
        {
            this.list = list;
        }

        @NonNull
        @Override
        public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            // get recycler view item
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.user_item, parent, false);
            return new UsersViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull UsersViewHolder holder, int position)
        {
            final UserModel userModel = list.get(position);

            String name = userModel.getName();
            String email = userModel.getEmail();

            holder.nameText.setText(name);
            holder.emailText.setText(email);

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                    intent.putExtra("user", userModel);
                    startActivity(intent);
                }
            });

            if (position == list.size() - 1)
            {
                holder.divider.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount()
        {
            return list.size();
        }
    }

    class UsersViewHolder extends RecyclerView.ViewHolder
    {
        TextView nameText,emailText;
        View divider;

        public UsersViewHolder(@NonNull View itemView)
        {
            super(itemView);

            nameText = itemView.findViewById(R.id.user_name_text);
            emailText = itemView.findViewById(R.id.user_email_text);
            divider = itemView.findViewById(R.id.divider_view);
        }
    }
}