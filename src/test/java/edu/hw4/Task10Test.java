package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task10Test {
    @Test
    @DisplayName("Возраст не равен количеству лап")
    void agePaws() {
        // given
        List<Animal> test = new ArrayList<>();
        test.add(new Animal("Freddi", Animal.Type.FISH, Animal.Sex.F, 12, 40, 2, false));
        test.add(new Animal("Hachiko", Animal.Type.DOG, Animal.Sex.M, 6, 54, 25, true));
        test.add(new Animal("Alex", Animal.Type.CAT, Animal.Sex.M, 7, 36, 3, true));
        test.add(new Animal("Kovalski", Animal.Type.BIRD, Animal.Sex.M, 3, 30, 2, false));
        test.add(new Animal("Jewel", Animal.Type.BIRD, Animal.Sex.F, 10, 56, 1, false));
        test.add(new Animal("Garfield", Animal.Type.CAT, Animal.Sex.M, 6, 38, 6, true));
        test.add(new Animal("Shelob", Animal.Type.SPIDER, Animal.Sex.F, 8, 183, 1800, true));

        // when
        List<Animal> answer = Task10.ageAndPaws(test);

        // then
        assertThat(answer.size()).isEqualTo(6);
    }
}
