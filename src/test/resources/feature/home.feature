@endtoend
Feature: E-Commerce Home Page

  Background: 
    Given Navigate to url

  @Url
  Scenario: Appliation Url Validation
    Then Verify the url

  @logo
  Scenario: Appliation Logo Visiblity
    Then Test the Height "99" and Width "350"

  @productCategory
  Scenario Outline: Application product main category list validation
    Then Test whether the Home page has 3 product categories
    And Test Home page must "<Product>" contains only three Product categories
 
    Examples: 
      | Product  |
      | T-SHIRTS |
      | DRESSES  |
      | WOMEN    |

  @Search
  Scenario: Aaplication searching functionality
    When User Search for product "T-shirt"
    Then Test Search Product contains is displyed result "T-shirt"

  @SocialMedia
  Scenario: Application social media handles validation
    When User click On SocialMedia Link
    Then Verify a URL containing Parameters "seleniumfrmwrk"
    And Verify Account Name "Selenium Framework"
