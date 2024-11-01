package org.project.medibook.model;

public class DoctorModel {
    private int id;
    private String name;
    private String speciality;
    private String profile_picture;
    private String biography;

    public DoctorModel() {
    }

    public DoctorModel(int id, String name, String speciality, String profile_picture, String biography) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.profile_picture = profile_picture;
        this.biography = biography;
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
