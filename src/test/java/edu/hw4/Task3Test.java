package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Карта по количеству каждого вида")
    void numberOfEverySpecies() {
        // given
        List<Animal> test = new ArrayList<>();
        test.add(new Animal("Freddi", Animal.Type.FISH, Animal.Sex.F, 12, 40, 2, false));
        test.add(new Animal("Hachiko", Animal.Type.DOG, Animal.Sex.M, 6, 54, 25, true));
        test.add(new Animal("Alex", Animal.Type.CAT, Animal.Sex.M, 7, 36, 3, true));
        test.add(new Animal("Kovalski", Animal.Type.BIRD, Animal.Sex.M, 3, 30, 2, false));
        test.add(new Animal("Jewel", Animal.Type.BIRD, Animal.Sex.F, 10, 56, 1, false));

        // when
        Map<Animal.Type, Integer> answer = Task3.everySpeciesCounter(test);

        // then
        assertThat(answer.get(Animal.Type.BIRD)).isEqualTo(2);
        assertThat(answer.get(Animal.Type.DOG)).isEqualTo(1);
        assertThat(answer.get(Animal.Type.SPIDER)).isNull();
    }
}
