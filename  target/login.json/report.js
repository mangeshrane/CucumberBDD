$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/login.feature");
formatter.feature({
  "line": 1,
  "name": "Github Login Feature",
  "description": "",
  "id": "github-login-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 12,
  "name": "User should not able to login using invalid login data",
  "description": "The intent of this scenario is to check user should not be able to login using incorrect credential combinations",
  "id": "github-login-feature;user-should-not-able-to-login-using-invalid-login-data",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "user is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "User enters \"\u003cusername\u003e\" and \"\u003cpassword\u003e\" as login details",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "clicks on login button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "user should not able to login succesfully",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Incorrect username or password error message should be displayed",
  "keyword": "And "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "github-login-feature;user-should-not-able-to-login-using-invalid-login-data;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 20,
      "id": "github-login-feature;user-should-not-able-to-login-using-invalid-login-data;;1"
    },
    {
      "cells": [
        "testuser",
        "passwd"
      ],
      "line": 21,
      "id": "github-login-feature;user-should-not-able-to-login-using-invalid-login-data;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "User is on login page",
  "description": "To test Login functionality user should be on login page",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "user is on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "login link is displayed",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user clicks on login link",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user should be on login page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_is_on_home_page()"
});
formatter.result({
  "duration": 12431779256,
  "error_message": "java.lang.AssertionError: expected [The world’s leading software development platform · GitHub] but found [The worldâ€™s leading software development platform Â· GitHub]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:513)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:135)\r\n\tat org.testng.Assert.assertEquals(Assert.java:116)\r\n\tat org.testng.Assert.assertEquals(Assert.java:190)\r\n\tat org.testng.Assert.assertEquals(Assert.java:200)\r\n\tat stepDefinations.LoginSteps.user_is_on_home_page(LoginSteps.java:33)\r\n\tat ✽.Given user is on home page(features/login.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginSteps.login_link_is_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.user_clicks_on_login_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.login_page_should_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 21,
  "name": "User should not able to login using invalid login data",
  "description": "The intent of this scenario is to check user should not be able to login using incorrect credential combinations",
  "id": "github-login-feature;user-should-not-able-to-login-using-invalid-login-data;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "user is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "User enters \"testuser\" and \"passwd\" as login details",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "clicks on login button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "user should not able to login succesfully",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Incorrect username or password error message should be displayed",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_is_on_login_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "testuser",
      "offset": 13
    },
    {
      "val": "passwd",
      "offset": 28
    }
  ],
  "location": "LoginSteps.userEntersAndAsLoginDetails(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.clicks_on_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.user_should_not_able_to_login_succesfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.incorrect_username_or_password_error_message_should_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1083610528,
  "status": "passed"
});
});