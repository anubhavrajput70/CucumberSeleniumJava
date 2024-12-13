Feature: Products

  Scenario Outline: validate promo code alert is visible when clicking on the special offers link
    Given User navigates to "<url>"
    When User clicks on the "<button>"
    Then User should be presented with a promo alert

    Examples: 
      | url                                                                 | button                   |
      | https://www.webdriveruniversity.com/Page-Object-Model/products.html | container-special-offers |
