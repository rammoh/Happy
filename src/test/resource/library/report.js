$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/cucumber/feature/loginAdactin.feature");
formatter.feature({
  "line": 1,
  "name": "Login functionality module of automation practise web page",
  "description": "conatins E2E functionality such as login, add a product to card,place order,\n and signout",
  "id": "login-functionality-module-of-automation-practise-web-page",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "verify the user login the application with valid credentials",
  "description": "",
  "id": "login-functionality-module-of-automation-practise-web-page;verify-the-user-login-the-application-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@sce1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "user navigates to the application",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user enter the valid usernames",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user enter the valid passwords",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user click the signin buttons",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.user_navigates_to_the_application()"
});
formatter.result({
  "duration": 3102295100,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.user_enter_the_valid_usernames()"
});
formatter.result({
  "duration": 635432200,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.user_enter_the_valid_passwords()"
});
formatter.result({
  "duration": 254546600,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.user_click_the_signin_buttons()"
});
formatter.result({
  "duration": 2626992600,
  "status": "passed"
});
});