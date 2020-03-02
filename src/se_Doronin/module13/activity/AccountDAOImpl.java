package se_Doronin.module13.activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    @SuppressWarnings("unused")
    private Connection conn;

    public AccountDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public List<Account> findAccount(String firstName, String lastName)
            throws AccountDAOException {
        List<Account> list = new ArrayList<>();
        try {
            String SQL_QUERY = "select * from Account where FIRST_NAME LIKE %s AND LAST_NAME LIKE %s";
            String sql = String.format(SQL_QUERY, "'"+ firstName + "%" + "'", "'"+lastName + "%"+ "'");
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //Retrieve by column name
                Account account = new AccountImpl(resultSet.getInt("ID"), resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"), resultSet.getString("E_MAIL"));
                list.add(account);
            }
            statement.close();
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

	public  Account findAccount(int id) throws AccountDAOException {
		Account account = null;
		try {
			PreparedStatement preparedStatement
					= conn.prepareStatement("select * from Account where ID = ?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			    account = new AccountImpl(resultSet.getInt("ID"), resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"), resultSet.getString("E_MAIL"));

			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}


    public boolean insertAccount(String firstName, String lastName, String email)
            throws AccountDAOException {
        try {
            PreparedStatement preparedStatement
                    = conn.prepareStatement("insert into Account (ID, FIRST_NAME, LAST_NAME, E_MAIL) VALUES (ACCOUNT_SEQ.NEXTVAL, ?,?,?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.commit();
            conn.close();

            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
