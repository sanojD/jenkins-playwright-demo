Feature: Login

  Scenario: Valid user can log in
    Given I open the login page
    When I login with "standard_user" and "secret_sauce"
    Then I should see the products page

  Scenario: Locked user cannot log in
    Given I open the login page
    When I login with "locked_out_user" and "secret_sauce"
    Then I should see an error message
