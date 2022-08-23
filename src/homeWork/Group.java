package homeWork;

import java.lang.reflect.Field;
import java.util.*;

public class Group {
    private String groupName;

    private Student[] students = new Student[10];

    public Group(){
    }

    public Group(String groupName, Student[] students) {
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
        boolean freeIndex = false;
        if (student.getName() != null & student.getLastName() != null & student.getGender() != null) {
            try {
                for (int i = 0; i < students.length; ++i) {
                    if (students[i] == null) {
                        freeIndex = true;
                        student.setGroupName(getGroupName());
                        students[i] = student;
                        break;
                    }
                }
                if (!freeIndex) {
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
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (id == students[i].getId()) {
                    students[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public String toStringNextLineCreation(Student[] students){
        String arrayElement;
        String toStringWithNewLines = "";
        for (int i = 0; i < students.length; i++){
            arrayElement = i+1 + ". " + students[i];
            toStringWithNewLines = toStringWithNewLines + "\n" + arrayElement;
        }
    return toStringWithNewLines;}

    public Student[] sortStudentsByLastName(Student[] students){
        Arrays.sort(students, Comparator.nullsLast(new lastNameCompartator()));
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
        return getGroupName().equals(group.getGroupName()) && Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getGroupName());
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }

    public List giveMeEqualStudents (){
        List <Student> equalizers = new ArrayList<>();
        for (int i = 0; i < students.length-1; i++) {
            for (int j = i+1; j < students.length; j++) {
                if (students[j] != null && students[i] != null) {
                        if (students[i].equals(students[j])) {
                        System.out.println("There is equality between student at position " + i + " " + students[i].getId() + " " + students[i].getName() + " " + students[i].getLastName() + " hashCode " + students[i].hashCode() + " and student at position " + j + " " + students[j].getId() + " " + students[j].getName() + " " + students[j].getLastName() + " hashCode " + students[i].hashCode());
                        equalizers.add(students[i]);
                        equalizers.add(students[j]);
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