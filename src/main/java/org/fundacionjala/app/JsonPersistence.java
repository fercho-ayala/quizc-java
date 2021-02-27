package org.fundacionjala.app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import org.fundacionjala.app.quizz.model.Quiz;

public class JsonPersistence {
    public static void main(String[] args) {
        Person person = new Person("Elon", "Musk", 49);
        //writeJsonFile(person);

        //Person parsedPerson = readJsonFile();
        //System.out.println(parsedPerson);
    }

    public static Quiz readJsonFile() {
        Gson gson = new Gson();
        Quiz quiz = null;
        try (JsonReader reader = new JsonReader(new FileReader("./myQuiz.json"))) {
            quiz = gson.fromJson(reader, Quiz.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return quiz;
    }

    public static void writeJsonFile(Quiz quiz) {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("./myQuiz.json")) {
            gson.toJson(quiz, writer);
        } catch (JsonIOException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public static class Person {
        private final String name;
        private final String lastName;
        private final int age;

        public Person(String name, String lastName, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return getName() + " " + getLastName() + " : " + getAge();
        }
    }
}
