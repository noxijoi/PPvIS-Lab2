package models;

import java.util.Objects;

public class FIO {
    public String firstName;
    public String secondName;
    public String patronymic;

    public FIO(String firstName, String secondName, String patronymic) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return firstName + ' ' + secondName + ' ' + patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FIO fio = (FIO) o;
        return Objects.equals(firstName, fio.firstName) &&
                Objects.equals(secondName, fio.secondName) &&
                Objects.equals(patronymic, fio.patronymic);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, patronymic);
    }
}
