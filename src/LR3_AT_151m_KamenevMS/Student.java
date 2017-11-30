package LR3_AT_151m_KamenevMS;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Student {

  private String groupName;
  private int age;
  private String secondName;
  private LocalDate birthDate;
  private String details;

  public Student(String groupName, int age, String secondName, String details) {
    this.groupName = groupName;
    this.age = age;
    this.secondName = secondName;
    this.birthDate = getDate();
    this.details = details;
  }

  public String getGroupName() {
    return groupName;
  }

  public int getAge() {
    return age;
  }

  public String getSecondName() {
    return secondName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public String getDetails() {
    return details;
  }

  public static LocalDate getDate() {
    long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
    long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
    return LocalDate.ofEpochDay(randomDay);
  }

}
