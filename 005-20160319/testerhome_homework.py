# coding:utf-8
__author__ = 'Book'

import os
from time import sleep

import unittest

from appium import webdriver

# Returns abs path relative to this file and not cwd
PATH = lambda p: os.path.abspath(
    os.path.join(os.path.dirname(__file__), p)
)


class SimpleAndroidTests(unittest.TestCase):

    def setUp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.2'
        desired_caps['deviceName'] = 'Android Emulator'
        desired_caps['unicodeKeyboard'] = 'True'
        desired_caps['resetKeyboard'] = 'True'
        desired_caps['app'] = PATH('testerhome.apk')

        self.driver = webdriver.Remote(
            'http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
        # end the session
        self.driver.quit()

    def test_login(self):
        sideBar=self.driver.find_element_by_accessibility_id("Open navigation drawer")
        sideBar.click()
        headBtn=self.driver.find_element_by_accessibility_id("Close navigation drawer")
        headBtn.click()
        textList=self.driver.find_elements_by_class_name("android.widget.EditText")
        textList[0].send_keys("Nancy")
        textList[1].send_keys("123456")
        textList[2].send_keys("123456")
        loginBtn=self.driver.find_element_by_accessibility_id("登录")
        loginBtn.click()
    def test_article_comment(self):
        # find_element/find_elements
        topicTitle = self.driver.find_element_by_id("com.testerhome.nativeandroid:id/tv_topic_title")
        topicTitle.click()
        commentBtn = self.driver.find_element_by_id("com.testerhome.nativeandroid:id/fab_add_comment")
        commentBtn.click()
        commentText = self.driver.find_element_by_id("com.testerhome.nativeandroid:id/etComment")
        commentText.send_keys(u"赞！")
        sentBtn=self.driver.find_element_by_id("com.testerhome.nativeandroid:id/btnSendComment")
        sentBtn.click()
    # def test_twiceback_exit(self):
    #     self.

if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(SimpleAndroidTests)
    unittest.TextTestRunner(verbosity=2).run(suite)
