package homeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        }
        catch (GroupOverFlowException e){
            System.out.println(e.getMessage());
        }
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
        for (int j = 0; j < soughtStudents.length; ) {
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
            arrayElement = i+1 + ". " + String.valueOf(students[i]);
            toStringWithNewLines = toStringWithNewLines + "\n" + arrayElement;
        }
    return toStringWithNewLines;}

    public Student[] sortStudentsByLastName(Student[] students){
        Arrays.sort(students, Comparator.nullsLast(new lastNameCompartator()));
    return students;
    }

    public List<Student> studentsOfGroupToList(Group group){
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
            }

