package tw.leonchen.oop.array;

public class SafeArray { 
    private int[] arr; 
 
    public SafeArray() { 
        this(10); 
    }
 
    public SafeArray(int length) { 
        arr = new int[length]; 
    }
 
    public int[] getArray() {
        return arr;
    }
 
    public int getElement(int i) { 
        if(i >= arr.length || i < 0) { 
            System.err.println("索引錯誤"); 
            return 0; 
        } 
 
        return arr[i]; 
    }
 
    public int getLength() { 
        return arr.length; 
    }
 
    public void setElement(int i, int data) { 
        if(i >= arr.length || i < 0) { 
            System.err.println("索引錯誤"); 
            return; 
        }
 
        arr[i] = data; 
    } 


 
    public static void main(String[] args) { 
        // 預設10個元素 
        SafeArray arr1 = new SafeArray();  
         // 指定配置20個元素 
        SafeArray arr2 = new SafeArray(20);
 
        for(int i = 0; i < arr1.getLength(); i++) 
            arr1.setElement(i, (i+1)*10);

        for(int i = 0; i < arr2.getLength(); i++) 
            arr2.setElement(i, (i+1)*10);

        for(int element : arr1.getArray())
            System.out.print(element + " "); 
        System.out.println(); 

        for(int element : arr2.getArray())
            System.out.print(element + " "); 
        System.out.println(); 
    }
 }