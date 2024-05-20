/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.nhathuy.mathutil.test.core;

import com.nhathuy.mathutil.core.MathUtil;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

/**
 *
 * @author huypd
 */
public class MathUtilityTest {

    public MathUtilityTest() {

    }
    //đây là class sẽ sử dụng các hàm của thư viện/framework JUnit
    //để kiểm thử/kiểm tra/verify code chính - hàm getFactorial() bên
    //class core.MathUtil
    //viết code để test code chính bên kia

    //có nhiều quy tắc đặt tên hàm kiểm thử
    //nhưng thường sẽ là nói lên mục đích của các case/tình huống kiểm thử
    //tình huống xài hàm theo kiểu thành công và thất bại!!!
    //hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
    //ta sẽ xài hàm kiểu well
    //@Test JUnit sẽ phối hợp với JVM để chạy hàm này
    //@Test phía hậu trường chính là psvm - public static void main()
    //Có nhiều @Test ứng với nhiều case khác nhau để kiểm thử hàm tính giai thừa
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0; //test thử tình huống tử tế đầu vào, mày phải chạy đúng
        long expected = 1;
        //long actual = ; //gọi hàm cần test bên core/app chính/code chính
        long actual = MathUtil.getFactorial(n);

        //so sánh expected vs. actual dùng xanh xanh đỏ đỏ, framework
        assertEquals(expected, actual);
        //hàm giúp so sánh 2 giá trị nào đó có giống nhau hay không
        //nếu giống nhau --> thảy màu xanh đèn đường - đường thông, code thông
        //                          ít nhất cho cái case đang test
        //nếu ko giống nhau --> thảy màu đỏ đèn đường, expected và actual ko giống nhau

        //gộp thêm vài case thành công/đưa đầu vào ngon, hàm phải tính ngon
    }

    //hàm getF() ta thiết kế có 2 tình huống xử lí
    //1. đưa data tử tế trong [0...20] -> tính đúng đc n! - done
    //2. đưa data vào cà chớn, âm, > 20; THIẾT KẾ CỦA HÀM LÀ NÉM RA NGOẠI LỆ
    //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N < 0 || N > 20
    //rất mong ngoại lệ xuất hiện với n cà chớn này
    //nếu hàm nhận vào n < 0 hoặc n > 20 và hàm ném ra ngoại lệ
    //HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ -> XANH PHẢI XUẤT HIỆN
    //nếu hàm nhận vào n < 0 hoặc n > 20 và hàm éo ném ra ngoại lệ
    //HÀM SAI MẸ RỒI
    //Test case:
    //input: -5
    //expected: IllegalArgumentException xuất hiện
    //tình huống bất thường, ngoại lệ, ngoài dự tính, dự liệu
    //là những thứ ko thể đo lường so sánh theo kiểu value
    //mà chỉ có thể đo lường bằng cách chúng có xuất hiện hay ko
    //assertEquals() ko dùng để so sánh 2 ngoại lệ
    //      equals() là bằng nhau hay ko trên value!!!
    //MÀU ĐỎ ĐÓ EM, DO HÀM ĐÚNG LÀ CÓ NÉM NGOẠI LỆ THẤT SỰ
    //              NHƯNG KO PHẢI LÀ NGOẠI LỆ NHƯ KỲ VỌNG - THỰC SỰ KỲ VỌNG SAI
    //              KO PHẢI HÀM NÉM SAI
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsException() {
//        MathUtil.getFactorial(-5); //hàm @Test chạy, hay hàm getF() chạy
//                                   //sẽ ném về ngoại lệ NumberFormatException
//                                   
//    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5); //hàm @Test chạy, hay hàm getF() chạy
        //sẽ ném về ngoại lệ IllegalArgumentException

    }

    //cách khác để bắt ngoại lệ xuất hiện, viết tự nhiên hơn!!!
    //xài Lambda
    //Test case: hàm sẽ ném về ngoại lệ nếu nhận vào 21
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_LambdaVersion() {
        //Assert.assertThrows(tham số 1: loại ngoại lệ muốn so sánh, 
        //                    tham số 2: đoạn code chạy văng ra ngoại lệ runable);
        assertThrows(IllegalArgumentException.class,
                () -> MathUtil.getFactorial(-5));

        //MathUtil.getFactorial(-5); //hàm @Test chạy, hay hàm getF() chạy
        //sẽ ném về ngoại lệ IllegalArgumentException
    }

    //Bắt ngoại lệ, xem hàm có ném về ngoại lệ hay ko khi n cà chớn
    //có ném, tức là hàm chạy đúng thiết kế -> xanh
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_TryCatch() {
        //chủ động kiểm soát ngoại lệ!!!
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //bắt try-catch là JUnit sẽ ra xanh do đã chủ động kiểm soát ngoại lệ
            //nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko???
            //có đoạn code kiểm soát ngoại lệ IllegalArgumentException
            assertEquals("Invalid argument. N must be between 0...20", 
                            e.getMessage());
        }
        
        //Exception e, trong e có từa lưa thông tin, mình có thể chấm để lấy...

    }

}
