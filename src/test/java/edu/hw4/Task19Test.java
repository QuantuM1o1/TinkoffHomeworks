package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class Task19Test {
    @Test
    @DisplayName("Ошибки")
    void errors() {
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
        test.add(new Animal("Mrs. Norris", Animal.Type.CAT, Animal.Sex.F, 10, 80, 9, false));
        test.add(new Animal("Bastet", Animal.Type.CAT, Animal.Sex.F, 9, 180, 70, false));
        test.add(new Animal("Scooby-Doo", Animal.Type.DOG, Animal.Sex.M, 3, 76, 54, false));
        test.add(new Animal("Vodnik", Animal.Type.FISH, Animal.Sex.M, 23, 180, 100, false));
        test.add(new Animal("Leviathan", Animal.Type.FISH, Animal.Sex.M, 2000, 1700, 300, true));

        // when
        Map<String, Set<ValidationError>> answer = Task19.errorsInFields(test);
        Set<ValidationError> leviathanSet = answer.get("Leviathan");

        // then
        assertThat(answer.get("Freddi")).isEmpty();
        assertThat(answer.get("Shelob").size()).isEqualTo(2);
        assertThat(answer.get("Mrs. Norris").size()).isEqualTo(1);
        assertThat(answer.get("Bastet").size()).isEqualTo(2);
        assertThat(answer.get("Leviathan").size()).isEqualTo(1);
        assertThat(leviathanSet.stream()
            .max(Comparator
                .comparing(ValidationError::nameOfError))
            .orElse(new ValidationError("Default", "Default"))
            .nameOfError())
            .isEqualTo("Age is too high");
    }
}
