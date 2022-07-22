//暴力法 时间复杂度n2
class Solution_force {
	public int reversePairs(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					count++;
				}
			}
		}
		return count;

	}
}

//归并排序法 时间复杂度nlogn 空间复杂度n
class Solution_mergesort {
	int[] nums, temp;

	public int reversePairs(int[] nums) {
		this.nums = nums;
		temp = new int[nums.length];
		return mergesort(0, nums.length - 1);

	}

//  归并排序
//	终止条件:当左索引大于等于右索引时,终止划分
//	计算数组重点m进行划分 left-m m+1-right
//	暂存数组left-right到临时数组temp
//	遍历数组进行填充,指针i指向左子数组,指针j指向有子数组,指针k指向nums数组
//	若i指向了右数组,则表明左数组已经填充完,只需添加右数组到当前位置
//	若j指向了right+1,则表明右数组已经填充完毕,只需添加左数组到当前位置
//	若i指向的元素小于等于j指向的元素,则添加i指向的元素到当前位置
//	若i指向的元素大于j指向的元素,则添加j指向的元素到当前位置
//  因为最右端的元素为子数组最小的,所以右数组中比左数组元素大的数量为m+1-i
	public int mergesort(int left, int right) {
		if (left >= right) {
			return 0;
		}
		int m = (left + right) / 2;
		int res = mergesort(left, m) + mergesort(m + 1, right);
		int i = left, j = m + 1;
		for (int k = left; k <= right; k++) {
			temp[k] = nums[k];
		}
		for (int k = left; k <= right; k++) {
			if (i == m + 1) {
				nums[k] = temp[j++];
			} else if (j == right + 1) {
				nums[k] = temp[i++];
			} else if (temp[i] <= temp[j]) {
				nums[k] = temp[i++];
			} else {
				nums[k] = temp[j++];
				res = res + m - i + 1;
			}
		}
		return res;
	}
}