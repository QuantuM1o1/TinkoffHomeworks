package edu.hw3;

import edu.hw3.Task6.Market;
import edu.hw3.Task6.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Проверка add")
    void addCheck() {
        // given
        Stock test = new Stock("AAPL", 173);
        Market market = new Market();

        // when
        market.add(test);
        Stock answer = market.mostValuableStock();

        // then
        assertThat(answer.getName()).isEqualTo("AAPL");
    }

    @Test
    @DisplayName("Проверка remove")
    void removeCheck() {
        // given
        Stock test = new Stock("AAPL", 173);
        Market market = new Market();

        // when
        market.add(test);
        Stock answer = market.mostValuableStock();
        assertThat(answer.getName()).isEqualTo("AAPL");
        market.remove(test);
        answer = market.mostValuableStock();

        // then
        assertThat(answer).isNull();
    }

    @Test
    @DisplayName("Проверка вывода самой дорогой акции")
    void mvsCheck() {
        // given
        Stock test1 = new Stock("AAPL", 173);
        Stock test2 = new Stock("GOOG", 140);
        Stock test3 = new Stock("Dow Jones", 33_141);
        Stock test4 = new Stock("BNO", 31);
        Market market = new Market();

        // when
        market.add(test1);
        market.add(test2);
        market.add(test3);
        market.add(test4);
        Stock answer = market.mostValuableStock();

        // then
        assertThat(answer.getName()).isEqualTo("Dow Jones");
    }
}
