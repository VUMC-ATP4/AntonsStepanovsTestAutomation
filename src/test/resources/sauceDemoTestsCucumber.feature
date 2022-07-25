Feature: Tests purchase functionality of https://www.saucedemo.com/ page

  Scenario: Successful login
    Given user navigate to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters username 'standard_user' and password 'secret_sauce'
    And user clicks login button
    Then user sees inventory page

  Scenario: Successfully adding an item to the cart
    Given user clicks to add 1 item to the cart
    And user clicks cart button
    Then user sees added item to the cart

