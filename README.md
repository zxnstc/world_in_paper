# 欢迎来到纸间万象

**项目成员:**

组长:

- 匡俊骅 2013157

组员:

- 张家冉 2012685
- 薛鹏 2012912
- 张怡桢 2013747
- 郭耘赫 2011361

##  **Revision History**

| 迭代次数  | 迭代任务                                                     | 迭代分支   | 迭代时间              |
| --------- | ------------------------------------------------------------ | ---------- | --------------------- |
| 第0次迭代 | 技术栈与极简demo（确定前后端技术栈）                         | Helloworld | 2022/10/1-2022/10/23  |
| 第1次迭代 | （实现最小可用产品），创建或指定功能需求，设置“优先级”和“状态” | MVP1       | 2022/10/24-2022/10/30 |
| 第2次迭代 | 实现RBAC（Role-Based Access Control）模型，进行用户-角色-权限设计 | RBAC       | 2022/10/31-2022/11/20 |
| 第3次迭代 | 内容管理系统（Content Management Systems，CMS）              | CMS        | 2022/22/21-2022/12/11 |
| 第4次迭代 | 完善网站细节                                                 | Main       | 2022/12/12-2022/12/30 |

## **Statement of Project**

###  Problem Statement

中国剪纸是我国民间独有的一种艺术，不仅具有美学价值，还是中国本源哲学的体现。在民间，人们通过不同造型的剪纸来表达不一样的情感，即每种剪纸都有自己独特的内涵。多数情况下，人们将剪纸作为一种装饰品来使用，墙壁、门窗、房主、镜子和灯笼都离不开剪纸的点缀。其次，剪纸作为装饰品是有一定的讲究的，剪纸多采用大红色，象征着吉祥与喜庆，常常被用在婚礼和一些喜庆的节日里。

中国剪纸于2009年9月入选联合国科教文组织第四批世界非物质文化遗产名录，这一事件使得中国剪纸进入了一个新的时代，从此，中国剪纸艺术将受到全世界人们的关注。同时，在全球化这样的背景下，在新旧事物交换更替的今天，中国剪纸也面临着严重的挑战。一方面，全球化的今天，世界各地加快了文化交流，在这样的环境下剪纸艺术不断地从其他文化中获取精华，不断创新；而另一方面，剪纸艺术作为一种古老的艺术，在现代化的冲击下，一些村寨剪纸艺术面临着流变和濒危的处境。

全球化的今天，剪纸艺术在各种现代文化的冲击之下，正面临着严峻的挑战，而人们对剪纸艺术的认识存在一些误区，对其发展的重视程度不够，这在很大程度上阻碍我国剪纸艺术的发展。此外，甚至连一些剪纸艺人也不能够正确认识剪纸这门艺术，他们仅仅把剪纸作为一种谋生的手段，对于一些剪纸技巧不进行外传，殊不知这种做法可能会导致一些技巧失传，带来剪纸界的重大损失。因此，人们必须提高对剪纸艺术的重视程度，相关工作者还应该制定一套完善的保护体制并成立专门的保护机构，对我国剪纸艺术进行保护，使其得到更好的传承和发展。

我们小组开发的“纸间万象”这个平台，就是为了传承，发展，分享有关于非物质文化遗产“剪纸”的文化。

考虑到人们对于剪纸艺术认识的局限性与误区，我们的网站，对剪纸艺术进行相关的科普与介绍，对于不同地域的剪纸艺术进行概述；考虑到剪纸兴趣者需要一个对于剪纸艺术的讨论空间，我们的网站，提供了一个剪纸论坛，让剪纸爱好者与纸间万象的用户进行互动沟通，进行剪纸文化问题的讨论，进行经验的交流等；考虑到剪纸艺术家对于自己作品的分享以及开展电子艺术展的需求，我们的网站，开发了艺术家专栏以及作品展示等功能，使用全方位展台展示艺术家上传的剪纸作品，也给艺术家提供了剪纸文化专栏，可以让艺术家分享自己的剪纸经历，技巧以及故事等。

“纸间万象”这个网站，旨在传承发扬剪纸艺术文化，提供一个平台给剪纸兴趣者深入了解剪纸文化，开发一个电子专栏供剪纸艺术家分享自己的剪纸作品与技巧经历，实现一个剪纸兴趣者与艺术家讨论学习的平台。

### Proposed Solution

“纸间万象”网站以前端vue3+后端springboot+redis+mysql数据库+图床chevereto技术栈，使用docker技术连接前后端并部署实现。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=YTIzNDE2NjFkYjZmNjUxZTM1NjYxM2E4Y2I1ZjYyNDBfZ053YllHNHY5ZEhwcWpyNlhWb0FjaFF4cU9oVG53cGdfVG9rZW46Ym94Y25wR2Z6Wk1RUXdrbTRjQ1AxSGw2azZkXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

“纸间万象”网站实现4种用户级别操作权限，实现不同的用户功能，进行对应的管理。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=OTU4NGI4MDQwNjY0ODhjMjA0MmZhMWE1NTc1YTZjZjRfNGQ2NnNSdTJUQzlWQk1mTzJDUklTT3RXYlUwbURNTmJfVG9rZW46Ym94Y25WSXhRemdVYm5IdFdVQ2o2U1BWbXZjXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

###  Novelty

本网站以互联网作为载体，将非物质文化遗产进行传承与发扬，促进剪纸文化的进一步发展，促进剪纸文化的交流。基础的静态网页展示了剪纸文化的历史，论坛功能实现兴趣者之间的文化交流，专栏与艺术展功能实现艺术家的经验分享。本网站服务于多种用户群体，将围绕剪纸艺术的多种用户群体通过互联网载体进行连接，实现剪纸文化的传承发扬，实现非物质文化遗产的进一步保护。该网站的UI艺术制作也十分到位，展现了制作团队对于中华传统文化美学艺术的审美与理解。

如图为网站的UI首页，实现了剪纸剪影的艺术效果。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=ODI5MDVkYzE5MjlkYzY2MjQ0NWIyNjY3MWI4MWIyZmZfZHJCenlMVFZ3V0hHYU5qQjdUM0hXTDR3VXdidVVXVDBfVG9rZW46Ym94Y253UFRJbUdXYlQzdmVZZDRjTnVEU1VjXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

引入Animate.css进行适当的特效修饰UI，进行翻页时，不同的页面会有不同的动画效果。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NDJjMjgyYjg1ZTNkNTFhMGFkYjUyYTIwYTZlYTYwZmRfeVIxV2c2dmRDQnpDZXpRUlNZR1BXV3dWaFlnZzUwcjZfVG9rZW46Ym94Y25pWkQzQ0RYak5takRNc2FiV2JSQUVnXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

## **System Requirement**

### Enumerated Functional Requirements

本项目将实现的功能分为了八个模块，每个模块的功能需求如下：

#### **1）导航栏模块**

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=ZWFiODFkMWM4NGIxOWQ0ZmZhZWU1ZDE5MGMxNDNkZGRfYTIxMXVscGRwSzVSWlgzMlJWeGpYQTBzMk1rcnZpeDJfVG9rZW46Ym94Y256eDV6dGZXb2FiNEJQUE9RNlBFb1RoXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 1: 用户登录。用户可以输入用户名和密码进行登陆操作。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=YjQ5ZjcxZTI4ZmUwOWViZmI2ZDNhZTNhNWE5Y2YzMGNfVHNSYVhpRWVJYzc1V2lOazVEZkVTOTNnVThobVhFUmJfVG9rZW46Ym94Y25md1huN3p5anpVOWJhbEp1aHlqQ0lmXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 2: 用户注册。新用户可以通过邮箱验证进行注册

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NmRkYWQ0YmJkMzgyZDU0MzQzOTI0OGQ3MWY4MGRjZGFfSVJGV3Q1OEJjNGwzZm9UbHZjVEZCRXJnWkV1N1JvRjJfVG9rZW46Ym94Y254OXB3QXF4ekdlcG9US0xnZ0llTUNoXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 3: 页面跳转。用户可以点击导航栏各个按钮进行各个功能模块的跳转。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MDdkMmI2MDdiNjkzYzEwYmQ5ZDc3ZjMzMDAyN2FjYjdfcFVkdHVNR0tVZUhkbTZ0aDB2MWpLWnNhNTEyZ0ttdG1fVG9rZW46Ym94Y25wVjh6cE1FWjNlYUFIR0NXWE9ic0ZlXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 4: 用户登陆可以通过菜单进入用户主页，如果是管理员可以进入内容管理页面，也可以通过菜单退出登陆。

#### **2）首页模块**

