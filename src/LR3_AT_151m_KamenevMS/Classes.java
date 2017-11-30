package LR3_AT_151m_KamenevMS;

public class Classes {

  private String groupName;
  private String doneClases;
  private String notDoneClasses;

  public Classes(String groupName, String doneClases, String notDoneClasses) {
    this.groupName = groupName;
    this.doneClases = doneClases;
    this.notDoneClasses = notDoneClasses;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getDoneClases() {
    return doneClases;
  }

  public String getNotDoneClasses() {
    return notDoneClasses;
  }
}