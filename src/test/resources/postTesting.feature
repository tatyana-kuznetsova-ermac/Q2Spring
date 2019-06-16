Feature: Testing  with POST and GET

  Scenario: New client creation test
    Given client to create:
      | name    | Tatyana             |
      | surname | neTatyana           |
      | age     | 15                  |
      | pk      | random              |
      | email   | sdjagjasgdjas@jk.lk |

    When we are sending client to server
    And  requesting list of all clients

    Then our new client exists in this list

