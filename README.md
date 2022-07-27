# Test automation framework

## Test execution

Run tests on default environment by one thread:

`.\gradlew clean test`

Run tests and generate Allure report

`.\gradlew clean test allureReport`

### Input properties (setting by -D attribute)

* **env** - environment name
* **threads** - number of active threads you want to use during test execution (default is 1)
* **includeTags** - select scenarios with these tags (default is empty)
* **excludeTags** - select scenarios without these tags (default is empty)
* **testPattern** - select scenario that method's name matches to this pattern (default is empty)
* **maxRetries** - number of scenario retries when fails (default is 0)
* **maxFailures** - stop testing when number of failed scenarios is greater than this value (default is 20)

## Example
`.\gradlew clean test allureReport -Dthreads=3 -DincludeTags=regression -Denv=dev`


## Allure report
Allure report is generated into the **build/reports/allure-report** directory