package methodTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;

import dao.BookDAO;
import bean.Book;

public class InsertTest {

	private WebDriver driver;

	public InsertTest(WebDriver driver) {
		this.driver = driver;
	}


	public void MoveInsertPage() {
		try {
			driver.findElement(By.linkText("【書籍登録】")).click();
		} catch (NoSuchElementException e) {
			try {
				driver.findElement(By.linkText("書籍登録")).click();
			} catch (NoSuchElementException f) {
				driver.findElement(By.linkText("【一覧表示に戻る】")).click();
				driver.findElement(By.linkText("書籍登録")).click();
			}
		}
	}

	// 正常処理
	// 正常に書籍を新規登録できるか
	public void Insert201() {

		// 書籍登録画面まで遷移する
		MoveInsertPage();

		// まだ登録されていないISBNを探す
		Book book;
		BookDAO bookdao = new BookDAO();
		String isbn = "";
		for (int i = 0; i < 10000; i++) {
			isbn = String.format("%5s", i).replace(" ", "0");
			book = bookdao.selectByIsbn(isbn);
			if (book.getIsbn() == null) {
				break;
			}
		}

		// ISBN入力
		WebElement inputIsbn = driver.findElement(By.name("isbn"));
		inputIsbn.sendKeys(isbn);

		// タイトル入力
		WebElement inputTitle = driver.findElement(By.name("title"));
		inputTitle.sendKeys("WebアプリケーションTEST");

		// 価格入力
		WebElement inputPrice = driver.findElement(By.name("price"));
		inputPrice.sendKeys("1000");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();
	}

	// 異常処理
	// 既存のISBNで登録したときエラーがでるか
	public void InsertExistingIsbn() {

		// 書籍登録画面まで遷移する
		MoveInsertPage();

		BookDAO bookdao = new BookDAO();
		ArrayList<Book> book_list = bookdao.selectAll();

		// 既に登録されているISBNを入力
		String isbn = book_list.get(1).getIsbn();
		WebElement inputIsbn = driver.findElement(By.name("isbn"));
		inputIsbn.sendKeys(isbn);

		// タイトル入力
		WebElement inputTitle = driver.findElement(By.name("title"));
		inputTitle.sendKeys("WebアプリケーションTEST");

		// 価格入力
		WebElement inputPrice = driver.findElement(By.name("price"));
		inputPrice.sendKeys("1000");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();
	}

	// ISBNを未入力で登録した場合エラーが出るか
	public void InsertEmptyIsbn() {

		// 書籍登録画面まで遷移する
		MoveInsertPage();

		// ISBNを未入力にする
		WebElement inputIsbn = driver.findElement(By.name("isbn"));
		inputIsbn.sendKeys("");

		// タイトル入力
		WebElement inputTitle = driver.findElement(By.name("title"));
		inputTitle.sendKeys("WebアプリケーションTEST");

		// 価格入力
		WebElement inputPrice = driver.findElement(By.name("price"));
		inputPrice.sendKeys("1000");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();
	}

	// タイトルを未入力で登録した場合エラーが出るか
	public void InsertEmptyTitle() {

		// 書籍登録画面まで遷移する
		MoveInsertPage();

		// まだ登録されていないISBNを探す
		Book book;
		BookDAO bookdao = new BookDAO();
		String isbn = "";
		for (int i = 0; i < 10000; i++) {
			isbn = String.format("%5s", i).replace(" ", "0");
			book = bookdao.selectByIsbn(isbn);
			if (book.getIsbn() == null) {
				break;
			}
		}

		// ISBN入力
		WebElement inputIsbn = driver.findElement(By.name("isbn"));
		inputIsbn.sendKeys(isbn);

		// タイトルを未入力にする
		WebElement inputTitle = driver.findElement(By.name("title"));
		inputTitle.sendKeys("");

		// 価格入力
		WebElement inputPrice = driver.findElement(By.name("price"));
		inputPrice.sendKeys("1000");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();
	}

	// タイトルを未入力で登録した場合エラーが出るか
	public void InsertEmptyPrice() {

		// 書籍登録画面まで遷移する
		MoveInsertPage();

		// まだ登録されていないISBNを探す
		Book book;
		BookDAO bookdao = new BookDAO();
		String isbn = "";
		for (int i = 0; i < 10000; i++) {
			isbn = String.format("%5s", i).replace(" ", "0");
			book = bookdao.selectByIsbn(isbn);
			if (book.getIsbn() == null) {
				break;
			}
		}

		// ISBN入力
		WebElement inputIsbn = driver.findElement(By.name("isbn"));
		inputIsbn.sendKeys(isbn);

		// タイトルを未入力にする
		WebElement inputTitle = driver.findElement(By.name("title"));
		inputTitle.sendKeys("WebアプリケーションTEST");

		// 価格入力
		WebElement inputPrice = driver.findElement(By.name("price"));
		inputPrice.sendKeys("");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='登録']")).click();
	}


}
