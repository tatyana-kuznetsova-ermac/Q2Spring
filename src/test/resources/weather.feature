Feature: City coordinates testing

  Scenario: Coordinates check
    Given country: uk
    And city: London

    When we are requesting weather data

    Then lon is -0.13
    And lat is 51.51

    And weather data is:
      | id          | 300                     |
      | main        | Drizzle                 |
      | description | light intensity drizzle |
      | icon        | 09d                     |

    And base is stations

    And main data is:
      | temp     | 280.32 |
      | pressure | 1012   |
      | humidity | 81     |
      | temp_min | 279.15 |
      | temp_max | 281.15 |

    And visibility is 10000

    And wind is:
      | speed | 4.1 |
      | deg   | 80  |

    And clouds is :
      | all | 90 |

    And dt is 1485789600

