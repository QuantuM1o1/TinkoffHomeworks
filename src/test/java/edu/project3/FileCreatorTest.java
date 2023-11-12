package edu.project3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileCreatorTest {
    @Test
    @DisplayName("Создание файла")
    void createFile() {
        // given
        String fileFormat = ".txt";
        List<Log> logList = new ArrayList<>();
        logList.add(new Log(
            "20.38.50.37",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            2642,
            "-",
            "Opera/10.33"
            ));
        logList.add(new Log(
            "130.220.210.145",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            1731,
            "-",
            "Opera/10.33"
        ));
        logList.add(new Log(
            "121.8.89.31",
            "-",
            OffsetDateTime.MIN,
            "HEAD",
            "/analyzing%20Multi-lateral.svg",
            404,
            1552,
            "-",
            "Opera/10.46"
        ));
        List<Path> pathList = new ArrayList<>();
        pathList.add(Paths.get("src/main/resources/project3/logs.txt"));
        LocalDate startDate = LocalDate.MIN;
        LocalDate finalDate = LocalDate.MAX;

        // when
        String answer = FileCreator.createFileWithStats(fileFormat, logList, pathList, startDate, finalDate);

        // then
        assertThat(answer).isEqualTo("""
                ### Общая информация:\s
                \s
                |               Метрика | Значение |
                |:---------------------:|:--------:|
                |              Файл(-ы) | logs.txt |
                |        Начальная дата |        - |
                |         Конечная дата |        - |
                |   Количество запросов |        3 |
                | Средний размер ответа |   1975 b |

                ### Запрашиваемые ресурсы:\s
                \s
                |                        Ресурсы | Количество |
                |:------------------------------:|:----------:|
                |                 /emulation.gif |          2 |
                | /analyzing%20Multi-lateral.svg |          1 |

                ### Коды ответа:\s
                \s
                | Код | Сообщение | Количество |
                |:---:|:---------:|:----------:|
                | 200 |        OK |          2 |
                | 404 | Not Found |          1 |

                ### Юзер агенты:\s
                \s
                |      Агенты | Количество |
                |:-----------:|:----------:|
                | Opera/10.33 |          2 |
                | Opera/10.46 |          1 |

                ### Запросы:\s
                \s
                | Код запроса | Количество |
                |:-----------:|:----------:|
                |         GET |          2 |
                |        HEAD |          1 |
                """);
    }
}
