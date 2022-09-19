package com.telran.phonebook.apiTests;

import api.dto.AuthRequestDto;
import api.dto.AuthResponseDto;
import api.dto.ErrorDto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpClientTests {

    String email = "Man@gmail.com";
    String password = "Aa123456789~";

    @Test
    public void loginHttpClientPositiveTest() throws IOException {

        String email = "Man@gmail.com";
        String password = "Aa123456789~";

        Response response = Request.Post("https://contacts-telran.herokuapp.com/api/login")
                .bodyString("{\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"password\": \"" + password + "\"\n" +
                        "}", ContentType.APPLICATION_JSON)
                .execute();

        System.out.println(response);

        String responseJson = response.returnContent().asString();
        System.out.println(responseJson);

        JsonElement element = JsonParser.parseString(responseJson);
        JsonElement token = element.getAsJsonObject().get("token");
        System.out.println(token.getAsString());

        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Ik1hbkBnbWFpbC5jb20ifQ.WrrG8QAxug5R528pRggQFwfupKNEEGe73NvOKSvRwOo

    }

    @Test
    public void loginHttpClientPositiveTest1() throws IOException {
        Gson gson = new Gson();

        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email(email)
                .password(password)
                .build();
        Response response = Request.Post("https://contacts-telran.herokuapp.com/api/login")
                .bodyString(gson.toJson(requestDto), ContentType.APPLICATION_JSON)
                .execute();

        String responseJson = response.returnContent().asString();
        AuthResponseDto responseDto = gson.fromJson(responseJson, AuthResponseDto.class);
        System.out.println(responseDto);

    }

    @Test
    public void loginHttpClientNegativeTestWithInvalidPassword() throws IOException {
        Gson gson = new Gson();

        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email(email)
                .password("Aa123456789")
                .build();
        Response response = Request.Post("https://contacts-telran.herokuapp.com/api/login")
                .bodyString(gson.toJson(requestDto), ContentType.APPLICATION_JSON)
                .execute();

        HttpResponse httpResponse = response.returnResponse();
//        System.out.println(httpResponse);
        System.out.println(httpResponse.getStatusLine().getStatusCode());

        InputStream inputStream = httpResponse.getEntity().getContent();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        ErrorDto errorDto = gson.fromJson(stringBuilder.toString(), ErrorDto.class);
        System.out.println(errorDto.getDetails());
        System.out.println(errorDto.getMessage());
        System.out.println(errorDto.getTimestamp());

    }

}
