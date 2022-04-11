
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();
    }

    /*
    kısa uzun kısa uzun
    uzun kısa uzun kısa
     */
    public void test() {
        //3, 4, 6, 5
        //3, 7, 4, 5
        //5, 4, 3, 2, 6
        //
        int[] A = {7, 7, 7, 5, 4, 3, 2, 6};
        int a = solution(A);
        System.out.println(a);
    }


    public int solution(int[] A) {
        int count = 0;
        if (A[0] < A[1]) {    //kısa uzun kısa uzun durumu
            for (int i = 1; i < A.length - 2; i += 2) {
                if (A[i] > A[i + 1] && A[i + 1] < A[i + 2]) {
                    continue;
                } else
                    count++;
            }
        } else {
            if (A[0] > A[1]) {   //uzun kısa uzun kısa durumu
                for (int i = 1; i < A.length - 2; i += 2) {
                    if (A[i] < A[i + 1] && A[i + 1] < A[i + 2]) {
                        continue;
                    } else
                        count++;
                }
            } else {
                count++;
                for (int i = 1; i < A.length - 1; i++) {    //başta eşitlik yakalama
                    if (A[i] == A[i + 1]) {
                        count++;
                    } else {
                        if (A[i] < A[i + 1]) {    // eşitlik yakadıktan sonra kısa uzun kısa uzun durumu
                            for (int k = i; k < A.length - 2; k += 2) {
                                if (A[k] > A[k + 1] && A[k + 1] < A[k + 2]) {
                                    continue;
                                } else
                                    count++;
                            }
                        } else {
                            if (A[i] > A[i + 1]) {   // eşitlik yakaladıktan sonra uzun kısa uzun kısa durumu
                                for (int j = i; j < A.length - 2; j += 2) {
                                    if (A[j] < A[j + 1] && A[j + 1] < A[j + 2]) {
                                        continue;
                                    } else
                                        count++;
                                }
                            }
                            break;
                        }

                    }

                }
            }

        }
        return count;
    }
}
