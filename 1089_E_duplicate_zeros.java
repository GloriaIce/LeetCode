class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 2; j > i; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }
}

class Solution {
    public void duplicateZeros(int[] arr) {
        int count0 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                count0++;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if ((i + count0) < arr.length) {
                arr[i + count0] = arr[i];
            }
            if ((arr[i] == 0) && ((i + count0 - 1) < arr.length)) {
                arr[i + count0 - 1] = 0;
            }
            if (arr[i] == 0){
                count0--;
            }
                
            if(count0 == 0) {
                return;
            }
        }
    }
}