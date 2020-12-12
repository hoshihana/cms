# CMS - API接口文档

## 公共规范

### 编码

若请求消息体中的参数支持中文，则中文字符必须为UTF-8编码，响应消息体中的中文同样为UTF-8编码。



### 请求消息头

| 消息头（Header） |               说明               |
| :--------------: | :------------------------------: |
|   Content-Type   | application/json; charset=utf-8  |
|      token       | 除登录接口和注册接口外均必须携带 |



### 响应消息头

| 消息头（Header） |              说明               |
| :--------------: | :-----------------------------: |
|   Content-Type   | application/json; charset=utf-8 |



### 类型说明

|        类型         |        说明         |        示例         |
| :-----------------: | :-----------------: | :-----------------: |
|       String        |       字符串        |   "hello world!"    |
|       Integer       |        整型         |         233         |
|        Date         |     yyyy-MM-dd      |     2020-12-05      |
|      Datetime       | yyyy-MM-dd HH:mm:ss | 2020-12-05 20:07:32 |
| Enum('A', 'B', 'C') |      枚举类型       |         "A"         |
|       boolean       |      布尔类型       |     true/false      |



### 身份验证结果

|    参数名    |  类型   |     说明     |
| :----------: | :-----: | :----------: |
|   success    | boolean | 验证是否成功 |
|   message    | String  |   错误信息   |
| requiredRole |  Role   |   要求角色   |
| requestRole  |  Role   |   访问角色   |



## 接口说明

### 登录接口

#### 登录提交

- URI：POST api/login/submit

- Path参数：

  |  参数名  |                   类型                   |   说明   |
  | :------: | :--------------------------------------: | :------: |
  |   role   | Role('USER', 'ADMIN', 'HOTEL', 'DRIVER') | 登录角色 |
  | username |                  String                  |  用户名  |
  | password |                  String                  |   密码   |

- Result参数：

  |   参数名   |                     类型                      |     说明     |
  | :--------: | :-------------------------------------------: | :----------: |
  |  success   |                    boolean                    | 登录是否成功 |
  |  message   |                    String                     |   错误信息   |
  |   token    |                  String/null                  |  token令牌   |
  |  username  |                  String/null                  |    用户名    |
| account_id |                    Integer                    |   账号编号   |
  |    role    | Role('USER', 'ADMIN', 'HOTEL', 'DRIVER')/null |   登录角色   |
  
  

### 注册接口

####  验证用户名可用

- URI: POST api/register/checkUsername

- Path参数：

  |  参数名  |  类型  |  说明  |
  | :------: | :----: | :----: |
  | username | String | 用户名 |

- Result参数：

  | 参数名 |  类型   |      说明      |
  | :----: | :-----: | :------------: |
  | result | boolean | 用户名是否可用 |



#### 注册提交

- URI: POST api/register/submit

- Path参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |     username     |          String          |  用户名  |
  |     password     |          String          |   密码   |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  |     birthday     |           Data           |   生日   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephone     |          String          |  手机号  |
  |      email       |          String          |   邮箱   |
  |    workplace     |          String          | 工作单位 |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 操作是否成功 |
  | message | String  |   错误信息   |



### 用户接口

#### 获取用户个人信息

- URI: POST api/user/profile

- Path参数：无

- Result参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |        id        |         Integer          | 用户编号 |
  |    accountId     |         Integer          | 账号编号 |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  |     birthday     |           Data           |   生日   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephone     |          String          |  手机号  |
  |      email       |          String          |   邮箱   |
  |    workplace     |          String          | 工作单位 |



#### 修改用户个人信息

- URI: POST api/user/profile/modify

- Path参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  |     birthday     |           Data           |   生日   |
  | residentIdNumber |          String          | 身份证号 |
  |      email       |          String          |   邮箱   |
  |    telephone     |          String          |  手机号  |
  |    workplace     |          String          | 工作单位 |
  
- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 操作是否成功 |
  | message | String  |   错误信息   |




#### 用户编号获取用户信息

- URI: POST api/user/profile/getById

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 用户编号 |

- Result参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |        id        |         Integer          | 用户编号 |
  |    accountId     |         Integer          | 账号编号 |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  |     birthday     |           Data           |   生日   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephone     |          String          |  手机号  |
  |      email       |          String          |   邮箱   |
  |    workplace     |          String          | 工作单位 |



#### 用户名获取用户信息

- URI: POST api/user/profile/getByUsername

- Path参数：

  |  参数名  |  类型  |  说明  |
  | :------: | :----: | :----: |
  | username | String | 用户名 |

- Result参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |        id        |         Integer          | 用户编号 |
  |    accountId     |         Integer          | 账号编号 |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  |     birthday     |           Data           |   生日   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephone     |          String          |  手机号  |
  |      email       |          String          |   邮箱   |
  |    workplace     |          String          | 工作单位 |



