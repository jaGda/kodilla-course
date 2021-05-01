package com.kodilla.good.patterns.challenges;

public class User {

    private final String name;
    private final String surname;
    private Long userID;

    public User(String name, String surname, Long userID) {
        this.name = name;
        this.surname = surname;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getUserID() {
        return userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(user.getSurname()) : user.getSurname() != null) return false;
        return getUserID() != null ? getUserID().equals(user.getUserID()) : user.getUserID() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getUserID() != null ? getUserID().hashCode() : 0);
        return result;
    }

}
