package leetcode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        res.val = -101;
        ListNode curr = res;

        while (list1 != null && list2 != null) {
            if (curr.val != -101) {
                if (list1.val < list2.val) {
                    curr.next = new ListNode(list1.val);
                    curr = curr.next;
                    list1 = list1.next;
                } else if (list1.val > list2.val) {
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                    list2 = list2.next;
                } else {
                    curr.next = new ListNode(list1.val);
                    curr = curr.next;
                    list1 = list1.next;
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                    list2 = list2.next;
                }
            } else {
                if (list1.val < list2.val) {
                    curr.val = list1.val;
                    list1 = list1.next;
                } else if (list1.val > list2.val) {
                    curr.val = list2.val;
                    list2 = list2.next;
                } else {
                    curr.val = list1.val;
                    list1 = list1.next;
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                    list2 = list2.next;
                }
            }
        }

        while (list1 != null) {
            if (curr.val != -101) {
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.val = list1.val;
                list1 = list1.next;
            }
        }

        while (list2 != null) {
            if (curr.val != -101) {
                curr.next = new ListNode(list2.val);
                curr = curr.next;
                list2 = list2.next;
            } else {
                curr.val = list2.val;
                list2 = list2.next;
            }
        }

        return curr.val == -101 ? null : res;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
