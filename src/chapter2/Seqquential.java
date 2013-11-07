package chapter2;

public class Seqquential {
	static final int MAXLEN = 100;

	class DATA {
		String key;
		String name;
		int age;
	}

	class SLType {
		DATA[] ListData = new DATA[MAXLEN + 1];
		int Listlen;
	}

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
			System.out.println("顺序表已满，不能插入结点！\n");
			return 0;
		}
		if (n < 1 || n > SL.Listlen - 1) {
			System.out.println("插入元素序号错误，不能插入元素！\n");
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
			System.out.println("顺序表已满，不能再添加结点了！\n");
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
			System.out.println("删除结点序号错误，不能删除结点！\n");
			return 0;
		}
		for (i = n; i < SL.Listlen; i++) {
			SL.ListData[i] = SL.ListData[i + 1];
		}
		SL.Listlen--;
		return 1;
	}
}
