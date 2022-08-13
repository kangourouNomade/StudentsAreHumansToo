package homeWork;
import java.lang.Enum;

public enum Gender {
    FEMALE("female"),
    MALE("male"),
    NOTSPECIFIED("not specified");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
