package DataStruct;

//二维数组变稀疏数组，节省空间
public class SparseArr {
    public static void main(String[] args) {
        int[][] originArr = new int[11][11];
        originArr[1][2] = 1;
        originArr[3][6] = 2;
        originArr[6][10] = 15;
        int sum = 0;
        for (int[] rows : originArr) {
            for (int col : rows) {
                System.out.print(col + "\t");
                if (col != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        //转换稀疏数组
        System.out.println("====================稀疏数组=====================");
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (originArr[i][j] != 0) {
                    ++count;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = originArr[i][j];
                }
            }
        }

        for (int[] rows : sparseArr) {
            for (int col : rows) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
        System.out.println("====================稀疏数组=====================");

        System.out.println("====================转换回去=====================");
        //转回原始数组
        int[][] toOriginArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sum + 1; i++) {
            toOriginArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        for (int[] rows : toOriginArr) {
            for (int col : rows) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
        System.out.println("====================转换回去=====================");

    }
}