- Feature 5: 首页的上半部分通过剪纸风味十足的元素来展示我们网站的主题。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=OGE4NGU1NThlOTlmOGQ5NGRjNTJhNjVmOWQwOGNjMDBfNEdTbGFOMERFeUNNVFFVa29rN2hVT0JjTVE2ZTk1bmdfVG9rZW46Ym94Y25ORkNiclZXcEpKYXRITGlEckJHb2pjXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 6: 首页的下半部分展示了各地剪纸的发展历史、剪纸艺术家介绍、剪纸的教程、剪纸的技巧、以及著名的剪纸作品等模块的入口。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NDUwYzQyNTQzNDJlZTA2NzRhNTZmOTUxOGU1NzUzNGFfSTVjNDQzVDA5S2VYdk9kVjlwSFBoNFY0NDNQYW44ZEVfVG9rZW46Ym94Y25tMXJwSGwweVcxRWVzQVRrVjBhemhmXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

#### **3）论坛模块**

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NDAxZjk4MDIwMzczYjhhOTgyOTYxNzhlMTVkN2I5ZWRfUFE5T1U1SVJwQWdnSmR2SWVkSnJzRmxaNEF3VE15djNfVG9rZW46Ym94Y25wdjZKRE1QM1FEOWRwR2FKd1c0OHhiXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 7: 数据展示。**用户**可查看论坛部分的文章数、评论数、访客数以及按照发布帖子数目进行排列的作者榜。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=ZTU5NWZkN2E1N2UzY2Q1ZTZlOTdjY2E0MDUzOWE0MTBfZFV5WjdXdzg2a3RpNWp4REpmUHgycEFjWVZ0YUxlZXpfVG9rZW46Ym94Y25zOFRjRUoxemd5NTBvYjRNdktDMGxjXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 8: 浏览帖子。**用户**可查看已发布的帖子列表，其中包括帖子标题、作者、帖子内容摘要，点进去之后查看帖子的详细内容、作者的详细信息以及当前帖子的评论。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=YzA3NWQyN2UxNDNmNGE2NzliOWYwMGUxNDEyMDFhNzZfSXBYaXpFb1JXRUJ2OXNKNlN2c2lqUmdXZVhmc3ZnY09fVG9rZW46Ym94Y25YdndkdW9UaUJQdGd3czdRZ2hhOXJVXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 9: 搜索帖子。**用户**可以在上方的搜索框中输入自己感兴趣的内容来搜索相关的帖子。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MzQyNjU4ZmZmMzYzOTg1NzBkYmQ5YmJjNDgwYWQxYjBfVFhmRlJLVXh4eWx2OGhOSElBMENKbW9TY0FITnJzaVZfVG9rZW46Ym94Y241aXNmNzRpUG1EanpMSFJ3QWRubmZPXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 10: 点赞评论。**用户在登录后**可以对自己喜欢的帖子进行点赞操作，并可以在点击进入帖子详情之后对帖子发表评论。
- Feature 11: 发布帖子。**用户在登录后**可以在论坛中发布自己的帖子。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=M2Q0NGRkMzQ1Yjk4YzI1M2U0NDJkNGNkOWVmODUwN2JfY0ZFM0liRUNXa3VwSEZhdUpjSGE1SGdlZzdqN3NlZnVfVG9rZW46Ym94Y25aUWFvNGNYMzRBQ3k0ano2bWtBVHVlXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 12: 帖子管理。

**管理员**可以在此界面删除用户发布的不适宜的帖子。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=ZjFiYjY4MzZlYjM2YWEzZWE4OGM0MmM0OTg2ODRhYjJfSzBaQzh1WFZEbGlxZE1xa2JFQ3N5TklBTFRYTDFNZ01fVG9rZW46Ym94Y243WWNYUHc5Mko1Q1RNZ1AzY045VDNUXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

**用户在登录后**可以在自己的主页删除掉自己发布的帖子。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=Njg0ZGFmY2U0NDdjZDVmOGZiNjZkMWE2YmQ1MWEyYjJfT28yRWhNOWVtRDRLRm9FMTRJdGJ2Q1VkNjN5OE9iSmFfVG9rZW46Ym94Y24xdVFGblFFZlhSVnNHZ2tBZWUzVHRkXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

#### **4) 专栏模块**

- Feature 13: 所有专栏展示。**用户**可以在专栏界面，查看所有的专栏信息，包括专栏名称、专栏封面以及各个专栏的文章数目。点击进入可以进入某个专栏内部。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=OTIwOTc0ZTMzNTY3ODlmNjc4ODU4YTI3OTkyNGI4YzRfMW5DcWhtU29nY1cwWHJKRkJSUG5FTXAxcUhwQ1RHY05fVG9rZW46Ym94Y25oR0RWdWx1UEcwWjhjcWYySTc5YjBtXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 14: 发布专栏。**艺术家**可以在自己的主页中的“创建专栏”模块中通过给定专栏名称、专栏简介、专栏封面等信息发布新的专栏。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=OGJkZTM4YzcwYjk4MzkzZmJlODAwOTU3MGNlMzUzZTdfd2ZCTWZmWTZ3QTIyWGZyRHlRaDVjVmlFS3J1RHlValhfVG9rZW46Ym94Y25oZm9GVkRpeGU5TVJleXRrMGQ5STZiXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 15: 专栏管理。

**管理员**可以所有专栏页面删除某些不适宜的专栏。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=Zjk1NjllYmQ3ZTAzOGExOGY3ZTA2MzQxZmY4YjVhNmJfNG96dUF3ZmJOSUI1amNBdGxIQ0xoZWlXNzdpRGg0bHlfVG9rZW46Ym94Y24xZWFTSDI0R3NKN1NaUzNld2w2V2dnXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

**艺术家**也可以在自己的个人主页中删除自己发布的专栏。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NmI1OGZjNjExODRhM2M3ZGEwMWY5Mzg3NDI5ZTE4ZGNfNFVSMXdsUTU2dE95bVhIQzB4eHlaZ2RvNkxCQmFKZVlfVG9rZW46Ym94Y25hY0U3andsOUdlejBhMmJQUFFQYVJsXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 16: 专栏信息展示。**用户**在专栏内部可以查看专栏的介绍、统计数据等信息。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NTRhZmM2OGI3NDc2Y2I5ODk5NDA3OWQ4ZmQxYjg3NzNfVWRZN0ZTM0l2dEVQTDAwODZ6OHpkZGRBTnpwWG5CRkRfVG9rZW46Ym94Y25STU9mSUtGbVJ4V05OWjczbExvWHIwXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 17: 专栏文章展示。**用户**可以在专栏中查看该专栏中发布的文章信息，包括文章的标题、内容概要、封面图片、发布者、点赞数、评论数等，点击标题后可以跳转到文章页面。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NTY3Y2EzMTFhYjgzZGViNzk4ZTBjODRiOTg2ODRkNTBfbzJlSXNnTW5NM2t3RnpSVEVoaThOZjdVS00yMUdydjBfVG9rZW46Ym94Y25vM1BjR21VTGhCREVPSmROQWFYZURkXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 18: 发布文章。**用户在登录后**，可以在专栏内发布文章。发布文章时，用户可以指定标题，上传封面图片，并通过富文本编辑器编辑文章内容，实现了工具栏（支持粗体、文本居中、修改字体字号、插入图片、视频等功能），编辑好的内容将转化成HTML代码在文章部分展示。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NjFlMGYwYWQzZWMxNmIwOTJmOGI2ZmI4NzJjN2IwNTJfa3M3SWNMdmtDREhCVXdSdWhvQVRZcXRmZFRxeUhHVzFfVG9rZW46Ym94Y25QVlRxNHExeVZMVGE4TGUwVnV1TjVjXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 19: 评论文章。**用户在登录后**，可以在文章下发布对文章内容的评论。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NWVlOTZlZTRmNTU2NDIzZTJlOTFmOGE1ZjE3MzU0NDZfS3JyWUhONW1JRHdBZFJyMHJCTFZWTnlCYWRESGVLaFFfVG9rZW46Ym94Y25yMENoRUVkNDFmUGF5Qmx1alpSQ0hOXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 20: 文章管理。

**管理员**可以在专栏内部删除某些不适宜的文章。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MzI5OWM4NmEwNWFjNmVkZmE1MzZmM2EzNTMyYmFmODhfM0d1c2JBaHo0NGhTSHZ5Sm52T2ppSndoaTNpdWZYdXNfVG9rZW46Ym94Y25UZEg5QWp5Z04wWFBRMHNaVktZZFJjXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

