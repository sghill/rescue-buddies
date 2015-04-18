*** Settings ***
Resource    libraries.txt

*** Test Cases ***
Add Foster Parent
    ${id}=    generate id
    ${response}=    create foster parent    ${id}    loretta
    ${assigned location}=    get location header value    ${response}
    ${expected location}=    resolve url    /foster-parents/${id}
    should be equal as integers    ${response.status}    201
    should be equal    ${assigned location}    ${expected location}
