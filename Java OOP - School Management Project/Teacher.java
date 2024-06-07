import java.util.*;

class Teacher {
    private String firstName;
    private String lastName;
    private ArrayList<Group> groups;

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groups = new ArrayList<Group>();
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void printGroups() {
        System.out.printf("Teacher name: %s %s \n", this.firstName, this.lastName);
        System.out.println("Groups of teacher:");
        for (Group group : this.groups) {
            group.printStudents();
        }
    }
}
