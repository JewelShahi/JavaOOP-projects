import java.util.*;
import java.io.*;

class School {
    private String name;
    private ArrayList<Teacher> teachers;
    private ArrayList<Group> groups;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.teachers = new ArrayList<Teacher>();
        this.groups = new ArrayList<Group>();
        this.students = new ArrayList<Student>();
    }
    public String getName() {
        return name;
    }

    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addGroup(Group group) {
        groups.add(group);
        for(Student student : group.getStudents()) {
            if(!this.students.contains(student)) {
                this.students.add(student);
            }
        }
    }
}
