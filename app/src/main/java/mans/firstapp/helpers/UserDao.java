package mans.firstapp.helpers;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import mans.firstapp.models.UserModel;

@Dao
public interface UserDao
{
    @Query("SELECT * FROM uu")
    List<UserModel> getUsers();

    @Insert
    void createUser(UserModel userModel);

    @Delete
    void deleteUser(UserModel userModel);

    @Update
    void updateUser(UserModel userModel);
}