package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Message;
import team.cms.repository.MessageRepository;
import team.cms.service.MessageService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageRepository messageRepository;

    @Override
    public List<Message> getSentMessageByAccountId(int senderId) {
        return messageRepository.getSentMessageBySenderId(senderId);
    }

    @Override
    public List<Message> getUnreadMessageByAccountId(int recipientId) {
        return messageRepository.getUnreadMessageByRecipientId(recipientId);
    }

    @Override
    public List<Message> getReadMessageByAccountId(int recipientId) {
        return messageRepository.getReadMessageByRecipientId(recipientId);
    }

    @Override
    public void sendMessage(Message message) {
        messageRepository.addMessage(message);
    }

    @Override
    public void setMessageRead(Integer messageId) {
        messageRepository.updateMessageReadStatus(messageId);
    }
}
