package chapter2;

import java.util.Scanner;

public class P2_2 {
	public static void main(String[] args) {
		CLType node, head = null;
		CLType CL = new CLType();
		String key, findkey;
		Scanner input = new Scanner(System.in);

		System.out.println("链表测试。先输入链表中的数据，格式为：关键字 姓名 年龄");
		do {
			DATA2 nodeData = new DATA2();
			nodeData.key = input.next();
			if (nodeData.key.equals("0")) {
				break;
			} else {
				nodeData.name = input.next();
				nodeData.age = input.next();
				head = CL.CLAddEnd(head, nodeData);
			}
		} while (true);
		CL.CLAllNode(head);

		System.out.println("\n演示插入结点，输入位置的关键字：");
		findkey = input.next();
		System.out.println("输入插入结点的数据（关键字 姓名 年龄）:");
		DATA2 nodeData = new DATA2();
		nodeData.key = input.next();
		nodeData.name = input.next();
		nodeData.age = input.next();
		head = CL.CLInsertNode(head, findkey, nodeData);
		CL.CLAllNode(head);

		System.out.println("\n演示删除结点，输入要删除的关键字");

		key = input.next();
		CL.CLDeleteNode(head, key);
		CL.CLAllNode(head);

		System.out.println("\n演示在链表中查找，输入查找关键字:");
		key = input.next();
		node = CL.CLFindNode(head, findkey);
		if (node != null) {
			nodeData = node.nodeData;
			System.out.printf("关键字%s对应的结点为(%s,%s,%s)\n", key, nodeData.key,nodeData.name, nodeData.age);
		} else {
			System.out.println("在链表中未找到关键字为％s的结点！");
		}
	}
}

class DATA2 {
	String key;
	String name;
	String age;
}

class CLType {
	DATA2 nodeData = new DATA2();
	CLType nextNode;

	CLType CLAddEnd(CLType head, DATA2 nodeData) {
		CLType node, htemp;
		if ((node = new CLType()) == null) {
			System.out.print("申请内存失败！\n");
			return null;
		} else {
			node.nodeData = nodeData;
			node.nextNode = null;
			if (head == null) {
				head = node;
				return head;
			}
			htemp = head;
			while (htemp.nextNode != null) {
				htemp = htemp.nextNode;
			}
			htemp.nextNode = node;
			return head;
		}
	}

	CLType CLAddFirst(CLType head, DATA2 nodeData) {
		CLType node;
		if ((node = new CLType()) == null) {
			System.out.print("申请内存失败！\n");
			return null;
		} else {
			node.nodeData = nodeData;
			node.nextNode = head;
			head = node;
			return head;
		}
	}

	CLType CLFindNode(CLType head, String key) {
		CLType htemp;
		htemp = head;
		while (htemp != null) {
			if (htemp.nodeData.key.compareTo(key) == 0) {
				return htemp;
			}
			htemp = htemp.nextNode;
		}
		return null;
	}

	CLType CLInsertNode(CLType head, String findkey, DATA2 nodeData) {
		CLType node, nodetemp;
		if ((node = new CLType()) == null) {
			System.out.print("申请内存失败！\n");
			return null;
		} else {
			node.nodeData = nodeData;
			nodetemp = CLFindNode(head, findkey);
			if (nodetemp != null) {
				node.nextNode = nodetemp.nextNode;
				nodetemp.nextNode = node;
			} else {
				System.out.print("未找到正确的插入位置！\n");
				// free(node);
			}
			return head;
		}
	}

	int CLDeleteNode(CLType head, String key) {
		CLType node, htemp;
		htemp = head;
		node = head;
		while (htemp != null) {
			if (htemp.nodeData.key.compareTo(key) == 0) {
				node.nextNode = htemp.nextNode;
				// free(htemp);
				return 1;
			} else {
				node = htemp;
				htemp = htemp.nextNode;
			}
		}
		return 0;
	}

	int CLLength(CLType head) {
		CLType htemp;
		int Len = 0;
		htemp = head;
		while (htemp != null) {
			Len++;
			htemp = htemp.nextNode;
		}
		return Len;
	}

	void CLAllNode(CLType head) {
		CLType htemp;
		DATA2 nodeData;
		htemp = head;
		System.out.printf("当前链表共有%d个结点。链表所有数据如下：\n", CLLength(head));
		while (htemp != null) {
			nodeData = htemp.nodeData;
			System.out.printf("结点(%s,%s,%s)\n", nodeData.key, nodeData.name,nodeData.age);
			htemp=htemp.nextNode;
		}
	}
}
