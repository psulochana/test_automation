Feature: Buy a Product from ecommerce site

  @ProblemStatement2_Chrome
  Scenario: Buy iPhone12 64GB from ecommerce Website
    Given User navigates to ecommerce login page url "<app url>" using "chrome" browser
    When User enters the username "username" and password "password"
    And User click login button
    And Validate the login page
    And User have to search for "iPhone 12" and select "64GB" phone on listing page
    And Add the product to cart and validate if the product added and available in Cart
    And Add a new address for shipping and proceed to checkout page then validate it