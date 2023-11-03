package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task18Test {
    @Test
    @DisplayName("Большая рыба")
    void bigFish() {
        // given
        List<Animal> test1 = new ArrayList<>();
        test1.add(new Animal("Freddi", Animal.Type.FISH, Animal.Sex.F, 12, 40, 2, false));
        test1.add(new Animal("Hachiko", Animal.Type.DOG, Animal.Sex.M, 6, 54, 25, true));
        test1.add(new Animal("Alex", Animal.Type.CAT, Animal.Sex.M, 7, 36, 3, true));
        test1.add(new Animal("Kovalski", Animal.Type.BIRD, Animal.Sex.M, 3, 30, 2, false));
        test1.add(new Animal("Jewel", Animal.Type.BIRD, Animal.Sex.F, 10, 56, 1, false));
        test1.add(new Animal("Garfield", Animal.Type.CAT, Animal.Sex.M, 6, 38, 6, true));
        test1.add(new Animal("Shelob", Animal.Type.SPIDER, Animal.Sex.F, 8, 183, 1800, true));
        test1.add(new Animal("Carcharodon carcharias", Animal.Type.FISH, Animal.Sex.M, 26, 400, 850, true));
        test1.add(new Animal("Cheshire Cat", Animal.Type.CAT, Animal.Sex.M, 27, 40, 2, true));
        test1.add(new Animal("Mrs. Norris", Animal.Type.CAT, Animal.Sex.F, 10, 80, 9, false));
        test1.add(new Animal("Bastet", Animal.Type.CAT, Animal.Sex.F, 9, 180, 70, false));
        test1.add(new Animal("Scooby-Doo", Animal.Type.DOG, Animal.Sex.M, 3, 76, 54, false));

        List<Animal> test2 = new ArrayList<>();
        test2.add(new Animal("Vodnik", Animal.Type.FISH, Animal.Sex.M, 23, 180, 100, false));
        test2.add(new Animal("Leviathan", Animal.Type.FISH, Animal.Sex.M, 2000, 1700, 300, true));

        List<List<Animal>> testList = new ArrayList<>();
        testList.add(test1);
        testList.add(test2);

        // when
        Animal answer = Task18.heaviestFish(testList);

        // then
        assertThat(answer.name()).isEqualTo("Carcharodon carcharias");
    }

    @Test
    @DisplayName("Нет рыб")
    void noFish() {
        // given
        List<Animal> test1 = new ArrayList<>();
        test1.add(new Animal("Hachiko", Animal.Type.DOG, Animal.Sex.M, 6, 54, 25, true));
        test1.add(new Animal("Alex", Animal.Type.CAT, Animal.Sex.M, 7, 36, 3, true));
        test1.add(new Animal("Kovalski", Animal.Type.BIRD, Animal.Sex.M, 3, 30, 2, false));
        test1.add(new Animal("Jewel", Animal.Type.BIRD, Animal.Sex.F, 10, 56, 1, false));
        test1.add(new Animal("Garfield", Animal.Type.CAT, Animal.Sex.M, 6, 38, 6, true));
        test1.add(new Animal("Shelob", Animal.Type.SPIDER, Animal.Sex.F, 8, 183, 1800, true));
        test1.add(new Animal("Cheshire Cat", Animal.Type.CAT, Animal.Sex.M, 27, 40, 2, true));
        test1.add(new Animal("Mrs. Norris", Animal.Type.CAT, Animal.Sex.F, 10, 80, 9, false));


        List<Animal> test2 = new ArrayList<>();
        test2.add(new Animal("Bastet", Animal.Type.CAT, Animal.Sex.F, 9, 180, 70, false));
        test2.add(new Animal("Scooby-Doo", Animal.Type.DOG, Animal.Sex.M, 3, 76, 54, false));

        List<List<Animal>> testList = new ArrayList<>();
        testList.add(test1);
        testList.add(test2);

        // when
        Animal answer = Task18.heaviestFish(testList);

        // then
        assertThat(answer).isNull();
    }
}
