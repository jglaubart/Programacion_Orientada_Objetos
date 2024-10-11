package Teorica.ArrayList;

public class SharedDriveTester {
    public static void main(String[] args) {

        SharedDrive drive = new SharedDrive();

        drive.addFile("mineSweeper.c", "PI").addFile("r2.doc", "PI")
                .addFile("r1.doc", "PI").addFile("r2.doc", "POO").addFile("r1.doc", "PI");

        for (SharedDrive.File sharedFile : drive.getAllFiles()) {
            System.out.println(sharedFile);
        }

        System.out.println(drive.getFirstFile(
                sF -> sF.getFileName().equals("r2.doc")));

        System.out.println(drive.getLastFile());
    }
}
