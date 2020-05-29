package DC;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * <br>
 * the divide and conquer
 *
 * @author zac
 * @create 2020/5/29
 * @since 1.0.0
 */
public class DC {

    public static void main(String args[]){
        System.out.println("main");

        int[] data = new int[3];
        char[] t = new char[3];
        for (int i=0;i<= t.length-1;i++)
            System.out.println(t[i]);

        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int local = binarySearch(a,7);
        System.out.println("the local:"+local+" of the value is "+ a[local]);

        int[] b = {4,1,8,3,7,6,2,5,9};
        //int[] tmp = new int[b.length];
        //sort(b,0,b.length-1,tmp);
        //System.out.println("The result of mergeSort:" + Arrays.toString(b));

        quickSort(b,0,b.length-1);
        System.out.println("The result of quickSort:" + Arrays.toString(b));
    }


    /**
     * 查找有序数组中对应某数值的位置
     * @param arr
     * @param tar
     * @return if -1 not exites or the local of the value
     */
    public static int binarySearch(int[] arr, int tar){
        int left = 0;
        int right = arr.length-1; // 左右边界
        while (left<=right){
            int mid = (right-left)/2+left;
            if (tar > arr[mid])
                left = mid+1;
            if (tar < arr[mid])
                right = mid-1;
            if (tar == arr[mid])
                return mid;
        }
        return -1;
    }

    /**
     * 对序列划分子序列并归并序列
     * @param arr
     * @param left
     * @param right
     * @param tmp
     */
    public static void sort(int[] arr,int left, int right, int[] tmp){
        if (left < right){
            int mid = (left + right)/2;
            //递归实现子序列合并
            sort(arr, left, mid, tmp);//对序列分组，并排列分组内容
            sort(arr, mid+1, right,tmp);
            merge(arr,left, mid, right,tmp);//归并有序的模块
        }
    }
    /**
     * 归并排序
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param tmp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] tmp){
        int lind = left;
        int rind = mid+1;
        int t = 0;
        //遍历左右子序列对其进行重排
        while(lind <=mid && rind <=right){
            if (arr[lind] <= arr[rind]){
                tmp[t++] = arr[lind++];
            }else {
                tmp[t++] = arr[rind++];
            }
        }
        //将剩余未合并序列合并
        while (lind <= mid){
            tmp[t++] = arr[lind++];
        }
        while (rind <= right){
            tmp[t++] = arr[rind++];
        }
        //将tmp复制到arr中
        t = 0;
        while (left <= right){
            arr[left++] = tmp[t++];
        }

    }

    /**
     * 快速排序，通过基准数据将序列分组，对子序列递归快排
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right){
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    /**
     * 依次对序列分别向中间元素遍历，并对序列分组
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right){
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }

}
