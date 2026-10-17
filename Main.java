import java.util.Scanner;

class Staff {
    protected String staffNo;
    protected String staffName;
    protected int staffAge;

    public Staff(String staffNo, String staffName, int staffAge) {
        this.staffNo = staffNo;
        this.staffName = staffName;
        this.staffAge = staffAge;
    }

    public void printDetails() {
        System.out.println("Staff Number : " + staffNo);
        System.out.println("Staff Name   : " + staffName);
        System.out.println("Staff Age    : " + staffAge);
    }
}

class FullTimeStaff extends Staff {
    private double basicSalary;
    private double statutoryDeductions;

    public FullTimeStaff(String staffNo, String staffName, int staffAge, double basicSalary, double statutoryDeductions) {
        super(staffNo, staffName, staffAge);
        this.basicSalary = basicSalary;
        this.statutoryDeductions = statutoryDeductions;
    }

    public double calculateNetPay() {
        return basicSalary - statutoryDeductions;
    }


    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Monthly Net Pay: $" + calculateNetPay());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Enter Full-Time Staff Details ===");
        System.out.print("Enter Staff No: ");
        String no = scanner.nextLine();

        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Staff Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Monthly Basic Salary: ");
        double basic = scanner.nextDouble();

        System.out.print("Enter Statutory Deductions: ");
        double deductions = scanner.nextDouble();

        FullTimeStaff ftStaff = new FullTimeStaff(no, name, age, basic, deductions);

        System.out.println("\n--- Full-Time Staff Payslip ---");
        ftStaff.printDetails();

        scanner.close();
    }
}

class PartTimeStaff extends Staff {
    private int hoursWorked;

    public static final double RATE_PER_HOUR = 10.0;

    public PartTimeStaff(String staffNo, String staffName, int staffAge, int hoursWorked) {
        super(staffNo, staffName, staffAge);
        this.hoursWorked = hoursWorked;
    }

    public double calculateNetPay() {
        double totalPay = hoursWorked * RATE_PER_HOUR;
        double tax = totalPay * 0.30;
        return totalPay - tax;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Monthly Net Pay: $" + calculateNetPay());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Enter Part-Time Staff Details ===");
        System.out.print("Enter Staff No: ");
        String no = scanner.nextLine();

        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Staff Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Number of Hours Worked: ");
        int hours = scanner.nextInt();

        PartTimeStaff ptStaff = new PartTimeStaff(no, name, age, hours);

        System.out.println("\n--- Part-Time Staff Payslip ---");
        ptStaff.printDetails();

        scanner.close();
    }
}