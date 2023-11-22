import java.io.File;

public class Files {
    public static void main(String[] args) {
        File rootDirectory = new File("C:\\Users\\kertu\\Pictures");
        File[] matchingFiles = rootDirectory.listFiles((dir, name) -> name.startsWith("test-file") && name.endsWith("jpg"));

        for (var index = 0; index <= matchingFiles.length; index++) {
            System.out.println(matchingFiles[index]);
        }
        System.out.println(matchingFiles[0].getName());

        File file = new File("C:\\Users\\kertu\\Pictures\\test-file.jpg");
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
