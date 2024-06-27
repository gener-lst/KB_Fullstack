package ch05;

public class MaxDataInArray {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 8, 2};
        int maxData = 0;
        for(int i = 0; i < array.length - 1; i++) {
            maxData = Math.max(array[i], array[i + 1]);
        }
        System.out.printf("최대값은 %d입니다.", maxData);
    }
}
