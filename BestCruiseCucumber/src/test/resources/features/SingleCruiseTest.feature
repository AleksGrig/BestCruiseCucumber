@Search-Cruises
Feature: Single Cruise Test

In order to find good cruise I need to find it and check its price

Scenario Outline: In order to find cheap cruise
	Given user navigates to "<cruiseadress>" page
	Then user compares "<cruisename>" price with "<price_limit>"
	 
Examples:
	| cruisename                  | cruiseadress                         | price_limit |
	| cruiseRome2411Rome0512Haifa | https://www.cruclub.ru/offer/107217/ | 30000       |
	| cruiseRome1612Rome2712Haifa | https://www.cruclub.ru/offer/104612/ | 30000       |
	| cruiseRome0701Rome1801Haifa | https://www.cruclub.ru/offer/104609/ | 30000       |
