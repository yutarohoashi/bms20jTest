package main;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

import methodTest.InsertTest;
import methodTest.DetailTest;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// ドライバ指定
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// 開きたいサイトのURLを取得
		driver.get("http://localhost:8080/bmsweb20j/view/login.jsp");

		// ログイン
		Thread.sleep(500);
		Login(driver);

		// 登録機能をテストするクラスをインスタンス化
		InsertTest inserttest = new InsertTest(driver);

		// 正常に新しい書籍を登録できるか
		inserttest.Insert201();
		Thread.sleep(500);
		// 既に登録されたISBNで登録した場合エラー画面に遷移するか
		inserttest.InsertExistingIsbn();
		Thread.sleep(500);
		// ISBNが未入力の場合エラー画面に遷移するか
		inserttest.InsertEmptyIsbn();
		Thread.sleep(500);
		// タイトルが未入力の場合エラー画面に遷移するか
		inserttest.InsertEmptyTitle();
		Thread.sleep(500);
		// 価格が未入力の場合エラー画面に遷移するか
		inserttest.InsertEmptyPrice();


		// 書籍情報変更機能をテストするクラスをインスタンス化
		Thread.sleep(500);
		DetailTest detailtest = new DetailTest(driver);

		// 書籍を正常に変更できるか
		detailtest.Detail200();
		Thread.sleep(500);

		//driver.quit();
	}

	public static void Login(WebDriver driver) {

		// ユーザー欄とパスワード欄にkandaitと入力
		WebElement user = driver.findElement(By.name("user"));
		user.sendKeys("kandait");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("kandait");

		// ログインボタンを押す
		driver.findElement(By.cssSelector("input[value='ログイン']")).click();
	}

}
