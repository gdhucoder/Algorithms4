
# 鉴权功能

## 细化需求
- 把 URL、AppID、密码、时间戳拼接为一个字符串；
- 对字符串通过加密算法加密生成 token；
- 将 token、AppID、时间戳拼接到 URL 中，形成新的 URL；
- 解析 URL，得到 token、AppID、时间戳等信息；
- 从存储中取出 AppID 和对应的密码；
- 根据时间戳判断 token 是否过期失效；
- 验证两个 token 是否匹配；

## 实现过程

拆分需求、组织类和方法的思考过程值得我们学习。

我想到的实现过程是按照用户发送请求通过鉴权和未通过鉴权的流程写：

- 先写接口auth(String url) ，这里先定义好请求的格式，例如“xxx?AppID=123&Token=aaa&TimeStamp=123123”
- ApiRequest类，解析请求
- AuthToken类，判断是否过期、token匹配、校验token
- CredentialStorate类，获取AppID对应的password

具体实现见：https://github.com/gdhucoder/Algorithms4/tree/master/geekbang/designpattern/u014