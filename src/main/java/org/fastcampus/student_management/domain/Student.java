package org.fastcampus.student_management.domain;

public class Student {

  private final String name;
  private final int age;
  private final String address;
  private boolean activated;

  public Student(String name, int age, String address) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("이름은 필수 입력값입니다.");
    }

    this.name = name;
    this.age = age;
    this.address = address;
    this.activated = true;
  }

  /**
   * setActivated가 안티 패턴인 이유
   * 1. setter는 캡슐화를 떨어뜨리기 때문에 권장되지 않는다. (dto 외에는 setter 사용을 지양해야 한다.)
   * 2. 코드의 가독성이 떨어지기 때문에 유즈케이스가 코드 내에서도 불분명해지며 안정성이 떨어진다.
   */
  /*public void setActivated(boolean activated) {
    if (activated && this.activated) {
      throw new IllegalArgumentException();
    }

    if (!activated && !this.activated) {
      throw new IllegalArgumentException();
    }

    this.activated = activated;
  }*/

  /**
   * 정확하게 어떤 동작을 할지 메서드 명으로 알 수 있기 때문에 가독성이 좋아진다.
   */
  public void activate(){
    if (this.activated) {
      throw new IllegalArgumentException();
    }
    this.activated = true;
  }

  public void deactivate(){
    if (!this.activated) {
      throw new IllegalArgumentException();
    }
    this.activated = false;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }
  public boolean isActivate() {
    return activated;
  }
}
