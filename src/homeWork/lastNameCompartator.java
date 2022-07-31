package homeWork;

import java.util.Comparator;

public class lastNameCompartator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student student1 =  (Student) o1;
        Student student2 = (Student) o2;

        if (student1.getLastName() != null & student2.getLastName() != null) {
            String lastName1 = student1.getLastName();
            String lastName2 = student2.getLastName();


            if (lastName1 != null & lastName2 != null) {

                if (lastName1.compareToIgnoreCase(lastName2) > 0) {
                return 1;
                }
                if (lastName1.compareToIgnoreCase(lastName2) < 0) {
                return -1;
                }
            }
        }
        return 0;
    }

}
