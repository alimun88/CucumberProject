Feature: Login
Description: The feature is to test the login functionality

Scenario: Successful Login with valid credentials
Given User is in home page
When User enters username and password
When clicks go button
Then He can visit the practice page
And A message is displayed
When user click Home Page Link
And He can see the logout link
When user click on logout link
Then he can see signup login link
And user close the browser
