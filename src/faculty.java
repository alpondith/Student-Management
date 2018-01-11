public class faculty {
    int id;
    String password;
    String name;
    String post;
    String address;
    faculty (int fid, String fpass, String fname, String fpost, String fadd)
    {
        id = fid;
        password = fpass;
        name = fname;
        post = fpost;
        address  = fadd;
    }


    public String toString() {
        return "Id:"+id+"\nPassword:"+password+"\nName:"+name+"\nPost:"+post+"\nAddress:"+address;
    }
}
