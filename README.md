## 技术栈
1. SpringBoot框架。
2. Thymeleaf模板引擎。
3. 数据访问层：Mybatis，mybatis generator。
4. 数据库：MySql。
5. 服务器：内置Tomcat。
6. 前端相关:Jquery,Bootstrap，Ajax，Layer等。
7. 前端模板：LayUI_fly社区模板。
8. 文件上传：腾讯云COS对象存储。
9. 短信验证：极光短信。
10. 邮箱验证：腾讯邮箱。
11. 富文本编辑器：WangEditor。
12. OAuth2授权登入（QQ、微博、百度、Github）
13. 验证码：vaptcha
14. 扫码登录
15. 身份验证:JWT

## 主要功能

#### 帖子相关
1. 发帖
2. 编辑
3. 点赞
4. 收藏
5. 回复[（支持楼中楼回复）]
6. 帖子分类
7. 话题标签
8. 图片处理[（图片审核，图片水印，图片压缩，头像智能剪切）]
9. 置顶帖
10. 精华帖
11. 内容审核
12. 分享
13. 管理面板[（支持加精、置顶、删除等操作）]

#### 用户相关
1. 登录
2. 注册（支持使用手机、邮箱、QQ、微博、百度、Github注册账号）
3. [账号体系(绑定账户)]手机号、邮箱号、QQ、微博、百度、Github六合一）
4. 上传头像
7. 会员特权
8. 消息通知
9. 个人主页
10. 更新资料
11. 设置、修改密码

#### 更多功能
1. 搜索
2. 排序
3. 瀑布流模式
4. 验证码-防灌水、攻击
5. 身份验证


## 目录结构
   ```
       ├─cn.chonglang.forum         应用目录
       │  ├─controller         控制器目录
       │  ├─model              映射数据库实体类
       │  ├─dto                数据传输层
       │  ├─intercepter        拦截器
       │  ├─enums              枚举类
       │  ├─provider           提供类
       │  ├─service            业务逻辑层
       │  ├─advice             异常处理
       │  ├─exception          自定义异常
       │  ├─dao                数据访问层
       │  ├─utils              工具类
       │__├─config             配置类
   ``` 


### 资料
[Spring 文档](https://spring.io/guides)
[Spring Web](https://spring.io/guides/gs/serving-web-content/)
[es](https://elasticsearch.cn/explore)
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)
[Bootstrap](https://v3.bootcss.com/getting-started/)
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)
[菜鸟教程](https://www.runoob.com/mysql/mysql-insert-query.html)
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)
[Spring Dev Tool](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)
[Spring MVC](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#mvc-handlermapping-interceptor)
[Markdown 插件](http://editor.md.ipandao.com/)
[UFfile SDK](https://github.com/ucloud/ufile-sdk-java)
[Count(*) VS Count(1)](https://mp.weixin.qq.com/s/Rwpke4BHu7Fz7KOpE2d3Lw)

### 工具
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)
[Lombok](https://www.projectlombok.org)
[ctotree](https://www.octotree.io/)
[Table of content sidebar](https://chrome.google.com/webstore/detail/table-of-contents-sidebar/ohohkfheangmbedkgechjkmbepeikkej)
[One Tab](https://chrome.google.com/webstore/detail/chphlpgkkbolifaimnlloiipkdnihall)
[Live Reload](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei/related)
[Postman](https://chrome.google.com/webstore/detail/coohjcphdfgbiolnekdpbcijmhambjff)


## 其它
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
