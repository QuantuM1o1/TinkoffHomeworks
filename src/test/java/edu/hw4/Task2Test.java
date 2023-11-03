package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Сортировка и максимум элементов")
    void byWeightReversedMaxElements() {
        // given
        List<Animal> test = new ArrayList<>();
        test.add(new Animal("Freddi", Animal.Type.FISH, Animal.Sex.F, 12, 40, 2, false));
        test.add(new Animal("Hachiko", Animal.Type.DOG, Animal.Sex.M, 6, 54, 25, true));
        test.add(new Animal("Alex", Animal.Type.CAT, Animal.Sex.M, 7, 36, 3, true));
        int max = 2;

        // when
        List<Animal> answer = Task2.weightDescMaxK(test, max);

        // then
        assertThat(answer.get(0).name()).isEqualTo("Hachiko");
        assertThat(answer.get(1).name()).isEqualTo("Alex");
        assertThat(answer.size()).isEqualTo(2);
    }
}
