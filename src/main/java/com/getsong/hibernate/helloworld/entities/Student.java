package com.getsong.hibernate.helloworld.entities;

import javax.persistence.*;

/**
 * TODO: Purpose
 *
 * @author TODO: getso
 * @since 10/10/2019 8:23 PM
 */
@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  private String email;

  public Student() {}

  public Student(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
