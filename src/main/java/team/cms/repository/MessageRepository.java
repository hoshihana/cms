package team.cms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team.cms.entity.Message;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface MessageRepository {

    List<Message> getSentMessageBySenderId(int senderId);

    List<Message> getReadMessageByRecipientId(int recipientId);

    List<Message> getUnreadMessageByRecipientId(int recipientId);

    void addMessage(Message message);

    void updateMessageReadStatus(Integer messageId);
}
