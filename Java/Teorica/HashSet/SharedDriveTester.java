package Teorica.HashSet;

public class SharedDriveTester {
    public static void main(String[] args) {
        SharedDrive drive = new SharedDrive();

        drive.addFile("mineSweeper.c", "PI").addFile("r2.doc", "PI")
                .addFile("r1.doc", "PI").addFile("r2.doc", "POO").addFile("r1.doc", "PI");

        System.out.println(drive.filesCount(sF -> sF.getFileName().equals("r2.doc")));

        drive.renameFile("mineSweeper.c", "PI", "minecraft.c");

        System.out.println(drive.fileExists("mineSweeper.c", "PI"));

        System.out.println(drive.fileExists("minecraft.c", "PI"));
    }
}
