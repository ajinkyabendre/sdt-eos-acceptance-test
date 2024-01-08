@Application
Feature: Login to Employee Management Application


Scenario: successful Login
	Given I setup with "CHROME" browser
	And I set appian version to "23.4"
	And I set appian locale to "en_US"
	When I login to url "https://techtamminaapps.appiancloud.com/suite/sites/automation-testing-application" with username "auto.test.user1"
	Then I see home page
	Then I logout

Scenario: Unsuccessful Login
	Given I am on Sign In Page
	When I populate username with "invalid.test.user1"
	And  I populate password with "Welcome@1234"
	And  I click Sign In Button
	Then I verify text "The username/password entered is invalid." is present

Scenario: Blank Username and Password
	Given I am on Sign In Page
	When I populate username with ""
	And  I populate password with ""
	And  I click Sign In Button
	Then I verify text "The username/password entered is invalid." is present

Scenario: Tear Down
	Then I tear down

