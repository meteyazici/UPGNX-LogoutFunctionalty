Feature: Upgenix Logout Functionality feature

  User Story :

  As a user, I should be able to log out.


  Background: User is expected to home page
    Given User is on the login page
    When  User enters valid username
    And   User enters valid password
    And   User click the login button
    Then  User should see in title and it should contains "Odoo"

  @UPGN-816
  Scenario Outline: User can log out and ends up in login page.
    When As a user go and click the usermenu top right of the page
    And As a user go and click to logout button
    Then User should see login page, title should contains <loginPageTitle>
    Examples:
      | loginPageTitle |
      | "Login"        |

  @UPGN-817
  Scenario Outline: The user can not go to the home page again by clicking the step back button after successfully logged out.
    When As a user go and click the usermenu top right of the page
    And As a user go and click to logout button
    And User should see login page, title should contains <loginPageTitle>
    And As a user click the back button
    Then User shouldn't see the home page
    Examples:
      | loginPageTitle |
      | "Login"        |

  @UPGN-818
  Scenario Outline: The user must be logged out if the user closes the open tab (all tabs if there are multiple open tabs)
    When As a user click the open new tab and go to celander
    And As a user click the open new tab button for random page
    And As a close the upgenix tabs
    And As a user go to upgenix homepage
    And User should see login page, title should contains the <loginPageTitle>
    Examples:
      | loginPageTitle |
      | "Login"        |






