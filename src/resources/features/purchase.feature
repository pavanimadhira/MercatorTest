Feature: Purchase highest-priced item
  Scenario: User logs in, selects the highest-priced item, and verifies it in the cart
    Given User is on the SauceDemo login page
    When User enters valid credentials and logs in
    Then User should see the available products information page
    When User added the highest priced item to the cart
    Then User should see the highest priced item in the cart