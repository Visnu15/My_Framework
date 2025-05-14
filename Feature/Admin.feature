Feature: Automating the functionalities of Admin module

  @sample
  Scenario Outline: Adding new user in Admin
    Given user launches the application
    And user logs in using <username> and <password>
    When user navigates to Admin - Add user
    Then user adds a new user
    And user logs out from the application

    Examples:
      |username|password|
      |Admin|admin123|