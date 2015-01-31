*** Settings ***
Library    net.sghill.rescuebuddies.acceptance.libraries.BuddyLibrary

*** Test Cases ***
ping
    ${buddies}=    fetch buddies

