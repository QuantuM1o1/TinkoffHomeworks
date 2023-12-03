package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

class Handler implements Runnable {
    private final Map<String, String> map;

    {
        map = new HashMap<>();
        map.put("личности",
            "Не переходи на личности там, где их нет");
        map.put("оскорбления",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        map.put("глупый",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма");
        map.put("интеллект",
            "Чем ниже интеллект, тем громче оскорбления");
    }

    private final Socket socket;

    Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String input = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(map.get(input));
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException("Server couldn't read from a client");
        }
    }
}
