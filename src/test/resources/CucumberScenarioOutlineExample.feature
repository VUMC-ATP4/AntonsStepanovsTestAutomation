Feature: This is scenario outline feature

  Scenario Outline: Test multiple page titles
    Given user navigate to '<url>'
    Then user sees page title '<page_title>'
    Examples:
      | url | page_title |
      | https://www.google.lv/ | Google |
      | https://www.lu.lv/ | Latvijas Universitāte |
      | https://www.rtu.lv/ | Rīgas Tehniskā universitāte \| Inženierzinātņu centrs Baltijā |