package Parcial1.RepasoP1_2024.Ej1_Exam;

import java.util.Arrays;

public class ExamTester {
    public static void main(String[] args) {
        Exam exam = new Exam("Primer Parcial PI");
        exam.enroll("Matias");
        exam.enroll("Matias");
        exam.enroll("Natalia");
        System.out.println("Enrolled Students: " + Arrays.toString(exam.getEnrolledStrudents()));
        exam.unenroll("Matias");
        System.out.println("Enrolled Students: " + Arrays.toString(exam.getEnrolledStrudents()));
        System.out.println("##########");
        UniqueExam uniqueExam = new UniqueExam("Primer Parcial POO");
        uniqueExam.enroll("Matias");
        uniqueExam.enroll("Matias");
        uniqueExam.enroll("Natalia");
        System.out.println("Enrolled Students: " + Arrays.toString(uniqueExam.getEnrolledStrudents()));
        uniqueExam.unenroll("Matias");
        System.out.println("Enrolled Students: " + Arrays.toString(uniqueExam.getEnrolledStrudents()));
        System.out.println("##########");
        LimitedExam limitedExam = new LimitedExam("TPE POD", 2);
        limitedExam.enroll("Matias");
        limitedExam.enroll("Matias");
        limitedExam.enroll("Natalia");
        limitedExam.enroll("Solange");
        limitedExam.enroll("Jose");
        limitedExam.enroll("Micaela");
        System.out.println("Enrolled Students: " + Arrays.toString(limitedExam.getEnrolledStrudents()));
        System.out.println("Pending Students: " + Arrays.toString(limitedExam.getPendingStudents()));
        limitedExam.unenroll("Matias");
        System.out.println("Enrolled Students: " + Arrays.toString(limitedExam.getEnrolledStrudents()));
        System.out.println("Pending Students: " + Arrays.toString(limitedExam.getPendingStudents()));
        limitedExam.unenroll("Jose");
        limitedExam.unenroll("Natalia");
        System.out.println("Enrolled Students: " + Arrays.toString(limitedExam.getEnrolledStrudents()));
        System.out.println("Pending Students: " + Arrays.toString(limitedExam.getPendingStudents()));
    }

    //SALIDA:
//
//    Enrolled Matias
//    Enrolled Matias
//    Enrolled Natalia
//    Enrolled Students: [Matias, Matias, Natalia]
//    Unenrolled Matias
//    Enrolled Students: [Matias, Natalia]
//            ##########
//    Enrolled Matias
//    Enrolled Natalia
//    Enrolled Students: [Matias, Natalia]
//    Unenrolled Matias
//    Enrolled Students: [Natalia]
//            ##########
//    Enrolled Matias
//    Enrolled Natalia
//    Enrolled Students: [Matias, Natalia]
//    Pending Students: [Solange, Jose, Micaela]
//    Unenrolled Matias
//    Enrolled Solange
//    Enrolled Students: [Natalia, Solange]
//    Pending Students: [Jose, Micaela]
//    Unenrolled Natalia
//    Enrolled Micaela
//    Enrolled Students: [Solange, Micaela]
//    Pending Students: []

}
