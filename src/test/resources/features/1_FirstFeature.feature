@Application
Feature: Sample feature file that interacts with an Appian application

	Configuring your site with the sample application:
	1. Import the applicable version of Automated Testing - XX.X.zip application, provided in the Shared Components page, into your Appian environment
	2. Log into Appian Designer view on your Appian environment and import the downloaded application zip
	3. After import is complete, click on the Automated Testing application
	4. Find and click on the AUT DS object to open the Appian Data Store Designer
	5. Verify the entity mappings under Schema Management and then Save & Publish the data store

	Prerequisites for running the test on the configured site above:
	1. Run the appropriate setupCustomPropertiesFor... script
	2. Replace BROWSER with either FIREFOX or CHROME
	3. Replace APPIAN_URL with your Appian site URL, beginning with https:// and including /suite at the end (e.g. https://forum.appian.com/suite)
	4. Replace APPIAN_VERSION with a supported Appian Version in xx.x format
	5. Replace APPIAN_LOCALE with either "en_US" or "en_GB"
	5. Replace APPIAN_USERNAME with a valid username for Appian URL above
	6. Open src/main/resources/configs/users.properties and add a line for the above username that is of the form username=password (e.g. test.user=password)



	Scenario: Login to Appian environment
		Given I setup with "CHROME" browser
		When I set appian URL to "https://techtamminaapps.appiancloud.com/suite/sites/automation-testing-application"
		And I set appian version to "23.4"
		And I set appian locale to "en_US"
		Then I login with username "auto.test.user1"

	Scenario: Add Employee Details
		Given I set test variable "varFirstName" with random UUID
		And I verify button "New Employee" is present
		And I click on button "New Employee"
		When I populate field "First Name" with "tv!varFirstName"
		And I populate field "Middle Name" with "Arvind"
		And I populate field "Last Name" with "Bendre1"
		And I populate field "Dob" with "06/22/1990"
		And I populate field "Gender" with "Male"
		And I populate field "Phone" with "5716862747"
		And I populate field "Address Line1" with "190 Laurel Way, APT B"
		And I populate field "Address Line2" with "Stuart Woods "
		And I populate field "City" with "H erndon"
		And I populate field "Pan Number" with "BBDFD5254F"
		And I populate field "Aadhar Number" with "2123122378"
		And I click on button "CREATE"
		And I wait for "3" seconds
		And I search for "tv!varFirstName"
		And I click on record "[1]"
		And I verify field "First Name" contains "tv!varFirstName"
		And I verify field "Middle Name" contains "Arvind"
		And I verify field "Last Name" contains "Bendre"
		And I verify field "Dob" contains "June 22, 1990"
		And I verify field "Gender" contains "Male"
		And I verify field "Phone" contains "5716862747"
		And I verify field "Address Line1" contains "190 Laurel Way, APT B"
		And I verify field "Address Line2" contains "Stuart Woods "
		And I verify field "City" contains "Herndon"
		And I verify field "Pan Number" contains "BBDFD5254F"
		And I verify field "Aadhar Number" contains "2123122378"

	Scenario: Logout
		Given I logout
		Then I tear down

