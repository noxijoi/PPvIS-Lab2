package models;

import java.util.Objects;

public class FIO {
    public String firstName;
    public String lastName;
    public String patronymic;

    public FIO(String firstName, String secondName, String patronymic) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.patronymic = patronymic;
    }

    public FIO(String[] fioStrings) {
        this.firstName = fioStrings[0];
        this.lastName = fioStrings[1];
        this.patronymic = fioStrings[2];
    }

    public FIO() {

    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName + ' ' + patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FIO fio = (FIO) o;
        return Objects.equals(firstName, fio.firstName) &&
                Objects.equals(lastName, fio.lastName) &&
                Objects.equals(patronymic, fio.patronymic);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic);
    }
}
