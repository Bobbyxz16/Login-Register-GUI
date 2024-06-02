package db;

import constants.CommonConstans;

import java.sql.*;

// JDBC - Java Database Connectivity
// This class will be our gateway in accessing our MySQL database
public class MyJDBC {
    // Register new user to the database
    // TRUE - register success
    // FALSE - register failure
    public static boolean register(String username, String password) {
        try {
            // first check if the username already exits in the database
            if (!checkUser(username)) {
                Connection connection = DriverManager.getConnection(CommonConstans.DB_URL,
                        CommonConstans.DB_USERNAME, CommonConstans.DB_PASSWORD);

                // Create insert query
                PreparedStatement insertUser = connection.prepareStatement(
                        "INSERT INTO " + CommonConstans.DB_USERS_TABLE_NAME + "(username, password)" +
                              "VALUES (?, ?)");

                // Insert parameters in the insert query
                insertUser.setString(1, username);
                insertUser.setString(2, password);

                // update database with new user
                insertUser.executeUpdate();

                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }

    public static boolean checkUser(String username) {
        try{
            Connection connection = DriverManager.getConnection(CommonConstans.DB_URL,
                    CommonConstans.DB_USERNAME,CommonConstans.DB_PASSWORD);

            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstans.DB_USERS_TABLE_NAME + " WHERE USERNAME = ? ");

            checkUserExists.setString(1,username);

            ResultSet resultSet = checkUserExists.executeQuery();
            // Check to see if the result set is empty
            // if it is empty it means that there was data row that contains username (i.e user does not exist)
            if (!resultSet.isBeforeFirst()){
                return false;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    // Validate login credentials by checking to see if username/password pair in the database
    public static boolean validateLogin(String username, String password) {
        try{
            Connection connection = DriverManager.getConnection(CommonConstans.DB_URL,
                    CommonConstans.DB_USERNAME,CommonConstans.DB_PASSWORD);

            // Create select query
            PreparedStatement validateUser = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstans.DB_USERS_TABLE_NAME +
                            " WHERE USERNAME = ? AND PASSWORD = ? "
            );

            validateUser.setString(1, username);
            validateUser.setString(2, password);

            ResultSet resultSet = validateUser.executeQuery();

            if (!resultSet.isBeforeFirst()){
                return false;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }
}
