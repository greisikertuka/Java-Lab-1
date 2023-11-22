import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Files {
    public static void main(String[] args) {
        executeFirstExercise();
        executeSecondExercise();
    }

    private static void executeFirstExercise() {
        File rootDirectory = new File("C:\\Users\\kertu\\Pictures");
        File[] matchingFiles = rootDirectory.listFiles((dir, name) -> name.startsWith("test-file") && name.endsWith("jpg"));

        for (var index = 0; index <= Objects.requireNonNull(matchingFiles).length; index++) {
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

    private static void executeSecondExercise() {

        //First

        File file = new File("C:\\Users\\kertu");
        String[] directories = file.list((current, name) -> new File(current, name).isDirectory());
        System.out.println(Arrays.toString(directories));

        //second
        File[] files = file.listFiles();
        assert files != null;
        long[] fileSizes = new long[files.length];
        for (int index = 0; index < files.length; index++) {
            fileSizes[index] = calculateFileSize(files[index]);
            boolean isDirectory = files[index].isDirectory();
            System.out.println(((isDirectory) ? "DIR" : "FILE") + " - " + files[index].getAbsolutePath() + " - " + fileSizes[index]);
        }

        //fifth
        File fileToDisplayLatestChange = new File("C:\\Users\\kertu\\Pictures");
        System.out.println(new Date(fileToDisplayLatestChange.lastModified()));
    }

    public static long calculateFileSize(File file) {
        long fileSize = 0L;
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            assert children != null;
            for (File child : children) {
                fileSize += calculateFileSize(child);
            }
        } else {
            fileSize = file.length();
        }
        return fileSize;
    }
}
