package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Проверка вывода")
    void calling() {
        // given
        CallingInfo info;

        // when
        info = Task4.callingInfo();
        String answer = info.toString();

        // then
        assertThat(answer).isEqualTo("CallingInfo[className=com.intellij.rt.junit.JUnitStarter, methodName=main]");
    }
}
