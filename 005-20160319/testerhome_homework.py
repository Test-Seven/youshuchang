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
        desired_caps['unicodeKeyboard'] = 'true'
        desired_caps['resetKeyboard'] = 'true'
        desired_caps['app'] = PATH('testerhome.apk')

        self.driver = webdriver.Remote(
            'http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
        # end the session
        self.driver.quit()

    def test_view_first_article(self):
        # find_element/find_elements
        '''
        topicTitle=self.driver.find_element_by_id("com.testerhome.nativeandroid:id/tv_topic_title")
        topictTitleList=self.driver.find_elements_by_id("com.testerhome.nativeandroid:id/tv_topic_title")
        topictTitleList[1].click()
        '''

        # 隐式等待10s
        self.driver.implicitly_wait(10)
        topicTitle = self.driver.find_element_by_id(
            "com.testerhome.nativeandroid:id/tv_topic_title")
        topicTitle.click()
        backBtn = self.driver.find_element_by_class_name(
            "android.widget.ImageButton")
        backBtn.click()


    def test_search_article(self):
        self.driver.implicitly_wait(10)
        searchBtn = self.driver.find_element_by_id(
            "com.testerhome.nativeandroid:id/action_search")
        searchBtn.click()
        searchEditText = self.driver.find_element_by_id(
            "com.testerhome.nativeandroid:id/search_src_text")
        searchEditText.send_keys("appium")
        self.driver.keyevent(66)
        sleep(5)

        #self.driver.find_element_by_accessibility_id("")
        # UiSelector().textContains()
        #UiScrollable()

    def test_view_topicA(self):
        topicA=self.driver.find_element_by_android_uiautomator('new UiSelector().text("Apple QA Engineer 的面试记")')
        topicA.click()
        backBtn = self.driver.find_element_by_class_name("android.widget.ImageButton")
        backBtn.click()


    def test_view_topicB(self):
        mrBugTitle=self.driver.find_element_by_android_uiautomator('new UiScrollable(new UiSelector().resourceId("com.testerhome.nativeandroid:id/vp_topics")).scrollIntoView(new UiSelector().text("元素在可视区域内，但是元素的坐标却是负数"))')
        mrBugTitle.click()

if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(SimpleAndroidTests)
    unittest.TextTestRunner(verbosity=2).run(suite)
