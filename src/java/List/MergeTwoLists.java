package List;

public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode res = l3;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    l3.next = l1;
                    l1 = l1.next;
                }else {
                    l3.next = l2;
                    l2 = l2.next;
                }
            }else if (l1 != null) {
                l3.next = l1;
                l1 = l1.next;
            }else if (l2 != null) {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        return res.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        l1.next = l11;
        ListNode l12 = new ListNode(4);
        l11.next = l12;
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        l2.next = l21;
        ListNode l22 = new ListNode(4);
        l21.next = l22;
        ListNode l3 = MergeTwoLists.mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + ",");
            l3 = l3.next;
        }
    }
}
