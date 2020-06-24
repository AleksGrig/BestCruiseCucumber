@Search-Cruises
Feature: Parameterized Search Test

In order to find good cruise I need to find it and check its price

Scenario Outline: In order to find cheap cruise
	Given user navigates to "<cruiseadress>" page
	Then user chooses destination "<region>"
	And chooses destination "<country>"
	And chooses departure "<port>"
	And chooses minimum cruise "<length>"
	And clicks submit button
	Then sorts cruises 
	And loads first cruise
	Then user compares "<cruisename>" price with "<price_limit>"
	 
Examples:
| cruisename    | cruiseadress           | region        | country    | port   |length| date      | price_limit|
| BritishIslands| https://www.cruclub.ru/| BritishIslands| SkipCountry| AnyCity|   6  | 1 февраль | 50000      |
| Mediterranean | https://www.cruclub.ru/| Mediterranean | SkipCountry| Rome   |   6  | 1 февраль | 50000      |	
	