**用户**也可以在自己的个人主页中删除自己发布的文章。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NjA4MDllOGJiNmYwMGRhMWIwNTg3YzJiZGE1NTRkYmNfc0M1YWZwbVJndHRSTVR3U05PV2daVGxNSkNYRWFQUE5fVG9rZW46Ym94Y25wM2pCbUdUZmozV2tGdFF2SmlmcHRiXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

#### **5）剪纸作品模块**

- Feature 21: 剪纸作品展示。**用户**可以在作品页面查看**艺术家上传**所有的剪纸作品信息，包括作品名称、创建时间等。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NWQ3NmE4ZWYzMTJmNTk2MzdmODEzOWY1YmI5NDg5NWRfeFRxd005a2h5bFpQOEFIWmExUTRyRHJnUHJtY3AxVE5fVG9rZW46Ym94Y25lY3plUTh2WVJCdDN1dFpKVVlyYU9jXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 22: 剪纸作品3D欣赏。**用户**可以点击作品进入3D交互界面，在其中用户可以对作品进行放大、缩小，平移、旋转等操作，从而可以从各个角度欣赏剪纸作品的细节之美。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NjlkOGRiZGEzMmFmM2EyYzE2NWI3NzFmZjQ4NDI0MWNfZDViSFJnaTUzbkZoelB5dTV0NW9aQkVvbFE0aTBzVFRfVG9rZW46Ym94Y25MajVpVUJ2RnpLQUxpZGM3SnNpcUpjXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 23: 剪纸作品管理。**艺术家**在自己的主页的块中，通过指定作品名称、作品简介、作品图片链接的方式，上传自己的剪纸作品。同时，可以在作品列表中删除自己的某个作品。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=OTIxZjRlOThmNWNkNzI0YWIzYjE3NjVlZThkYWE5NmVfdVQ1OU5ma2NxdjRmbjhBY1FUaHh5Tzh6bFc3NTlJOGRfVG9rZW46Ym94Y25hRGRNMXp6UDZkRHlVejZSMmNidGVjXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=NDdiNzY2ZjVlZjRjMmMxMzU1YWQ3NTU2YjQ0MmRjNThfNEhUZmZndExUdDIyb3ByeHRoOEtIQ0JIUWprRmFBSzZfVG9rZW46Ym94Y25Sa1NmeEhOT2hoenFERVdxa3pHTGpnXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

#### **6）剪纸文化模块**

**剪纸历史**

- Feature 24：剪纸历史。**用户**可以了解有关剪纸的发展历史等内容。

**剪纸艺术家**

- Feature 25：艺术家列表。**用户**可以了解有关当今中国著名剪纸艺术家，如段云丽夫妇、傅作仁、顾朋泉、陈粉丸等
- Feature 26：艺术家介绍。**用户**可以从中认识有关艺术家的人生经历、相关作品等信息

**剪纸教程**

- Feature 27：折法介绍。**用户**可以学习对边折剪法、三角折剪法、四角折剪法、五角折剪法、六角折剪法、二方连续折剪法、四方连续折剪法等剪纸的通用折法。
- Feature 28：纹样介绍。**用户**可以学习剪纸的月牙纹、太阳纹、云纹、柳叶纹、火纹、水纹等纹样来装饰剪纸的作品。

**剪纸技巧**

- Feature 29：技巧介绍。**用户**可以学习剪纸中的阴刻、阳刻、彩色剪纸、立体剪纸等剪纸技巧。

#### **7）用户主页模块**

- Feature 30：我的主页。**所有用户**可以查看自己的头像、个人简介等个人信息。同时可以查看或删除自己发布的帖子和文章。**艺术家**还同时可以查看和删除自己发布的专栏。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=YTdmMzZhNzYzNWZjYTEyNzFhNDhkN2ZkMGQxYTRmZmNfazFTZXZ6cVh3OVVTaWZ3S3JPU29CRks2ZkNZNzhCclZfVG9rZW46Ym94Y25wYVA4eklxQU9WakFuT1FJREpjUXlUXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 31：修改个人信息。**用户**可以修改自己头像和个性签名。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=ZmFhMTk3YzdkNTc0MDY5OGE1NjBiYzA4ZDM1MDE1NTNfYm5LZ1gxbEo0QXZ5NDdaYWhWWnFDR05WUXA4elFic01fVG9rZW46Ym94Y25vWUduYmtyaGE3M2d2SXE3YzVRUlJiXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 32：用户权限管理。**管理员**可以对用户进行管理，执行包括用户封禁和解禁、修改用户角色权限（可以指定为普通用户、艺术家、管理员）同时可以通过上方的搜索框搜索指定用户。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MGI4MzBhYjBhYzI1ODI5OGFmNjBlYWUzMWRkMjRjODRfcnkyUmE2YUlqaXFHYXpuZVVCbHVPVTlGdjhpbFdFQXFfVG9rZW46Ym94Y25TNXQ0TzdpRFJTbTl3aTIwZVR5cUtmXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MWZiMTQyNzBjYzZmYmEwMjZjMTAyMGZiMDY1NTAwZDFfeHBEV1gyUkJ3bFJta3hidnFZYWp0VlhnQ0FQaVVaZ1hfVG9rZW46Ym94Y25iejZGc1ZnREFIMzdFaUVtMWFMUElkXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 33：创建专栏。**艺术家**可以查看自己所有已创建的专栏，也可以通过指定专栏标题、专栏简介、专栏封面来发布新的专栏。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=OTc1MWFjYTZmMDYxZjhkNDRiNzE3M2RlOTI0MmJkYTlfRUdadHZ4YXd6dHprdmF1NHdORTY2TkxSN0R1T3BxQTJfVG9rZW46Ym94Y25PQ0hZNXJTQVNSM0tJRDlWbk40TDZmXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

- Feature 34：剪纸作品管理。**艺术家**可以查看自己已经上传过的剪纸作品，包括ID、名称、描述和图片等，并可以删除自己上传的剪纸作品，以及上传全新的剪纸作品。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=YjFiNDc4YjJlYmNiMWU2NGJlYTVjZjE1MjQ5NDk2YTRfR1FGRWhTVnBCWlByRllsejVReXBSRVRqanBBZGxtUEZfVG9rZW46Ym94Y25nNTg5NVZKOGlPSWpnWWNVZVh5SUpoXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

#### **8）内容管理模块**

- Feature 35：帖子管理。**管理员**可以对用户发布的不适宜的帖子进行删除操作。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=OGZlMjNmMTgzMjc2ZDBkYWZlMjFiMDJmOGFmNTI0ZTZfZEtFakYzaWJUVDU4ZzlNV0VzRExOMERGWG5GMmNpWFdfVG9rZW46Ym94Y25WVzh3VEJPc2g5YnhEUUZRU2JmdnZoXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

### Enumerated Non-Functional Requirements

1. 体验优化：对于加载速度较慢的界面，通过在界面中添加动画、进行懒加载等方式，提升用户的使用体验。
2. 易于理解：在某些需要操作的界面添加帮助按钮，从而免去了用户的学习成本。
3. 安全性：后端使用拦截器技术，避免对接口进行权限越级的非法访问。
4. 访问权限控制：不同等级的用户访问到的功能在前端有着明显的划分，与此同时在后端对非法请求进行有效拦截。
5. 模块化：将整个系统分为剪纸作品展示、剪纸论坛、剪纸专栏等模块，降低耦合性，便于并行开发。
6. 可复⽤性需求：程序中实现了⼤量的组件模块。⽐如登录组件、评论组件等，以便开发过程中能够复⽤，提⾼了开发效率。
7. 便于部署：使用docker容器技术，可以实现对整个系统的前后端进行一键部署。
8. 资料完备：对每个迭代都有较为完备的信息记录，包含阶段及成果设计内容等。

###  On-Screen Appearance Requirements

1. 符合B/S设计规范
2. 色彩设计上饱含中国剪纸的元素，带有中国传统文化色彩
3. 交互性强，易于使用

## **Functional Requirements Specification**

### Stakeholders

暂时无法在飞书文档外展示此内容

###  Actors and Goals

| **角色**     | **游客**                                                     | **普通用户**                                                 | **管理员**                                                   | **艺术家**                                                   |
| ------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **描述**     | 未在本网站登陆注册的用户                                     | 在本网站完成注册登陆的用户                                   | 负责网站用户管理和内容管理的人员                             | 具有一定艺术水平、可以对网站的内容进行艺术创作的人员         |
| **使用功能** | 浏览主页欣赏剪纸作品阅读专栏页面以及专栏对应文章查看剪纸论坛的帖子内容学习剪纸教程注册账号 | 继承游客的全部功能修改个人信息在专栏中发布文章在剪纸论坛中发帖参与讨论对帖子和文章进行点赞、评论删除自己发布的文章和帖子 | 继承普通用户所有功能修改用户的角色权限对用户进行封禁与解封进行论坛和专栏内容管理 | 继承普通用户的所有功能创建专栏，用户可以在专栏中发布文章删除自己创建的专栏上传剪纸艺术作品删除自己上传的剪纸作品 |

