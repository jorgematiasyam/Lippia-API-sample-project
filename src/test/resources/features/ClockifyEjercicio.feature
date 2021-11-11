Feature: Projects
  COMO usuario de Clockify
  QUIERO crear proyectos en mi Worckspace
  PARA llevar un buen control de mis horas de trabajo y el de mis empleados


@jmy
Scenario Outline: Realizar un Get time entries
Given que genere un X-Api-Key valido
And un workspace ID valido
And un User Id valido
When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
And se obtuvo el status code <status>
Then Valido los datos obtenidos

Examples:
| operation | entity    | jsonName            | status |
| GET       | TIMEENTRY | GetTimeEntries      | 200    |

@jmy
Scenario Outline: Realizar un Post time entries
Given que genere un X-Api-Key valido
And un workspace ID valido
When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
And se obtuvo el status code <status>
Then valido el ID
And guardo el id

Examples:
| operation | entity    | jsonName         | status |
| POST      | TIMEENTRY | PostTimeEntries  | 201    |


@jmy
Scenario Outline: Realizar un Put time entries
  Given que genere un X-Api-Key valido
  And un workspace ID valido
  #And designar time entry id
  #And designar una nueva hora <startedHour>
  When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
  And se obtuvo el status code <status>
  Then valido el ID

  Examples:
    | operation | entity    | jsonName           | status |
    | PUT      | TIMEENTRY | PutTimeEntries      | 200    |


