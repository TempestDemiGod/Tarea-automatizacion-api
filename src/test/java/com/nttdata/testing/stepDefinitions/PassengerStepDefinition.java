package com.nttdata.testing.stepDefinitions;

import com.nttdata.testing.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PassengerStepDefinition {
    public static ArrayList<String> listPassenger = new ArrayList<String>();

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        System.out.println("lista pasajeros /********************************* "+listPassenger.toString());
    }
    public static void setList(Response response){
        listPassenger.add(response.jsonPath().get("_id").toString());
    }
    @Given("el {actor} establece el endpoint para pasajeros")
    public void elActorEstableceElEndpointParaCrearUnNuevoPasajero(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el envia una solicitud POST con el {string} {string} {string}")
    public void elActorEnviaUnaSolicitudPOSTConEl(String name, String trips, String airline) {
        theActorInTheSpotlight().attemptsTo(PostPassenger.fromPage(name, trips, airline));
        if (name.equals("tempest")){
//            cars.add(Serenity.getCurrentSession().get("passenger01").toString());
            Serenity.getCurrentSession().get("passenger01").toString();
//            airlineID = Serenity.getCurrentSession().get("passenger01").toString();
            System.out.println("IDPassenger ******************** "+  Serenity.getCurrentSession().get("passenger01").toString() );

        }else {
//            cars.add(Serenity.getCurrentSession().get("passenger02").toString());
            Serenity.getCurrentSession().get("passenger02").toString();
            System.out.println("IDPassenger ******************** "+ Serenity.sessionVariableCalled("passenger01") + "  *******  "+ Serenity.sessionVariableCalled("passenger02") );
        }

    }

//    String token1 = Serenity.getCurrentSession().get("passenger01").toString();
//    String token2 = Serenity.getCurrentSession().get("passenger02").toString();
//
//        System.out.println("user 01 : "+ token1);
//        System.out.println("user 02 : "+ token2);
    @When("el {actor} envia una solicitud GET para los datos del Pasajero")
    public void elActorEnviaUnaSolicitudGETParaLosDatosDelPasajero(Actor actor) {
//        String IDPassenger = Serenity.getCurrentSession().get("passenger01").toString();
//        System.out.println("IDPassenger ******************** "+Serenity.getCurrentSession().get("passenger01").toString());
        actor.attemptsTo(GetPassenger.fromEndpoint("/passenger/674ea216abdcfa62996f6d56"));
    }

    @When("el envia una solicitud PATCH para editar datos del Pasajero {string} {string} {string}")
    public void elActorEnviaUnaSolicitudPATCHParaEditarDatosDelPasajero(String name, String trips , String id) {
        theActorInTheSpotlight().attemptsTo(PatchPassenger.fromPage(name, trips, id));
    }

    @When("el envia una solicitud DELETE para eliminar al Pasajero {string}")
    public void elActorEnviaUnaSolicitudDELETEParaEliminarAlPasajero(String id) {
        theActorInTheSpotlight().attemptsTo(DeletePassenger.fromPage(id));
    }

//    @Given("el {actor} establece el endpoint para editar datos del pasajero")
//    public void elActorEstableceElEndpointParaEditarDatosDelPasajero() {
//    }
//
//    @When("el {actor} envia una solicitud PATCH para editar datos del Pasajero")
//    public void elActorEnviaUnaSolicitudPATCHParaEditarDatosDelPasajero() {
//    }
//
//    @Given("el {actor} establece el endpoint para eliminar al pasajero")
//    public void elActorEstableceElEndpointParaEliminarAlPasajero() {
//    }
//
//    @When("el {actor} envia una solicitud DELETE para eliminar al Pasajero")
//    public void elActorEnviaUnaSolicitudDELETEParaEliminarAlPasajero() {
//    }
//
//    @Given("el {actor} establece el endpoint para obtener datos del pasajero eliminado")
//    public void elActorEstableceElEndpointParaObtenerDatosDelPasajeroEliminado() {
//
//
//    }
//
//    @When("el {actor} envia una solicitud GET para los datos del Pasajero eliminado")
//    public void elActorEnviaUnaSolicitudGETParaLosDatosDelPasajeroEliminado() {
//    }
//
//    @Then("el codigo de respuesta deberia ser {int} para el pasajero eliminado")
//    public void elCodigoDeRespuestaDeberiaSerParaElPasajeroEliminado(int responseCode) {
//    }
//
//    @Given("el {actor} establece el endpoint para obtener datos del pasajero restante")
//    public void elActorEstableceElEndpointParaObtenerDatosDelPasajeroRestante() {
//    }
}
