@Google
  #pasar de lenguaje gherking a lenguaje tecnico o step definition
  Feature: try the principal funcionality
    Scenario Outline: select the flights, the dates, the amoungt of passengers and the price most economic.
      Given go to the fligth page
      When select1 the <Origin>
      And select2 the <Departure>
      And select departure date <DayD> / <MonthD> / <YearD>
      And select income date <DayI> / <MonthI> / <YearI>
      And select the amoungth of <Adult> / <Child> / <Baby>
      And search the most economic price and select
      Examples:

      |Origin||Departure|   |DayD||MonthD||YearD||DayI||MonthI||YearI||Adult|Child||Baby|
      |Medellin||Bogota| |15  | |11   ||2022|  |18  ||11   | |2022| | 2   |   2 || 0  |


