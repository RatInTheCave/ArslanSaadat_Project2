package P2InheritanceExample;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// 2.2.8. Creating Multiple Classes
abstract class BaseMessage { // 2.2.2. Abstract Class Demonstration
    protected LocalDateTime date;
    protected String author;

    public abstract void output();
}

class TextMessage extends BaseMessage { // 2.2.1. Inheritance Demonstration
    private String Text;

    public TextMessage() {
        setText("no text");
        author = "not set";
        date = LocalDateTime.now();
    } // 2.2.3. Method Overloading Demonstration

    public TextMessage(String newText, String newAuthor) {
        setText(newText);
        setAuthor(newAuthor);
        date = LocalDateTime.now();
    }

    @Override   // 2.2.4. Method Overriding Demonstration
    public void output() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        System.out.printf("At: %s, %s said: %s.\n", dtf.format(date), getAuthor(), getText());
    }

    public void setText(String newText) {
        Text = newText;
        date = LocalDateTime.now(); // always current
    }

    // 2.2.3. Method Overloading Demonstration
    public void setText(int intText) {
        setText(Integer.toString(intText));
    }

    public void setText(double dText) {
        setText(Double.toString(dText));
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public String getText() {
        return Text;
    }

    public String getAuthor() {
        return author;
    }
}

class VoiceMessage extends BaseMessage {
    public VoiceMessage() {
        author = "not set";
        date = LocalDateTime.now();
    }

    public VoiceMessage(String newAuthor) {
        author = newAuthor;
        date = LocalDateTime.now();
    }

    @Override   // 2.2.4. Method Overriding Demonstration
    public void output() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        System.out.printf("At: %s, %s sent a voice message.\n", dtf.format(date), author);
    }
}

class FileMessage extends TextMessage {
    public FileMessage() {
        super();
    }

    // 2.2.6. Use of super
    public FileMessage(String newText, String newAuthor) {
        super(newText, newAuthor);
    }
}

class ImageMessage extends TextMessage {
    public ImageMessage() {
        super();
    }

    public ImageMessage(String newText, String newAuthor) {
        super(newText, newAuthor);
    }
}

class LocationMessage extends TextMessage {
    public LocationMessage(String newAuthor) {
        super();
    }

    @Override   // 2.2.4. Method Overriding Demonstration
    public void output() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        System.out.printf("At: %s, %s sent a location message.\n", dtf.format(date), author);
    }
}

class ContactMessage extends TextMessage {
    public ContactMessage(String newAuthor) {
        super();
    }

    @Override   // 2.2.4. Method Overriding Demonstration
    public void output() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        System.out.printf("At: %s, %s sent a contact message.\n", dtf.format(date), author);
    }
}

class Chat  {
    private String ChatName;
    private ArrayList<User> Users = new ArrayList<>();
    private ArrayList<FileMessage> FileMessages = new ArrayList<>();
    private ArrayList<ImageMessage> ImageMessages = new ArrayList<>();
    private ArrayList<BaseMessage> Messages = new ArrayList<>();

    public Chat() {
        setChatName("Noname");
        setUsers();
    }

    public Chat(String chatName) {
        setChatName(chatName);
//        setUsers();
    }

    public void setChatName(String newChatName) {
        ChatName = newChatName;
    }

    public void setUsers() {
        for (int i = 0; i < 10; i++) {
            User UsrObj = new User("User_" + i, "Name" + i, "+380000000" + i);
            Users.add(UsrObj);
        }
    }

    public void output() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        System.out.printf("Chat description:\nNumber of messages = %d\nNumber of users = %d\nUsers list:\n", Messages.size(), Users.size());

        for (User UsrObj : Users) {
            System.out.printf("User: %s, has nickname '%s' and a phone number: %s.\n", UsrObj.getTitle(), UsrObj.getNickname(), UsrObj.getPhoneNumber());
        }

        for (FileMessage FileObj : FileMessages) {
            System.out.printf("At: %s, %s sent a file message: %s.\n", dtf.format(FileObj.date), FileObj.getAuthor(), FileObj.getText());
        }

