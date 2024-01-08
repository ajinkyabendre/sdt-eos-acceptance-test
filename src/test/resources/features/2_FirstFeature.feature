@Application
Feature: Sample feature file that interacts with an Appian application

	Scenario: Setup
		Given I setup with "CHROME" browser
		And I set appian version to "23.4"
		And I set appian locale to "en_US"

	Scenario: Add Employee : Positive Scenario
		Given I am on Sign In Page
			And  I login to url "https://techtamminaapps.appiancloud.com/suite/sites/automation-testing-application" with username "auto.test.user1"
			And I see home page
			And I set test variable "varFirstName" with random UUID
		When I click on button "New Employee"
			And I populate field "First Name" with "tv!varFirstName"
			And I populate field "Middle Name" with "Ajinkya"
			And I populate field "Last Name" with "Bendre"
			And I populate field "Dob" with "06/22/1990"
		    And I populate field "Email" with "abendre@sdt.com"
			And I populate field "Gender" with "Male"
			And I populate field "Phone" with "5716862747"
			And I populate field "Address Line1" with "190 Laurel Way, APT B"
			And I populate field "Address Line2" with "Stuart Woods "
			And I populate field "City" with "Herndon"
			And I populate field "Pan Number" with "BBDFD5254F"
			And I populate field "Aadhar Number" with "2123122378"
			And I click on button "CREATE"
			And I search for "tv!varFirstName"
			And I click on record "[1]"
		Then I verify field "First Name" contains "tv!varFirstName"
			And I verify field "Middle Name" contains "Ajinkya"
			And I verify field "Last Name" contains "Bendre"
			And I verify field "Dob" contains "June 22, 1990"
		    And I verify field "Email" contains "abendre@sdt.com"
			And I verify field "Gender" contains "Male"
			And I verify field "Phone" contains "5716862747"
			And I verify field "Address Line1" contains "190 Laurel Way, APT B"
			And I verify field "Address Line2" contains "Stuart Woods "
			And I verify field "City" contains "Herndon"
			And I verify field "Pan Number" contains "BBDFD5254F"
			And I verify field "Aadhar Number" contains "2123122378"

	Scenario: Add Employee : Blank Checks
		Given I am on Sign In Page
			And  I login to url "https://techtamminaapps.appiancloud.com/suite/sites/automation-testing-application" with username "auto.test.user1"
			And I see home page
			And I set test variable "varFirstName" with random UUID
		When I click on button "New Employee"
			And I click on button "CREATE"
		Then I verify field "First Name" contains validation message "A value is required"
			And I verify field "Last Name" contains validation message "A value is required"
			And I verify field "Gender" contains validation message "A value is required"
			And I verify field "Phone" contains validation message "A value is required"
			And I verify field "Dob" contains validation message "A value is required"
			And I verify field "Email" contains validation message "A value is required"
			And I verify field "Address Line1" contains validation message "A value is required"
			And I verify field "Aadhar Number" contains validation message "A value is required"



	Scenario: Closure
		Then I tear down

