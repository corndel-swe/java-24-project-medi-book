package org.project.medibook.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
  private int id;
  private int doctor_id;
  private int user_id;
  private LocalTime start_time;
  private LocalDate date;
  private String comment;
  private String doctor_name;
  private String display_date;

  public Appointment() {
  }

  public Appointment(int id, int doctor_id, int user_id, LocalTime start_time, LocalDate date, String comment) {
    this.id = id;
    this.doctor_id = doctor_id;
    this.user_id = user_id;
    this.start_time = start_time;
    this.date = date;
    this.comment = comment;
  }

  public static Appointment of(ResultSet rs) throws SQLException {
    Appointment appointment = new Appointment();
    appointment.setId(rs.getInt("id"));
    appointment.setUser_id(rs.getInt("user_id"));
    appointment.setDoctor_id(rs.getInt("doctor_id"));
    appointment.setStart_time(LocalTime.parse(rs.getString("start_time")));
    appointment.setDate(LocalDate.parse(rs.getString("date")));
    appointment.setComment(rs.getString("comment"));
    appointment.setDoctor_name(rs.getString("name"));
    appointment.setDisplay_date(LocalDate.parse(rs.getString("date")));
    return appointment;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDoctor_id() {
    return doctor_id;
  }

  public void setDoctor_id(int doctor_id) {
    this.doctor_id = doctor_id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public LocalTime getStart_time() {
    return start_time;
  }

  public void setStart_time(LocalTime start_time) {
    this.start_time = start_time;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDoctor_name() {
    return doctor_name;
  }

  public void setDoctor_name(String doctor_name) {
    this.doctor_name = doctor_name;
  }

  public String getDisplay_date() {
    return display_date;
  }

  public void setDisplay_date(LocalDate date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy");
    this.display_date = date.format(formatter);
  }

  @Override
  public String toString() {
    return "AppointmentModel{" +
        "id=" + id +
        ", doctor_id=" + doctor_id +
        ", user_id=" + user_id +
        ", start_time=" + start_time +
        ", date=" + date +
        ", comment='" + comment + '\'' +
        '}';
  }
}
