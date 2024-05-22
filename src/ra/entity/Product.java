package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    //1. Propertis
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String description;
    private boolean status;

    //2. Constructors
    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String description, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
    }

    //3. Methods

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProducts, int currentIndex) {
        this.productId = inputProductId(scanner, arrProducts, currentIndex);
        this.productName = inputProductName(scanner, arrProducts, currentIndex);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.quantity = inputQuantity(scanner);
        this.description = inputDescription(scanner);
        this.status = inputStatus(scanner);
    }

    

    public String inputProductId(Scanner scanner, Product[] arrProducts, int currentIndex) {
        System.out.println("Nhập vào mã sản phẩm:");
        do {
            String productId = scanner.nextLine();
            String productIdRegex = "[\\w]{4}";
            if (Pattern.matches(productIdRegex, productId)) {
                //DUy nhất
                boolean isExist = checkUnique(productId, arrProducts, currentIndex, "productId");
                if (isExist) {
                    System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại");
                } else {
                    return productId;
                }
            } else {
                System.err.println("Mã sản phẩm phải gồm 4 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public boolean checkUnique(String strCheck, Product[] arrProducts, int currentIndex, String attName) {
        for (int i = 0; i < currentIndex; i++) {
            switch (attName) {
                case "productId":
                    if (arrProducts[i].getProductId().equals(strCheck)) {
                        return true;
                    }
                    break;
                case "productName":
                    if (arrProducts[i].getProductName().equals(strCheck)) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public String inputProductName(Scanner scanner, Product[] arrProducts, int currentIndex) {
        System.out.println("Nhập vào tên sản phẩm:");
        do {
            String productName = scanner.nextLine();
            if (productName.length() >= 6 && productName.length() <= 50) {
                //Duy nhất
                boolean isExist = checkUnique(productName, arrProducts, currentIndex, "productName");
                if (isExist) {
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
                } else {
                    return productName;
                }
            } else {
                System.err.println("Tên sản phẩm có từ 6-50 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        System.out.println("Nhập vào giá nhập sản phẩm:");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá nhập phải có giá trị lớn hơn 0, vui lòng nhập lại");
            }
        } while (true);
    }

    public float inputExportPrice(Scanner scanner) {
        System.out.println("Nhập vào giá xuất sản phẩm:");
        do {
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice >= 1.3F * this.importPrice) {
                return exportPrice;
            } else {
                System.err.println("Giá xuất phải có giá trị lớn hơn ít nhất 30% giá nhập, vui lòng nhập lại");
            }
        } while (true);
    }

    public int inputQuantity(Scanner scanner) {
        System.out.println("Nhập vào số lượng sản phẩm:");
        do {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity > 0) {
                return quantity;
            } else {
                System.err.println("Số lượng sản phẩm phải lớn hơn 0, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputDescription(Scanner scanner) {
        System.out.println("Nhập vào mô tả sản phẩm:");
        return scanner.nextLine();
    }

    public boolean inputStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái sản phẩm:");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.printf("Produt ID: %s - Product Name: %s - Import Price: %.2f - Export Price: %.2f\n", this.productId, this.productName, this.importPrice, this.exportPrice);
        System.out.printf("Profit: %.2f - Quantity: %d - Description: %s - Status: %s\n", this.profit, this.quantity, this.description, this.status ? "Đang bán" : "Không bán");
    }

    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }
}
