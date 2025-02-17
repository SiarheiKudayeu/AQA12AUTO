Feature: Testing of ContactUs Page
Background:
  Given Set up driver

  Scenario Outline: Test of sending positive message

    When open contact us page
    When I select option from subject heading
    And I set valid mail "<text1>"
    When I set valid orderID
    And I set valid message
    And clicking on Send Button
    Then I see success alert message
    Examples:
      |  text1 |
      |  mail@mail.mail|

    @selenium
  Scenario Outline: Test of sending positive message

    When open contact us page
    When I select option from subject heading
    And I set valid mail "<text1>"
    When I set valid orderID
    And I set valid message
    And clicking on Send Button
    Then I see success alert message
    Examples:
      |  text1 |
      |  mail@mail.mail|
