package dominio;

import java.util.Arrays;

public class Aritmeticas {
    private double[] nums;

    public Aritmeticas() {}

    public Aritmeticas(double[] nums){
        this.nums = nums;
    }

    public double[] getNums() {
        return nums;
    }

    public void setNums(double[] nums) {
        this.nums = nums;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Aritmeticas that = (Aritmeticas) o;
        return Arrays.equals(nums, that.nums);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(nums);
    }
}
