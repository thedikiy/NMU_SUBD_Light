package LR3_AT_151m_KamenevMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {

  private final static String USAGE = "Usage: java db_url db_username db_password";
  private final static String[] CREATE_TABLE = new String[]
      {
          "create table if not exists groups ( `group` VARCHAR(6), numbers_stud INTEGER(2), university VARCHAR(30))",
          "create table if not exists student ( `group` VARCHAR(6), stud_second_name VARCHAR(10), age INTEGER(2), birth_date DATE, details VARCHAR(50))",
          "create table if not exists classes ( `group` VARCHAR(6), done_classes VARCHAR(35), not_done_classes VARCHAR(35))"
      };

  private final static String[] INSERT_QUERY = new String[]
      {
          "insert into groups values(?, ?, ?)",
          "insert into student values(?, ?, ?, ?, ?)",
          "insert into classes values(?, ?, ?)"
      };


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
        for (String query: CREATE_TABLE) {
          statement.execute(query);
        }

        statement.close();


        PreparedStatement groupStatement = connection.prepareStatement(INSERT_QUERY[0]);
        PreparedStatement studentStatement= connection.prepareStatement(INSERT_QUERY[1]);
        PreparedStatement classesStatement = connection.prepareStatement(INSERT_QUERY[2]);

        for (int i = 0; i < 10; i++) {
          Group group = Util.getRandomGroup();
          groupStatement.setString(1, group.getGroupName());
          groupStatement.setInt(2, group.getNumbers_stud());
          groupStatement.setString(3, group.getUniversity());
          groupStatement.execute();

          Student student = Util.getRandomStudent();

          studentStatement.setString(1, student.getGroupName());
          studentStatement.setString(2, student.getSecondName());
          studentStatement.setInt(3, student.getAge());
          studentStatement.setDate(4, java.sql.Date.valueOf(student.getBirthDate()));
          studentStatement.setString(5, student.getDetails());
          studentStatement.execute();

          Classes classes = Util.getRandomClass();

          classesStatement.setString(1, classes.getGroupName());
          classesStatement.setString(2, classes.getDoneClases());
          classesStatement.setString(3, classes.getNotDoneClasses());
          classesStatement.execute();

        }


        groupStatement.close();
        studentStatement.close();
        classesStatement.close();
        connection.close();

      } catch (Exception e) {
        System.out.println("Can't open connection");
        System.out.println(USAGE);
        e.printStackTrace();
      }
    }
  }
}


