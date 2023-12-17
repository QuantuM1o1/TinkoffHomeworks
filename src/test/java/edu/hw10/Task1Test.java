package edu.hw10;

import edu.hw10.Task1.MyClass;
import edu.hw10.Task1.MyFactory;
import edu.hw10.Task1.MyRecord;
import edu.hw10.Task1.RandomObjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    @DisplayName("Обычный класс с конструктором")
    void simpleClass() {
        // given
        RandomObjectGenerator generator = new RandomObjectGenerator();

        // when
        MyClass answer = generator.nextObject(MyClass.class);

        // then
        assertThat(answer).isNotNull();
        assertThat(answer.getName().length()).isBetween(1, 8);
        assertThat(answer.getAge()).isNotNull();
    }

    @Test
    @DisplayName("Класс с фабричным методом")
    void factoryClass() {
        // given
        RandomObjectGenerator generator = new RandomObjectGenerator();

        // when
        MyFactory answer = generator.nextObject(MyFactory.class, "create");

        // then
        assertThat(answer).isNotNull();
        assertThat(answer.getAge()).isNotNull();
    }

    @Test
    @DisplayName("Рекорд")
    void recordClass() {
        // given
        RandomObjectGenerator generator = new RandomObjectGenerator();

        // when
        MyRecord answer = generator.nextObject(MyRecord.class);

        // then
        assertThat(answer).isNotNull();
        assertThat(answer.age()).isNotNull();
    }

    @Test
    @DisplayName("Проверка аннотаций")
    void annotations() {
        // given
        RandomObjectGenerator generator = new RandomObjectGenerator();
        boolean stringNotNull = true;
        boolean ageMin = true;
        boolean ageMax = true;

        // when
        for (int i = 0; i < 100; i++)
        {
            MyClass answer = generator.nextObject(MyClass.class);
            if (answer.getName() == null) {
                stringNotNull = false;
                break;
            }
            if (answer.getAge() < 0) {
                ageMin = false;
                break;
            }
            if (answer.getAge() > 150) {
                ageMax = false;
                break;
            }
        }

        // then
        assertTrue(stringNotNull);
        assertTrue(ageMax);
        assertTrue(ageMin);
    }
}
