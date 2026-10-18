
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode curr = head;
        ListNode newHead = null;
        ListNode tail = null;

        while (curr != null) {
            while (tail != null && tail.val < curr.val) {
                // This approach needs a stack, so use the solution below.
                break;
            }
            curr = curr.next;
        }

        java.util.Stack<ListNode> stack = new java.util.Stack<>();
        curr = head;

        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }

        newHead = null;
        tail = null;

        for (ListNode node : stack) {
            node.next = null;

            if (newHead == null) {
                newHead = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return newHead;
    }
}
