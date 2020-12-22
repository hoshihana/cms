package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.entity.Message;
import team.cms.result.Result;
import team.cms.service.AccountService;
import team.cms.service.MessageService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Resource
    private MessageService messageService;
    @Resource
    private AccountService accountService;

    @PostMapping("/sent")
    public List<Message> getSentMessage(HttpServletRequest request)
    {
        Integer accountId=(Integer)request.getAttribute("accountId");
        List<Message> messages=messageService.getSentMessageByAccountId(accountId);
        return messages;
    }

    @PostMapping("/read")
    public List<Message> getReadMessage(HttpServletRequest request)
    {
        Integer accountId=(Integer)request.getAttribute("accountId");
        List<Message> messages=messageService.getReadMessageByAccountId(accountId);
        return messages;
    }

    @PostMapping("/unread")
    public List<Message> getUnreadMessage(HttpServletRequest request)
    {
        Integer accountId=(Integer)request.getAttribute("accountId");
        List<Message> messages=messageService.getUnreadMessageByAccountId(accountId);
        return messages;
    }

    @PostMapping("/sendByAccountId")
    public Result sendMessageByAccountId(HttpServletRequest request, Integer accountId, String content)
    {
        Account recipientAccount = accountService.getAccountById(accountId);
        if(recipientAccount == null) {
            return new Result(false, "收信人不存在！");
        }
        Date sendTime=new Date();
        Integer senderId = (Integer) request.getAttribute("accountId");
        Message message = new Message();
        message.setContent(content);
        message.setSendTime(sendTime);
        message.setRecipientId(accountId);
        message.setSenderId(senderId);
        messageService.sendMessage(message);
        return new Result(true, null);
    }

    @PostMapping("/sendByUsername")
    public Result sendMessageByUsername(HttpServletRequest request, String username, String content)
    {
        Account recipientAccount = accountService.getAccountByUsername(username);
        if(recipientAccount == null) {
            return new Result(false, "收信人不存在！");
        }
        Date sendTime=new Date();
        Integer senderId = (Integer) request.getAttribute("accountId");
        Message message = new Message();
        message.setContent(content);
        message.setSendTime(sendTime);
        Account account=new Account();
        account=accountService.getAccountByUsername(username);
        System.out.println(account.getId());
        message.setRecipientId(account.getId());
        message.setSenderId(senderId);
        messageService.sendMessage(message);
        return new Result(true, null);
    }

    @PostMapping("/setRead")
    public Result setRead(Integer id)
    {
        messageService.setMessageRead(id);
        return new Result(true, null);
    }
}
