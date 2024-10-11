package Parcial1.RepasoP1_2024.Ej1_Exam;


import java.lang.reflect.Array;
import java.util.Arrays;

public class LimitedExam extends UniqueExam{
    private final int IN_TO_DIM = 5;
    private String[] toEnroll = new String[IN_TO_DIM];
    private int toEnrollDim = 0;
    private final int maxCant;

    public LimitedExam(String name, int max){
        super(name);
        this.maxCant = max;
    }

    private void resizeToEnroll(){
        toEnroll = Arrays.copyOf(toEnroll, toEnrollDim + IN_TO_DIM);
    }

    private void addToEnroll(String student){
        // compruebo si no esta ya en la lista de espera
        for(int i=0; i<toEnrollDim; i++){
            if(toEnroll[i].equals(student)){
                return;
            }
        }
        if(toEnrollDim == toEnroll.length){
            resizeToEnroll();
        }
        toEnroll[toEnrollDim++] = student;
    }

    @Override
    public void enroll(String student) {
       if(super.getEnrolledCount() < maxCant){
           super.enroll(student);
       } else{
           addToEnroll(student);
       }
    }

    public String[] getPendingStudents(){
        return Arrays.copyOf(toEnroll,toEnrollDim);
    }

    private void removeToEnroll(int i){
        System.arraycopy(toEnroll, i + 1, toEnroll, i, toEnrollDim - 1 - i);
        toEnrollDim--;
    }
    private boolean unenrollPending(String student){
        if(toEnrollDim == 0){
            return false;
        }
        for(int i=0; i<toEnrollDim; i++){  // si lo encuentra lo saca
            if(toEnroll[i].equals(student)){
                removeToEnroll(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void unenroll(String student){
        //busco si hay que sacarlo de la lista de espera (no puede estar en las dos porque no van repetidos)
        if(unenrollPending(student)){
            return;
        }
        int dimBefore = getEnrolledCount();
        super.unenroll(student);
        if(getEnrolledCount() == dimBefore || toEnrollDim==0){  //me fijo si realmente se saco al alumno o si no hay nadie para agregar
            return;
        }
        super.enroll(toEnroll[0]);
        removeToEnroll(0);
    }


}
