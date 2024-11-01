package org.project.medibook.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentModel {
  private int id;
  private int doctor_id;
  private int user_id;
  private LocalTime start_time;
  private LocalDate date;
  private String comment;

    public AppointmentModel() {
    }

    public AppointmentModel(int id, int doctor_id, int user_id, LocalTime start_time, LocalDate date, String comment) {
        this.id = id;
        this.doctor_id = doctor_id;
        this.user_id = user_id;
        this.start_time = start_time;
        this.date = date;
        this.comment = comment;
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
