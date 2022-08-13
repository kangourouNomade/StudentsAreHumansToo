package homeWork;

import java.util.Locale;

public class CSVStringConverter implements StringConverter{

    CSVStringConverter() {
    }

    @Override
    public String toStringRepresentation(Student student) {
        return String.valueOf(student.getId()) + "," + student.getGroupName() + "," + student.getName() + "," + student.getLastName() + "," + student.getGender();
    }

    @Override
    public Student fromStringRepresentation(String str) {
        String[] parameters = str.split(",");
        return new Student(Integer.parseInt(parameters[0]), parameters[1], parameters[2], parameters[3], Gender.valueOf(parameters[4].toUpperCase(Locale.ROOT)));
    }
    }

