package ru.marinin.people;

public class FullName {
    final String firstName;
    final String lastName;
    final String patronymic;

    public FullName(String firstName) {
        this(firstName, "", "");
    }
    public FullName(String firstName, String lastName ) {
        this(firstName, "", lastName);
    }
    public FullName(String firstName, String patronymic, String lastName ) {
        boolean check = !firstName.isEmpty() || !patronymic.isEmpty() || !lastName.isEmpty();
        if (check) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.patronymic = patronymic;
        } else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public String toString() {
        String result = "";
        if (lastName!=null && !lastName.isEmpty()) result += lastName + " ";
        if (firstName!=null && !firstName.isEmpty()) result += firstName + " ";
        if (patronymic!=null && !patronymic.isEmpty()) result += patronymic + " ";
        return result.trim();

    }
}

