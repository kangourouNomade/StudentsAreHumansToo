package homeWork;

public class Student extends Human {
    private int id;
    private String groupName;

    public Student(int id, String groupName, String name, String lastName, Gender gender) {
        super(name, lastName, gender);
        this.id = id;
        this.groupName = groupName;
    }

    public Student(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName() {
        this.groupName = groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id: " + id +
                ", groupName: '" + groupName + '\'' +
                ", name: '" + super.getName() + '\'' +
                ", lastName: '" + super.getLastName() + '\'' +
                ", gender: '" + super.getGender() + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public Gender getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(Gender gender) {
        super.setGender(gender);
    }
}
