package test;

class XXXX {
	int x=5;
	int y=10;
	public int ListMethod() {
		return x*y;
	}
}

public class TestMethod {

	public static void main(String[] args) {
XXXX XYZ= new XXXX();
XYZ.ListMethod();
XXXX ABC= new XXXX();
ABC.y=20;
	System.out.println(XYZ.ListMethod());
	System.out.println(ABC.y);
	}

}
/*
 * [修飾字] class Class名稱 {
 * 
 * [修飾字] type 屬性名稱 [ = value ];
 * 
 * [修飾字] type 方法名稱([type1 參數1, type2 參數2, ...]) { //程式邏輯 return 資料值 or 變數名稱; }
 * 
 * [修飾字] Class名稱([type1 參數1, type2 參數2, ...]) { //程式邏輯 } }
 * 
 * =================================================================== type name
 * = value;
 * 
 * 呼叫建構子的語法 Class名稱 class1 = new Class名稱([value1, value2, ....]);
 * 
 * 呼叫方法的語法 type 執行結果 = 物件參考變數.方法名稱([value1, value2, ....]);
 */
