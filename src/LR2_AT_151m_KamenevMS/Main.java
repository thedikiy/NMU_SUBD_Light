package LR2_AT_151m_KamenevMS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {

  private final static String USAGE = "Usage: java db_url db_username db_password";
  private final static String CREATE_TABLE_QUERY =
          "create table if not exists credit_card ( number VARCHAR(12), bank VARCHAR(32))";
  private final static String INSERT_QUERY = "insert into credit_card values(?, ?)";
  private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) {
    if (args.length < 3) {
      System.out.println(USAGE);
    } else {
      String url = args[0];
      String username = args[1];
      String password = args[2];
      try {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.execute(CREATE_TABLE_QUERY);
        statement.close();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
        boolean exit = false;

        while (!exit) {
          System.out.println("Enter card number and bank name or Q to exit:");

          String input = reader.readLine();
          if (input.equalsIgnoreCase("q")) {
            exit = true;
          }
          String[] params = input.split(" ");
          if (params.length != 2) {
            System.out.println("Invalid input");
            continue;
          }
          String cardName = params[0];
          String bank = params[1];
          preparedStatement.setString(1, cardName);
          preparedStatement.setString(2, bank);
          preparedStatement.execute();

        }

        preparedStatement.close();
        connection.close();

      } catch (Exception e) {
        System.out.println("Can't open connection");
        System.out.println(USAGE);
        e.printStackTrace();
      }
    }
  }
}
