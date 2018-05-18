Narrative:
In order to manage the book store collection
As a store administrator
I want to be able to add, update and remove books

Scenario: 用户应当可以展示图书细节

Given 用户当前在图书页面
Then 字段bookId存在
Then 字段bookTitle存在
Then 字段bookAuthor存在
Then 字段bookDescription存在

Scenario: 用户应当可以创建一本新书

Given 用户当前在图书页面
When 用户点击newBook按钮
When 用户为图书表单设置值
When 用户点击saveBook按钮
Then 保存图书

Scenario: 用户应当可以展示图书细节

Given 用户当前在图书页面
When 用户选择一本书
Then 图书表单包含所有数据

Scenario: 用户应当可以更新图书细节

Given 用户当前在图书页面
When 用户选择一本书
When 用户为图书表单设置值
Then 保存图书

Scenario: 用户应当可以删除图书

Given 用户当前在图书页面
When 用户选择一本图书
When 用户点击deleteBook按钮
Then 删除图书