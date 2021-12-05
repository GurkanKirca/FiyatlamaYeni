import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class FiyatlamaGozlem {


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
        kullanici.sendKeys("30090");

        WebElement sifre = driver.findElement(new By.ByCssSelector(".form-control[id='password']"));
        sifre.click();
        sifre.sendKeys("1");

        WebElement girisButon = driver.findElement(By.id("login_button"));
        girisButon.click();
        Thread.sleep(1500);

        WebElement handanKontrol = driver.findElement(By.xpath("//div[@class='info']"));
        String handanKontroltext = handanKontrol.getText();
        String expectedHANDANkontroltext = "HANDAN KAYA TEST\n" +
                "30090";

        Assert.assertEquals(handanKontroltext, expectedHANDANkontroltext);
        {
            System.out.println("Doğru Kullanıcı");

        }

        WebElement kredi = driver.findElement(new By.ByCssSelector("a[style='cursor: pointer;'] i[class='fa fa-fa fa-address-card-o']"));
        kredi.click();
        Thread.sleep(1500);

        WebElement fiyatlama = driver.findElement(By.xpath("//*[text()[contains(.,'Fiyatlama')]]"));
        fiyatlama.click();
        Thread.sleep(1500);

        WebElement fiyatlamaTanimlama = driver.findElement(By.xpath("//*[text()[contains(.,'Fiyatlama Gözlem')]]"));
        fiyatlamaTanimlama.click();
        Thread.sleep(5000);

        WebElement fiyatlamaKontrol = driver.findElement(new By.ByCssSelector("h1[class='page-header']"));
        String fiyatlamaKontrolText = fiyatlamaKontrol.getText();
        String expectedKontrolText = "Fiyatlama Gözlem";

        Assert.assertEquals(fiyatlamaKontrolText, expectedKontrolText);
        {
            System.out.println("Doğru Fiyatlama Ekranı");

        }

        WebElement fiyatlamaKodu = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[4]/input"));
        fiyatlamaKodu.click();
        fiyatlamaKodu.sendKeys("206");
        Thread.sleep(1500);

        WebElement fiyatlamalariListele = driver.findElement(new By.ByCssSelector("button[orionid='btnSearchAndListPricings']"));
        fiyatlamalariListele.click();
        Thread.sleep(1500);

        WebElement sonuclarTablo = driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div/div[2]/div/div[4]/div/div/div/div/div/div[3]/div/div/div/table/tbody/tr[1]/th"));
        sonuclarTablo.click();
        Thread.sleep(1500);

        WebElement fiyatlamaDetaylari = driver.findElement(new By.ByCssSelector("h5[class='orionrpm-accordion-title open']"));
        String fiyatlamaDetaylariText = fiyatlamaDetaylari.getText();
        String expectedDetaylariText = "Fiyatlama Detayları";

        Assert.assertEquals(fiyatlamaDetaylariText, expectedDetaylariText);
        {
            System.out.println("Fiyatlama Detayları akordiyonu");

        }

    }
}
