package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HackerNews {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String UNABLE_TO_CONNECT = "Couldn't reach a URL";
    public static final String TOP_STORIES_FROM_HACKER_NEWS = "https://hacker-news.firebaseio.com/v0/topstories.json";
    public static final String FIND_NEWS_BY_ID = "https://hacker-news.firebaseio.com/v0/item/";

    private HackerNews() {
    }

    public static long[] hackerNewsTopStories() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder(URI.create(TOP_STORIES_FROM_HACKER_NEWS)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String[] stringToReturn = response.body().replace("[", "").replace("]", "").split(",");
            long[] answer = new long[stringToReturn.length];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = Long.parseLong(stringToReturn[i]);
            }
            return answer;
        } catch (IOException | InterruptedException e) {
            LOGGER.info(UNABLE_TO_CONNECT);
            return new long[0];
        }
    }

    public static String news(long id) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder(URI.create(FIND_NEWS_BY_ID + id + ".json")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Pattern pattern = Pattern.compile("^.*\"title\":\"(.+)\",\"t.*$");
            Matcher matcher = pattern.matcher(response.body());
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IOException | InterruptedException e) {
            LOGGER.info(UNABLE_TO_CONNECT);
        }
        return "";
    }
}
