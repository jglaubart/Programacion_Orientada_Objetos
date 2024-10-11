package Teorica.HashSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class SharedDrive {
    private final Set<SharedFile> sharedFiles = new HashSet<>();

    public SharedDrive addFile(String name, String wa){
        sharedFiles.add(new SharedFile(name,wa));
        return this;
    }

    public boolean fileExists(String name, String wa){
        return sharedFiles.contains(new SharedFile(name, wa));
    }

    public int filesCount(Predicate<SharedFile> predicate){
        int count = 0;
        for(SharedFile sf : sharedFiles){
            if(predicate.test(sf)){
                count++;
            }
        }
        return count;
    }

    public void renameFile(String fileName, String workArea, String newFileName) {   //lo elimina y lo vuelve a agregar asi cae en su posicion correcta
        if(!sharedFiles.removeIf(sF -> sF.equals(new SharedFile(fileName, workArea)))) {  //si solo se cambia el nombre, puede quedar mal acomodado
            throw new IllegalArgumentException();
        }
        addFile(newFileName, workArea);
    }

    public static class SharedFile{
        private String name;
        private final String workArea;

        public SharedFile(String name, String wa){
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
        public boolean equals(Object o){
            return o instanceof SharedFile sf &&
                    name.equals(sf.getFileName()) &&
                    workArea.equals(sf.getFileWorkArea());
        }

        @Override
        public int hashCode(){
            return Objects.hash(name, workArea);
        }

        @Override
        public String toString(){
            return "File %s in work area %s".formatted(name,workArea);
            //File r2.doc in work area PI
        }
    }
}
