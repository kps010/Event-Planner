package DS;

import Main.*;

public class UserLL {
    public static class node {
        String email;
        String password;
        node next;

        public node(String email, String password) {
            this.email = email;
            this.password = password;
            next = null;
        }
    }

    public static node first = null;

    static public void insert(String email, String pass) {
        node n = new node(email, pass);
        if (first == null) {
            first = n;
        } else {
            node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    static public void deleteAll() {
        while (first != null) {
            first = first.next;
        }
    }

    static public boolean contains(String name) {
        if (first == null) {
            return false;
        } else {
            node temp = first;
            while (temp != null) {
                if (temp.email.equals(name)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    static public boolean checkUser(String email, String pass) {
        if (first == null) {
            return false;
        } else {
            node temp = first;
            while (temp != null) {
                if (temp.email.equals(email) && temp.password.equals(pass)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    static public boolean checkOldUser(String email) {
        if (first == null) {
            return false;
        } else {
            node temp = first;
            while (temp != null) {
                if (temp.email.equals(email)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    static public void display() {
        if (first != null) {
            System.out.println("EMPTY");
        } else {
            node temp = first;
            while (temp != null) {
                System.out.println(temp.email + " => " + temp.password);
            }
        }
    }
}
