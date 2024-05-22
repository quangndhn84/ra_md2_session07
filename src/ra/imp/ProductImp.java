package ra.imp;

import ra.entity.Product;

import java.util.Scanner;

public class ProductImp {
    Product[] arrProducts = new Product[100];
    int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductImp productImp = new ProductImp();
        do {
            System.out.println("**************MENU**************");
            System.out.println("1. Nhập thông tin n sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phâm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productImp.inputListProduct(scanner);
                    break;
                case 2:
                    productImp.displayListProduct();
                    break;
                case 3:
                    productImp.calProfitOfProduct();
                    break;
                case 4:
                    productImp.sortProductByProfit();
                    break;
                case 5:
                    productImp.staticticProductByPrice(scanner);
                    break;
                case 6:
                    productImp.searchProductByName(scanner);
                    break;
                case 7:
                    productImp.importProduct(scanner);
                    break;
                case 8:
                    productImp.exportProduct(scanner);
                    break;
                case 9:
                    productImp.updateProductStatus(scanner);
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-10");

            }
        } while (true);
    }

    public void inputListProduct(Scanner scanner) {
        System.out.println("Nhập vào số lượng sản phẩm cần nhập thông tin:");
        int numberOfProducts = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfProducts; i++) {
            arrProducts[currentIndex] = new Product();
            arrProducts[currentIndex].inputData(scanner, arrProducts, currentIndex);
            currentIndex++;
        }
    }

    public void displayListProduct() {
        System.out.println("DANH SÁCH CÁC SẢN PHẨM:");
        for (int i = 0; i < currentIndex; i++) {
            arrProducts[i].displayData();
        }
    }

    public void calProfitOfProduct() {
        for (int i = 0; i < currentIndex; i++) {
            arrProducts[i].calProfit();
        }
        System.out.println("Đã tính xong lợi nhuận cho tất cả sản phẩm");
    }

    public void sortProductByProfit() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrProducts[i].getProfit() < arrProducts[j].getProfit()) {
                    Product temp = arrProducts[i];
                    arrProducts[i] = arrProducts[j];
                    arrProducts[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp các sản phẩm giảm dần theo lợi nhuận");
    }

    public void staticticProductByPrice(Scanner scanner) {
        do {
            System.out.println("Nhập vào giá thống kê bắt đầu:");
            float formPrice = Float.parseFloat(scanner.nextLine());
            System.out.println("Nhập vào giá thống kê kết thúc:");
            float toPrice = Float.parseFloat(scanner.nextLine());
            if (formPrice <= toPrice) {
                //Thống kê theo giá bán
                int cntProduct = 0;
                System.out.printf("THÔNG TIN SẢN PHẨM TRONG KHOẢNG GIÁ TỪ %.2f ĐẾN %.2f:\n", formPrice, toPrice);
                for (int i = 0; i < currentIndex; i++) {
                    if (arrProducts[i].getExportPrice() >= formPrice && arrProducts[i].getExportPrice() <= toPrice) {
                        arrProducts[i].displayData();
                        cntProduct++;
                    }
                }
                System.out.printf("CÓ %d SẢN PHẨM TRONG KHOẢNG GIÁ TÌM KIẾM\n", cntProduct);

            }
        } while (true);
    }

    public void searchProductByName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm cần tìm:");
        String productNameSearch = scanner.nextLine();
        //Tìm gần đúng
        System.out.println("KẾT QUẢ TÌM KIẾM:");
        for (int i = 0; i < currentIndex; i++) {
            if (arrProducts[i].getProductName().toLowerCase().contains(productNameSearch.toLowerCase())) {
                arrProducts[i].displayData();
            }
        }
    }

    public void importProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần nhập:");
        String productId = scanner.nextLine();
        int indexImport = getIndexByIdOrName(productId, "productId");
        if (indexImport >= 0) {
            //Đã tồn tại --> cộng vào quantity
            System.out.println("Nhập vào số lượng sản phẩm cần nhập:");
            int quantity = Integer.parseInt(scanner.nextLine());
            arrProducts[indexImport].setQuantity(arrProducts[indexImport].getQuantity() + quantity);
        } else {
            //Chưa tồn tại sản phẩm
            System.out.println("Sản phẩm chưa tồn tại, nhập sản phẩm mới");
            arrProducts[currentIndex] = new Product();
            arrProducts[currentIndex].inputData(scanner, arrProducts, currentIndex);
            currentIndex++;
        }
    }

    public int getIndexByIdOrName(String strSearch, String strName) {
        for (int i = 0; i < currentIndex; i++) {
            switch (strName) {
                case "productId":
                    if (arrProducts[i].getProductId().equals(strSearch)) {
                        return i;
                    }
                    break;
                case "productName":
                    if (arrProducts[i].getProductName().equals(strSearch)) {
                        return i;
                    }
                    break;
            }
        }
        return -1;
    }

    public void exportProduct(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm cần bán:");
        String productName = scanner.nextLine();
        int indexExport = getIndexByIdOrName(productName, "productName");
        if (indexExport >= 0) {
            System.out.println("Nhập vào số lượng cần bán:");
            int quantity = Integer.parseInt(scanner.nextLine());
            if (arrProducts[indexExport].getQuantity() >= quantity) {
                arrProducts[indexExport].setQuantity(arrProducts[indexExport].getQuantity() - quantity);
            } else {
                System.err.println("Số lượng sản phẩm không đủ để bán");
            }
        } else {
            System.err.println("Tên sản phẩm không tồn tại");
        }
    }

    public void updateProductStatus(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần cập nhật trạng thái:");
        String productId = scanner.nextLine();
        int indexUpdate = getIndexByIdOrName(productId, "productId");
        if (indexUpdate >= 0) {
            arrProducts[indexUpdate].setStatus(!arrProducts[indexUpdate].isStatus());
        } else {
            System.err.println("Mã sản phẩm không tồn tại");
        }
    }


}
