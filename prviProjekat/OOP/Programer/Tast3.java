package Programer;

public class Tast3 {

	public static void main(String[] args) {
		
        int[] arr1 = {0, 1, 3, 6, 7, 10};
        int[] arr2 = {2, 4, 5, 8, 9};

        int[] spojeniArr = mergeArrays(arr1, arr2);
        
        System.out.println("Spojeni niz:");
        for (int num : spojeniArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int duzinaOdPrvog = arr1.length;
        int duzinaOdDrugog = arr2.length;
        int[] spojeniArr = new int[duzinaOdPrvog + duzinaOdDrugog];

        int i = 0, j = 0, k = 0;
        
        // Spajanje nizova dok god nisu iscrpljeni
        while (i < duzinaOdPrvog && j < duzinaOdDrugog) {
            if (arr1[i] < arr2[j]) {
                spojeniArr[k++] = arr1[i++];
            } else {
                spojeniArr[k++] = arr2[j++];
            }
        }

        // Dodavanje preostalih elemenata prvog niza
        while (i < duzinaOdPrvog) {
            spojeniArr[k++] = arr1[i++];
        }

        // Dodavanje preostalih elemenata drugog niza
        while (j < duzinaOdDrugog) {
            spojeniArr[k++] = arr2[j++];
        }

        return spojeniArr;
    }
}
