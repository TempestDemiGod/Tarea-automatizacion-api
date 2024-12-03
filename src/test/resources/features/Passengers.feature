@Passengers
Feature: Passenger API

  Como un usuario de la API de aerolíneas
  Quiero poder crear, obtener datos, editar y eliminar un pasajero
  Para poder verificar los detalles de las aerolíneas disponibles en pasajeros

  Background:
    Given el actor establece el endpoint para pasajeros
#  @TC-Create-passenger
#  Scenario Outline: Creacion de un pasajero exitosamente
##    Given el actor establece el endpoint para pasajeros
#    When el envia una solicitud POST con el "<name>" "<trips>" "<airline>"
#    Then el codigo de respuesta deberia ser 200
#    Examples:
#      | name           | trips | airline                              |
#      | tempest        | 250   | 66038402-402d-4a3f-baef-7cb5f53697a8 |
#      | RIMURU DEMIGOD | 254   | 66038402-402d-4a3f-baef-7cb5f53697a8 |

  @TC-Get-passenger
  Scenario: Obtener los datos del pasajero tempest
#    Given el actor establece el endpoint para pasajeros
    When el actor envia una solicitud GET para los datos del Pasajero
    Then el codigo de respuesta deberia ser 200

  @TC-Patch-passenger
  Scenario Outline: Editar los datos del pasajero tempest
#    Given el actor establece el endpoint para editar datos del pasajero
    When el envia una solicitud PATCH para editar datos del Pasajero "<name>" "<trips>" "<id>"
    Then el codigo de respuesta deberia ser 200
    And el actor envia una solicitud GET para los datos del Pasajero
    And el codigo de respuesta deberia ser 200
    Examples:
      | name            | trips | id                       |
      | Tempest DemiGod | 300   | 674ea216abdcfa62996f6d56 |
      | Darkin God      | 400   | 674ea216abdcfa62996f6d56 |
      | Deus Soul       | 342   | 674ea216abdcfa62996f6d56 |
      | Tempest         | 234   | 674ea216abdcfa62996f6d56 |

  @TC-Delete-passenger
  Scenario Outline: Eliminar al pasajero tempest DEMIGOD
#    Given el actor establece el endpoint para eliminar al pasajero
    When el envia una solicitud DELETE para eliminar al Pasajero "<id>"
    Then el codigo de respuesta deberia ser 200
    Examples:
      | id                       |
      | 674ea216abdcfa62996f6d56 |

#  @TC-Get-passengerEliminated
#  Scenario: Obtener los datos del pasajero tempest DEMIGOD
#    Given el actor establece el endpoint para obtener datos del pasajero eliminado
#    When el actor envia una solicitud GET para los datos del Pasajero eliminado
#    Then el codigo de respuesta deberia ser 204 para el pasajero eliminado
#
#  @TC-Get-passenger-RIMURU-DEMIGOD
#  Scenario: Obtener los datos del pasajero RIMURU DEMIGOD
#    Given el actor establece el endpoint para obtener datos del pasajero restante
#    When el actor envia una solicitud GET para los datos del Pasajero
#    Then el codigo de respuesta deberia ser 200