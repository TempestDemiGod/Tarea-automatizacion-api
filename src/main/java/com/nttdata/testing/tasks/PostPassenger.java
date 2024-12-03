package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import io.restassured.response.Response;

import java.util.ArrayList;


public class PostPassenger implements Task {
    public ArrayList<String> list = new ArrayList<String>();
    private final String name, trips, airline;
    public PostPassenger(String name, String trips, String airline) {
        this.name = name;
        this.trips = trips;
        this.airline = airline;
    }

    public static Performable fromPage(String name, String trips, String airline) {
        return instrumented(PostPassenger.class, name, trips, airline);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/passenger")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body("{\"name\":\"" + name
                                        + "\"," + "\"trips\":\"" + trips
                                        + "\"," + "\"airline\":\"" + airline + "\"}")
                                .log()
                                .all()));
        Response response = SerenityRest.lastResponse();
        imprimir(response);
    }

    public static void imprimir(Response response){
        System.out.println("response : "+response);
//        ArrayList AirlineArr = response.jsonPath().get("airline");

//        System.out.println("******************************* "+ response.jsonPath().get("_id").toString());

        if (response.jsonPath().get("name").equals("RIMURU DEMIGOD")){
            String name = Serenity.sessionVariableCalled("passenger01");
            System.out.println("///////////////////////// nam ////////////// "+name);
            Serenity.setSessionVariable("passenger02").to(response.jsonPath().get("_id").toString());
        }else {
            Serenity.setSessionVariable("passenger01").to(response.jsonPath().get("_id").toString());
        }

//        System.out.println("*************************************");
    }

}
