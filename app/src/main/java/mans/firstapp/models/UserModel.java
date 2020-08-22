package mans.firstapp.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "uu")
public class UserModel
{
    @PrimaryKey(autoGenerate = true)
    public int userId;

    @ColumnInfo(name = "name")
    public String userName;

    @ColumnInfo(name = "email")
    public String userEmail;

    public UserModel(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}