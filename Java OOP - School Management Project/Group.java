import java.util.*;
class Group{
  
    private String name;
    private ArrayList<Student> students;
  
    public Group(String name)  {
        this.name = name;
        this.students = new ArrayList<Student>();
    }
    public String getName()  {
        return this.name;
    }
    public ArrayList<Student> getStudents()  {
        return this.students;
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void printStudents(){
        System.out.printf("Group name: %s \n", this.name);
        System.out.println("Students in group:");
        for(Student student : this.students) {
            System.out.printf("Name: %s \n", student.getName());
        }
    }
}
