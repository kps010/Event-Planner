package DS;

public class LL {
    public static class node {
        String id;
        String name;
        node next;

        public node(String id, String name) {
            this.id = id;
            this.name = name;
            next = null;
        }
    }

    public static node first = null;

    static public void insert(String id, String name) {
        node n = new node(id, name);
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

    // static public void deleteAll() {
    // while (first != null) {
    // first = first.next;
    // }
    // }

    static public String getId(String venue) {
        node temp = first;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(venue)) {
                return temp.id;
            }
            temp = temp.next;
        }
        return null;
    }

    static public void display() {
        if (first == null) {
            System.out.println("EMPTY");
        } else {
            node temp = first;
            while (temp != null) {
                System.out.println(temp.id + " => " + temp.name);
                temp = temp.next;
            }
        }
    }
}
