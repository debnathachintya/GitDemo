Feature: Login into application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://qaclickacademy.com" site
And Click on Login link on homepage to land on secure sign in page
When user enters <Username> and <Password> and logs in
Then verify that user is successfully logged in
And Close Browsers

Examples:
|Username			|Password		|
|test99@gmail.com	|123456			|
|test123@gmail.com	|1234			|