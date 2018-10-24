Feature: Github Login Feature

  Background: User is on login page
    To test Login functionality user should be on login page

    Given user is on home page
    And login link is displayed
    When user clicks on login link
    Then user should be on login page


  Scenario Outline: User should not able to login using invalid login data
    The intent of this scenario is to check user should not be able to login using incorrect credential combinations
    Given user is on login page
    When User enters "<username>" and "<password>" as login details
    And clicks on login button
    Then user should not able to login succesfully
    And Incorrect username or password error message should be displayed
    Examples:
      | username    | password  |
      | testuser    | passwd    |
      | mangeshrane | passwd    |
      | admin       | 12342141  |