### Use Cases and Description

#### 游客(全部用户)

1. Use case：浏览首页

| **Use case**        | 浏览首页                                           |
| ------------------- | -------------------------------------------------- |
| **Primary actor**   | 游客（全部用户）                                   |
| **Goal in context** | 用户浏览首页，感受剪纸剪影的美                     |
| **Preconditions**   | 网站前端正常部署用户已进入首页页面                 |
| **Scenario**        | 通过点击导航栏，以及首页的下半部分，跳转到其他模块 |
| **Exceptions**      | 网站未能成功跳转：用户检查网络情况                 |
| **Priority**        | 中等                                               |
| **When avaliable**  | 迭代1                                              |

1. Use case：欣赏剪纸作品

| **Use case**        | 欣赏剪纸作品                                                 |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 游客（全部用户）                                             |
| **Goal in context** | 用户可以进入3D交互界面，从各个角度欣赏剪纸作品的细节之美     |
| **Preconditions**   | 网站前、后端正常部署用户已进入作品页面                       |
| **Scenario**        | 点击某个作品，进入3D交互界面点击帮助按钮，显示出如何操作剪纸作品鼠标左键拖动，旋转作品鼠标右键拖动，平移作品鼠标滚轮，缩放作品点击旋转按钮，作品自动旋转 |
| **Exceptions**      | 作品图片加载缓慢：检查网络条件                               |
| **Priority**        | 高级                                                         |
| **When avaliable**  | 迭代4                                                        |

1. Use case：阅读专栏及其文章

| **Use case**        | 阅读专栏及其文章                                             |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 游客（全部用户）                                             |
| **Goal in context** | 用户通过专栏来了解感兴趣的剪纸内容                           |
| **Preconditions**   | 网站前、后端正常部署用户已进入专栏页面                       |
| **Scenario**        | 用户在专栏页面点击进入按钮进入专栏内部用户点击某个文章标题进入文章页面 |
| **Exceptions**      | 点赞、评论文章失败：用户需要登录后才能进行操作               |
| **Priority**        | 中级                                                         |
| **When avaliable**  | 迭代2                                                        |

1. Use case：查看剪纸论坛的帖子内容

| **Use case**        | 查看剪纸论坛的帖子内容                         |
| ------------------- | ---------------------------------------------- |
| **Primary actor**   | 游客（全部用户）                               |
| **Goal in context** | 用户之间通过帖子来交流剪纸的心得               |
| **Preconditions**   | 网站前、后端正常部署用户已进入专栏页面         |
| **Scenario**        | 用户在论坛界面点击帖子内容查看详细信息         |
| **Exceptions**      | 点赞、评论帖子失败：用户需要登录后才能进行操作 |
| **Priority**        | 中级                                           |
| **When avaliable**  | 迭代2                                          |

1. Use case：学习剪纸教程

| **Use case**        | 学习剪纸教程                                                 |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 游客（全部用户）                                             |
| **Goal in context** | 用户通过剪纸教程页面来学习剪纸的通用折法以及剪纸的装饰纹样   |
| **Preconditions**   | 网站前端正常部署用户已进入剪纸教程页面                       |
| **Scenario**        | 用户在教程页面点击折法查看剪纸的通用折法教程用户在教程页面点击纹样查看剪纸的装饰纹样教程 |
| **Exceptions**      | 教程图片未能正常加载：用户检查网络情况                       |
| **Priority**        | 低级                                                         |
| **When avaliable**  | 迭代2                                                        |

1. Use case：注册账号

| **Use case**        | 注册账号                                                     |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 游客（全部用户）                                             |
| **Goal in context** | 用户可以注册账号来参与文章、贴子的点赞、评论、发布等         |
| **Preconditions**   | 网站前端正常部署用户已进入首页页面                           |
| **Scenario**        | 用户点击右上角导航栏的空白头像进入登录页面用户点击登录页面的注册按钮进入注册页面通过邮箱验证进行注册 |
| **Exceptions**      | 邮箱验证码获取失败：可能邮箱发送邮件过多被拉入黑名单         |
| **Priority**        | 低级                                                         |
| **When avaliable**  | 迭代1                                                        |

#### 普通用户

1. 继承游客全部功能

| **Use case**        | 继承游客全部功能           |
| ------------------- | -------------------------- |
| **Primary actor**   | 普通用户                   |
| **Goal in context** | 普通用户拥有游客的所有权限 |
| **Preconditions**   | 游客具有的权限             |
| **Scenario**        | 同上                       |
| **Exceptions**      | 网站未能成功部署           |
| **Priority**        | 低级                       |
| **When avaliable**  | 迭代2                      |

1. 修改个人信息

| **Use case**        | 修改个人信息                                                 |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 普通用户                                                     |
| **Goal in context** | 用户能够修改自己的头像、个性签名信息                         |
| **Preconditions**   | 网站前后端部署成功用户已登录并点击右上角进入个人主页页面     |
| **Scenario**        | 点击侧边栏修改个人信息点击上传头像，选择一张照片输入个性签名点击提交按钮即可修改个人信息 |
| **Exceptions**      | 上传头像失败：上传的图片太大，请选择一张不超过4MB大小的图片  |
| **Priority**        | 中级                                                         |
| **When avaliable**  | 迭代3                                                        |

1. 在专栏中发布文章

| **Use case**        | 在专栏中发布文章                                             |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 普通用户                                                     |
| **Goal in context** | 用户可以将自己的一些关于剪纸的想法写成文章发布到专栏中       |
| **Preconditions**   | 网站前后端部署成功用户已登录并进入某个专栏内部页面已有艺术家创建出专栏 |
| **Scenario**        | 点击添加文章按钮输入文章标题为文章选择一张封面（可选）为文章选择一个标签（可选）输入文章正文部分点击提交按钮 |
| **Exceptions**      | 上传封面失败：上传图片过大，请选择一张不超过4MB的图片发布文章按钮看不见：用户未登录 |
| **Priority**        | 高级                                                         |
| **When avaliable**  | 迭代3                                                        |

1. 在剪纸论坛中发帖

| **Use case**        | 在剪纸论坛中发帖                                             |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 普通用户                                                     |
| **Goal in context** | 用户可以将自己关于剪纸的一些看法、一些问题发到论坛中等待别人回答 |
| **Preconditions**   | 网站前后端部署成功用户已登录并进入论坛页面                   |
| **Scenario**        | 点击右下角发布帖子按钮输入帖子标题和内容点击立即创建按钮，即完成帖子发布 |
| **Exceptions**      | 发布帖子失败：用户未登录                                     |
| **Priority**        | 高级                                                         |
| **When avaliable**  | 迭代2                                                        |

1. 对帖子和文章进行点赞、评论

| **Use case**        | 对帖子和文章进行点赞、评论                          |
| ------------------- | --------------------------------------------------- |
| **Primary actor**   | 普通用户                                            |
| **Goal in context** | 用户可以对自己感兴趣的帖子和文章进行点赞、评论      |
| **Preconditions**   | 网站前后端部署成功用户已登录并进入专栏或论坛页面    |
| **Scenario**        | 用户点击自己感兴趣的文章或帖子进行点赞或评论        |
| **Exceptions**      | 点赞失败：用户登录时间过久，已经被后台清除token缓存 |
| **Priority**        | 高级                                                |
| **When avaliable**  | 迭代2                                               |

1. 删除自己发布的文章和帖子

| **Use case**        | 删除自己发布的文章和帖子                                     |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 普通用户                                                     |
| **Goal in context** | 用户可以删除掉自己之前发布的、感觉不太恰当的帖子和文章       |
| **Preconditions**   | 网站前后端部署成功用户已登录并发布过文章或帖子用户已进入个人主页 |
| **Scenario**        | 点击帖子右上角的删除帖子按钮来删除帖子点击文章右上角的删除文章按钮来删除文章 |
| **Exceptions**      | 删除失败：检查网络或者是否已经登录过久                       |
| **Priority**        | 高级                                                         |
| **When avaliable**  | 迭代4                                                        |

#### 3.3.3  管理员

1. 继承普通用户的全部功能

