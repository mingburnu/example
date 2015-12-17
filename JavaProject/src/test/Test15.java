package test;

public class Test15 {  
    static{  
        System.out.println("Test类被初始化了");  
    }  
    public void testClass() throws Exception, Exception{  
        this.getClass();  
    }  
      
    public void shuChu(){  
        System.out.println("本类的Class对象");  
    }  
      
    public static void main(String[] args) throws Exception {  
        Test15 t = new Test15();  
        t.testClass();
    }  
}  