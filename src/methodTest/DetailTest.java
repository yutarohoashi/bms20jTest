package methodTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;

import dao.BookDAO;
import bean.Book;


public class DetailTest {

	private WebDriver driver;
	private ArrayList<WebElement> elem_list;

	public DetailTest(WebDriver driver) {
		this.driver = driver;
	}

	public void MoveDetailPage() {
		try {
			driver.findElement(By.linkText("【書籍一覧】")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("【一覧表示に戻る】")).click();
		} finally {
			elem_list = (ArrayList<WebElement>)driver.findElements(By.linkText("変更"));
			elem_list.get(1).click();
		}
	}

	// 正常処理
	// 正常に書籍情報を変更できるか
	public void Detail200() {

		// 書籍変更画面まで遷移
		MoveDetailPage();

		// タイトル入力
		WebElement InputTitle = driver.findElement(By.name("title"));
		InputTitle.sendKeys("WebアプリケーションTEST：変更後");

		// 価格入力
		WebElement inputPrice = driver.findElement(By.name("price"));
		inputPrice.sendKeys("2000");

		// 登録ボタンをクリック
		driver.findElement(By.cssSelector("input[value='変更完了']")).click();
	}
}
