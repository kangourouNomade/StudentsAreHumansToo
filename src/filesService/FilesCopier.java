package filesService;

import java.io.*;

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

    public static void copyFilesByExtension(File folderIn, File folderOut, String extension) throws IOException {
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
}
