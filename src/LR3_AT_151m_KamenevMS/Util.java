package LR3_AT_151m_KamenevMS;

import java.util.Date;

public class Util {

  private static class GroupData {

    static String[] groupNames = new String[]{"AT-15", "AG-13", "Akit05"};
    static int[] studentNumber = new int[]{15, 10, 9};
    static String university = "NGU";
  }

  private static class StudentData {

    static String[] groupNames = new String[]{"AT-15", "AG-13", "Akit05"};
    static String[] secondName = new String[]{"Pupkin", "Krutkin", "Sutkin"};
    static int[] age = new int[]{15, 10, 9};
    static String[] details = new String[] {"good student", "talanted student", "bad student"};
  }

  private static class ClassData {

    static String[] groupNames = new String[]{"AT-15", "AG-13", "Akit05"};
    static String[] doneClasses = new String[]{"OOP", "PEP", "STMGV"};
    static String[] notDoneClasses = new String[]{"TAU", "Diploma", "English"};
  }

  public static Group getRandomGroup(){
    return new Group(GroupData.groupNames[getNumber()], GroupData.studentNumber[getNumber()],GroupData.university);
  }

  public static Student getRandomStudent(){
    return new Student(
        StudentData.groupNames[getNumber()],
        StudentData.age[getNumber()],
        StudentData.secondName[getNumber()],
        StudentData.details[getNumber()]
    );
  }

  public static Classes getRandomClass(){
    return new Classes(
        ClassData.groupNames[getNumber()],
        ClassData.doneClasses[getNumber()],
        ClassData.notDoneClasses[getNumber()]
    );
  }

  private static int getNumber(){
    return (int) (Math.random()*3);
  }
}
