package homeWork;

import java.util.Scanner;

public class StudentScanner extends Student{
    private Scanner sc = new Scanner(System.in);

    public StudentScanner(int id, String groupName, String name, String lastName, Gender gender){
        super();
    }

    public StudentScanner(){
        setId();
        setGroupName();
        setName();
        setLastName();
        setGender();
    }

    public Student StudentScanner(){
        Student studentFromKeyboard = new StudentScanner();
    return studentFromKeyboard;}

    @Override
    public int getId() {
        return super.getId();
    }

    public void setId(){
        //trying to solve the InputMissmatchException and realize the possibility to re-scan the input
        Integer intID = null;
        System.out.println("Input student's ID (int): ");
        do {
            try {
                intID = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Wrong input. Please, input only integer number: ");
                sc.nextLine();
            }
        }
            while (intID == null);
            this.setId(intID);
    }
    @Override
    public void setId(int id){
        super.setId(id);
    }

    @Override
    public String getGroupName() {
        return super.getGroupName();
    }

    @Override
    public void setGroupName() {
        System.out.println("Input student's Group (string): ");
        this.setGroupName(sc.next());
    }

    @Override
    public void setGroupName(String groupName) {
        super.setGroupName(groupName);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setName(){
        System.out.println("Input the name of the student: ");
        this.setName(sc.next());
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public void setLastName(){
        System.out.println("Input the surname of the student: ");
        this.setLastName(sc.next());
    }

    @Override
    public Gender getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(Gender gender) {
        super.setGender(gender);
    }

    public void setGender(){

        String inputGender;
        for (;;){
            System.out.println("Input gender. Please, choose between male, female or notspecified: ");
            inputGender = sc.next().toUpperCase();
                 if (inputGender.equalsIgnoreCase("male") || inputGender.equalsIgnoreCase("female") || inputGender.equalsIgnoreCase("notspecified")){
                     this.setGender(Gender.valueOf(inputGender));
                     break;
                 }
            }
    }

}
