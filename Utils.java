import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {

    /**
     * Read content from file.
     */
    public static String readContentFromFile(String path) throws IOException {
        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);
        String line;
        String ans = "";

        while ((line = br.readLine()) != null) {
            ans += line + "\n";
        }

        br.close();
        return ans;
    }

    /**
     * Write content to file 1.
     */
    public static void writeContentToFile(String path) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        File file = new File(path);
        FileWriter writer = new FileWriter(file);
        writer.write(str);
        sc.close();
        writer.close();
    }

    /**
     * Write content to file 2.
     */
    public static void writeContentToFile2(String path) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        File file = new File(path);
        FileWriter writer = new FileWriter(file, true);
        writer.write(str);
        sc.close();
        writer.close();
    }

    /**
     * Find file by name.
     */
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] listFile = folder.listFiles();

        if (listFile == null) {
            return null;
        }

        for (File f : listFile) {
            if (f.getName().equals(fileName) && f.isFile()) {
                return f;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        File file = findFileByName("D:\\OOP_PROJECT\\src", "testInput.txt");
        System.out.println(file.getName());

        if (file != null) {
            System.out.println(file.getAbsolutePath());
            String content = readContentFromFile(file.getAbsolutePath());
            System.out.println(content);
            writeContentToFile("D:\\OOP_PROJECT\\src\\testOutput.txt");
            writeContentToFile2("D:\\OOP_PROJECT\\src\\testOutput.txt");

        }
    }
}
