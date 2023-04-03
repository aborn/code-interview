# TcpServer

## 题目
用Java语言实现一个TcpServer和TcpClient程序，要求实现以下功能：  
1. client端能通过ip:端口号进行连接；  
2. 支持多Client的连接能力；  
3. Client端连接到TcpServer端后可发起字符串命令，命令以\n为结尾符号，TcpServer返回字符串的逆序；  
   举例： client发送： abcd\n  ，Server端返回dcba\n  
  

## 要求
1. 不能依赖于netty框架；  
2. 可以使用jdk自带的库；


## 时间要求
在 2023.04.04 20点前向本仓库提交pr （先fork本仓库，实现功能，再提交pr）