class Main {
    public static void main(String[] args) {
        School school = new School("Свобода");
        SchoolTest t = new SchoolTest();

t.addObjectsToSchool(school);
        for (Teacher teacher : school.getTeachers()) {
            teacher.printGroups();
            System.out.println();
        }
    }
}
