package Teorica.ArrayList;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.SequencedCollection;
import java.util.function.Predicate;

public class SharedDrive {
    private SequencedCollection<File> files = new ArrayList<>();

    public SharedDrive addFile(String name, String wa){
        files.add(new File(name, wa));
        return this;
    }

    public Iterable<File> getAllFiles(){
        return new ArrayList<>(files); //copia de files
    }

    public File getFirstFile(Predicate<File> predicate){
        for(File f : files){
            if(predicate.test(f)){
                return f;
            }
        }
        throw new NoSuchElementException();
    }

    public File getLastFile(){
        return files.getLast();
    }

    public static class File{
        private final String name;
        private final String workArea;
        public File(String name, String wa){
            this.name=name;
            this.workArea=wa;
        }

        public String getFileWorkArea() {
            return workArea;
        }

        public String getFileName() {
            return name;
        }

        @Override
        public String toString(){
            return "File %s in work area %s".formatted(name,workArea);
                    //File r2.doc in work area PI
        }
    }
}
