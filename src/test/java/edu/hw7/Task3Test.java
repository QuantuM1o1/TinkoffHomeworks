package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDatabase;
import edu.hw7.Task3.ReaderDatabase;
import edu.hw7.Task3.SyncedDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    @DisplayName("Проверяем запись")
    void writingToDB() {
        // given
        PersonDatabase database = new SyncedDatabase();
        int numberOfThreads = 10_000;
        AtomicBoolean answer = new AtomicBoolean(true);
        List<String> names = new ArrayList<>();
        List<String> phoneNumbers = new ArrayList<>();
        List<String> addresses = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            names.add("Name n" + i);
            phoneNumbers.add("Number n" + i);
            addresses.add("Address n" + i);
        }
        Random random = new Random();

        // when
        Stream.generate(() ->
                new Thread(() ->{
                    int randNum = Math.abs(random.nextInt() % numberOfThreads);
                    database.add(new Person(randNum, names.get(randNum), addresses.get(randNum), phoneNumbers.get(randNum)));
                }))
            .limit(numberOfThreads)
            .forEach(Thread::start);


        Stream.generate(() ->
                new Thread(() ->{
                    int randNum = Math.abs(random.nextInt() % numberOfThreads);
                    if (database.findByName(names.get(randNum)) != null
                        && (database.findByPhone(phoneNumbers.get(randNum)) == null
                        && database.findByAddress(addresses.get(randNum)) == null)) {
                        answer.set(false);
                    }
                }))
            .limit(numberOfThreads)
            .forEach(Thread::start);

        // then
        assertTrue(answer.get());
    }

    @Test
    @DisplayName("Проверяем работу с перевесом чтения")
    void readWriteSupremacy() {
        // given
        PersonDatabase database = new ReaderDatabase();
        int numberOfReads = 20_000;
        int numberOfWrites = numberOfReads / 100;
        AtomicBoolean answer = new AtomicBoolean(true);
        List<String> names = new ArrayList<>();
        List<String> phoneNumbers = new ArrayList<>();
        List<String> addresses = new ArrayList<>();
        for (int i = 0; i < numberOfWrites; i++) {
            names.add("Name n" + i);
            phoneNumbers.add("Number n" + i);
            addresses.add("Address n" + i);
        }
        Random random = new Random();

        // when
        Stream.generate(() ->
                new Thread(() ->{
                    int randNum = Math.abs(random.nextInt() % numberOfWrites);
                    database.add(new Person(randNum, names.get(randNum), addresses.get(randNum), phoneNumbers.get(randNum)));
                }))
            .limit(numberOfWrites)
            .forEach(Thread::start);


        Stream.generate(() ->
                new Thread(() ->{
                    int randNum = Math.abs(random.nextInt() % numberOfWrites);
                    if (database.findByName(names.get(randNum)) != null
                        && (database.findByPhone(phoneNumbers.get(randNum)) == null
                        && database.findByAddress(addresses.get(randNum)) == null)) {
                        answer.set(false);
                    }
                }))
            .limit(numberOfReads)
            .forEach(Thread::start);

        // then
        assertTrue(answer.get());
    }
}
