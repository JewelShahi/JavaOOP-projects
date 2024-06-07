import java.util.*;
import java.io.*;

class Student {
    private String firstName, lastName;

    public Student(String f, String l) {
        this.firstName = f;
        this.lastName = l;
    }

    public String getName() {
        return (this.firstName + " " + this.lastName);
    }
}
