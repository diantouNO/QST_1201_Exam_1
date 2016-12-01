package qst.com.test;
//完成链表反转
public class Test {
	public static class Node {
		public int value;
		public Node next = null;

		Node(int value) {
			this.value = value;
		}

		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	//链表的反转
	public static Node reverseLinkList(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node pre = null;
		Node nex = null;
		while(head != null){
			nex = head.next;
			head.next = pre;
			pre = head;
			head = nex;
		}
		return pre;
	}
	//创建了求取链表长度的方法，为了方便在后面输出时判断是否是最后一个元素
	public static int length(Node head) {
		int len = 0;
		while(head != null){
			head = head.next;
			len++;
		}
		return len;
	}
	private static void printLinkList(Node head) {
		int len = length(head);
		int flag = 0;
		while(head != null){
			//若是最后一个元素，不输出 "->"
			if(flag == len-1){
				System.out.print(head.value);
				head = head.next;
			}
			else{
				System.out.print(head.value +"->");
				head = head.next;
			}
			flag++;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 2, 4 };
		Node head = createLinkList(arr);
		printLinkList(head);
		printLinkList(reverseLinkList(head));
		
	}

	private static Node createLinkList(int[] arr) {
		Node[] linkArr = new Node[arr.length];
		for (int i = 0; i < arr.length; i++) {
			linkArr[i] = new Node(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			linkArr[i].setValue(arr[i]);
			if (i == arr.length - 1) {
				linkArr[i].next = null;
			} else {
				linkArr[i].next = linkArr[i + 1];
			}
		}
		return linkArr[0];
	}
}
