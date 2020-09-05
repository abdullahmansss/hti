package mans.firstapp.models;

import java.util.List;

public class RemoteModel
{
    List<UserDetails> users;

    class UserDetails
    {
        String name;
        String email;
        int phone;
    }
}