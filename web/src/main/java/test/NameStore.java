package test;

import java.io.Serializable;

public class NameStore implements Serializable {
    private String firstName;
    private transient String middleName;
    private String lastName;

    public NameStore (String fName, String mName, String lName){
        this.firstName = fName;
        this.middleName = mName;
        this.lastName = lName;
    }

    @Override
    public String toString() {
        return "NameStore{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
