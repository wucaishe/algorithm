package chapter2;

import java.util.Scanner;

import sun.security.krb5.internal.PAData;

class DATA {
	String key;
	String name;
	int age;
}

class SLType {
	static final int MAXLEN = 100;
	DATA[] ListData = new DATA[MAXLEN + 1];
	int Listlen;

	/**
	 * 初始化顺序序
	 * 
	 * @param SL
	 */
	void SLInit(SLType SL) {
		SL.Listlen = 0;
	}

	/**
	 * 计算顺序表长度
	 * 
	 * @param SL
	 * @return
	 */
	int SLLength(SLType SL) {
		return SL.Listlen;
	}

	/**
	 * 插入结点
	 * 
	 * @param SL
	 * @param n
	 * @param data
	 * @return
	 */
	int SLInert(SLType SL, int n, DATA data) {
		int i;
		if (SL.Listlen >= MAXLEN) {
			System.out.println("顺序表已满，不能插入结点！");
			return 0;
		}
		if (n < 1 || n > SL.Listlen - 1) {
			System.out.println("插入元素序号错误，不能插入元素！");
			return 0;
		}
		for (i = SL.Listlen; i >= n; i--) {
			SL.ListData[i + 1] = SL.ListData[i];
		}
		SL.ListData[n] = data;
		SL.Listlen++;
		return 1;
	}

	/**
	 * 追加结点
	 * 
	 * @param SL
	 * @param data
	 * @return
	 */
	int SLAdd(SLType SL, DATA data) {
		if (SL.Listlen >= MAXLEN) {
			System.out.println("顺序表已满，不能再添加结点了！");
			return 0;
		}
		SL.ListData[++SL.Listlen] = data;
		return 1;
	}

	/**
	 * 删除结点
	 * 
	 * @param SL
	 * @param n
	 * @return
	 */
	int SLDelete(SLType SL, int n) {
		int i;
		if (n < 1 || n > SL.Listlen + 1) {
			System.out.println("删除结点序列号错误，不能删除结点！");
			return 0;
		}
		for (i = n; i < SL.Listlen; i++) {
			SL.ListData[i] = SL.ListData[i + 1];
		}
		SL.Listlen--;
		return 1;
	}

	/**
	 * 按序列号查找结点
	 * 
	 * @param SL
	 * @param n
	 * @return
	 */
	DATA SLFindByNum(SLType SL, int n) {
		if (n < 1 || n > SL.Listlen+1) {
			System.out.println("结点语错误，不能返回结点！");
			return null;
		}
		return SL.ListData[n];
	}

	/**
	 * 按关键字查找结点
	 * 
	 * @param SL
	 * @param key
	 * @return
	 */
	int SLFindByCout(SLType SL, String key) {
		int i;
		for (i = 1; i <= SL.Listlen; i++) {
			if (SL.ListData[i].key.compareTo(key) == 0) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * 显示所有结点
	 * 
	 * @param SL
	 * @return
	 */
	int SLAll(SLType SL) {
		int i;
		for (i = 1; i <= SL.Listlen; i++) {
			System.out.printf("(%s,%s,%d)\n", SL.ListData[i].key,
					SL.ListData[i].name, SL.ListData[i].age);
		}
		return 0;
	}
}

public class Seqquential {
	public static void main(String[] args) {
		int i;
		SLType SL = new SLType();
		DATA pdata;
		String key;
		System.out.println("顺序表操作演示！");
		SL.SLInit(SL);
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("输入添加的结点（学号 姓名 年龄）：");
			DATA data = new DATA();
			data.key = input.next();
			data.name = input.next();
			data.age = input.nextInt();
			if (data.age != 0) {
				if (SL.SLAdd(SL, data) == 0) {
					break;
				}
			} else {
				break;
			}
		} while (true);
		System.out.println("\n顺序表中的顺序为：");
		SL.SLAll(SL);
		System.out.println("\n要取出的结点的序号为：");
		i = input.nextInt();
		pdata = SL.SLFindByNum(SL, i);
		if (pdata != null) {
			System.out.printf("第%d个结点为：(%s,%s,%d)", i, pdata.key, pdata.name,pdata.age);
		}
		System.out.printf("\n要查找结点的关键字：");
		key = input.next();
		i = SL.SLFindByCout(SL, key);
		pdata = SL.SLFindByNum(SL, i);
		if (pdata != null) {
			System.out.printf("第%d个结点为：(%s,%s,%d)", i, pdata.key, pdata.name,pdata.age);
		}
	}
}
