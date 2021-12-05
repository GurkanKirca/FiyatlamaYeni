    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;

    import java.text.Format;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.Date;

    public class KrediBaşvuruGKTİ {
        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\GurkanOtomasyon\\Drivers\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            // Navigate to a website"
            driver.get("https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/");

            //Mazimize current window & Deleting Cookies
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            WebElement kullanici = driver.findElement(By.id("username"));
            kullanici.click();
            Thread.sleep(1500);
            kullanici.sendKeys("40000");

            WebElement sifre = driver.findElement(new By.ByCssSelector(".form-control[id='password']"));
            sifre.click();
            sifre.sendKeys("1");

            WebElement girisButon = driver.findElement(By.id("login_button"));
            girisButon.click();
            Thread.sleep(1500);

            WebElement handanKontrol = driver.findElement(By.xpath("//div[@class='info']"));
            String handanKontroltext = handanKontrol.getText();
            String expectedHANDANkontroltext = "SATIŞ PERSONELİ TEST\n" +
                    "40000";

            Assert.assertEquals(handanKontroltext, expectedHANDANkontroltext);
            {
                System.out.println("Doğru Kullanıcı");

            }

            WebElement kredi = driver.findElement(new By.ByCssSelector("a[style='cursor: pointer;'] i[class='fa fa-fa fa-address-card-o']"));
            kredi.click();
            Thread.sleep(1500);

            WebElement fiyatlama = driver.findElement(By.xpath("//*[text()[contains(.,'Başvuru')]]"));
            fiyatlama.click();
            Thread.sleep(1500);

            WebElement fiyatlamaTanimlama = driver.findElement(By.xpath("//*[text()[contains(.,'Kredi Başvurusu Giriş')]]"));
            fiyatlamaTanimlama.click();
            Thread.sleep(5500);

            WebElement basvuruKontrol = driver.findElement(new By.ByCssSelector("h1[class='page-header']"));
            String basvuruKontrolText = basvuruKontrol.getText();
            String expectedKontrolText = "Kredi Başvuru";

            Assert.assertEquals(basvuruKontrolText, expectedKontrolText);
            {
                System.out.println("Kredi Başvuru Ekranı");

            }

            WebElement musteriNoBuyutec = driver.findElement(By.xpath("//*[@id='step1']/div/div[1]/div[4]/div[3]/div[1]/div[1]/div[4]/div/i"));
            musteriNoBuyutec.click();
            Thread.sleep(1000);

            WebElement musteriNo = driver.findElement(new By.ByCssSelector("input[orionid='edCustomerCode']"));
            musteriNo.click();
            musteriNo.sendKeys("11428");

            WebElement sorgulaButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[5]/div[1]/div/div/div[3]/div/div[2]/button/span[2]"));
            sorgulaButton.click();
            Thread.sleep(1000);

            WebElement musteriNoSecme = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[5]/div[2]/div/div/div[1]/div/div/div/div/div[3]/div/div/div/table/tbody/tr[1]/th/div"));
            musteriNoSecme.click();
            Thread.sleep(1000);

            //if()

            WebElement ticaretSicilNo = driver.findElement(new By.ByCssSelector("input[orionid='tradeRegistrationNo']"));
            ticaretSicilNo.click();
            ticaretSicilNo.sendKeys("4600");






        }


    }