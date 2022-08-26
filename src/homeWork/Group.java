package homeWork;

import java.util.*;

public class Group {
    private String groupName;

    private List <Student> students = new ArrayList<>(10);

    public Group(){
    }

    public Group(String groupName, List<Student> students) {
        this.groupName = groupName;
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Student student) throws GroupOverFlowException {
        if (student.getName() != null & student.getLastName() != null & student.getGender() != null) {
            try {
                if (students.size() < 10){
                        student.setGroupName(getGroupName());
                        students.add(student);
                    }
                if (students.size() >= 10) {
                    throw new GroupOverFlowException("На танцполе нет свободных мест");
                }
            } catch (GroupOverFlowException e) {
                System.out.println(e.getMessage());
            }
        }
        else System.out.println("You cannot add non-fully initialized student to group. Finish initialization first, please");
    }

    public Student SearchStudentByLastName(String lastName) throws StudentNotFoundException {
        try {
            for (Student student : students) {
                if (lastName.equals(student.getLastName())) {
                    return student;
                }
            }
                throw new StudentNotFoundException(lastName + " not found");
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

public List<Student> SearchNamesakers(String lastName) throws StudentNotFoundException {
    Student[] soughtStudents = new Student[10];
    List<Student> nameSakers = new ArrayList<>();
    try {
        for (int j = 0; j < soughtStudents.length;) {
            for (Student student : students) {
                if (student != null) {
                    if (lastName.equals(student.getLastName())) {
                        soughtStudents[j] = student;
                        j++;
                    }
                }
                if (soughtStudents[0] == null) {
                    throw new StudentNotFoundException(lastName + " not found");
                }
            }
            break;
            }
        for (Student soughtStudent : soughtStudents) {
            if (soughtStudent != null) {
                nameSakers.add(soughtStudent);
            }
        }
    }
    catch(StudentNotFoundException e){
        System.out.println(e.getMessage());
            }
    return nameSakers;
    }

public boolean removeStudentById(int id){
        for (int i = 0; i < students.size(); i++) {
                if (id == students.get(i).getId()) {
                    students.remove(i);
                    System.out.println("Student removed");
                    return true;
                }
        }
    System.out.println("There is no student with id: " + id + " in this group");
        return false;
    }

    public String toStringNextLineCreation(List <Student> students){
        String arrayElement;
        String toStringWithNewLines = "";
        for (int i = 0; i < students.size(); i++){
            arrayElement = i+1 + ". " + students.get(i);
            toStringWithNewLines = toStringWithNewLines + "\n" + arrayElement;
        }
    return toStringWithNewLines;}

    public List <Student> sortStudentsByLastName(List <Student> students){
        students.sort(Comparator.nullsLast(new LastNameCompartator()));
    return students;
    }

    public List<Student> studentsOfGroupToList(){
        List <Student> studentsList = new ArrayList<>();
        for (Student student : students) {
            if (student != null) {
                studentsList.add(student);
            }
        }
        return studentsList;
    }

    @Override
    public String toString() {
        return "Group:" + "\n" + groupName + ":" + "\n" + toStringNextLineCreation(students);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return getGroupName().equals(group.getGroupName()) && students.equals(group.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getGroupName());
        result = 31 * result + students.hashCode();
        return result;
    }

    public List giveMeEqualStudents (){
        List <Student> equalizers = new ArrayList<>();
        for (int i = 0; i < students.size()-1; i++) {
            for (int j = i+1; j < students.size(); j++) {
                if (students.get(j) != null && students.get(i) != null) {
                        if (students.get(j).equals(students.get(i))) {
                        System.out.println("There is equality between student at position " + i + " " + students.get(i).getId() + " " + students.get(i).getName() + " " + students.get(i).getLastName() + " hashCode " + students.get(i).hashCode() + " and student at position " + j + " " + students.get(j).getId() + " " + students.get(j).getName() + " " + students.get(j).getLastName() + " hashCode " + students.get(j).hashCode());
                        equalizers.add(students.get(i));
                        equalizers.add(students.get(j));
                        }
                }
            }
        }
        if (equalizers.size() == 0){
            System.out.println("There is no equal students");
        }
        return equalizers;
    }

}