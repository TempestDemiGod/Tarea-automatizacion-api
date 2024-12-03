package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PatchPassenger implements Task {
    private final String name, trips , id;

    public PatchPassenger(String name,String trips, String id) {
        this.name = name;
        this.trips = trips;
        this.id = id;
    }

    public static Performable fromPage(String name,String trips, String id) {
        return instrumented(PatchPassenger.class, name, trips , id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Patch.to("/passenger/"+id)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body("{\"name\":\"" + name
                                        + "\"}")
                                .log()
                                .all()));
    }
}