| **Use case**        | 继承普通用户的全部功能       |
| ------------------- | ---------------------------- |
| **Primary actor**   | 管理员                       |
| **Goal in context** | 管理员拥有普通用户的所有权限 |
| **Preconditions**   | 普通用户具有的权限           |
| **Scenario**        | 同上                         |
| **Exceptions**      | 网站未能成功部署             |
| **Priority**        | 低级                         |
| **When avaliable**  | 迭代2                        |

1. 修改用户的角色权限

| **Use case**        | 修改用户的角色权限                                           |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 管理员                                                       |
| **Goal in context** | 管理员可以修改其他用户的权限来让用户可以有机会切换账号角色   |
| **Preconditions**   | 登录的账号为管理员权限账号                                   |
| **Scenario**        | 登录管理员权限账号进入我的主页点击用户权限管理对不同用户进行修改权限 |
| **Exceptions**      | 用户权限管理不能使用：登录的账号不是管理员权限账号           |
| **Priority**        | 中级                                                         |
| **When avaliable**  | 迭代3                                                        |

1. 对用户进行封禁

| **Use case**        | 对用户进行封禁                                               |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 管理员                                                       |
| **Goal in context** | 管理员可以禁用或者解禁其他账号                               |
| **Preconditions**   | 登录的账号为管理员权限账号                                   |
| **Scenario**        | 登录管理员权限账号进入我的主页点击用户权限管理对不同用户进行禁用或解禁 |
| **Exceptions**      | 用户权限管理不能使用：登录的账号不是管理员权限账号           |
| **Priority**        | 中级                                                         |
| **When avaliable**  | 迭代3                                                        |

1. 进行论坛和专栏内容管理

| **Use case**        | 进行论坛和专栏内容管理                                       |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 管理员                                                       |
| **Goal in context** | 管理员可以对用户发布的不适宜的帖子或文章进行删除操作。       |
| **Preconditions**   | 登录的账号为管理员权限账号                                   |
| **Scenario**        | 登录管理员权限账号在论坛界面或内容管理页面来删除不适宜的帖子在专栏页面来删除不适宜的文章 |
| **Exceptions**      | 在上述界面看不到删除按钮： 登录的账号不是管理员权限账号      |
| **Priority**        | 高级                                                         |
| **When avaliable**  | 迭代3                                                        |

#### 艺术家

1. 继承普通用户的全部功能

| **Use case**        | 继承普通用户的全部功能       |
| ------------------- | ---------------------------- |
| **Primary actor**   | 艺术家                       |
| **Goal in context** | 艺术家拥有普通用户的所有权限 |
| **Preconditions**   | 普通用户具有的权限           |
| **Scenario**        | 同上                         |
| **Exceptions**      | 网站未能成功部署             |
| **Priority**        | 低级                         |
| **When avaliable**  | 迭代2                        |

1. 创建专栏

| **Use case**        | 创建专栏                                                     |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 艺术家                                                       |
| **Goal in context** | 艺术家可以创建专栏来提供一个交流的平台                       |
| **Preconditions**   | 登录的账号为艺术家权限账号                                   |
| **Scenario**        | 登录艺术家权限账号进入我的主页页面点击专栏管理按钮给定专栏名称、专栏简介、专栏封面信息来创建一个指定专栏 |
| **Exceptions**      | 创建专栏不能使用：登录的账号不是艺术家权限账号               |
| **Priority**        | 中级                                                         |
| **When avaliable**  | 迭代2                                                        |

1. 删除自己创建的专栏

| **Use case**        | 删除自己创建的专栏                                           |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 艺术家                                                       |
| **Goal in context** | 艺术家可以删除自己创建的、感觉不太适宜的专栏                 |
| **Preconditions**   | 登录的账号权限为艺术家权限有自己发布的专栏存在               |
| **Scenario**        | 登录艺术家权限账号进入我的主页进入专栏管理页面点击自己创建的专栏的删除按钮删除专栏 |
| **Exceptions**      | 我的专栏中不存在专栏：之前未创建过专栏                       |
| **Priority**        | 中级                                                         |
| **When avaliable**  | 迭代3                                                        |

1. 上传剪纸艺术作品

| **Use case**        | 上传剪纸艺术作品                                             |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 艺术家                                                       |
| **Goal in context** | 艺术家可以上传自己的剪纸作品以供用户观赏                     |
| **Preconditions**   | 登录的账号为艺术家权限账号                                   |
| **Scenario**        | 登录艺术家权限账号进入我的主页进入剪纸作品管理页面点击上传剪纸作品按钮提供作品名称、作品简介、作品链接后完成作品上传 |
| **Exceptions**      | 剪纸作品管理按钮无法使用：登录的账号不是艺术家权限选择图片上传失败：上传图片过大 |
| **Priority**        | 高级                                                         |
| **When avaliable**  | 迭代3                                                        |

1. 删除自己上传的剪纸作品

| **Use case**        | 删除自己上传的剪纸作品                                       |
| ------------------- | ------------------------------------------------------------ |
| **Primary actor**   | 艺术家                                                       |
| **Goal in context** | 艺术家可以删除自己上传过的作品                               |
| **Preconditions**   | 登录的账号为艺术家权限账号艺术家已有上传的作品               |
| **Scenario**        | 登录艺术家权限账号进入我的主页进入剪纸作品管理页面点击作品右侧的删除按钮，在确认后完成作品删除 |
| **Exceptions**      | 剪纸作品管理中没有作品：该艺术家未上传过作品                 |
| **Priority**        | 中级                                                         |
| **When avaliable**  | 迭代4                                                        |

### Sequence Diagrams

####  用户登录

![UML 图](/Users/zhangxiaoni/Downloads/UML 图.jpg)

####  用户注册

![UML 图-2](/Users/zhangxiaoni/Downloads/UML 图-2.jpg)

####  用户发帖

![UML 图-3](/Users/zhangxiaoni/Downloads/UML 图-3.jpg)

####  用户评论帖子

![UML 图-4](/Users/zhangxiaoni/Downloads/UML 图-4.jpg)

#### 用户修改个人信息

![UML 图-5](/Users/zhangxiaoni/Downloads/UML 图-5.jpg)

####  用户发布文章

![UML 图-6](/Users/zhangxiaoni/Downloads/UML 图-6.jpg)

####  用户浏览剪纸作品

![UML 图-7](/Users/zhangxiaoni/Downloads/UML 图-7.jpg)

####  用户删除文章

![UML 图-8](/Users/zhangxiaoni/Downloads/UML 图-8.jpg)

####  用户删除帖子

![UML 图-9](/Users/zhangxiaoni/Downloads/UML 图-9.jpg)

####  艺术家创建专栏

![UML 图-10](/Users/zhangxiaoni/Downloads/UML 图-10.jpg)

####  艺术家上传剪纸作品

![UML 图-11](/Users/zhangxiaoni/Downloads/UML 图-11.jpg)

####  艺术家删除专栏

![UML 图-12](/Users/zhangxiaoni/Downloads/UML 图-12.jpg)

####  艺术家删除剪纸作品

![UML 图-13](/Users/zhangxiaoni/Downloads/UML 图-13.jpg)

#### 管理员授予用户权限

![UML 图-14](/Users/zhangxiaoni/Downloads/UML 图-14.jpg)

####  管理员禁用用户

![UML 图-15](/Users/zhangxiaoni/Downloads/UML 图-15.jpg)

####  管理员删除帖子

![UML 图-16](/Users/zhangxiaoni/Downloads/UML 图-16.jpg)

## **** **System Architecture Design and Implementation**

###  Architectural Style

本项目使用了前后端分离的软件架构:前端项目使用vue3,后端项目使用springboot,数据的存储使用redis与mysql与图床chevereto,全部使用docker技术,将前后端与数据库运行在docker容器当中,使得项目易于部署。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=YTM3ZGY1YmFkNDNlNjQzOTRiMTg4YzAxZmZjNDJjZmNfdjlpc2txeEFBR3BwckM3c2ZjbEhHR3dXelVKMmZzWWlfVG9rZW46Ym94Y25MYWtGQTlBS0o5RmpmUzh1N21QaDJiXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

### Identifying Subsystems

在本项目中,我们实现了用户的登录与注册模块,论坛模块,专栏与文章模块,作品模块,剪纸知识介绍模块。

**登录与注册模块：**

在用户进行登录时，输入账号密码后由前端将发送请求到后端,随后后端验证用户输入的用户名与密码是否匹配,如果匹配，则返回前端登录成功的信息。同时将将用户的session记录在redis当中,为会话保持做准备。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MjdkMGMyYWI0ZmE0MzViY2IxZGViMGNhYjg0N2FiMmNfRGttc1p1eThDczVxbm1STWhMZnZuWEN1aTkzSll2WXRfVG9rZW46Ym94Y242VUJiWWJsSFNPVVE5TGV6Njc3Q0hlXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

