package com.telran.phonebook.apiTests;

import api.dto.ContactDto;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class DeleteContactByIdRestAssuredTests {

    private String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Ik1hbkBnbWFpbC5jb20ifQ.WrrG8QAxug5R528pRggQFwfupKNEEGe73NvOKSvRwOo";

    int id;

    @BeforeMethod
    public void ensurePreconditions(){

        System.err.close();
        System.setErr(System.out);

        RestAssured.baseURI = "https://contacts-telran.herokuapp.com";
        RestAssured.basePath = "api";

        int i = (int) (System.currentTimeMillis()/1000%3600);

        ContactDto contactDto = ContactDto.builder()
                .address("Haifa")
                .description("IT")
                .email("tan" + i + "@gmail.com")
                .lastName("black")
                .name("Tom"+ i)
                .phone("123456" + i)
                .build();

         id = given().header("Authorization", token)
                .contentType("application/json")
                .body(contactDto)
                .post("contact")
                .then()
                .assertThat().statusCode(200)
                .extract().path("id");
    }

    @Test
    public void deleteContactByIdPositiveTest(){
        String status = given().header("Authorization", token)
                .delete("contact/" + id)
                .then()
                .assertThat().statusCode(200)
                .extract().path("status");
        System.out.println(status);
    }

}
