interface DiscountRate {
    double getServiceDiscountRate();
    double getProductDiscountRate();
}

class Customer implements DiscountRate {
    private String customerName;
    private String customerType;

    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }


    public double getServiceDiscountRate() {
        switch (customerType) {
            case "Premium":
                return 0.20;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }

    
    public double getProductDiscountRate() {
        switch (customerType) {
            case "Premium":
                return 0.10;
            case "Gold":
                return 0.10;
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }
}

class Sale {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
        this.serviceExpense = 0.0;
        this.productExpense = 0.0;
    }

    public String getDate() {
        return date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double totalServiceExpense = serviceExpense * (1 - customer.getServiceDiscountRate());
        double totalProductExpense = productExpense * (1 - customer.getProductDiscountRate());
        return totalServiceExpense + totalProductExpense;
    }

    public void displayInfo() {
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Date: " + date);
        System.out.println("Total Expense: $" + getTotalExpense());
    }
}

public class Main {
    public static void main(String[] args) {
        Customer premiumCustomer = new Customer("Sok mean", "Premium");
        Sale sale = new Sale(premiumCustomer, "2024-02-19");
        sale.setServiceExpense(100);
        sale.setProductExpense(50);

        sale.displayInfo();
    }
}
