plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    Feature: Login functionality
    Scenario: Successful login
    Given I am on the login page
    When I enter valid credentials
    And I click the login button
            Then I should see the welcome message

}
