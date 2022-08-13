package homeWork;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class GroupFileStorage extends Group {

    public GroupFileStorage() {

    }

    public void saveGroupToCSV(Group gr) throws IOException {
        File groupCSV = new File("E:\\", gr.getGroupName() + ".csv");
        List<Student> listOfStudents = gr.studentsOfGroupToList(gr);
        Iterator<Student> iterator = listOfStudents.iterator();
        for (boolean i = true; i == iterator.hasNext(); ) {
            Student studentIteration = iterator.next();
            CSVStringConverter groupStudentToCSV = new CSVStringConverter();
            String studentToCSV = groupStudentToCSV.toStringRepresentation(studentIteration);
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(groupCSV, true)))) {
                pw.println(studentToCSV);
            }
        }
    }

    public Group loadGroupFromCSV(File file) {
        String nameOfGroup = file.getName().substring(0, file.getName().lastIndexOf("."));
        String stringFromFile = "";
        try (Reader read = new FileReader(file)) {
            char[] chars = new char[1000];
            int readChars;
            for (; ; ) {
                readChars = read.read(chars);
                if (readChars <= 0) {
                    break;
                }
                stringFromFile += new String(chars, 0, readChars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] dividedString = stringFromFile.split(System.lineSeparator());
        Student[] students = new Student[dividedString.length];
        CSVStringConverter csvStrCon = new CSVStringConverter();
        for (int i = 0; i < dividedString.length; i++) {
            students[i] = csvStrCon.fromStringRepresentation(dividedString[i]);
        }
        Group gr = new Group(nameOfGroup, students);
        return gr;
    }

    public File findFileByGroupName(String groupName, File workFolder) {
        if (!workFolder.exists() || !workFolder.isDirectory()) {
            throw new IllegalArgumentException("Directory name is incorrect or directory is absent " + workFolder.getName());
        }
        for (File file : Objects.requireNonNull(workFolder.listFiles())) {
            if (file.isFile() && file.getName().startsWith(groupName + ".")) {
                System.out.println("File " + groupName + ".csv found");
                return file;
                }
            }
        System.out.println("File " + groupName + ".csv not found");
        return null;
    }
}

