package edu.hw8;

import edu.hw8.Task3.HashGenerator;
import edu.hw8.Task3.MultiThreadBruteforcer;
import edu.hw8.Task3.OneThreadBruteforcer;
import edu.hw8.Task3.PasswordBruteforcer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Перебор пароля на одном потоке")
    void oneThread() {
        // given
        List<String> input = new ArrayList<>();
        input.add("a.v.petrov" + " " + HashGenerator.generateMD5Hash("9123"));
        input.add("v.v.belov" + " " + HashGenerator.generateMD5Hash("pass"));
        input.add("a.s.ivanov" + " " + HashGenerator.generateMD5Hash("Aiya"));
        input.add("k.p.maslov" + " " + HashGenerator.generateMD5Hash("YeaH"));

        // when
        PasswordBruteforcer bruteforcer = new OneThreadBruteforcer(input, 4);
        Map<String, String> answer = bruteforcer.start();

        // then
        assertThat(answer.get("a.v.petrov")).isEqualTo("9123");
        assertThat(answer.get("v.v.belov")).isEqualTo("pass");
        assertThat(answer.get("a.s.ivanov")).isEqualTo("Aiya");
        assertThat(answer.get("k.p.maslov")).isEqualTo("YeaH");
    }

    @Test
    @DisplayName("Перебор пароля на нескольких потоках")
    void multiThread() {
        // given
        List<String> input = new ArrayList<>();
        input.add("a.v.petrov" + " " + HashGenerator.generateMD5Hash("9123"));
        input.add("v.v.belov" + " " + HashGenerator.generateMD5Hash("pass"));
        input.add("a.s.ivanov" + " " + HashGenerator.generateMD5Hash("Aiya"));
        input.add("k.p.maslov" + " " + HashGenerator.generateMD5Hash("YeaH"));

        // when
        PasswordBruteforcer bruteforcer = new MultiThreadBruteforcer(input, 4, 4);
        Map<String, String> answer = bruteforcer.start();

        // then
        assertThat(answer.get("a.v.petrov")).isEqualTo("9123");
        assertThat(answer.get("v.v.belov")).isEqualTo("pass");
        assertThat(answer.get("a.s.ivanov")).isEqualTo("Aiya");
        assertThat(answer.get("k.p.maslov")).isEqualTo("YeaH");
    }
}
