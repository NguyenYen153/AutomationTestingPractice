## Handle different behaviour on Pages
- Example like HomePage has something that other pages don't have

## Allure reporter
- Installation: Dependency and allure commandline tool
- Generate report
Command: 1. allure generate allure-results
allure generate allure-results --clean (Xóa allure report, Xóa bằng cmd: rm -rf allure-re*)
2. allure open

## BaseTest
- Driver initialization
- Test failure handling: Capture screenshot when test is failed
## Run test with maven
 - mvn clean test -DsuiteXmlFile=src/test/resources/test-suites/Regression.xml