Feature: My first cucumber feature

  Scenario: User can login with correct title Google
    #Hooks izpildisies
    Given user is navigated to 'https://www.google.lv/' page
    Then user sees page title 'Google'

  Scenario: User can login with correct title LU
    Given user is navigated to 'https://www.lu.lv/' page
    Then user sees page title 'Latvijas Universitāte'

  Scenario: User can login with correct title RTU
    Given user is navigated to 'https://www.rtu.lv/' page
    Then user sees page title 'Rīgas Tehniskā universitāte | Inženierzinātņu centrs Baltijā'


#    When user enters username 'standard_user' and password 'secret_sauce'
#    And user clicks login button
#    Then user sees inventory page