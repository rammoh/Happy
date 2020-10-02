Feature: End to End test cases for Amazon application
Contains test scenarios includes login the application, search product

@LoginScenario
Scenario: User login the applciation and verify user name in the header
Given User launch the applciation
And User wait for '3' seconds
When User moushover to the Hello sign in 
And User wait for '3' seconds
And User click on sign in button on ajax call
And User enter the username '8122447745' in the emailid/mobile number
And User click on continue button
Then User verify the entered mobile number '+918122447745' displays on the mobile number feild
When User enter the password '8148181640' in the password feild
And User click on login button
And User wait for '5' seconds
Then User verify the username 'Hello, harish' in the header page

@LoginScenariowithExample
Scenario Outline: User login the applciation and verify user name in the header
Given User launch the applciation
And User wait for '3' seconds
When User moushover to the Hello sign in 
And User wait for '3' seconds
And User click on sign in button on ajax call
And User enter the username '<MobileNumber>' in the emailid/mobile number
And User click on continue button
Then User verify the entered mobile number '<MobileNumber>' displays on the mobile number feild
When User enter the password '<PassWord>' in the password feild
And User click on login button
And User wait for '5' seconds
Then User verify the username '<UserName>' in the header page

Examples:
|MobileNumber	|PassWord	|UserName		|
|+918122447745	|8148181640	|Hello, harish	|

@LoginScenariowithListDatatable
Scenario: User login the applciation and verify user name in the header
Given User launch the applciation
And User wait for '3' seconds
When User moushover to the Hello sign in 
And User wait for '3' seconds
And User click on sign in button on ajax call
And User enter the username in the emailid/mobile number using Datatable
|+918122447745|8148181640|
|8148181640   |8148181640|
And User click on continue button
Then User verify the entered mobile number '+918122447745' displays on the mobile number feild
When User enter the password '8148181640' in the password feild
And User click on login button
And User wait for '5' seconds
Then User verify the username 'Hello, harish' in the header page
