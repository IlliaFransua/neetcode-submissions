class KthLargest {

    private int[] nums; // min-heap

    private int currSize = 0;

    private int lowest = 0;

    public KthLargest(int k, int[] nums) {
        this.nums = new int[k + 2];
        for (var n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        currSize += 1;
        nums[currSize] = val;
        int i = currSize;

        while (i / 2 > 0 && nums[i] < nums[i / 2]) {
            int tmp = nums[i];
            nums[i] = nums[i / 2];
            nums[i / 2] = tmp;
            i = i / 2;
        }

        if (currSize == nums.length - 1) {
            pop();
        }

        return currSize == 0 ? 0 : nums[1];
    }


    private void pop() {
        if (currSize == 0) { 
            return;
        }

        int i = 1;
        nums[i] = nums[currSize];
        nums[currSize] = 0;
        currSize -= 1;

        while (i * 2 <= currSize) {

            if (i * 2 + 1 <= currSize &&
                nums[i * 2 + 1] < nums[i * 2] &&
                nums[i * 2 + 1] < nums[i]) {

                int tmp = nums[i];
                nums[i] = nums[i * 2 + 1];
                nums[i * 2 + 1] = tmp;
                i = i * 2 + 1;

            } else if (nums[i * 2] < nums[i]) {
                
                int tmp = nums[i];
                nums[i] = nums[i * 2];
                nums[i * 2] = tmp;
                i = i * 2;

            } else {
                break;
            }
        }
    }
}
