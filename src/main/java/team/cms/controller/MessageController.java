package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Message;
import team.cms.result.Result;
import team.cms.service.MessageService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user/message")
public class MessageController {

    @Resource
    MessageService messageService;

    @PostMapping("/sent")
    List<Message> getSentMessage(HttpServletRequest request)
    {
        Integer accountId=(Integer)request.getAttribute("accountId");
        List<Message> messages=messageService.getSentMessageByAccountId(accountId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Message message: messages) {
            System.out.println(df.format(message.getSendTime()));
        }
        return messages;
    }

    @PostMapping("/read")
    List<Message> getReadMessage(HttpServletRequest request)
    {
        Integer accountId=(Integer)request.getAttribute("accountId");
        List<Message> messages=messageService.getReadMessageByAccountId(accountId);
        return messages;
    }

    @PostMapping("/unread")
    List<Message> getUnreadMessage(HttpServletRequest request)
    {
        Integer accountId=(Integer)request.getAttribute("accountId");
        List<Message> messages=messageService.getUnreadMessageByAccountId(accountId);
        return messages;
    }

    @PostMapping("/sendByAccountId")
    Result sendMessage(HttpServletRequest request, Integer recipientId, String content)
    {
        Date sendTime=new Date();
        Integer senderId = (Integer) request.getAttribute("accountId");
        Message message = new Message();
        message.setContent(content);
        message.setSendTime(sendTime);
        message.setRecipientId(recipientId);
        message.setSenderId(senderId);
        messageService.sendMessage(message);
        return new Result(true, null);
    }
}
