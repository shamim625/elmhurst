@smoketest
Feature: Validate login function in PHP travels

Scenario: User able to login with valid credential
Given user go to login page
When user enters a valid user name
And user enters a valid password
Then user click on the login button
And user verify the visibility of Hi Demo User
When user click on log out button
Then user close the browser