package team.cms.service;

import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import team.cms.entity.Message;

import java.util.Date;
import java.util.List;

public interface MessageService {

    List<Message> getSentMessageByAccountId(int senderId);

    List<Message> getUnreadMessageByAccountId(int recipientId);

    List<Message> getReadMessageByAccountId(int recipientId);

    void sendMessage(Message message);

    void setMessageRead(Integer messageId);
}
