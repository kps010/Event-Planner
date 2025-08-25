package Main;

public class User {
    static String name;
    static String email;
    static String pass;
    static String phno;
    static String user_id;

    User(String name, String email, String phno, String pass, String user_id) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phno = phno;
        this.user_id = user_id;
    }

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPass() {
        return pass;
    }

    public static String getPhno() {
        return phno;
    }

    public static String getUser_id() {
        return user_id;
    }
}
