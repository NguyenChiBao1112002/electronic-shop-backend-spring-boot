package ct250.backend.conversation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConversationService {
    
    @Autowired
    private ConversationRepository conversationRepository;
    
    void addConversation(Conversation conversation) {
        this.conversationRepository.save(conversation);
    }

    ArrayList<Conversation> getAllConversations() {
        return (ArrayList<Conversation>) this.conversationRepository.findAll();
    }

    public Conversation findConversationById(Long id) {
        return  this.conversationRepository.findById(id).isPresent() ? 
                this.conversationRepository.findById(id).get() : null;
    }

    void deleteConversationById(Long id) {
        this.conversationRepository.deleteById(id);
    }

}
