*** Settings ***
Library    net.sghill.rescuebuddies.acceptance.libraries.BuddyLibrary
Library    net.sghill.rescuebuddies.acceptance.libraries.LifecycleLibrary
Suite Setup    start app with updated database
Suite Teardown    stop application

*** Test Cases ***
ping
    ${buddies}=    fetch buddies

*** Keywords ***
start app with updated database
    start application
    apply database migrations
