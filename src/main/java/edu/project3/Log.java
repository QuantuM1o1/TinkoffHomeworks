package edu.project3;

import java.net.HttpURLConnection;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public record Log(
    String address,
    String user,
    OffsetDateTime time,
    String status,
    String requestAddress,
    int responseCode,
    int bytesSent,
    String httpReferer,
    String userAgent
    ) {
    private static final Map<Integer, String> HTTP_RESPONSE = new HashMap<>();

    static {
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_OK, "OK");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_CREATED, "Created");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_ACCEPTED, "Accepted");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_NOT_AUTHORITATIVE, "Non-Authoritative Information");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_NO_CONTENT, "No Content");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_RESET, "Reset Content");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_PARTIAL, "Partial Content");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_MULT_CHOICE, "Multiple Choices");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_MOVED_PERM, "Moved Permanently");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_MOVED_TEMP, "Moved Temporarily");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_SEE_OTHER, "See Other");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_NOT_MODIFIED, "Not Modified");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_USE_PROXY, "Use Proxy");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_BAD_REQUEST, "Bad Request");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_UNAUTHORIZED, "Unauthorized");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_PAYMENT_REQUIRED, "Payment Required");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_FORBIDDEN, "Forbidden");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_NOT_FOUND, "Not Found");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_BAD_METHOD, "Method Not Allowed");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_NOT_ACCEPTABLE, "Not Acceptable");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_PROXY_AUTH, "Proxy Authentication Required");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_CLIENT_TIMEOUT, "Request Time-Out");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_CONFLICT, "Conflict");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_GONE, "Gone");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_LENGTH_REQUIRED, "Length Required");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_PRECON_FAILED, "Precondition Failed");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_ENTITY_TOO_LARGE, "Request Entity Too Large");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_REQ_TOO_LONG, "Request-URI Too Large");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_UNSUPPORTED_TYPE, "Unsupported Media Type");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_INTERNAL_ERROR, "Internal Server Error");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_NOT_IMPLEMENTED, "Not Implemented");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_BAD_GATEWAY, "Bad Gateway");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_UNAVAILABLE, "Service Unavailable");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_GATEWAY_TIMEOUT, "Gateway Timeout");
        HTTP_RESPONSE.put(HttpURLConnection.HTTP_VERSION, "HTTP Version Not Supported");
    }

    public static String getResponseMessage(int resCode) {
        return HTTP_RESPONSE.get(resCode);
    }
}
