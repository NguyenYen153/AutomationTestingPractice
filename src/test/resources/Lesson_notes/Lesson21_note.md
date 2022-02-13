# TestNG & Hooks
* Hooks
```
BeforeSuite/Test/Class/Method
AfterSuite/Test/Class/Method
```

* Execution:
```
- Directly from Class
- From Test Configuration(From TestNG class and TestSuite)
- From Maven Command(with Surefire plugin)
```

* Order and priorities and dependsOn
```
- BeforeMethod by deafault run in A-Z order
- Nếu method dependsOn  fail -> k thực hiện method có dependsOn z
```
