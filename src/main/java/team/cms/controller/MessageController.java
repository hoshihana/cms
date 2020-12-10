package team.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Message;
import team.cms.service.MessageService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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

    @PostMapping("/send")
    void sendMessage(HttpServletRequest request,Integer recipientId,String content)
    {

    }
}
