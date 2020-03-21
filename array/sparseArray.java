package sparseArray;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //create a 2-deimensions arrays, size is 11*11
        //先创建一个原始的二维数组，大小为11*11
        //1 is black, 2 is blue
        //0表示没有旗子，1表示黑子，2表示蓝子

        int chessArr1[][] = new int[11][11];
        //先定义一个棋盘，并在棋盘上方向两个棋子，一个黑子，一个篮子
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        int sum = 0;//统计这个棋盘上到底有多少棋子
        System.out.println("orginal 2 dimensions arrays");
        for(int[] row: chessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
                if(data!=0){
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println("sparseArrs is:");

        //sparsearray,稀疏数组的定义就是，第一行值为 棋盘大小和总共的非棋子数   11 11 2
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for(int i = 0 ; i < chessArr1.length; i++){
            for(int j = 0; j <chessArr1.length; j++){
                if(chessArr1[i][j] != 0){ //如果当前的值不为0，则将这些值存下来。下标和值都要保存
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j]; 
                }
            }
        }
       
         //打印出稀疏数组

        for(int[] spar:sparseArr){
            for(int va: spar){
                System.out.printf("%d\t",va);
            }
            System.out.println();
        }
       
        //将前面的稀疏数组给从新放回普通的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]]; 
        for(int i = 1; i<sparseArr.length; i++){
            
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            
        }

         System.out.println("after 2 dimensions arrays");
        for(int[] row: chessArr2){
            for(int data:row){
                System.out.printf("%d\t",data);   
            }
            System.out.println();
        }
    }
}
