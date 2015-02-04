*** Settings ***
Library    net.sghill.rescuebuddies.acceptance.libraries.AdminLibrary

*** Test Cases ***
Ping
    ${response}=    ping
    should be equal as numbers    ${response.status}    200
