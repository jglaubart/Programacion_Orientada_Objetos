package Teorica.Streams_Java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Serializacion {
    private Person applicationData;

    private void loadData(Path inputPath) throws IOException {
        try (InputStream inputStream = Files.newInputStream(inputPath)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                this.applicationData = new Person("Juan", 50);
                this.applicationData.readExternal(objectInputStream);
            }
        }
    }

    private void saveData(Path outputPath) throws IOException {
        try (OutputStream outputStream = Files.newOutputStream(outputPath)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
                this.applicationData.writeExternal(objectOutputStream);
            }
        }
    }


    public static class Person implements Externalizable {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person %s with age %d".formatted(name, age);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeUTF(name);
            out.writeInt(age);
        }
        @Override
        public void readExternal(ObjectInput in) throws IOException {
            name = in.readUTF();
            age = in.readInt();
        }
    }
}
