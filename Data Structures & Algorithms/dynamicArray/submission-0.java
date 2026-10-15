class DynamicArray {

    private int length = 0;
    private int capacity;
    private int[] array;

    public DynamicArray(int capacity) {
       this.capacity = capacity;
       this.array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (length >= capacity) {
            this.resize();
        }
        this.array[length++] = n;
    }

    public int popback() {
        int res = array[length - 1];
        array[--length] = 0;
        return res;
    }

    private void resize() {
        capacity *= 2;
        int[] new_array = new int[capacity];
        for (int i = 0; i < length; ++i) {
            new_array[i] = array[i];
        }
        array = new_array;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
