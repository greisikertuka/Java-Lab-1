package main.java;

import main.java.animals.Animal;
import main.java.animals.Bird;
import main.java.animals.Mammal;
import main.java.roles.Director;
import main.java.roles.Employee;
import main.java.roles.Manager;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Files {
    public static void main(String[] args) {

        //executeFirstExercise();
        //executeSecondExercise();
        //executeThirdExercise();
        executeFourthExercise();
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

    private static void executeThirdExercise() {
        Employee employee = new Employee("Andi", "Shkoza", 2100);
        Manager manager = new Manager("Andi", "Shkoza", 2100, 5);
        Director director = new Director("Andi", "Shkoza", 2100, 5, 20000);
        System.out.println("Employee: \n" + employee.toString());
        System.out.println("Manger: \n" + manager.toString());
        System.out.println("Director: \n" + director.toString());
    }

    private static void executeFourthExercise() {
        Animal animal = new Animal("Lion", "RRR");
        Mammal mammal = new Mammal("Lion", "RRR", "Orange");
        Bird bird = new Bird("Seagull", "RRR", "white", 2);
        System.out.println("Animal: \n" + animal.toString());
        System.out.println("Mammal: \n" + mammal.toString());
        System.out.println("Bird: \n" + bird.toString());
        System.out.println("Animal sound: \n" + animal.getSound());
        System.out.println("Mammal sound: \n" + mammal.getSound());
        System.out.println("Bird sound: \n" + bird.getSound());
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
