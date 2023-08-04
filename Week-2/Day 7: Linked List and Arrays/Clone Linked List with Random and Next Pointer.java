class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        if (head==null) return null;

        while (curr!=null) {
            Node temp = new Node(curr.val, null, null);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }


        Node ans = head.next;
        Node temp = ans;
        curr = head;
        while (temp!=null) {
            Node x = curr.random;
            if (x==null) temp.random = null;
            else temp.random = x.next;
            curr = curr.next.next;
            if (temp.next==null) break;
            temp = temp.next.next;
        }

        temp = ans;
        curr = head;
        while (temp!=null) {
            curr.next = temp.next;
            curr = curr.next;
            if (temp.next==null) break;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return ans;
    }
}