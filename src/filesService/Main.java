package filesService;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File folderIn = new File("E:\\Саша");
        File folderOut = new File("E:\\CopyFolder");
        String extension = ".doc";
        try {
            FilesCopier.copyFilesByExtension(folderIn, folderOut, extension);
        }catch (IOException e){
            e.printStackTrace();
        }

        // Task 3 from Generics and Collections lecture:
        // testing readFromFileToString
        File readFrom = new File("Refactoring.txt");
        String inputSting = "";
        try {
            inputSting = FilesCopier.readFromFileToString(readFrom.getName()).toUpperCase().replaceAll("[^a-zA-z]", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // My first vision of solving:

        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < inputSting.length(); i++) {
            chars.add(inputSting.charAt(i));
        }
        List<Integer> appearance = new ArrayList<>();
        int app = 0;
        Iterator<Character> itr = chars.iterator();
        while (itr.hasNext()) {
            Character current = itr.next();
            for (int i = 0; i < inputSting.length(); i++) {
                if (current.equals(inputSting.charAt(i))) {
                    app += 1;
                }
            }
            appearance.add(app);
            app = 0;
        }
        System.out.println(appearance);
        HashMap<Character, Integer> charactersAppearance = new HashMap<>();
        itr = chars.iterator();
        Iterator<Integer> itrIntgr = appearance.iterator();
        while (itr.hasNext()) {
            charactersAppearance.put(itr.next(), itrIntgr.next());
        }

        //we just sort keys according to its values decremented order, without counting the average frequency of char usage in the text.
        charactersAppearance.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(System.out::println);

        //Second vision of solving, after realizing my first one is sucks... Without creating list and set, without changing inputString.

        try {
            inputSting = FilesCopier.readFromFileToString(readFrom.getName()).toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<Character, Integer> mapCharsCount = new HashMap<>();
        System.out.println(inputSting);
        int lettersAmount = 0;
        for (int i = 0; i < inputSting.length(); i++) {
            if (Character.isLetter(inputSting.charAt(i))) {
                lettersAmount += 1;
                if (!mapCharsCount.containsKey(inputSting.charAt(i))) {
                    mapCharsCount.put(inputSting.charAt(i), 1);
                    System.out.println(mapCharsCount.entrySet());
                } else mapCharsCount.put(inputSting.charAt(i), mapCharsCount.get(inputSting.charAt(i))+1);
            }
        }
        mapCharsCount.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(System.out::println);

        //now lets try to change the values of our keys in HashMap from number of appearance to average frequency of usage in text:

        Set entrySet = mapCharsCount.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry mapEntry = (Map.Entry) it.next();
            double frequency = Double.parseDouble(mapEntry.getValue().toString()) / (double) lettersAmount;
            mapEntry.setValue(frequency);
        }
        mapCharsCount.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(System.out::println);

    // Task 4 from Generics and Collections lecture:
    }
}