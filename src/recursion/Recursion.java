package recursion;


/**
 * <br>
 * the algorithm of recursion test
 *
 * @author zac
 * @create 2020/5/28
 * @since 1.0.0
 */


public class Recursion {

    public static void main(String args[]){
        int result = accumulateN(100);
        System.out.println("the result of the accumulate N:"+result);

        int res = factorialN(5);
        System.out.println("the result of the factorial N:"+ res);

        int f = fibonacci(8);
        System.out.println("the result of fibonacci number:"+ f);

        int v = pascal(2,1);
        System.out.println("the value in x row and y col:"+ v);


    }

    /**
     * 求前n项元素和
     * @param n
     * @return
     */
    public static int accumulateN(int n){

        if (n==1)
            return 1;

        return accumulateN(n-1) + n;
    }

    /**
     * 求N阶乘
     * @param n
     * @return
     */
    public static int factorialN(int n){
        if (n==1)
            return 1;
        return factorialN(n-1)*n;
    }

    /**
     * 求斐波那契数列的第N个元素值
     * @param n
     * @return
     */
    public static int fibonacci(int n){
        if (n==1 || n==2)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    /**
     * 求杨辉三角第x行y列的值
     * @param row
     * @param col
     * @return
     * 杨辉三角
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     */
    public static int pascal(int row, int col){
        if (col==1 || row==col)
            return 1;
        return pascal(row-1,col-1) + pascal(row-1, col);
    }

    /**
     * 汉诺塔问题，将a塔中的块移到c塔，移动过程保证level大的块不能叠在level小上
     * @param level
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static void hanoiTower(int level, char a, char b, char c){

        if (level == 1) {
            System.out.println("move " + a + " to" + c);
        }else {
            //将level-1层塔块从a塔移到b塔
            hanoiTower(level-1, a, c, b);
            //将level-1层塔块从b塔移到c塔
            hanoiTower(level-1, b, a, c);
        }
    }


}
