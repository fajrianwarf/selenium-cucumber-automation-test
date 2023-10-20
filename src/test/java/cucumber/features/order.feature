Feature: Ordering Product in Swag Labs

@Positive, @Order_scc
Scenario: Success ordering product
  Given I already login into dashboard
  When Adding backpack to cart
  Then Go to cart
  Then Checking out product
  Then Filling all the form
  And Continuing order
  Then Finish the order
  Then User should see order notification

@Negative, @Order_err
Scenario: Success ordering product
  Given I already login into dashboard
  When Adding backpack to cart
  Then Go to cart
  Then Checking out product
  Then Filling all the form
  And Continuing order
  Then Cancel the order
  Then User should going back to dashboard