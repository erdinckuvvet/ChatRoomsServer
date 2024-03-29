package Messages;

//This class' purpose is providing a generic cominication object for us to
// send any serializable objects to the server.
public class Message implements java.io.Serializable {

    public static enum MessageTypes {
        USERNAME,CREATE_ROOM, ALL_ROOMS,USERNAME_REACHED
        ,ROOM_CREATED, IN_ROOM_MESSAGE, JOIN_ROOM, ALL_USERS ,CREATE_PERSONEL_ROOM, ACCEPT_PERSONEL_ROOM,
        PERSONEL_ROOM_REJECTED, PERSONEL_ROOM_ACCEPTED,PERSONEL_ROOM_MESSAGE,DOWNLOAD_FILE_REQUEST,UPLOAD_FILE_REQUEST,
        FILE_UPLOADED,PERSONEL_ROOM_DISPERSED,LEFT_FROM_ROOM
    };

    public MessageTypes type;
    public Object content;

    public Message(MessageTypes type) {
        this.type = type;
    }
}