如果用户选择注册的话,则输入要注册的用户名与密码后,还有自己的邮箱,前端向后端发送请求后,后端会向用户输入的邮箱发送一个验证码,同时以邮箱为key,验证码为value存入redis里,同时设置过期的时间,使得验证码只在一段时间内有效。用户填写完收到的验证码，点击注册按钮发送给后端，后端经过验证，如果准确，则将用户注册的用户名与密码写入到数据库中。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=OTNmNDhhNTMzMjFiZGEyMzJjNTFmMTI0NTViZDJhMTVfTHIyTkZiTmZ3MkN5am1uZDdPVHhCSmR2OUk3NGR3M3ZfVG9rZW46Ym94Y25yZGVQV1VCZGYwR1N3UzlpbVNMYlZlXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

因为http协议是无状态的,所以要记住登录的状态还需要会话保持的技术,因为我们在登录的时候将用户的session记录在了redis里,所以用户的刷新页面或者是跳转页面时,后端都会检查一下前端发送过来的session,如果该session是记录过的,那么该用户也是登录过的,否则就提醒用户进行登录。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MTUxYTg2Y2M3OGNjOTZjYTgyYTcyZDEyOGRhN2ZlZGNfell4RjExNWtnaFV0MGNUY1BuMVF2eHRTU3FLMVZSbDVfVG9rZW46Ym94Y243NXpmRTFZdFlCdWM0SDY0MENtUGNiXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

**论坛模块:**

论坛模块具有供用户与其他剪纸爱好者交流学习的功能,用户可以发布帖子,可以在帖子下评论,也能根据关键字搜索帖子。

在发布帖子时，没有登录的游客是不能发布的，所以在发布帖子之前，要验证用户的登录状态。这里我们使用了拦截器。在后端响应前端的发布帖子的请求之前，首先检验用户的登录状态，如果没有登录，就拒绝这个请求。

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MjYzZGUxMTUzODI1MjA0MjA2Zjc2ZTVkYmY5M2ZhN2FfTlR4NFdtSUpHaG1zUXBieTlKMnZBVVM5VHREVmdoQ0lfVG9rZW46Ym94Y25xSXlsTE5JOWZ2RkN1OVVLTzZackZmXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

**专栏与文章模块:**

专栏与文章模块是给想要进阶学习剪纸的爱好的用户一个学习的地方,专栏是一个主题的文章的集合,文章的内容与质量上会比帖子好.

同时,编写文章时,使用的是富文本编辑器,所以在内容的样式上,文章比帖子更丰富,同时,也有插入图片与视频等特殊功能。

在使用富文本编辑器编辑好文章后,前端会将文章转换为html格式存储在数据库里,图片则会存储在图床里,然后mysql只会存储图床返回的URl。

暂时无法在飞书文档外展示此内容

**作品模块：**

作品模块可以上传剪纸艺术家的作品,供其他剪纸爱好者学习与参考。

**剪纸****文化****模块:**

剪纸文化模块主要介绍了一些剪纸的历史与剪纸的基础技巧.可以给爱好剪纸的用户一个入门知识的讲解

### 4.3 Development and Deployment Environment

**Development Environment:**

本项目使用git作为版本管理工具，腾讯工蜂作代码远程托管，使用IDEA开发后端，使用VSCode开发前端，使用mysql，redis，chevereto作为存储工具

IDEA 全称IntelliJ IDEA，是用于java语言开发的集成环境，IntelliJ在业界被公认为最好的java开发工具之一，尤其在智能代码助手、代码自动提示、重构、J2EE支持、Ant、JUnit、CVS整合、代码审查、 创新的GUI设计等方面的功能可以说是超常的。

Visual Studio Code是Microsoft在2015年4月30日Build开发者大会上正式宣布一个运行于 Mac OS X、Windows和 Linux 之上的，针对于编写现代Web和云应用的跨平台源代码编辑器 可在桌面上运行，并且可用于Windows，macOS和Linux。它具有对JavaScript，TypeScript和Node.js的内置支持，并具有丰富的其他语言扩展的生态系统。

MySQL是一个关系型数据库管理系统，由瑞典MySQL AB公司开发，目前属于Oracle公司。MySQL是一种关联数据库管理系统，关联数据库将数据保存在不同的表中，而不是将所有数据放在一个大仓库内，这样就增加了速度并提高了灵活性。MySQL所使用的SQL语言是用于访问数据库的最常用标准化语言。MySQL软件采用了双授权政策，它分为社区版和商业版，由于其体积小、速度快、总体拥有成本低，尤其是开放源码这一特点，一般中小型网站的开发都选择MySQL作为网站数据库。由于其社区版的性能卓越，搭配PHP和Apache可组成良好的开发环境。

- Redis 是完全开源免费的，遵守 BSD 协议，是一个灵活的高性能 key-value 数据结构存储，可以用来作为数据库、缓存和消息队列。

-  Redis 比其他 key-value 缓存产品有以下三个特点：

- - Redis 支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载到内存使用。
  - Redis 不仅支持简单的 key-value 类型的数据，同时还提供 list，set，zset，hash 等数据结构的存储。
  - Redis 支持主从复制，即 master-slave 模式的数据备份

Chevereto是一个自行托管的多用户、功能齐全的媒体托管解决方案。它可以用来创建无数的应用程序或增强现有系统的能力，所有这些都围绕着用户托管和与媒体内容交互的概念。

**Deployment Environment:**

本项目使用Docker容器部署

Docker 是一个开源的应用容器引擎，让开发者可以打包他们的应用以及依赖包到一个可移植的镜像中，然后发布到任何流行的 Linux 机器上。使用Docker可以让每个应用彼此相互隔离，在同一台机器上同时运行多个容器，他们彼此之间共享同一个操作系统。Docker的优势在于，它可以在更细的粒度上进行资源的管理，比虚拟化技术性能更高，更加节约资源。

本项目的前端,后端还有数据库都是利用docker部署在服务器上,这样既减少了环境配置的麻烦,也使得多个程序可以同时运行且不会相互冲突.

同时,在部署时,我们使用了IDEA的docker部署功能,使用IDEA连接上服务器的docker后,在对项目配置好dockerfile文件,IDEA便可以通过dockerfile为我们打造好镜像,随后将镜像部署在服务器上,大大简化了部署流程,实现了一键部署

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=ZDEyZmE1ODI4MTdlM2RmNmEyYzk4YjQyNDAyNTFlMTBfRnBjZEh4dU5aOUI5Vjl5dXN6YUhJZ0ZHUHhIVWFpdlBfVG9rZW46Ym94Y24yaW4xcmZqYW93TmU4SjZNeVZjREdoXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MTgzNzdkMzgyYjg3YWIxMThhNjRjMjY4ZWQzYWMwZGVfQzJzMkhCUlVDazJPQ3Q0SmNTQzJKMFgxcGNXTnN0UkZfVG9rZW46Ym94Y25STzd4WjBtZWNsNzh5OGJQNUJwSnRkXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

### Algorithm and Data Structure

本项目使用mysql做主要数据的存储:

- 在mysql中,我们为数据库建立了以下的表:

-  1.user表,用来记录用户的基本信息:

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MzBjOTBiZmI4MWU4MThlNWIzNzFlMDMyZDhjZGZkZThfNDk3RmNpT1VSUmVhZWVXeVF5aWw5VFRzcnN1TGt3cWlfVG9rZW46Ym94Y25OUklCd1J3elNrSW5ZOGhhb3IxNlJoXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

2.art表,记录用户上传作品的信息,包括图床的URl链接等

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=ZTcwZWEyNzlkZjBlNmQyZjAxYWMyZGJlMGZlOTU0OTFfTXBYQnFDdW9MQVdXMWJCeU1mYWllWXZsUDZma0JFaWFfVG9rZW46Ym94Y243TG5xYTI3UzhtZmk5VzYxY2lwVmtlXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

3.article表,用来记录用户上传的文章的基本信息

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=Y2Q3ODcyZTU3ODdkYzgzZGViZjBiOTU2ODE3N2Y0MTRfcDBLRjZYdTdWeFBNZ0tKNEZvUmR1YlVTNXNmOUJlRDJfVG9rZW46Ym94Y25TUUVDZW13Ylg0Y1hWOEhrTGhrMm8wXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

4.column_table表,记录专栏的一些基本信息

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=ZmJmZmFkMTAyMWY5MjBhZjUwZDllNDY1ZGY3YmJkNDlfRHRENEk3N1hjYWlEcmRFaEdkejdtMkhJU3JwSzRnQ1JfVG9rZW46Ym94Y25sNEZYZ0x4ZmxTeUtDWENsQ3dWMldiXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

