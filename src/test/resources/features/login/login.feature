Feature: Login into the application
  @login
   Scenario: Succesful login
    Given Daniela has an active account
    When she sends their valid credentials
    Then she should have access to manage his account

  Scenario: Remember things
    Given Daniela wants to remember something
    When she tries to remember Foo
    Then she should get Foo

  @dev
  Scenario: Successful login 5
    Given Pepito has a token

  Scenario: Failed 1
    Given pepito failed1

  Scenario: Failed 2
    Given pepito failed2

  Scenario: Compromised 1
    Given pepito compromised


