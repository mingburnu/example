package test;

class Statics {
	double pi = 3.14;
}

public class Test1 {
	public static void main(String[] args) {
		Statics abc = new Statics();
		abc.pi=3.14;
		System.out.println(+ abc.pi);
	}

}
/*
 * [�׹��r] class Class�W�� {
 * 
 * [�׹��r] type �ݩʦW�� [ = value ];
 * 
 * [�׹��r] type ��k�W��([type1 �Ѽ�1, type2 �Ѽ�2, ...]) { //�{���޿� return ��ƭ� or �ܼƦW��; }
 * 
 * [�׹��r] Class�W��([type1 �Ѽ�1, type2 �Ѽ�2, ...]) { //�{���޿� } }
 * 
 * =================================================================== type name
 * = value;
 * 
 * �I�s�غc�l���y�k Class�W�� class1 = new Class�W��([value1, value2, ....]);
 * 
 * �I�s��k���y�k type ���浲�G = ����Ѧ��ܼ�.��k�W��([value1, value2, ....]);
 */
