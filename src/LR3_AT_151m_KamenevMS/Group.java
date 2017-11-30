package LR3_AT_151m_KamenevMS;

public class Group {
  private String groupName;
  private int numbers_stud;

  public String getGroupName() {
    return groupName;
  }

  public int getNumbers_stud() {
    return numbers_stud;
  }

  public String getUniversity() {
    return university;
  }

  public Group(String groupName, int numbers_stud, String university) {

    this.groupName = groupName;
    this.numbers_stud = numbers_stud;
    this.university = university;
  }

  private String university;

}
