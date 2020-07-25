package com.mkyong.hashing;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    private static final HttpClient httpClient = HttpClient.newBuilder()
    //.followRedirects(HttpClient.Redirect.NORMAL)
    .version(HttpClient.Version.HTTP_2)
    .connectTimeout(Duration.ofSeconds(10))
    .build();
    public static void main(String[] args) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = new StringBuilder()
                .append("{")
                .append("\"title\": \"CONFITERIA SAN RODRIGO\",\"address\": \"Calle 125 #52A-17, Bogotá\",\"latitude\": null,\"longitude\": null,\"load\": 50,\"window_start\": \"09:00\",\"window_end\": \"19:00\",\"duration\": \"00:20:00\",\"contact_name\": \"Paulina Muñoz\",\"contact_phone\": \"965847147\",\"contact_email\": \"paulinamunoz@ejemplo.com\",\"reference\": \"invoice_id\",\"notes\": \"Leave\",\"planned_date\": \"2020-07-14\"")
                .append("}").toString();

        String json2 = new StringBuilder()
                .append("{")
                .append("\"title\": \"CONFITERIA SAN RODRIGO\",\"body\": \"CONFITERIA SAN RODRIGO\",\"userId\": \"1\"")
                .append("}").toString();

        String json3 = new StringBuilder()
                .append("{")
                .append("\"name\":\"eduardo\",\"job\":\"coo\"")
                .append("}").toString();
                
        //System.out.println(jsonString);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json3))
                //.uri(URI.create("https://api.simpliroute.com/v1/routes/visits"))
                .uri(URI.create("https://reqres.in/api/users")) 
                .setHeader("User-Agent", "MDW TG HttpClient Bot") // add request header
                //.setHeader("authorization", "Token 639f89c3b848beaee1b38efe18fcafd288941388") // add request header
                .header("Content-Type", "application/json")
                .header("Accept", "*/*")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print response headers
        //HttpHeaders headers = response.headers();
        //headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        System.out.println(response.statusCode());
        // print response body
        System.out.println(response.body());

    }

}
