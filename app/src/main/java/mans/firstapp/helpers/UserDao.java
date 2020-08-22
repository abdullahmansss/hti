package mans.firstapp.helpers;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import mans.firstapp.models.UserModel;

@Dao
public interface UserDao
{
    @Query("SELECT * FROM uu")
    List<UserModel> getUsers();

    @Insert
    void createUser(UserModel userModel);
}