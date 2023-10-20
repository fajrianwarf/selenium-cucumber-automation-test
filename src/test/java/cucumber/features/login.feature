Feature: Login Page Swag Labs App

@Regression, @Positive, @Login_scc
Scenario: Success Login
  Given Login screen Swag Labs
  When Inputting username
  And Inputting password
  And Submitting login button
  Then User should see dashboard Swag Labs

@Regression, @Negative, @Login_err
Scenario: Failed Login
  Given Login screen Swag Labs
  When Inputting username
  And Inputting wrong password
  And Submitting login button
  Then User should see error message

