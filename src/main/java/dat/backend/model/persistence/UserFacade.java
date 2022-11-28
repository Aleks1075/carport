package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

public class UserFacade
{
    public static User login(String name, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.login(name, password, connectionPool);
    }

    public static User createUser(String name, String password, String role, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.createUser(name, password, role, connectionPool);
    }
}
