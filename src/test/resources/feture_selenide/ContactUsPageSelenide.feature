Feature: Testing of ContactUs Page Selenide
Background:
  Given Set up driver Selenide

  Scenario Outline: Test of sending positive message Selenide

    When open contact us page Selenide
    When I select option from subject heading Selenide
    And I set valid mail Selenide "<text1>"
    When I set valid orderID Selenide
    And I set valid message Selenide
    And clicking on Send Button Selenide
    Then I see success alert message Selenide
    Examples:
      |  text1 |
      |  mail@mail.mail|


