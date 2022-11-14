/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // -- pointer to the head of the result
        ListNode result = new ListNode(0);
        
        // -- result iterator
        ListNode iterator = result;
        
		// -- go to the end of both lists
        while (l1 != null || l2 != null) {
            // -- at least 1 digit is available, if both sum them up
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            
            // -- sum the leftover with the current digits sum
            int carry = iterator.val + sum;
            
            // -- move forward in the input lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            
            // -- if the result it's a digit set it as val in the last result node
			// -- if at least 1 input list has a next node, add an empty node to the result with 0 as initial val
            if (carry <= 9) {
                iterator.val = carry;                
                if (l1 != null || l2 != null) iterator.next = new ListNode(0);
            } else {
                // -- if you're here, it means your final sum is > 9 and you need to do the maths :)
                // -- ex: if the sum is 21, keep 1 in the current node and add the next node with 2 as initial val
                iterator.next = new ListNode(carry / 10);
                iterator.val = carry % 10;                
            }
            
            // --move forward in the result
            iterator = iterator.next;
        }
        
        return result;
    }
}