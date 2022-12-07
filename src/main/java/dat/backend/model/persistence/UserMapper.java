package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper
{
    static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String role = rs.getString("role");
                    int postcode = rs.getInt("postcode");
                    int phoneNumber = rs.getInt("phone_number");
                    user = new User(username, email, password, address, role, postcode, phoneNumber);
                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }


    public static User createUser(String username, String email, String password, String address, String role, int postcode, int phoneNumber, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "INSERT INTO user (username, email, password, address, role, postcode, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, address);
                ps.setString(5, role);
                ps.setInt(6, postcode);
                ps.setInt(7, phoneNumber);
                ps.executeUpdate();
                user = new User(username, email, password, address, role, postcode, phoneNumber);
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error creating user. Something went wrong with the database");
        }
        return user;
    }

    public static List<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String address = rs.getString("address");
                    String role = rs.getString("role");
                    int postcode = rs.getInt("postcode");
                    int phoneNumber = rs.getInt("phone_number");
                    User user = new User(username, email, password, address, role, postcode, phoneNumber);
                    users.add(user);
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error getting all users. Something went wrong with the database");
        }
        return users;
    }
}