5.comment表,记录用户的评论信息,包括评论的内容,时间,以及评论的类型等等

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=YzRjNWE2OTMwNGYyNmJmNTdjN2JjMWMwY2Q5YmY1OTRfZUZPM2tvRkY0Wm05aXFaS3JQSHpZV0lHQUtGQm5YV2tfVG9rZW46Ym94Y25vRzF1NTh2S2ZrUFhuUFdBdHlXUm1kXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

6.favor表,用来记录读者关注的专栏

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=YjFhNzc0ZTQ5ODEyYjljOGU4MjIzMDE0ODg3NDg4NGJfakNKMXhFZ0hMWkpzZ0FWcUtOblRJTTlSSXZxTFhzS05fVG9rZW46Ym94Y25NMXFNRG92ZDVOODNNdDRGdXdobU9kXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

7.thumbs表,用来记录用户给帖子,文章点赞的信息

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=MDZiOWVhYTNlZTcwNTE1NjQ0Nzk4ZGU4N2JhYTg1YzVfMGs3NXBxNzNtdk5VUHROQnZ4QlVuVGY5TGVpOW5FcDhfVG9rZW46Ym94Y25LbncwMDlGbE9iY2ptN0pSZkFKMnRiXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

8.topic表,用来记录用户发送的帖子的基本信息

