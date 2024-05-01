package com.example.cab302_project_mood_tracker.Model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqliteAccountDAO implements IAccountDAO {
    private final Connection connection;

    public SqliteAccountDAO() {
        connection = SqliteConnection.getInstance();
        createTable();
        //insertSampleData();
    }

    private void insertSampleData() {
        try {
            // Clear before inserting
            Statement clearStatement = connection.createStatement();
            String clearQuery = "DELETE FROM accounts";
            clearStatement.execute(clearQuery);
            Statement insertStatement = connection.createStatement();
            String insertQuery = "INSERT INTO accounts (firstName, lastName, phone, email) VALUES "
                    + "('John', 'Doe', '0423423423', 'johndoe@example.com'),"
                    + "('Jane', 'Doe', '0423423424', 'janedoe@example.com'),"
                    + "('Jay', 'Doe', '0423423425', 'jaydoe@example.com')";
            insertStatement.execute(insertQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        // Create table if not exists
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS accounts ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "firstName VARCHAR NOT NULL,"
                    + "lastName VARCHAR NOT NULL,"
                    + "phone VARCHAR NOT NULL,"
                    + "email VARCHAR NOT NULL"
                    + ")";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(Account account) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts (firstName, lastName, phone, email) VALUES (?, ?, ?, ?)");
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setString(3, account.getPhone());
            statement.setString(4, account.getEmail());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET firstName = ?, lastName = ?, phone = ?, email = ? WHERE id = ?");
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setString(3, account.getPhone());
            statement.setString(4, account.getEmail());
            statement.setInt(5, account.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Account account) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM accounts WHERE id = ?");
            statement.setInt(1, account.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccount(int id) {
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM accounts";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Account contact = new Account(firstName, lastName, phone, email);
                contact.setId(id);
                accounts.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}