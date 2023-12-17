import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Book{
    private String title;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }
    //getter
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }

}
class Member{
    private String member;
    public Member(String member){
        this.member = member;
    }
    //getter
    public String getMember(){
        return this.member;
    }
}
class Staff{
    private String staff;
    public Staff(String staff){
        this.staff = staff;
    }
    //getter
    public String getStaff(){
        return this.staff;
    }
}
class Library{
    private List<Book> books;
    private List<Member> members;
    private List<Staff> staffs;
    private List<Book> borrowedBooks;

    public Library(){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.staffs = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
    }
    //adding book
    void addBook(String title, String author){
        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println(newBook.getTitle() + " by " + newBook.getAuthor() + " was successfully added");
    }
    //removing book
    void removeBook(Book book){
        books.remove(book);
        borrowedBooks.remove(book);
        System.out.println(book.getTitle() + book.getAuthor() + " was successfully removed");
    }
    //adding member
    void addMember(String member){
        Member newMember = new Member(member);
        members.add(newMember);
        System.out.println(newMember.getMember() + " was successfully added to member");
    }
    //removing member
    void removeMember(Member member){
        members.remove(member);
        System.out.println(member.getMember() + " was successfully removed");
    }
    //adding staff
    void addStaff(String staff){
        Staff newStaff = new Staff(staff);
        staffs.add(newStaff);
        System.out.println(newStaff.getStaff() + " was successfully added to staff");
    }
    //removing staff
    void removeStaff(Staff staff){
        staffs.remove(staff);
        System.out.println(staff.getStaff() + " was successfully removed");
    }
    //lend book
    void lendBook(Member member, Book book){
        borrowedBooks.add(book);
        System.out.println(book.getTitle() + " was borrowed by " + member.getMember() );
    }
    
    //returning book
    void returnBook(Book book){
        borrowedBooks.remove(book);
        System.out.println(book.getTitle() + " was returned");
    }
    //track borrowed books
    void trackBorrowedBooks(){
        System.out.println("Borrowed books : ");
        for (Book book : borrowedBooks){
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
    //show added books
    void displayBook(){
        System.out.println("Added book : ");
        for (Book book : books){
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
    //show member
    void displayMember(){
        System.out.println("Added member : ");
        for (Member member : members){
            System.out.println(member.getMember());
        }
    }
    //show staff
    void displayStaff(){
        System.out.println("Added staff : ");
        for (Staff staff : staffs){
            System.out.println(staff.getStaff());
        }
    }
    //get book to search
    public Book getBookByTitle(String titleToSearch){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(titleToSearch)){
                return book;
            }
        }
        return null;
    }
    //get member to search
    public Member getMemberToSearch(String memberToSearch){
        for (Member member : members){
            if (member.getMember().equalsIgnoreCase(memberToSearch)){
                return member;
            }
        }
        return null;
    }
    //get staff to search
    public Staff getStaffToSearch(String staffToSearch){
        for (Staff staff : staffs){
            if (staff.getStaff().equalsIgnoreCase(staffToSearch)){
                return staff;
            }
        }
        return null;
    }

}


public class Main{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Library library = new Library();

            boolean exit = false;
            while(!exit){
                System.out.println("\nOption : ");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Add Member");
                System.out.println("4. Remove Member");
                System.out.println("5. Add Staff");
                System.out.println("6. Remove Staff");
                System.out.println("7. Borrow Book");
                System.out.println("8. Return Book");
                System.out.println("9. track borrowed books");
                System.out.println("10. Show Added Books");
                System.out.println("11. Show Registered Member");
                System.out.println("12. Show Registered Staff");
                System.out.println("0. Exit");
    
            System.out.println("Select Option : ");
            int option = scanner.nextInt();
            scanner.nextLine();
  
            switch (option) {
                case 1:
                    System.out.println("Enter book title : ");
                    String bookTitle = scanner.nextLine().trim();
                    System.out.println("Enter book author : ");
                    String bookAuthor = scanner.nextLine().trim();
                    library.addBook(bookTitle, bookAuthor);
                    break;
                    case 2:
                    System.out.println("Enter the title of the book you want to delete : ");
                    String titleToRemove = scanner.nextLine().trim();
                    Book bookToRemove = library.getBookByTitle(titleToRemove);
                    if (bookToRemove != null){
                        library.removeBook(bookToRemove);
                    }else{
                        System.out.println("Book is not found");
                    }
                    break;
                case 3:
                    System.out.println("Enter member to add : ");
                    String newMember = scanner.nextLine().trim();
                    library.addMember(newMember);
                    break;
                case 4:
                    System.out.println("Enter to remove : ");
                    String memberNameToRemove = scanner.nextLine().trim();
                    Member memberToRemove = library.getMemberToSearch(memberNameToRemove);
                    if (memberToRemove != null){
                        library.removeMember(memberToRemove);
                    }else{
                        System.out.println("Member is not found");
                    }
                    break;
                case 5:
                    System.out.println("Enter staff to add : ");
                    String newStaff = scanner.nextLine();
                    library.addStaff(newStaff);
                    break;
                case 6:
                    System.out.println("Enter staff to remove : ");
                    String staffNameToRemove = scanner.nextLine().trim();
                    Staff staffToRemove = library.getStaffToSearch(staffNameToRemove);
                    if (staffToRemove != null){
                        library.removeStaff(staffToRemove);
                    }else{
                        System.out.println("Staff is not found");
                    }
                    break;
                case 7:
                    System.out.println("Enter member: ");
                    String memberToBorrow = scanner.nextLine().trim();
                    System.out.println("Enter book to borrow: ");
                    String bookToBorrowTitle = scanner.nextLine().trim();
                    Member borrower = library.getMemberToSearch(memberToBorrow);
                    if (borrower != null) {
                        Book bookToBorrow = library.getBookByTitle(bookToBorrowTitle);
                        if (bookToBorrow != null) {
                            library.lendBook(borrower, bookToBorrow);
                        } else {
                            System.out.println("Book not found");
                        }
                    } else {
                        System.out.println("Member not found");
                    }
                    break;  
                case 8:
                    System.out.println("Enter book to return: ");
                    String bookToReturnTitle = scanner.nextLine().trim();
                    Book bookToReturn = library.getBookByTitle(bookToReturnTitle);
                    if (bookToReturn != null) {
                        library.returnBook(bookToReturn);
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                    
                case 9:
                    library.trackBorrowedBooks();
                    break;
                case 10:
                    library.displayBook();
                    break;
                case 11:
                    library.displayMember();
                    break;
                case 12:
                    library.displayStaff();
                    break;
                case 0:
                    System.out.println("Exit successed");
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong choise");
                    break;
            }

        }
        }
    }

}