![img](https://nankai.feishu.cn/space/api/box/stream/download/asynccode/?code=YjRiMmRjM2E3YmRlOTlhNTVlMjI5YTRlZTJhNjAzNzNfNm1wRWRCM3I1SkJ4bEFYcnFmZTI5S1kxRE1ITG1xN0dfVG9rZW46Ym94Y25GZlJlNUVUcFRJSXlKZ2R6a28zR0tmXzE2NzgxNTg1ODM6MTY3ODE2MjE4M19WNA)

###  Persistent Data Storage

本项目使用运行在docker容器中的数据库进行数据的持久化,同时,也利用文件的挂载,将docker容器中的数据库内容保存在了服务器内,保证了容器运行崩溃时,容器内的数据也不会丢失.保护了数据的安全性.

### Network Communication

本项目是前后端分离的项目,所以,前端在给后端发送请求的时候,是使用ajax,发送http请求给后端,后端在处理完请求后,在发送http回复给前端,前端根据返回的信息,动态刷新页面.

###  User Interface Specification

1. 易用性
   1. 按钮名称或图标清晰易懂，与同一界面的其余按钮易于区分
   2. 完成相同或相近功能的按钮用Frame框起来
   3. 完成同一功能或任务的元素放在集中位置，减少鼠标移动的距离。
   4. 按功能将界面划分局域块，用Frame框括起来,并要有功能说明或标题。
   5. 同一页面展示的文章和专栏数不会太多，多于10个时使用分页界面显示
2. 规范性
   1. 界面设计都按Windows 界面的规范来设计，即包含“菜单条、工具栏、工具箱、状态栏、滚动条”的格式
   2. 完成相同或相近功能的菜单用横线隔开放在同一位置。
   3. 一条工具栏的长度最长不能超出屏幕宽度。
   4. ⼯具栏设置默认放置位置。
3. 帮助设施
   1. 用户在作品3D交互界面可以按照帮助文档指示来操作
4. 合理性
   1. 用户在登录后仍保持在原页面，保证了阅读的连续性
   2. 用户在退出登录后会回到首页并刷新权限，避免非法操作
   3. 进行了登录持久化的操作，避免用户刷新页面后直接退出登录
   4. 非法的输入或操作有足够的提示说明。
   5. 没有权限操作的按钮加以屏蔽（用灰色显示，没法使用该按钮）。
   6. 对可能造成数据无法恢复的操作必须提供确认信息,给用户放弃选择的机会。
   7. 对运行过程中出现问题而引起错误的地方有提示，让用户明白错误出处，避免形成无限期的等待。

## **Individual Contributions, Current Status, and Future Work**

###  Individual Contributions

1） 导航栏模块

- Feature 1: 用户登录。用户可以输入用户名和密码进行登陆操作。（薛鹏）
- Feature 2: 用户注册。新用户可以通过邮箱验证进行注册。（薛鹏）
- Feature 3: 页面跳转。用户可以通过导航栏各个按钮进行各个功能模块的跳转。（郭耘赫）
- Feature 4: 用户登陆可以通过菜单进入用户主页，如果是管理员可以进入内容管理页面，也可以通过菜单退出登陆。（张家冉）

2）首页模块

- Feature 5: 首页的上半部分通过剪纸风味十足的元素来展示我们网站的主题。（张怡桢）
- Feature 6: 首页的下半部分展示了各地剪纸的发展历史、剪纸艺术家介绍、剪纸的教程、剪纸的技巧、以及著名的剪纸作品等模块的入口。（匡俊骅）

3）论坛模块

- Feature 7: 数据展示。用户可查看论坛部分的文章数、评论数、访客数以及按照发布帖子数目进行排列的作者榜。（匡俊骅）
- Feature 8: 浏览帖子。用户可查看已发布的帖子列表，其中包括帖子标题、作者、帖子内容摘要，点进去之后查看帖子的详细内容、作者的详细信息以及当前帖子的评论。（张怡桢）
- Feature 9: 搜索帖子。用户可以在上方的搜索框中输入自己感兴趣的内容来搜索相关的帖子。（郭耘赫）
- Feature 10: 点赞评论。用户在登录后可以对自己喜欢的帖子进行点赞操作，并可以在点击进入帖子详情之后对帖子发表评论。（张家冉）
- Feature 11: 发布帖子。用户在登录后可以在论坛中发布自己的帖子。（薛鹏）
- Feature 12: 帖子管理。（匡俊骅）
  -  管理员可以删除用户发布的不适宜的帖子。

  -  用户在登录后可以在自己的主页删除掉自己发布的帖子。

4）专栏模块

- Feature 13: 所有专栏展示。用户可以在专栏界面，查看所有的专栏信息，包括专栏名称、专栏封面以及各个专栏的文章数目。点击进入可以进入某个专栏内部。（郭耘赫）
- Feature 14: 发布专栏。艺术家可以在自己的主页中的“创建专栏”模块中通过给定专栏名称、专栏简介、专栏封面等信息发布新的专栏。（张家冉）
- Feature 15: 专栏管理。（张怡桢）
  -  管理员可以所有专栏页面删除某些不适宜的专栏。

  -  艺术家也可以在自己的个人主页中删除自己发布的专栏。
- Feature 16: 专栏信息展示。用户在专栏内部可以查看专栏的介绍、统计数据等信息。（薛鹏）
- Feature 17: 专栏文章展示。用户可以在专栏中查看该专栏中发布的文章信息，包括文章的标题、内容概要、封面图片、发布者、点赞数、评论数等，点击标题后可以跳转到文章页面。（匡俊骅）
- Feature 18: 发布文章。用户在登录后，可以在专栏内发布文章。发布文章时，用户可以指定标题，上传封面图片，并通过富文本编辑器编辑文章内容，实现了工具栏（支持粗体、文本居中、修改字体字号、插入图片、视频等功能），编辑好的内容将转化成HTML代码在文章部分展示。（郭耘赫）
- Feature 19: 评论文章。用户在登录后，可以在文章下发布对文章内容的评论。（张怡桢）
- Feature 20: 文章管理。（张家冉）
  -  管理员可以在专栏内部删除某些不适宜的文章。

  -  用户也可以在自己的个人主页中删除自己发布的文章。

5）剪纸作品模块

- Feature 21: 剪纸作品展示。用户可以在作品页面查看艺术家上传所有的剪纸作品信息，包括作品名称、创建时间等。（薛鹏）
- Feature 22: 剪纸作品3D欣赏。用户可以点击作品进入3D交互界面，在其中用户可以对作品进行放大、缩小，平移、旋转等操作，从而可以从各个角度欣赏剪纸作品的细节之美。（郭耘赫）
- Feature 23: 剪纸作品管理。艺术家在自己的主页的“剪纸作品管理”模块中，通过指定作品名称、作品简介、作品图片链接的方式，上传自己的剪纸作品。同时，可以在作品列表中删除自己的某个作品。（匡俊骅）

6）剪纸文化模块

- Feature 24：剪纸历史。用户可以了解有关剪纸的发展历史等内容。（张家冉）
- Feature 25：艺术家列表。用户可以了解有关当今中国著名剪纸艺术家，如段云丽夫妇、傅作仁、顾朋泉、陈粉丸等（张怡桢）
- Feature 26：艺术家介绍。用户可以从中认识有关艺术家的人生经历、相关作品等信息（张怡桢）
- Feature 27：折法介绍。用户可以学习对边折剪法、三角折剪法、四角折剪法、五角折剪法、六角折剪法、二方连续折剪法、四方连续折剪法等剪纸的通用折法。（薛鹏）
- Feature 28：纹样介绍。用户可以学习剪纸的月牙纹、太阳纹、云纹、柳叶纹、火纹、水纹等纹样来装饰剪纸的作品。（薛鹏）
- Feature 29：技巧介绍。用户可以学习剪纸中的阴刻、阳刻、彩色剪纸、立体剪纸等剪纸技巧。（郭耘赫）

7）用户主页模块

- Feature 30：我的主页。所有用户可以查看自己的头像、个人简介等个人信息。同时可以查看或删除自己发布的帖子和文章。艺术家还同时可以查看和删除自己发布的专栏。（张怡桢）
- Feature 31：修改个人信息。用户可以修改自己头像和个性签名。（张家冉）
- Feature 32：用户权限管理。管理员可以对用户进行管理，执行包括用户封禁和解禁、修改用户角色权限（可以指定为普通用户、艺术家、管理员）同时可以通过上方的搜索框搜索指定用户。（匡俊骅）
- Feature 33：创建专栏。艺术家可以查看自己所有已创建的专栏，也可以通过指定专栏标题、专栏简介、专栏封面来发布新的专栏。（张怡桢）
- Feature 34：剪纸作品管理。艺术家可以查看自己已经上传过的剪纸作品，包括ID、名称、描述和图片等，并可以删除自己上传的剪纸作品，以及上传全新的剪纸作品。（张家冉）

8）内容管理模块

- Feature 35：帖子管理。管理员可以对用户发布的不适宜的帖子进行删除操作。（郭耘赫）

### Current Status

经过一学期的工作，我们已经搭建了一个较为完整的“纸间万象”平台，来传承，发展，分享有关于非物质文化遗产“剪纸”的文化。

网站的设计综合考虑了人们对剪纸艺术的认识、剪纸的发展历史、剪纸兴趣者的交流沟通和经验分享、艺术家的作品展览等多方面因素，旨在为传承和发扬剪纸文化提供一个综合性的平台。

网站实现了对剪纸艺术进行相关的科普与介绍、对于不同地域的剪纸艺术进行概述、对剪纸技巧和教程进行初步介绍；提供了一个剪纸论坛，让剪纸爱好者与纸间万象的用户进行互动沟通、讨论交流；开发了剪纸艺术家专栏，让艺术家分享自己的剪纸经历，技巧以及故事等；搭建了剪纸作品3D交互界面，让艺术家能够上传自己的剪纸作品，供剪纸爱好者们从各个角度来欣赏剪纸作品。

不同的身份来访问我们的网站，分别可以进行以下操作：

1）**游客**可以浏览主页、欣赏剪纸作品、阅读专栏页面以及专栏对应文章、查看剪纸论坛的帖子内容、学习剪纸教程、注册账号

2）**普通用户**可以执行游客的所有操作、修改个人信息、在专栏中发布文章、在剪纸论坛中发帖参与讨论、对帖子和文章进行点赞、评论、删除自己发布的文章和帖子

3）**管理员**可以执行普通用户的所有操作、修改用户的角色权限、对用户进行封禁、进行论坛和专栏内容管理

4）**艺术家**可以执行普通用户的所有操作、创建专栏，用户可以在专栏中发布文章、删除自己创建的专栏、上传和删除剪纸艺术作品

### Future Work

1. 当前网站在PC设备上显示效果较好，未来可能进行移动端等其他设备的适配。
2. 未来可能在剪纸作品3D浏览的基础上，进一步实现动态展示剪纸过程，实现在线剪纸小游戏。
3. 进一步完善填充网站的帖子和文章的内容。
4. 未来可能尝试拓展其他功能，如展现最新的有关剪纸的新闻动态等。
5. 未来尝试长期维护项目，真正将项目投入使用，而不是仅仅当做一份作业来完成。希望最终我们的这个网站能真正成为一个剪纸交流的平台。

## **Summary and Prospect**

### Summary

本次项目实践中，我们采用前端vue3+后端springboot+redis+mysql数据库+图床chevereto技术栈，使用docker技术连接前后端，来进行网站的开发。

我们将网站的开发分为几个主要的功能模块，小组的每一个成员都尝试着去做一个Feature从前端到后端的全栈开发，这样既有助于每个成员都能获得全栈的开发经验，又能保证各个Feature在开发过程中的独立性，降低小组成员之间开发进度不同造成的影响。

整个开发过程中，我们采用的是敏捷开发模型，一共进行了五次迭代，每次迭代完成一部分当前进度下优先级最高的需求，每次迭代都使网站的功能更加完善，逐步使一个空白的框架在一次一次的迭代中发展成一个能实现项目需求、正常运作的网站。

为了完成项目开发，实现项目需求，我们熟悉并掌握了vue3、JavaScript等前端开发知识，完成了网站前端的设计；通过学习springboot和数据库的知识，我们创建了网站需要的数据库，完成了网站前后端的交互。

由于缺少项目开发的经验，我们的开发过程并不是一帆风顺。小组有的成员没有前端开发经验，有的成员没有后端开发的经验，我们从零开始一步步学习、实践，一步步加快开发的速度，完成了整个网站的开发。在整个项目的进度安排上，我们有时也会遇到一些问题，比如会发现原本计划在当次迭代中完成的需求遇到了困难，或者给当次迭代安排的任务过多，难以在迭代时间内完成，这时就只能调整进度安排，将未完成的需求安排在下一次迭代进行实现。在团队开发的初期，由于缺乏沟通，我们偶尔还会遇到合并冲突的问题，常常要花费很长时间去解决。随着开发的进度不断推进，我们都有了一定经验，这类问题出现的频率大大减少。

总的来说，经过本次项目开发，我们小组的每一个成员都收获颇丰。相信有了这次项目开发的经验，我们会在今后的项目开发中完成得更好。

### Prospect

通过这次的项⽬实践，我们发现⾃⾝在项⽬开发⽅⾯还有很多的不⾜，我们的项⽬也有很多地⽅可以改进和完善，受时间和⾃⾝能⼒的限制，我们暂时还⽆法⽴刻将我们的项⽬做到尽善尽美，但这次项⽬经历的价值并不仅限于这个网站，更重要的是这次开发的过程，以及这次项⽬经历带给我们的经验和知识。

在这次项⽬开发中，我们每⼀个小组成员都积累到了许多项⽬经验。我们深刻地认识到了团队协作的重要性，如果没有小组成员间有效的沟通，在实际开发中会遇到⼤量的问题，作为软件⼯程专业的学⽣，我们不应该只会单打独斗，⽽应该多与他人合作，多多积累经验。个人能力再强，如果缺乏团队有效的沟通，便只能是一加一小于二。只有多交流，多实践，真正获得了团队开发实际项⽬的能⼒，才能更好地发挥团队的作用，实现一加一大于二的效果。

在接下来的学习中，我们会在努⼒丰富理论知识的同时，更加注重实践和团队协作，养成动⼿实践的习惯，也会将这⼀次实践中获得的经验多多⽤于以后的项⽬开发中去，虽然⽬前我们的能⼒还有限，我们的成品也有很多可以改进的地方，但我们会不断学习，不断提升，努力在未来开发出更加优秀的产品。

## **Product Visit Link and Test Method:**

###  Product Visit Link

网站地址：http://39.105.50.27:8888/#/homeView

腾讯工蜂地址：https://git.code.tencent.com/kuangjunhua/zhijianwanxiang.git

### Product Test Method

1）输入网址，即可访问网站。

理论上讲，我们在开发时考虑到了对不同分辨率屏幕的适配问题，但是由于设备有限，我们只在**1080P、2K和2.5K分辨率**屏幕上进行了显示效果测试，不能确保在其他分辨率屏幕显示效果也是正常的。

- 2）体验用户如下

- | **用户身份** | **用户名**   | **密码**     |
  | ------------ | ------------ | ------------ |
  | **管理员**   | admin        | 123456       |
  | **艺术家**   | kjh          | kjh          |
  | zhh          | zhh          |              |
  | gyh          | gyh          |              |
  | zjr          | zjr          |              |
  | xp           | xp           |              |
  | **普通用户** | general_user | general_user |

3）注册方式

点击导航栏右上角空白头像，进入登录页面后，点击注册按钮进入注册页面，输入用户名、密码，并通过邮箱验证后即可完成注册。
