Feature: Validate login and logout function in OrangeHRM website

  Scenario: User able to login with valid info in orangehrm
    Given user go to login page of OrangeHRM
    When user enters valid username
    And user enters valid password
    Then user click on the login button of OrangeHRM
    When user click on the Welcome Admin
    Then user click on the logout button
    And user close the browser of orangehrm