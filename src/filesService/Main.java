package filesService;


import java.io.File;
import java.io.IOException;

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
    }
}