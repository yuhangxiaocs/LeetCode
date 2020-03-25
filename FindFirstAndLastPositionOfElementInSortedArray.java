/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 * Memory Usage: 42.8 MB, less than 99.29% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 */
 
class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findStarting(nums, target);
        res[1] = findEnding(nums, target);
        return res;
    }
    
    public int findStarting(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        int index = -1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target)
                hi = mid - 1;
            else
                lo = mid + 1;
            if(nums[mid] == target)
                index = mid;
        }
        return index;
    }
    
    public int findEnding(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        int index = -1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
            if(nums[mid] == target)
                index = mid;
        }
        return index;
        
    }
}
