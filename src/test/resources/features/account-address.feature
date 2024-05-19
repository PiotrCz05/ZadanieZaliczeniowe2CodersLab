Feature: Adding address on a web page

  Scenario Outline: Adding a new address
    Given the user is logged in to their account
    When the user clicks on the "Addresses" tile
    And the user clicks on the "+ Create new address" button
    And the user fills out the New address form with "<alias>", "<address>", "<city>", "<zip_code>", "<country>", "<phone>"
    And the user clicks on the "Save" button to add the address
    Then the new address should be displayed with "<alias>", "<address>", "<city>", "<zip_code>", "<country>", "<phone>"

    Examples:
      | alias    | address       | city       | zip_code | country       | phone     |
      | Work     | 123 Test St.  | Liverpool  | 10001    | United Kingdom| 123456789 |

