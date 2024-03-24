package org.example.ExceptionsFinalTask.Core.Model;

import java.util.Objects;

public class User {
    private String surname;
    private String name;
    private String patronymic;
    private String dateOfBirth;
    private long phoneNumber;
    private String gender;

    public User(String surname, String name, String patronymic, String dateOfBirth, long phoneNumber, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public User() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("<%s> <%s> <%s> <%s> <%s> <%s>", surname, name, patronymic, dateOfBirth, phoneNumber, gender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phoneNumber == user.phoneNumber && Objects.equals(surname, user.surname) && Objects.equals(name, user.name) && Objects.equals(patronymic, user.patronymic) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(gender, user.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, dateOfBirth, phoneNumber, gender);
    }
}
