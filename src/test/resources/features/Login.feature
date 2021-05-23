Feature: Login Scenarios

  Scenario Outline: Login with Invalid credentials
    Given User navigates to login page
    When User enters the email address as "<email>"
    And User enters password as "<password>"
    And User clicks on Sign In button
    Then User should see error message on Login screen

    Examples:
      | email                | password    |
      | rishabhb441@gmail.com  | Comm@0100  |

  Scenario: Validate Forgot your password navigation
    Given User navigates to login page
    When User clicks on Forgot your password link
    Then User should navigate to Forgot your password page

  Scenario Outline: Login Scenario for empty Password field
    Given User navigates to login page
    When User enters email address as "<email>"
    And User clicks on Sign In button
    Then User should see inline error messages for password field

    Examples:
      | email                |
      | rishabhb441@gmail.com  |

  Scenario Outline: Login Scenario for invalid Email address
    Given User navigates to login page
    When User enters email address as "<email>"
    And  User enters password as "<password>"
    And User clicks on Sign In button
    Then User should see inline error messages for invalid email

    Examples:
      | email                | password    |
      | rishabhb441            | Comm@0100  |