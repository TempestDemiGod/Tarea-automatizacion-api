package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeletePassenger implements Task {
    private final String id;

    public DeletePassenger(String id) {
        this.id = id;
    }

    public static Performable fromPage(String id) {
        return instrumented(DeletePassenger.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/passenger/"+id)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .log()
                                .all()));
    }
}
