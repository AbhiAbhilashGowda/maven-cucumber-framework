Feature: Validate the login functionality for e2eHiring application

        @login @one
      Scenario: Verification of login functionality with valid credentials
Given I launch the application
When I enter emailid "sunny@mail7.io"
When I enter password "Diatoz@123"
Then I click on login button