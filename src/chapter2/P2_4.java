package chapter2;

import java.util.Scanner;

class DATA4{
	String name;
	int age;
}
class SQType{
	static final int QUEUELEN = 15;
	DATA4[] data=new DATA4[QUEUELEN];
	int head;
	int tail;
	
	SQType SQTypeInit(){
		SQType q;
		if ((q=new SQType())!=null) {
			q.head=0;
			q.tail=0;
			return q;
		}
		else {
			return null;
		}
	}
	
	int SQTypeIsEmpty(SQType q){
		int temp=0;
		if(q.head==q.tail)
			temp=1;
		return (temp);
	}
	
	int SQTypeIsFull(SQType q){
		int temp=0;
		if(q.tail==QUEUELEN)
			temp=1;
		return (temp);
	}
	
	void SQTypeClear(SQType q){
		q.head=0;
		q.tail=0;
	}
	
	void SQTypeFree(SQType q){
		if(q!=null){
			q=null;
		}
	}
	
	int InSQType(SQType q,DATA4 data){
		if(q.tail==QUEUELEN){
			System.out.println("队列已满！操作失败！");
			return(0);
		}else {
			q.data[q.tail++]=data;
			return(1);
		}
	}
	
	DATA4 OutSQType(SQType q){
		if(q.head==q.tail){
			System.out.println("\n队列已空！操作失败！");
			System.exit(0);
		}else {
			return q.data[q.head++];
		}
		return null;
	}
	
	DATA4 PeekSQType(SQType q){
		if(SQTypeIsEmpty(q)==1){
			System.out.println("空队列！");
			return null;
		}else {
			return q.data[q.head];
		}
	}
	
	int SQTypeLen(SQType q){
		int temp;
		temp=q.tail-q.head;
		return (temp);
	}
}
public class P2_4 {
	public static void main(String[] args) {
		SQType st=new SQType();
		
		DATA4 data1;
		
		Scanner input=new Scanner(System.in);
		SQType stack=st.SQTypeInit();
		System.out.println("入队列操作：");
		System.out.println("输入姓名 年龄进行入队列操作：");
		do {
			DATA4 data=new DATA4();
			data.name=input.next();
			data.age=input.nextInt();
			if(data.name.equals("0")){
				break;
			}else {
				st.InSQType(stack, data);
			}
		} while (true);
		
		String temp="1";
		System.out.println("出队列操作：按任意非0键进行出栈操作：");
		temp=input.next();
		while (!temp.equals("0")) {
			data1=st.OutSQType(stack);
			System.out.printf("出队列的数据是(%s,%d)",data1.name,data1.age);
			temp=input.next();
		}
		System.out.println("测试结束！");
		st.SQTypeFree(stack);
	}
}