#### 账号编号获取用户信息

- URI: POST api/user/profile/getByAccountId

- Path参数：

  |  参数名   |  类型   |   说明   |
  | :-------: | :-----: | :------: |
  | accountId | Integer | 账号编号 |

- Result参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |        id        |         Integer          | 用户编号 |
  |    accountId     |         Integer          | 账号编号 |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  |     birthday     |           Data           |   生日   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephone     |          String          |  手机号  |
  |      email       |          String          |   邮箱   |
  |    workplace     |          String          | 工作单位 |



#### 更改用户密码

- URI: POST api/user/password/modify

- Path参数：

  |   参数名    |  类型  |  说明  |
  | :---------: | :----: | :----: |
  | oldPassword | String | 旧密码 |
  | newPassword | String | 新密码 |

- Result参数：

  |       参数名       |  类型   |      说明      |
  | :----------------: | :-----: | :------------: |
  |      success       | boolean |  更改是否成功  |
  | oldPasswordCorrect | boolean | 旧密码是否正确 |
  |      message       | String  |      信息      |



#### 获取用户发送的消息

- URI: POST api/user/message/sent

- Path参数：无

- Result参数：

  |   参数名    |   类型   |      说明      |
  | :---------: | :------: | :------------: |
  |     id      | Integer  |    消息编号    |
  |  senderId   | Integer  | 发送者用户编号 |
  | recipientId | Integer  | 接收者用户编号 |
  |   content   |  String  |      内容      |
  |  sendTime   | Datetime |    发送时间    |
  |    read     | boolean  |    是否已读    |



#### 获取用户接收的未读消息

- URI: POST api/user/message/unread

- Path参数：无

- Result参数：

  |   参数名    |   类型   |       说明       |
  | :---------: | :------: | :--------------: |
  |     id      | Integer  |     消息编号     |
  |  senderId   | Integer  |  发送者用户编号  |
  | recipientId | Integer  |  接收者用户编号  |
  |   content   |  String  |       内容       |
  |  sendTime   | Datetime |     发送时间     |
  |    read     | boolean  | 是否已读（false) |

  

#### 获取用户接收的已读消息

- URI: POST api/user/message/read

- Path参数：无

- Result参数：

  |   参数名    |   类型   |      说明       |
  | :---------: | :------: | :-------------: |
  |     id      | Integer  |    消息编号     |
  |  senderId   | Integer  | 发送者用户编号  |
  | recipientId | Integer  | 接收者用户编号  |
  |   content   |  String  |      内容       |
  |  sendTime   | Datetime |    发送时间     |
  |    read     | boolean  | 是否已读（true) |



#### 通过用户编号发送消息

- URI: POST api/user/message/sendById

- Path参数：

  | 参数名  |  类型   |      说明      |
  | :-----: | :-----: | :------------: |
  |   id    | Integer | 接收者用户编号 |
  | content | String  |      内容      |
  
- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 操作是否成功 |
  | message | String  |   错误信息   |



#### 通过账号编号发送消息

- URI: POST api/user/message/sendByAccountId

- Path参数：

  |  参数名   |  类型   |      说明      |
  | :-------: | :-----: | :------------: |
  | accountId | Integer | 接收者账号编号 |
  |  content  | String  |      内容      |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 操作是否成功 |
  | message | String  |   错误信息   |



#### 通过用户名发送消息

- URI: POST api/user/message/sendByUsername

- Path参数：

  |  参数名  |  类型  |     说明     |
  | :------: | :----: | :----------: |
  | username | String | 接收者用户名 |
  | content  | String |     内容     |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 操作是否成功 |
  | message | String  |   错误信息   |



#### 将消息置为已读

- URI: POST api/user/message/setRead

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 消息编号 |
  
- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 操作是否成功 |
  | message | String  |   错误信息   |



### 用户会议接口

#### 获取用户创建的进行中会议

- URI: POST api/user/conference/created/ongoing

- Path参数：无

