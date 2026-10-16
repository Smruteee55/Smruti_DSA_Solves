
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;

        // Count total nodes
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        int size = n / k;
        int extra = n % k;

        ListNode[] result = new ListNode[k];
        curr = head;

        for (int i = 0; i < k; i++) {
            result[i] = curr;

            // This part gets one extra node if needed
            int partSize = size + (i < extra ? 1 : 0);

            for (int j = 0; j < partSize - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }

            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null; // Break the linked list
                curr = nextPart;
            }
        }

        return result;
    }
}
