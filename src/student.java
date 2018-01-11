public  class student {
    int id;
    String password;
    String name;
    String semester;
    double result;
    String address ;
    student(int sid,String spass, String nam, String sem, double res , String adrs){
        id = sid;
        password = spass;
        name = nam;
        semester = sem;
        result = res;
        address = adrs;
    }
    public String toString() {
        return "Id:"+id+"\nPassword:"+password+"\nName:"+name+"\nSemester:"+semester+"\nResult:"+result+"\nAddress:"+address;
    }

}
