Feature: Tests all functionality of sauce labs login page
  
  Scenario: Successful login
    Given user navigate to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters username 'standard_user' and password 'secret_sauce'
    And user clicks login button
    Then user sees inventory page

    Scenario: User sees error message if username empty
      Given user navigate to 'https://www.saucedemo.com/'
      And user sees page title 'Swag Labs'
      When user enters username '' and password 'secret_sauce'
      And user clicks login button
      Then user sees error message 'Epic sadface: Username is required'

  Scenario: User sees error message if password empty
    Given user navigate to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters username 'standard_user' and password ''
    And user clicks login button
    Then user sees error message 'Epic sadface: Username is required'
    #izlabot

  Scenario: User sees error message if username and password empty
    Given user navigate to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters username '' and password ''
    And user clicks login button
    Then user sees error message 'Epic sadface: Username is required'
        #izlabot