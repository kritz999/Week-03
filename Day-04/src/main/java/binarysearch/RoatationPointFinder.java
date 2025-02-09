package binarysearch;

public class RoatationPointFinder {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation Point Index: " + rotationIndex);
        System.out.println("Smallest Element: " + arr[rotationIndex]);
    }


}