- Result参数：

  |   参数名   |                             类型                             |     说明     |
  | :--------: | :----------------------------------------------------------: | :----------: |
  |     id     |                           Integer                            |   会议编号   |
  |   number   |                            String                            |    会议号    |
  |   userId   |                           Integer                            |  创建者编号  |
  | createTime |                           Datetime                           |   创建时间   |
  |    name    |                            String                            |    会议名    |
  |   detail   |                            String                            |   会议详情   |
  |  address   |                            String                            |   会议地点   |
  | startTime  |                           Datetime                           |   开始时间   |
  |  endTime   |                           Datetime                           |   结束时间   |
  | enrollTime |                           Datetime                           | 报名截止时间 |
  | inviteCode |                         String/null                          |    邀请码    |
  |  hotelId   |                         Integer/null                         | 预约酒店编号 |
  |  fleetId   |                         Integer/null                         | 预约车队编号 |
  |  progress  | Progress('ENROLLMENT', 'OWNER_CONFIRM','RESERVATION_CONFIRM', 'READY', 'ENDED'') | 会议确认进度 |
  



#### 获取用户参加的进行中会议

- URI: POST api/user/conference/participated/ongoing

- Path参数：无

- Result参数：

  |   参数名   |                             类型                             |     说明     |
  | :--------: | :----------------------------------------------------------: | :----------: |
  |     id     |                           Integer                            |   会议编号   |
  |   number   |                            String                            |    会议号    |
  |   userId   |                           Integer                            |  创建者编号  |
  | createTime |                           Integer                            |   创建时间   |
  |    name    |                            String                            |    会议名    |
  |   detail   |                            String                            |   会议详情   |
  |  address   |                            String                            |   会议地点   |
  | startTime  |                           Datetime                           |   开始时间   |
  |  endTime   |                           Datetime                           |   结束时间   |
  | enrollTime |                           Datetime                           | 报名截止时间 |
  | inviteCode |                         String/null                          |    邀请码    |
  |  hotelId   |                         Integer/null                         | 预约酒店编号 |
  |  fleetId   |                         Integer/null                         | 预约车队编号 |
  |  progress  | Progress('ENROLLMENT', 'OWNER_CONFIRM','RESERVATION_CONFIRM', 'READY', 'ENDED') | 会议确认进度 |



#### 获取用户创建的已结束会议

- URI: POST api/user/conference/created/ended

- Path参数：无

- Result参数：

  |   参数名   |                             类型                             |     说明     |
  | :--------: | :----------------------------------------------------------: | :----------: |
  |     id     |                           Integer                            |   会议编号   |
  |   number   |                            String                            |    会议号    |
  |   userId   |                           Integer                            |  创建者编号  |
  | createTime |                           Datetime                           |   创建时间   |
  |    name    |                            String                            |    会议名    |
  |   detail   |                            String                            |   会议详情   |
  |  address   |                            String                            |   会议地点   |
  | startTime  |                           Datetime                           |   开始时间   |
  |  endTime   |                           Datetime                           |   结束时间   |
  | enrollTime |                           Datetime                           | 报名截止时间 |
  | inviteCode |                         String/null                          |    邀请码    |
  |  hotelId   |                         Integer/null                         | 预约酒店编号 |
  |  fleetId   |                         Integer/null                         | 预约车队编号 |
  |  progress  | Progress('ENROLLMENT', 'OWNER_CONFIRM','RESERVATION_CONFIRM', 'READY', 'ENDED') | 会议确认进度 |



#### 获取用户参加的已结束会议

- URI: POST api/user/conference/participated/ended

- Path参数：无

- Result参数：

  |   参数名   |                             类型                             |     说明     |
  | :--------: | :----------------------------------------------------------: | :----------: |
  |     id     |                           Integer                            |   会议编号   |
  |   number   |                            String                            |    会议号    |
  |   userId   |                           Integer                            |  创建者编号  |
  | createTime |                           Datetime                           |   创建时间   |
  |    name    |                            String                            |    会议名    |
  |   detail   |                            String                            |   会议详情   |
  |  address   |                            String                            |   会议地点   |
  | startTime  |                           Datetime                           |   开始时间   |
  |  endTime   |                           Datetime                           |   结束时间   |
  | enrollTime |                           Datetime                           | 报名截止时间 |
  | inviteCode |                         String/null                          |    邀请码    |
  |  hotelId   |                         Integer/null                         | 预约酒店编号 |
  |  fleetId   |                         Integer/null                         | 预约车队编号 |
  |  progress  | Progress('ENROLLMENT', 'OWNER_CONFIRM','RESERVATION_CONFIRM', 'READY', 'ENDED') | 会议确认进度 |



#### 会议编号检查用户是否为会议创建者

- URI: POST api/user/conference/created/checkById

- Path参数：
  |   参数名   |                             类型                             |     说明     |
  | :--------: | :----------------------------------------------------------: | :----------: |
  |     id     |                           Integer                            |   会议编号   |
  
- Result结果：

  | 参数名 |  类型   |         说明         |
  | :----: | :-----: | :------------------: |
  | result | boolean | 用户是否为会议创建者 |



#### 会议号检查用户是否为会议创建者

- URI: POST api/user/conference/created/checkByNumber

- Path参数：

  | 参数名 |  类型  |  说明  |
  | :----: | :----: | :----: |
  | number | String | 会议号 |

- Result结果：

  | 参数名 |  类型   |         说明         |
  | :----: | :-----: | :------------------: |
  | result | boolean | 用户是否为会议创建者 |



#### 会议编号检查用户是否为会议参加者

- URI: POST api/user/conference/participated/checkById

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |

- Result结果：

  | 参数名 |  类型   |         说明         |
  | :----: | :-----: | :------------------: |
  | result | boolean | 用户是否为会议参加者 |





#### 会议号检查用户是否为会议参加者

- URI: POST api/user/conference/participated/checkByNumber

- Path参数：

  | 参数名 |  类型  |  说明  |
  | :----: | :----: | :----: |
  | number | String | 会议号 |

- Result结果：

  | 参数名 |  类型   |         说明         |
  | :----: | :-----: | :------------------: |
  | result | boolean | 用户是否为会议参加者 |



#### 创建会议

- URI: POST api/user/conference/create

- Path参数：

  |   参数名   |    类型     |     说明     |
  | :--------: | :---------: | :----------: |
  |    name    |   String    |    会议名    |
  |   detail   |   String    |   会议详情   |
  |  address   |   String    |   会议地点   |
  | startTime  |  Datetime   |   开始时间   |
  |  endTime   |  Datetime   |   结束时间   |
  | enrollTime |  Datetime   | 报名截止时间 |
  | inviteCode | String/null |    邀请码    |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 创建是否成功 |
  | message | String  |   错误信息   |



#### 参加会议

- URI: POST api/user/conference/participate

- Path参数：

  |   参数名   |    类型     |     说明     |
  | :--------: | :---------: | :----------: |
  |     id     |   Integer   |   会议编号   |
  | tripNumber |   String    | 航班号/车次  |
  | arriveTime |  Datetime   |   到达时间   |
  | stayStart  |    Date     | 住宿开始日期 |
  |  stayEnd   |    Date     | 住宿结束日期 |
  | stayNeeds  | String/null |   住宿需求   |
  |   remark   | String/null |     备注     |
  | inviteCode | String/null |    邀请码    |

- Result参数：

  |      参数名       |  类型   |      说明      |
  | :---------------: | :-----: | :------------: |
  |      success      | boolean |  参加是否成功  |
  | inviteCodeCorrect | boolean | 邀请码是否正确 |
  |      message      | String  |    错误信息    |



### 公共会议接口

#### 会议编号获取会议信息

- URI: POST api/conference/getById

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |

- Result参数：

  |   参数名   |                             类型                             |     说明     |
  | :--------: | :----------------------------------------------------------: | :----------: |
  |     id     |                           Integer                            |   会议编号   |
  |   number   |                            String                            |    会议号    |
  |   userId   |                           Integer                            |  创建者编号  |
  | createTime |                           Datetime                           |   创建时间   |
  |    name    |                            String                            |    会议名    |
  |   detail   |                            String                            |   会议详情   |
  |  address   |                            String                            |   会议地点   |
  | startTime  |                           Datetime                           |   开始时间   |
  |  endTime   |                           Datetime                           |   结束时间   |
  | enrollTime |                           Datetime                           | 报名截止时间 |
  | inviteCode |                         String/null                          |    邀请码    |
  |  hotelId   |                         Integer/null                         | 预约酒店编号 |
  |  fleetId   |                         Integer/null                         | 预约车队编号 |
  |  progress  | Progress('ENROLLMENT', 'OWNER_CONFIRM','RESERVATION_CONFIRM', 'READY', 'ENDED') | 会议确认进度 |



#### 会议号获取会议信息

- URI: POST api/conference/getByNumber

- Path参数：

  | 参数名 |  类型  |  说明  |
  | :----: | :----: | :----: |
  | number | String | 会议号 |

- Result参数：

  |   参数名   |                             类型                             |     说明     |
  | :--------: | :----------------------------------------------------------: | :----------: |
  |     id     |                           Integer                            |   会议编号   |
  |   number   |                            String                            |    会议号    |
  |   userId   |                           Integer                            |  创建者编号  |
  | createTime |                           Datetime                           |   创建时间   |
  |    name    |                            String                            |    会议名    |
  |   detail   |                            String                            |   会议详情   |
  |  address   |                            String                            |   会议地点   |
  | startTime  |                           Datetime                           |   开始时间   |
  |  endTime   |                           Datetime                           |   结束时间   |
  | enrollTime |                           Datetime                           | 报名截止时间 |
  | inviteCode |                         String/null                          |    邀请码    |
  |  hotelId   |                         Integer/null                         | 预约酒店编号 |
  |  fleetId   |                         Integer/null                         | 预约车队编号 |
  |  progress  | Progress('ENROLLMENT', 'OWNER_CONFIRM','RESERVATION_CONFIRM', 'READY', 'ENDED') | 会议确认进度 |



### 创建者会议接口

#### 获取参会人数

- URI: POST api/conference/participant/count

- Path参数：

  | 参数名 |  类型  |   说明   |
  | :----: | :----: | :------: |
  |   id   | String | 会议编号 |

- Result参数：

  | 参数名 |  类型   |     说明     |
  | :----: | :-----: | :----------: |
  | amount | Integer | 参会人员数量 |



#### 获取参会人员信息

- URI: POST api/conference/participant/get

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |

- Result参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |        id        |         Integer          | 用户编号 |
  |    accountId     |         Integer          | 账号编号 |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  |     birthday     |           Data           |   生日   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephone     |          String          |  手机号  |
  |      email       |          String          |   邮箱   |
  |    workplace     |          String          | 工作单位 |



#### 获取参会人员报名信息

- URI: POST api/conference/enrollment/get

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |
  | userId | Integer | 用户编号 |

- Result参数：

  |    参数名    |   类型   |     说明     |
  | :----------: | :------: | :----------: |
  |    userId    | Integer  |   用户编号   |
  | conferenceId | Integer  |   会议编号   |
  |  tripNumber  |  String  | 车次/航班号  |
  |  arriveTime  | Datetime |   到达时间   |
  |  enrollTime  | Datetime |   报名时间   |
  |  stayStart   |   Date   | 住宿开始日期 |
  |   stayEnd    |   Date   | 住宿结束日期 |
  |  stayNeeds   |  String  |   住宿需求   |
  |    remark    |  String  |     备注     |



#### 删除参会人员报名信息

- URI: POST api/conference/enrollment/remove

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |
  | userId | Integer | 用户编号 |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 删除是否成功 |
  | message | String  |   错误信息   |




#### 选择预约酒店

- URI: POST api/conference/chooseHotel

- Path参数：

  | 参数名  |  类型   |   说明   |
  | :-----: | :-----: | :------: |
  |   id    | Integer | 会议编号 |
  | hotelId | Integer | 酒店编号 |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 选择是否成功 |
  | message | String  |   错误信息   |



#### 选择预约车队

- URI: POST api/conference/chooseFleet

- Path参数：

  | 参数名  |  类型   |   说明   |
  | :-----: | :-----: | :------: |
  |   id    | Integer | 会议编号 |
  | fleetId | Integer | 车队编号 |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 选择是否成功 |
  | message | String  |   错误信息   |



#### 确认会议并发送所有用户预约

- URI: POST api/conference/confirm

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 发送是否成功 |
  | message | String  |   错误信息   |



#### 检查酒店预约是否均确认

- URI: POST api/conferfence/hotelReservation/checkAll

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |

- Result参数：

  | 参数名 |  类型   |        说明        |
  | :----: | :-----: | :----------------: |
  | result | boolean | 酒店预约是否均确认 |

  

#### 检查司机预约是否均确认

- URI: POST api/conference/driverReservation/checkAll

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |

- Result参数：

  | 参数名 |  类型   |        说明        |
  | :----: | :-----: | :----------------: |
  | result | boolean | 司机预约是否均确认 |



#### 获取参加者酒店预约信息

- URI: POST api/conference/hotelReservation/get

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |
  | userId | Integer | 用户编号 |

- Result参数：

  |    参数名    |   类型   |      说明      |
  | :----------: | :------: | :------------: |
  |   hotelId    | Integer  |    酒店编号    |
  | conferenceId | Integer  |    会议编号    |
  |    userId    | Integer  |    用户编号    |
  |  startStart  |   Date   |  住宿开始时间  |
  |   startEnd   |   Date   |  住宿结束时间  |
  |  stayNeeds   |  String  |    住宿需求    |
  | reserveTime  | Integer  |  发送预约时间  |
  |  hotelCheck  | boolean  | 酒店是否已确认 |
  | checkinTime  | Datetime |    入住时间    |
  |  roomNumber  |  String  |     房间号     |
  |  userCheck   | Integer  | 用户是否已确认 |



#### 获取参加者车队预约信息

- URI: POST api/conference/driverReservation/get

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |
  | userId | Integer | 用户编号 |

- Result参数：

  |    参数名    |   类型   |      说明      |
  | :----------: | :------: | :------------: |
  |   fleetId    | Integer  |    车队编号    |
  | conferenceId | Integer  |    会议编号    |
  |    userId    | Integer  |    用户编号    |
  |  arriveTime  | Integer  |    到站时间    |
  | reserveTime  | Datetime |  发送预约时间  |
  | driverCheck  | boolean  | 司机是否已确认 |
  |   driverId   | Integer  |    司机编号    |
  |  pickupTime  | Datetime |    接车时间    |
  |  pickupSite  |  String  |    接车地点    |
  |  carNumber   |  String  |     车牌号     |
  |  userCheck   | boolean  | 用户是否已确认 |



### 参加者会议接口

#### 获取个人酒店预约信息

- URI: POST api/conference/hotelReservation

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |

- Result参数：

  |    参数名    |   类型   |      说明      |
  | :----------: | :------: | :------------: |
  |   hotelId    | Integer  |    酒店编号    |
  | conferenceId | Integer  |    会议编号    |
  |    userId    | Integer  |    用户编号    |
  |  startStart  |   Date   |  住宿开始时间  |
  |   startEnd   |   Date   |  住宿结束时间  |
  |  stayNeeds   |  String  |    住宿需求    |
  | reserveTime  | Integer  |  发送预约时间  |
  |  hotelCheck  | boolean  | 酒店是否已确认 |
  | checkinTime  | Datetime |    入住时间    |
  |  roomNumber  |  String  |     房间号     |
  |  userCheck   | Integer  | 用户是否已确认 |



#### 获取个人司机预约信息

- URI: POST api/conference/driverReservation

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 会议编号 |
  
- Result参数：

  |    参数名    |   类型   |      说明      |
  | :----------: | :------: | :------------: |
  |   fleetId    | Integer  |    车队编号    |
  | conferenceId | Integer  |    会议编号    |
  |    userId    | Integer  |    用户编号    |
  |  arriveTime  | Integer  |    到站时间    |
  | reserveTime  | Datetime |  发送预约时间  |
  | driverCheck  | boolean  | 司机是否已确认 |
  |   driverId   | Integer  |    司机编号    |
  |  pickupTime  | Datetime |    接车时间    |
  |  pickupSite  |  String  |    接车地点    |
  |  carNumber   |  String  |     车牌号     |
  |  userCheck   | boolean  | 用户是否已确认 |




### 酒店接口

#### 获取所有酒店信息

- URI: POST api/hotel/profile/getAll

- Path参数：无

- Result参数：

  |  参数名   |  类型   |     说明     |
  | :-------: | :-----: | :----------: |
  |    id     | Integer |   酒店编号   |
  | accountId | Integer | 酒店账号编号 |
  |   name    | String  |    酒店名    |
  |  address  | String  |   酒店地址   |
  |  detail   | String  |     详情     |
  | telephone | String  |   联系电话   |



#### 酒店编号获取酒店信息

- URI: POST api/hotel/profile/get

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 酒店编号 |

- Result参数：

  |  参数名   |  类型   |     说明     |
  | :-------: | :-----: | :----------: |
  |    id     | Integer |   酒店编号   |
  | accountId | Integer | 酒店账号编号 |
  |   name    | String  |    酒店名    |
  |  address  | String  |   酒店地址   |
  |  detail   | String  |     详情     |
  | telephone | String  |   联系电话   |



#### 更改酒店密码

- URI: POST api/hotel/password/modify

- Path参数：

  |   参数名    |  类型  |  说明  |
  | :---------: | :----: | :----: |
  | oldPassword | String | 旧密码 |
  | newPassword | String | 新密码 |

- Result参数：

  |       参数名       |  类型   |      说明      |
  | :----------------: | :-----: | :------------: |
  |      success       | boolean |  更改是否成功  |
  | oldPasswordCorrect | boolean | 旧密码是否正确 |



#### 获取酒店信息

- URI: POST api/hotel/profile
- Path参数：无
- Result参数：
  
  |  参数名   |  类型   |     说明     |
  | :-------: | :-----: | :----------: |
  |    id     | Integer |   酒店编号   |
  | accountId | Integer | 酒店账号编号 |
  |   name    | String  |    酒店名    |
  |  address  | String  |   酒店地址   |
  |  detail   | String  |     详情     |
  | telephone | String  |   联系电话   |



#### 修改酒店信息

- URI: POST api/hotel/profile/modify

- Path参数：

  |  参数名   |  类型  |   说明   |
  | :-------: | :----: | :------: |
  |   name    | String |  酒店名  |
  |  address  | String | 酒店地址 |
  |  detail   | String |   详情   |
  | telephone | String | 联系电话 |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 修改是否成功 |
  | message | String  |   错误信息   |



#### 获取待确认预约

- URI: POST api/hotel/reservation/unchecked

- Path：无

- Result参数：

  |      参数名      |           类型           |      说明      |
  | :--------------: | :----------------------: | :------------: |
  |   conferenceId   |         Integer          |    会议编号    |
  |      userId      |         Integer          |    用户编号    |
  |       name       |          String          |      姓名      |
  |      gender      | Gender('MALE', 'FEMALE') |      性别      |
  | residentIdNumber |          String          |    身份证号    |
  |    telephone     |          String          |    联系电话    |
  |    startStart    |           Date           |  住宿开始时间  |
  |     startEnd     |           Date           |  住宿结束时间  |
  |    stayNeeds     |          String          |    住宿需求    |
  |   reserveTime    |         Integer          |  发送预约时间  |
  |    hotelCheck    |         boolean          | 酒店是否已确认 |
  |   checkinTime    |         Datetime         |    入住时间    |
  |    roomNumber    |          String          |     房间号     |
  |    userCheck     |         Integer          | 用户是否已确认 |



#### 获取已确认预约

- URI: POST api/hotel/reservation/checked

- Path参数：无

- Result参数：

  |      参数名      |           类型           |      说明      |
  | :--------------: | :----------------------: | :------------: |
  |   conferenceId   |         Integer          |    会议编号    |
  |      userId      |         Integer          |    用户编号    |
  |       name       |          String          |      姓名      |
  |      gender      | Gender('MALE', 'FEMALE') |      性别      |
  | residentIdNumber |          String          |    身份证号    |
  |    telephone     |          String          |    联系电话    |
  |    startStart    |           Date           |  住宿开始时间  |
  |     startEnd     |           Date           |  住宿结束时间  |
  |    stayNeeds     |          String          |    住宿需求    |
  |   reserveTime    |         Integer          |  发送预约时间  |
  |    hotelCheck    |         boolean          | 酒店是否已确认 |
  |   checkinTime    |         Datetime         |    入住时间    |
  |    roomNumber    |          String          |     房间号     |
  |    userCheck     |         Integer          | 用户是否已确认 |



#### 获取已结束预约

- URI: POST api/hotel/reservation/ended

- Path参数：无

- Result参数：

  |      参数名      |           类型           |      说明      |
  | :--------------: | :----------------------: | :------------: |
  |     hotelId      |         Integer          |    酒店编号    |
  |   conferenceId   |         Integer          |    会议编号    |
  |      userId      |         Integer          |    用户编号    |
  |       name       |          String          |      姓名      |
  |      gender      | Gender('MALE', 'FEMALE') |      性别      |
  | residentIdNumber |          String          |    身份证号    |
  |    telephone     |          String          |    联系电话    |
  |    startStart    |           Date           |  住宿开始时间  |
  |     startEnd     |           Date           |  住宿结束时间  |
  |    stayNeeds     |          String          |    住宿需求    |
  |   reserveTime    |         Integer          |  发送预约时间  |
  |    hotelCheck    |         boolean          | 酒店是否已确认 |
  |   checkinTime    |         Datetime         |    入住时间    |
  |    roomNumber    |          String          |     房间号     |
  |    userCheck     |         Integer          | 用户是否已确认 |



#### 确认预约

- URI: POST api/hotel/reservation/check

- Path参数：

  |    参数名    |   类型   |   说明   |
  | :----------: | :------: | :------: |
  | conferenceId | Integer  | 会议编号 |
  |    userId    | Integer  | 用户编号 |
  | checkinTime  | Datetime | 入住时间 |
  |  roomNumber  |  String  |  房间号  |
  
- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | result  | boolean | 确认是否成功 |
  | message | String  |   错误信息   |

  



### 车队接口

#### 获取所有车队信息

- URI：POST api/fleet/getAll

- Path参数：无

- Result参数：

  |    参数名    |  类型   |   说明   |
  | :----------: | :-----: | :------: |
  |      id      | Integer | 车队编号 |
  |     name     | String  |  车队名  |
  |    detail    | String  |   详情   |
  |  telephone   | String  | 联系电话 |
  | driverAmount | Integer |  司机数  |



#### 车队编号获取车队信息

- URI：POST api/fleet/get

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 车队编号 |

- Result参数：

  |    参数名    |  类型   |   说明   |
  | :----------: | :-----: | :------: |
  |      id      | Integer | 车队编号 |
  |     name     | String  |  车队名  |
  |    detail    | String  |   详情   |
  |  telephone   | String  | 联系电话 |
  | driverAmount | Integer |  司机数  |



### 司机接口

#### 车队编号获取所有司机信息

- URI：POST api/driver/getByFleetId

- Path参数：

  | 参数名  |  类型   |   说明   |
  | :-----: | :-----: | :------: |
  | fleetId | Integer | 车队编号 |

- Result参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |        id        |         Integer          | 司机编号 |
  |    accountId     |         Integer          | 账户编号 |
  |     fleetId      |         Integer          | 车队编号 |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephonne    |          String          |  手机号  |



#### 司机编号获取司机信息

- URI：POST api/driver/getById

- Path参数：

  | 参数名 |  类型   |   说明   |
  | :----: | :-----: | :------: |
  |   id   | Integer | 司机编号 |

- Result参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |        id        |         Integer          | 司机编号 |
  |    accountId     |         Integer          | 账户编号 |
  |     fleetId      |         Integer          | 车队编号 |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephonne    |          String          |  手机号  |



#### 更改司机密码

- URI：POST api/driver/password/modify

- Path参数：

  |   参数名    |  类型  |  说明  |
  | :---------: | :----: | :----: |
  | oldPassword | String | 旧密码 |
  | newPassword | String | 新密码 |

- Result参数：

  |       参数名       |  类型   |      说明      |
  | :----------------: | :-----: | :------------: |
  |      success       | boolean |  更改是否成功  |
  | oldPasswordCorrect | boolean | 旧密码是否正确 |



#### 获取司机信息

- URI：POST api/driver/profile

- Path参数：无

- Result参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |        id        |         Integer          | 司机编号 |
  |    accountId     |         Integer          | 账户编号 |
  |     fleetId      |         Integer          | 车队编号 |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephonne    |          String          |  手机号  |



#### 修改司机信息

- URI: POST api/driver/profile/modify

- Path参数：

  |      参数名      |           类型           |   说明   |
  | :--------------: | :----------------------: | :------: |
  |       name       |          String          |   姓名   |
  |      gender      | Gender('MALE', 'FEMALE') |   性别   |
  | residentIdNumber |          String          | 身份证号 |
  |    telephone     |          String          |  手机号  |

- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | success | boolean | 修改是否成功 |
  | message | String  |   错误信息   |



#### 获取待确认预约

- URI: POST api/driver/reservation/unchecked

- Path：无

- Result参数：

  |    参数名    |           类型           |      说明      |
  | :----------: | :----------------------: | :------------: |
  | conferenceId |         Integer          |    会议编号    |
  |    userId    |         Integer          |    用户编号    |
  |     name     |          String          |      姓名      |
  |    gender    | Gender('MALE', 'FEMALE') |      性别      |
  |  telephone   |          String          |    联系电话    |
  |  arriveTime  |         Integer          |    到站时间    |
  | reserveTime  |         Datetime         |  发送预约时间  |
  | driverCheck  |         boolean          | 司机是否已确认 |
  |   driverId   |         Integer          |    司机编号    |
  |  pickupTime  |         Datetime         |    接车时间    |
  |  pickupSite  |          String          |    接车地点    |
  |  carNumber   |          String          |     车牌号     |
  |  userCheck   |         boolean          | 用户是否已确认 |



#### 获取已确认预约

- URI: POST api/driver/reservation/checked

- Path参数：无

- Result参数：

  |    参数名    |           类型           |      说明      |
  | :----------: | :----------------------: | :------------: |
  | conferenceId |         Integer          |    会议编号    |
  |    userId    |         Integer          |    用户编号    |
  |     name     |          String          |      姓名      |
  |    gender    | Gender('MALE', 'FEMALE') |      性别      |
  |  telephone   |          String          |    联系电话    |
  |  arriveTime  |         Integer          |    到站时间    |
  | reserveTime  |         Datetime         |  发送预约时间  |
  | driverCheck  |         boolean          | 司机是否已确认 |
  |   driverId   |         Integer          |    司机编号    |
  |  pickupTime  |         Datetime         |    接车时间    |
  |  pickupSite  |          String          |    接车地点    |
  |  carNumber   |          String          |     车牌号     |
  |  userCheck   |         boolean          | 用户是否已确认 |



#### 获取已结束预约

- URI: POST api/driverl/reservation/ended

- Path参数：无

- Result参数：

  |    参数名    |           类型           |      说明      |
  | :----------: | :----------------------: | :------------: |
  | conferenceId |         Integer          |    会议编号    |
  |    userId    |         Integer          |    用户编号    |
  |     name     |          String          |      姓名      |
  |    gender    | Gender('MALE', 'FEMALE') |      性别      |
  |  telephone   |          String          |    联系电话    |
  |  arriveTime  |         Integer          |    到站时间    |
  | reserveTime  |         Datetime         |  发送预约时间  |
  | driverCheck  |         boolean          | 司机是否已确认 |
  |   driverId   |         Integer          |    司机编号    |
  |  pickupTime  |         Datetime         |    接车时间    |
  |  pickupSite  |          String          |    接车地点    |
  |  carNumber   |          String          |     车牌号     |
  |  userCheck   |         boolean          | 用户是否已确认 |



#### 确认预约

- URI: POST api/driver/reservation/check

- Path参数：

  |    参数名    |   类型   |   说明   |
  | :----------: | :------: | :------: |
  | conferenceId | Integer  | 会议编号 |
  |    userId    | Integer  | 用户编号 |
  |  pickupTime  | Datetime | 接车时间 |
  |  pickupSite  |  String  | 接车地点 |
  |  carNumber   |  String  |  车牌号  |
  
- Result参数：

  | 参数名  |  类型   |     说明     |
  | :-----: | :-----: | :----------: |
  | result  | boolean | 确认是否成功 |
  | message | String  |   错误信息   |

  



### 管理员接口



