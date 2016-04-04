Feature: 登录

  Scenario: 输入错误的密码登录失败，并截图
    When I enter "18126121961" into input field number 1
    When I enter "123456" into input field number 2
    When I press "登录"
    Then I take a screenshot
