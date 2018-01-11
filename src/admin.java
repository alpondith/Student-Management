public class admin {
    int id;
    String password;
    String name;
    String address;

    admin(int aid, String apass, String anam, String aad)
    {
        id = aid;
        password = apass;
        name = anam;
        address = aad;
    }


    public String toString() {
        return "Id:"+id+"\nPassword:"+password+"\nName:"+name+"\nAddress:"+address;
    }
}
