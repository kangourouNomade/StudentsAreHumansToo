package filesService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FilesCopier {

    private FilesCopier(){

    }

    public static void copyFile(File in, File out) throws IOException{
        try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {
        long byteCopy = is.transferTo(os);
            System.out.println(byteCopy + "bytes copied");
        }
    }

    public static void copyFolder(File folderIn, File folderOut) throws IOException{
        File[] files2copy = folderIn.listFiles();
        for (File file : files2copy) {
            if (file.isFile()) {
                File fileOut = new File(folderOut, file.getName());

            }
        }
    }

    public static void copyFilesByExtension(File folderIn, File folderOut, String extension) throws IOException, NullPointerException {
        File[] files2copy = folderIn.listFiles();
        for (File file : files2copy) {
            if (file.isFile()) {
                if (file.getName().endsWith(extension)) {
                    File fileOut = new File(folderOut, file.getName());
                    copyFile(file, fileOut);
                }
            }
        }
    }

    public static String readFromFileToString (String fileName) throws IOException{
    return Files.lines(Paths.get(fileName)).filter(str -> str.length() > 1)
            .collect(Collectors.joining());
    }
}