        for (ImageMessage ImgObj : ImageMessages) {
            System.out.printf("At: %s, %s sent an image message: %s.\n", dtf.format(ImgObj.date), ImgObj.getAuthor(), ImgObj.getText());
        }

    }

    public void addMessage(BaseMessage newMsg) {
        Messages.add(newMsg);

        addUser(newMsg.author);

    }

    public void addImageMessage(ImageMessage newImgMsg) {
        if (newImgMsg.getClass() == ImageMessage.class) {
            ImageMessages.add(newImgMsg);
        }
        addMessage(newImgMsg);
    }

    public void addFileMessage(FileMessage newFileMsg) {
        if (newFileMsg.getClass() == FileMessage.class) {
            FileMessages.add(newFileMsg);
        }
        addMessage(newFileMsg);
    }

    private void addUser(String nickname) {
        int EndOfArray = Users.size() - 1;
        for (int i = 0; i <= EndOfArray; i++) {
            if (nickname.compareTo(Users.get(i).getNickname()) == 0) {
                //Users.get(i);
                break;
            }
            if (i == EndOfArray) {
                // if all items in Users != nickname then create a new User, and add to Users.
                Users.add(new User("User_" + Users.size(), nickname, "+380000000" + Users.size()));
            }

        }
        if (Users.size() == 0) {
            Users.add(new User("User_0", nickname, "+3800000000"));
        }
    }

    public ArrayList<FileMessage> getAllFileMessages() {
        return FileMessages;
    }

    public ArrayList<ImageMessage> getAllImageMessages() {
        return ImageMessages;
    }

    public void saveAllUsersToFile(String fileName) throws FileNotFoundException {
        String relativePath = System.getProperty("user.dir");
        File DestinationFile = new File(relativePath + "\\" + fileName + ".txt");
        PrintWriter out = new PrintWriter(DestinationFile);
        out.printf("List of all users in chat named: %s \n", ChatName);
        for (User UsrObj : Users) {
            out.printf("|%s|%s|%s|\n", UsrObj.getTitle(), UsrObj.getNickname(), UsrObj.getPhoneNumber());
        }

        out.close();
    }
    public void loadAllUsersFromFile(String fileName) throws FileNotFoundException{
        String relativePath = System.getProperty("user.dir");
        File sourceFile = new File(relativePath+"\\" + fileName + ".txt");
        Scanner fileScanner = new Scanner(sourceFile);


        while (fileScanner.hasNext()) {
            String currentLine = fileScanner.nextLine();
            if (currentLine.contains("|")){
                StringTokenizer st = new StringTokenizer(currentLine,"|");
//                while (st.hasMoreTokens()) {
//                    System.out.println(st.nextToken());
//                }
                User UsrObj = new User(st.nextToken(), st.nextToken(), st.nextToken());
                Users.add(UsrObj);
            }

        }
        fileScanner.close();

    }
}

class User {
    private String nickname;
    private String PhoneNumber;
    private String Title;

    public void setNickname(String newNickname) {
        nickname = newNickname;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        PhoneNumber = newPhoneNumber;
    }

    public void setTitle(String newTitle) {
        Title = newTitle;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getTitle() {
        return Title;
    }

    public User() {
        setNickname("none");
        setTitle("EmptyUser");
        setPhoneNumber("+3800000000");
    }

    public User(String newTitle, String newNickname, String newPhone) {
        setTitle(newTitle);
        setNickname(newNickname);
        setPhoneNumber(newPhone);
    }

}

/*
  1.  Inheritance   [Done]
  2.  Abstract class    [Done]
  3.  Method overloading    [Done]
  4.  Method overriding    [Done]
  5.  Use of private, protected, public     [Done]
  6.  Use call of superclass method using super.[Done]
  7.  Call of superclass constructor.[Done]
  8.  Create at least 5 classes.   [Done]
  9.  Create entities with composition/aggregation relations with use of collections [Done]
  10.  Create I/O part to save/read state of the system using files [Done]
*/



