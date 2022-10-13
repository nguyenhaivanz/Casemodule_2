package validate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    private static final String USERNAME_REGEX = "^(?=.*[a-z])(?=.*[0-9]).{8,12}$";
    private static final String PASS_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$]).{8,16}$";
    private static final String PHONE_REGEX = "^[(](\\+84)[)][-][0-9]{9,}$";
    private static final String NAME_REGEX = "[A-Z][A-Za-z]+";
    private static final String ADDRESS_REGEX = "[A-Za-z0-9]+";
    private static final String AGE_REGEX = "18|(^[2-9][0-9])";


    private Scanner scanner = new Scanner(System.in);

    public String UserName() {
        while (true) {
            System.out.println("[Lưu ý]:Tài khoản phải từ 8 - 12 ký tự (a,1,...)");
            System.out.print("Nhập tên tài khoản: ");
            String account = scanner.nextLine();
            Pattern pattern = Pattern.compile(USERNAME_REGEX);
            Matcher matcher = pattern.matcher(account);
            if (matcher.matches()) {
                return account;
            }
            System.err.println("Tài khoản không hợp lệ");

        }
    }

    public String PassWord() {
        while (true) {
            System.out.println("[Lưu ý]: Mật khẩu phải từ 8 - 16 ký tự (a,A,1,...) bao gồm 1 ký tự đặc biệt (@,#,$)");
            System.out.print("Nhập password: ");
            String password = scanner.nextLine();
            Pattern pattern = Pattern.compile(PASS_REGEX);
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                return password;
            }
            System.err.println("Mật khẩu không hợp lệ");
        }
    }

    public String PhoneNumber() {
        while (true) {
            System.out.println("[LưuA ý]: Số điện thoại phải có 10 số (0 - 9) định dạng: (+84)-911112222");
            System.out.print("Nhập số điện thoại: ");
            String phone = scanner.nextLine();
            Pattern pattern = Pattern.compile(PHONE_REGEX);
            Matcher matcher = pattern.matcher(phone);
            if (matcher.matches()) {
                return phone;
            }
            System.err.println("Số điện thoại không hợp lệ");
        }
    }

    public String Name() {
        while (true) {
            System.out.println(">[Chú ý]: Tên chữ cái đầu phải viết hoa");
            System.out.print("┠ ▹ Nhập tên: ");
            String name = scanner.nextLine();
            Pattern pattern = Pattern.compile(NAME_REGEX);
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()) {
                return name;
            }
            System.err.println("Tên không hợp lệ !!!");
        }
    }
    public  String gender(){
        System.out.println("1.Nam");
        System.out.println("2.Nữ");
        System.out.println("Nhập lựa chọn của bạn");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                return "Nam";
            case 2:
                return "Nữ";
            default:
                return "vui lòng chọn lại";

        }
    }



    public String Address(){
        while (true){
            System.out.println(">[Chú ý]: Địa chỉ không thê ký tự đặc biệt");
            System.out.print("┠ ▹ Nhập địa chỉ: ");
            String address = scanner.nextLine();
            Pattern pattern = Pattern.compile(ADDRESS_REGEX);
            Matcher matcher = pattern.matcher(address);
            if (matcher.matches()){
                return address;
            }
            System.err.println("⛔ Địa chỉ không hợp lệ !!!");
        }
    }


    public String Age() {
        while (true) {
            System.out.println(">[Chú ý]: Tuổi từ 18 ");
            System.out.print("┠ ▹ Nhập tuổi: ");
            String age = scanner.nextLine();
            Pattern pattern = Pattern.compile(AGE_REGEX);
            Matcher matcher = pattern.matcher(age);
            if (matcher.matches()) {
                return age;
            }
            System.err.println("Tuổi không hợp lệ !!!");
        }
    }
}
