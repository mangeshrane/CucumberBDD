#Author: ranemangesh555@gmail.com

Feature: creating user using user creation API.
  This API is used to create new user in the system

  Scenario: Check user creation using API
    Given API url is given
    When user makes request to API to create user using following data
    """
    {
    "name": "morpheus",
    "job": "leader"
		}
		"""
    Then response code should be 201
    And response body should contains following
      | name | morpheus |
      | job  | leader   |
      | id   | 59       |
