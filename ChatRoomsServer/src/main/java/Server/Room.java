package Server;

import java.util.ArrayList;


public class Room {
    
    public String name;
    
    public ArrayList<String> userNames;
    
    public Room(String name, String creatorName)
    {
        userNames = new ArrayList<String>();
        this.name = name;
        this.userNames.add(creatorName);
    }
    // return true if the user added succesfully. else return false;
    public boolean addAndValidateUser(String userName)
    {
        if(isValidUserAdding(userName))
        {
            this.userNames.add(userName);
            return true;
        }
        return false;
    }
    public void addUser(String userName)
    {
        if(isValidUserAdding(userName))
        {
            this.userNames.add(userName);
        }
    }
    public boolean isValidUserAdding(String userName)
    {
        for(String name : userNames)
        {
            if(name.equals(userName)) return false;
        }
        return true;
    }
    public boolean hasUser(String userName)
    {
        for(String name: userNames)
        {
            if(name.equals(userName)) return true;
        }
        return false;
    }
    
    public void removeUser(String userName)
    {
        if(!hasUser(userName))return;
        this.userNames.remove(userName);
        if(this.userNames.isEmpty()) Server.rooms.remove(this);
    }
    
}
