package List;
// 876
public class MiddleNode {
    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode head2 = head;
        while(head != null) {
            length++;
            head = head.next;
        }
        System.out.println(length);

        int middle = length / 2;
        while(middle > 0) {
            middle--;
            head2 = head2.next;
        }
        return head2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head.next = head2;
        ListNode head3 = new ListNode(3);
        head2.next = head3;
        ListNode head4 = new ListNode(4);
        head3.next = head4;
        ListNode head5 = new ListNode(5);
        head4.next = head5;
        System.out.println(MiddleNode.middleNode(head).val);
    }
}
