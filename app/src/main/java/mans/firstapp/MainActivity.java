package mans.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import mans.firstapp.models.UserModel;
import mans.firstapp.network.local.UsersDatabase;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    EditText nameField, emailField;
    FloatingActionButton floatingActionButton;
    UsersDatabase usersDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews()
    {
        floatingActionButton = findViewById(R.id.add_user_fab);
        recyclerView = findViewById(R.id.users_recycler);
        nameField = findViewById(R.id.name_field);
        emailField = findViewById(R.id.email_field);

        usersDatabase = Room.databaseBuilder(getApplicationContext(), UsersDatabase.class, "users").build();

        new GetAllUsers().execute();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                String email = emailField.getText().toString();

                if(name.isEmpty() || email.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "invalid data", Toast.LENGTH_SHORT).show();
                    return;
                }

                UserModel userModel = new UserModel(name, email);

                new InsertUser().execute(userModel);
            }
        });
    }

    class GetAllUsers extends AsyncTask<Void, Void, List<UserModel>>
    {
        List<UserModel> userModelList = new ArrayList<>();

        @Override
        protected List<UserModel> doInBackground(Void... voids)
        {
            userModelList = usersDatabase.userDao().getUsers();
            return userModelList;
        }

        @Override
        protected void onPostExecute(List<UserModel> userModels)
        {
            super.onPostExecute(userModels);

            recyclerView.setAdapter(new UsersAdapter(userModels));
        }
    }

    class InsertUser extends AsyncTask<UserModel, Void, Void>
    {
        @Override
        protected Void doInBackground(UserModel... userModels)
        {
            usersDatabase.userDao().createUser(userModels[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);

            new GetAllUsers().execute();
        }
    }

    class UsersAdapter extends RecyclerView.Adapter<UsersVH>
    {
        List<UserModel> userModels;

        public UsersAdapter(List<UserModel> userModels) {
            this.userModels = userModels;
        }

        @NonNull
        @Override
        public UsersVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.user_item, parent, false);
            return new UsersVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull UsersVH holder, int position)
        {
            UserModel userModel = userModels.get(position);

            String name = userModel.getUserName();
            String email = userModel.getUserEmail();
            String id = String.valueOf(userModel.getUserId());

            holder.nameText.setText(id + " " + name);
            holder.emailText.setText(email);
        }

        @Override
        public int getItemCount() {
            return userModels.size();
        }
    }

    class UsersVH extends RecyclerView.ViewHolder
    {
        TextView emailText, nameText;

        public UsersVH(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.user_name_text);
            emailText = itemView.findViewById(R.id.user_email_text);
        }
    }
}