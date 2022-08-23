package homeWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main (String[] args) throws GroupOverFlowException, StudentNotFoundException, IOException {
        Student[] students = new Student[10];
//  initializing some elements of students array for further testing of code:

        students[0] = new Student(1, "JavaOOP", "Michel", "Schumaher", Gender.MALE);
        students[1] = new Student(2, "JavaOOP", "Anjelina", "Jolly", Gender.FEMALE);
        students[2] = new Student(3, "JavaOOP", "Lara", "Kroft", Gender.MALE);
        students[3] = new Student(4, "JavaOOP", "Jim", "EarthWorm", Gender.NOTSPECIFIED);

//      creating new single student object without appointing to any group
        Student stud1 = new Student(5, "", "Jack", "Daniels", Gender.MALE);
        System.out.println(stud1.toString());

        Group JavaOOP = new Group("JavaOOP", students);

//      testing the assignment of a groupName to a Student during adding Student to a specific Group
        JavaOOP.addStudent(stud1);
        System.out.println(ANSI_GREEN + "student Jack Daniels added to JavaOOP group:" + ANSI_RESET);
        System.out.println(JavaOOP.toString());
        System.out.println();

//      Trying to add empty Student object into Group to test that groupName assigns correctly:
        JavaOOP.addStudent(new Student());
        System.out.println(JavaOOP.toString());

//      Creating array of Students with name that differs from "students" to test that this object will be accepted
//      as field "Student[] students" by the Group Class:
        Student[] oldfags = new Student[10];
        oldfags[0] = new Student(6, "JavaStart", "Charles", "Dickkens", Gender.MALE);
        oldfags[1] = new Student(7, "JavaStart", "Till", "Lindemann", Gender.MALE);
        oldfags[2] = new Student(8, "JavaStart", "Monica", "Dickkens", Gender.FEMALE);
        oldfags[3] = new Student(9, "JavaStart", "Roberto", "Carlos", Gender.MALE);
        oldfags[4] = new Student(10, "JavaStart", "Scotty", "Dickkens", Gender.MALE);
        oldfags[5] = new Student(11, "JavaStart", "Tarja", "Turunen", Gender.FEMALE);
        oldfags[6] = new Student(12, "JavaStart", "Placido", "Dickkens", Gender.MALE);
        oldfags[7] = new Student(13, "JavaStart", "Jeremy", "Clarkson", Gender.MALE);
        oldfags[8] = new Student(14, "JavaStart", "Margaret", "Thatcher", Gender.FEMALE);
        oldfags[9] = new Student(15, "JavaStart", "Deborah", "Chow", Gender.FEMALE);

        Group JavaStart = new Group ("JavaStart", oldfags);
        Student stud2 = new Student(016, "JavaStart", "Morgan", "Freeman", Gender.MALE);

        //testing equality
        JavaOOP.addStudent(stud1);
        JavaOOP.addStudent(stud1);
        JavaOOP.addStudent(stud1);

        System.out.println(JavaStart.giveMeEqualStudents());
        System.out.println(JavaOOP.giveMeEqualStudents());

        /*
        //  testing saveGroup2CSV method.
        GroupFileStorage gfs = new GroupFileStorage();
        try {
            gfs.saveGroupToCSV(JavaStart);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

//  testing loadGroupFromCSV
        File file = new File("E:\\JavaStart.csv");
        Group groupFromFile = gfs.loadGroupFromCSV(file);
        System.out.println(ANSI_GREEN + "LOADED GROUP FROM THE FILE: " + ANSI_RESET);
        System.out.println(groupFromFile.toString());

//  testing findFileByGroupName
        File folder = new File("E:\\");
        gfs.findFileByGroupName(JavaStart.getGroupName(), folder);


//      testing SearchStudentByLastName();
        String lastName = oldfags[6].getLastName(); //Dickkens
        System.out.println();
        System.out.println(ANSI_GREEN + "Trying to find the " + lastName + " in JavaStart group" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "We have found: " + ANSI_RESET + JavaStart.SearchStudentByLastName(lastName).toString());

        lastName = students[1].getLastName(); //Jolly
        System.out.println(ANSI_GREEN + "Trying to find the "  + lastName + " in JavaStart group" + ANSI_RESET);
        String whatWeGet = String.valueOf(JavaStart.SearchStudentByLastName(lastName));
        System.out.println(ANSI_GREEN + "The result is: " + ANSI_RESET + whatWeGet);

//      testing the SearchNamesakers(). THis method should find all the namesakers in current group and return
//      the array with Students with the same surnames. If there aren't any namesaker it returns null array
        lastName = students[0].getLastName(); //Schumaher
        System.out.println();
        List<Student> nameSakers = JavaStart.SearchNamesakers(lastName);
        System.out.println(nameSakers); //NameSaker not found
        System.out.println();
        lastName = oldfags[0].getLastName(); //Dickkens
        nameSakers = JavaOOP.SearchNamesakers(lastName);
        System.out.println(nameSakers);//NameSaker not found
        System.out.println();
        nameSakers = JavaStart.SearchNamesakers(lastName);

        Iterator <Student> iterator = nameSakers.iterator(); //printing the nameSakers
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//      deleting the student from group by his/her ID.
        System.out.println();
        System.out.println(JavaStart.removeStudentById(15));
        System.out.println(JavaOOP.removeStudentById(7));

//      checking do we really deleted the student from array
        System.out.println(oldfags[9]);
        System.out.println(JavaStart.removeStudentById(-55));

//  testing sortByLastName method
        JavaStart.sortStudentsByLastName(students);
        System.out.println(ANSI_GREEN + "Sorted array of students in alphabet order: " + ANSI_RESET);
        for (Student student : students){
            System.out.println(student);
            System.out.println();
        }
//  testing CSVStringConverter
        System.out.println(ANSI_GREEN + "testing CSV method" + ANSI_RESET);
        CSVStringConverter CSVString = new CSVStringConverter();
        String str = CSVString.toStringRepresentation(oldfags[0]);
        System.out.println(str);
        Student studentFromString = CSVString.fromStringRepresentation(str);
        System.out.println(studentFromString.toString());


//  testing overriding the methods from class Student in subclass StudentScanner
        StudentScanner stud3 = new StudentScanner(0, null, null, null, Gender.NOTSPECIFIED);
        stud3.setId();
        System.out.println(stud3.getId());
        stud3.setGroupName();
        System.out.println(stud3.getGroupName());
        stud3.setName();
        System.out.println(stud3.getName());
        stud3.setGender();
        System.out.println(stud3.getGender());
        stud3.setLastName();
        System.out.println(stud3.getLastName());
        System.out.println(stud3.toString());
//      now testing constructor of new StudentScanner
        StudentScanner stud4 = new StudentScanner();
        System.out.println(stud4.toString());
//      testing that object from subclass StudentScanner properly executed by addStudent method of Group class
        JavaOOP.addStudent(stud4);
        System.out.println(JavaOOP.toString());
//      realise method that creates object Student through the StudentScanner constructor and returns us the initialized
//      by keyboard input object of Student class
        Student stud5 = new StudentScanner();
        System.out.println(stud5.toString());
        */
        }

    }
