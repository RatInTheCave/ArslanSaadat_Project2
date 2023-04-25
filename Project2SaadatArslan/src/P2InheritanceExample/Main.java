package P2InheritanceExample;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TextMessage a = new TextMessage("Jack is here","Name_2");
        a.output();
        a.setText(1);
        a.output();
        a.setText(3.14);
        a.output();
        ImageMessage imgMesObj = new ImageMessage();
        imgMesObj.output();
        FileMessage FlMsgObj = new FileMessage("This is my file","Jack");
        FlMsgObj.output();
        VoiceMessage VoMsgObj = new VoiceMessage("IAmAuthor");
        VoMsgObj.output();
        Chat FirstOneChat = new Chat("First");
        FirstOneChat.addMessage(new TextMessage("First message in this chat","Name1"));
        FirstOneChat.addMessage(a);
        FirstOneChat.addImageMessage(new ImageMessage("First image in this chat","Name1"));
        FirstOneChat.addMessage(new TextMessage("Great","Name2"));
        FirstOneChat.addFileMessage(new FileMessage("First file in this chat","Name1"));
        FirstOneChat.addMessage(new TextMessage("It just works","Name2"));
        FirstOneChat.addImageMessage(imgMesObj);
        FirstOneChat.addFileMessage(FlMsgObj);
        FirstOneChat.output();
        System.out.println(FirstOneChat.getAllFileMessages().toString());
        System.out.printf("Total image messages count is %d",FirstOneChat.getAllImageMessages().size());
        FirstOneChat.saveAllUsersToFile("users");
        Chat copyOfFirst = new Chat("Second");
        copyOfFirst.loadAllUsersFromFile("users");
        copyOfFirst.output();
    }
}
