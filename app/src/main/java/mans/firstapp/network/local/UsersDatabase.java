package mans.firstapp.network.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import mans.firstapp.helpers.UserDao;
import mans.firstapp.models.UserModel;

@Database(entities = {UserModel.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase
{
    public abstract UserDao userDao();
}