package AdvanceJDBC;

class EmpRec {
	private String empno;
	private double salary;
	public EmpRec(String empno, double salary) {
		this.empno = empno;
		this.salary = salary;
	}
	public String getEmpNo() { return empno; }
	public double getSalary() { return salary; }
}// end of class EmpRec