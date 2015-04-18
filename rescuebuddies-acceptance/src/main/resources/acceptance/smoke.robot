*** Settings ***
Resource    libraries.txt

*** Test Cases ***
Ping
    ${response}=    ping
    should be equal as numbers    ${response.status}    200
