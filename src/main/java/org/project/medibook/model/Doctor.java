package org.project.medibook.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
    private int id;
    private String name;
    private String speciality;
    private String profile_picture;
    private String biography;

    public Doctor() {
    }

    public Doctor(int id, String name, String speciality, String profile_picture, String biography) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.profile_picture = profile_picture;
        this.biography = biography;
    }

    public static Doctor of(ResultSet rs) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setId(rs.getInt("id"));
        doctor.setName(rs.getString("name"));
        doctor.setSpeciality(rs.getString("speciality"));
        doctor.setProfile_picture(rs.getString("image"));
        doctor.setBiography(rs.getString("biography"));
      return doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "DoctorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
