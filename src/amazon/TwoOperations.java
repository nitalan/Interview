package amazon;

import java.util.Arrays;
import java.util.HashMap;
/*
 * �ڶ��⣺ Two Operations�������Ǵ��㿪ʼ��ֻ�����ֲ����ɹ�ѡ��+ 1 �� �� 2����ĳ�����ֵ���С�Ĳ�������.  
����(�������Ҽ��㣬�ҾͲ���������)
       3 = 0 +1+1+1 (3) / 0 + 1 * 2 + 1(3)  
       5 = 0 + 1 * 2 * 2 + 1(4). 围观我们@1point 3 acres
�����븴���ˣ���������DPȥ�������������м���case��ʱ���������֣�* 2 ����һ���� + 1�����죬Ȼ��͸����£�Ȼ���pass��test case����Ϊ��������˵��n <= pow(10, 16), ����������Integet.parseInt(S)�ᱨ�쳣��������Longȥ���ա������˸�cache�Ż�һ��
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=194035&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 */
public class TwoOperations {
	public int[] MinOperations(long[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = helper(nums[i]);
		}
		return res;
	}

	HashMap<Long, Integer> map = new HashMap();

	private int helper(long num) {
		if (num==0) return 0;
		if (map.containsKey(num)) return map.get(num);
		int res;
		if (num % 2==0) {
			res = helper(num/2);
		} else {
			res = helper(num-1);
		}
		res++;
		map.put(num, res);
		return res;
	}
	
	public static void main(String[] args) {
		TwoOperations q = new TwoOperations();
		System.out.println(Arrays.toString(q.MinOperations(new long[]{0,3,5,4})));
	}
}
