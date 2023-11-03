package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task13Test {
    @Test
    @DisplayName("Вес больше роста")
    void weighMoreThanHeight() {
        // given
        List<Animal> test = new ArrayList<>();
        test.add(new Animal("Freddi", Animal.Type.FISH, Animal.Sex.F, 12, 40, 2, false));
        test.add(new Animal("Hachiko", Animal.Type.DOG, Animal.Sex.M, 6, 54, 25, true));
        test.add(new Animal("Alex", Animal.Type.CAT, Animal.Sex.M, 7, 36, 3, true));
        test.add(new Animal("Kovalski", Animal.Type.BIRD, Animal.Sex.M, 3, 30, 2, false));
        test.add(new Animal("Jewel", Animal.Type.BIRD, Animal.Sex.F, 10, 56, 1, false));
        test.add(new Animal("Garfield", Animal.Type.CAT, Animal.Sex.M, 6, 38, 6, true));
        test.add(new Animal("Shelob", Animal.Type.SPIDER, Animal.Sex.F, 8, 183, 1800, true));
        test.add(new Animal("Carcharodon carcharias", Animal.Type.FISH, Animal.Sex.M, 26, 400, 850, true));
        test.add(new Animal("Cheshire Cat", Animal.Type.CAT, Animal.Sex.M, 27, 40, 2, true));

        // when
        List<Animal> answer = Task13.longNames(test);

        // then
        assertThat(answer.size()).isEqualTo(2);
        assertThat(answer.get(0).name()).doesNotContain("Freddi", "Hachiko", "Alex", "Kovalski", "Jewel", "Garfield", "Shelob");
    }
}
