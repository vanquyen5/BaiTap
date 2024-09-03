package baitap;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;

public class BaiTap {

    public static ArrayList<Integer> EnterData(ArrayList<Integer> numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("So luong phan tu cua mang: ");
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("numbers[ " + i + "]=");
            int value = scanner.nextInt();
            numbers.add(value);
        }
        return numbers;
    }

    public static void DisplayData(ArrayList<Integer> numbers) {
        System.out.println("numbers[]=" + Arrays.toString(numbers.toArray()));
    }
     public static Integer FindMax2(ArrayList<Integer> numbers) {
        if (numbers.size() < 2) {
            System.out.println("Danh sach phai co 2 phan tu.");
            return null;
        }

        Integer max1 = null;
        Integer max2 = null;

        for (Integer number : numbers) {
            if (max1 == null || number > max1) {
                max2 = max1;
                max1 = number;
            } else if (number < max1 && (max2 == null || number > max2)) {
                max2 = number;
            }
        }

        if (max2 == null) {
            System.out.println("Khong tim thay gia tri lon thu 2.");
        }

        return max2;
    }
     public static void DeleteOddNums(ArrayList<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 != 0) {
                iterator.remove();
            }
        }
        System.out.println("Đã xóa các phần tử lẻ.");
    }
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int Max2;
        String check;
        do {
            System.out.println("Chon tac vu!!");
            System.out.println("1. Nhap du lieu");
            System.out.println("2. Xuat du lieu");
            System.out.println("3. Tim Max2");
            System.out.println("4. Xoa phan tu le");
            int choosion = Integer.parseInt(scanner.nextLine());
            switch (choosion) {
                case 1:
                    numbers = BaiTap.EnterData(numbers);
                    break;
                case 2:
                    BaiTap.DisplayData(numbers);
                    break;
                case 3:
                    Max2=BaiTap.FindMax2(numbers);
                    System.out.println("Gia tri lon thu 2 trong mang la: "+Max2);
                    break;
                case 4:
                    BaiTap.DeleteOddNums(numbers);
                    BaiTap.DisplayData(numbers);
                    break;
                default:
                    System.out.println("Lia chon khong hop le!");
            }
            System.out.println("Nhap yes de tiep tuc chuong trinh!");
            check = scanner.nextLine();
        } while (check.equals("yes"));
    }

}
