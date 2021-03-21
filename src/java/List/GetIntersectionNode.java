package List;
//160
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0, b = 0;
        ListNode heada = headA;
        ListNode headb = headB;
        while (heada != null) {
            a++;
            heada = heada.next;
        }
        while (headb != null) {
            b++;
            headb = headb.next;
        }

        if (a > b) {
            while (a != b) {
                headA = headA.next;
                a--;
            }
        }
        if (a < b) {
            while (a != b) {
                headB = headB.next;
                b--;
            }
        }
        while(headA != headB && headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
