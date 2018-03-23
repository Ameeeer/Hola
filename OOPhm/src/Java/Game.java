package Java;


public class Game {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > 0; j--) {
                arr[j][i] = 1;
            }
        }

        for (int i = 0; i < 5; i++) {
            arr[i][i] = 1;
        }
    }
}
//        char[][] symbols = new char[3][3];
//        symbols[0][0] = 'x';
//        symbols[1][1] = '0';

//        char[][] symbols = {{'0', 'x', 'x'}, {'x', '0', '0'}, {'0', 'x', '0'}};
//        int[] arr;
