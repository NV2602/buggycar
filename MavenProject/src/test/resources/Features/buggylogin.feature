#Auther - Neelam Verma
#Date - 23-09-22
#Description - Feature file for Registeration page (buggy car) 

Feature: Registeration for new user

  @Regression_scenario1
  Scenario Outline: Registration functionality without password criteria matching
    Given The User Navigate to the application
    When The user selects Registeration option
    Then User enters <Login> , <FirstName> , <LastName> , <NoCaptialCharPassword>, <NoCaptialCharConfirmPassword>
    When The User click to Register button
    Then User registration is unsuccessful
    Then User enters Password again <Login> , <FirstName> , <LastName>, <NoSymolPassword> , <NoSymbolConfirmpassword>
    And User again click to Register button
    Then User registration is again unsuccessful
    And User entering Password without Lowercase character <Login> , <FirstName> , <LastName>, <NoLowerCharPassword> , <NoLowerCharConfirmPassword>
    And User again click to Register button for Registeration
    Then User registration is again unsuccessful because password standared

    Examples: 
      | Login    | FirstName | LastName | NoCaptialCharPassword | NoCaptialCharConfirmPassword | NoSymolPassword | NoSymbolConfirmpassword | NoLowerCharPassword | NoLowerCharConfirmPassword |
      | Test1988 | NV2606    | TK2606   | neelam@168            | neelam@168                   | Neelam123       | Neelam123               | NEELAM@262          | NEELAM@262                 |

  @Regression_scenario2
  Scenario Outline: Registration functionality with password criteria matching
    Given User try to register again
    When Enters <UsersLogin> , <UsersFirstName> , <UsersLastName>, <Password> , <ConfirmPassword>
    And click to Register button for Registeration
    Then Registration is successful and a message will be display

    Examples: 
      | UsersLogin | UsersFirstName | UsersLastName | Password     | ConfirmPassword |
      | SwiftTest1  | SV2407         | TG2607        | Neelam@1985 | Neelam@1985    |

  @Regression_scenario3
  Scenario Outline: Validate a user can Register once
    Given User tries to register with existing credientals
    When Entering existing credienatls <ExistingLogin> , <ExistingFirstName> , <ExistingLastName>, <ExistingPassword> , <ExistingConfirmPassword>
    And Try to submit
    Then Validation should occurs for user can only register once

    Examples: 
      | ExistingLogin | ExistingFirstName | ExistingLastName | ExistingPassword | ExistingConfirmPassword |
      | SwiftTest1    | TN8933            | NT696            | Neelam@1985     | Neelam@1985            |
