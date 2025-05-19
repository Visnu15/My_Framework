Feature: Automating the functionalities of Admin module

  @sample
  Scenario Outline: Adding new user in Admin
    Given user launches the application
    And user enters the credentials "<username>" and "<password>"
    Then user logs in to the application
    When user navigates to Admin
    Then user adds a new user
    And user logs out from the application

    Examples:
      |username|password|
      |Admin|admin123|