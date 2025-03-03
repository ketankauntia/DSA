//  Inplace Heap sort
// Moderate
// Score:
// 160/160
// Average time to solve is 40m
// Problem statement

// Send feedback
// Given an integer array of size N. Sort this array (in decreasing order) using heap sort.

// Note: Space complexity should be O(1).

// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 1 <= n <= 10^6
// Time Limit: 1 sec
// Sample Input 1:
// 6 
// 2 6 8 5 4 3
// Sample Output 1:
// 8 6 5 4 3 2


void heapSort(int arr[], int n)
{
    // Write your code
    for (int i = 1; i < n; i++)
    {
        int childIndex = i;
        while (childIndex > 0)
        {
            int parentIndex = (childIndex - 1) / 2;
            if (arr[parentIndex] > arr[childIndex])
            {
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[childIndex];
                arr[childIndex] = temp;
            }
            else
                break;
            childIndex = parentIndex;
        }
    }
    int size = n;

    while (size > 1)
    {
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;

        size--;

        int parentIndex = 0;
        while (parentIndex < size)
        {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;
            int minIndex;
            if (leftChildIndex < size && rightChildIndex < size)
                minIndex = (arr[leftChildIndex] <= arr[rightChildIndex]) ? leftChildIndex : rightChildIndex;
            else if (leftChildIndex < size)
                minIndex = leftChildIndex;
            else
                break;
            if (arr[minIndex] < arr[parentIndex])
            {
                int temp = arr[minIndex];
                arr[minIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
            }
            else
                break;
            parentIndex = minIndex;
        }
    }
}