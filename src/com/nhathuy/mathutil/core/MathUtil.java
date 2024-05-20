/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhathuy.mathutil.core;

/**
 *
 * @author huypd
 */
public class MathUtil {
    //trong class này cung cấp cho ai đó nhiều hàm xử lí toán học
    //clone class Math của JDK
    //hàm thư viện xài chung cho ai đó, ko cần lưu lại trạng thái/giá trị
    //chọn thiết kế là hàm static
    
    //hàm tính giai thừa!!!
    //n! = 1.2.3.4... n
    //ko có giai thừa cho số âm
    //0! = 1! =- 1 quy ước
    //giai thừa hàm đồ thị dốc đứng, tăng nhanh về giá trị
    //20! chứa 18 con số 9, vừa kịp đủ cho kiểu long của Java
    //21! tràn kiểu LONG
    //bài này quy ước tính n! trong khoảng từ 0...20
    public static long getFactorial(int n) {
        if (n < 0 || n > 20)
            throw new IllegalArgumentException("Invalid argument. N must be between 0...20");
        if (n == 0 || n == 1)
            return 1; //kết thúc cuộc chơi sớm nếu nhận những đầu vào đặc biệt
        long product = 1;
        for (int i = 2; i <= n; i++) 
            product *= i;
        return product;
    }
}
