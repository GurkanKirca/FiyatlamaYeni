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


public class FiyatlamaMevcut {

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

        WebElement fiyatlamaTanimlama = driver.findElement(By.xpath("//*[text()[contains(.,'Fiyatlama Tanımlama')]]"));
        fiyatlamaTanimlama.click();
        Thread.sleep(5000);

        WebElement fiyatlamaKontrol = driver.findElement(new By.ByCssSelector("h1[class='page-header']"));
        String fiyatlamaKontrolText = fiyatlamaKontrol.getText();
        String expectedKontrolText = "Fiyatlama Tanımı";

        Assert.assertEquals(fiyatlamaKontrolText, expectedKontrolText);
        {
            System.out.println("Doğru Fiyatlama Ekranı");

        }

        WebElement mevcutFiyatlama = driver.findElement(new By.ByCssSelector("a[value='existing']"));
        mevcutFiyatlama.click();
        Thread.sleep(1000);

        WebElement buyutecButton = driver.findElement(new By.ByCssSelector("i[type='search']"));
        buyutecButton.click();

        WebElement fiyatlamaKodu = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div[4]/input"));
        fiyatlamaKodu.click();
        fiyatlamaKodu.sendKeys("206");

        WebElement sorgulaButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[3]/div[2]/button/span[2]"));
        sorgulaButton.click();
        Thread.sleep(1000);

        WebElement ikiyuzalti = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div/table/tbody/tr[1]/th/div/span"));
        ikiyuzalti.click();

        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        Format f = new SimpleDateFormat("dd/MM/yyyy");
        date.add(Calendar.YEAR, 1);
        System.out.println(f.format(date.getTime()));

        WebElement bitisTar = driver.findElement(new By.ByCssSelector("div[class='orion-widget-container orion-buttonedit-container orion-inline'] input[orionid='endDate']"));
        bitisTar.click();
        bitisTar.sendKeys(f.format(date.getTime()));
        Thread.sleep(1000);

        WebElement guncelleButton = driver.findElement(new By.ByCssSelector("button[orionid='btnSaveAsPricing']"));
        guncelleButton.click();

        WebElement islemNote = driver.findElement(new By.ByCssSelector("textarea[id='modal-body-notetext']"));
        islemNote.click();
        islemNote.sendKeys("Fiyatlama Güncelleme Onayı Ltf.");
        Thread.sleep(500);

        WebElement evetOnay = driver.findElement(new By.ByCssSelector("i[class='fa fa-check']"));
        evetOnay.click();
        Thread.sleep(1500);

        WebElement refNo = driver.findElement(By.xpath("//*[@id='modal-title-text']/b"));
        String getRefId = refNo.getText();
        System.out.println(getRefId);
        Thread.sleep(1500);

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        driver.get("https://orion-finance-finco-amtest.apps.dvt-fcloud.vfinans.local/");
        Thread.sleep(4000);

        WebElement onayKullanici = driver.findElement(By.id("username"));
        onayKullanici.click();
        Thread.sleep(1500);
        onayKullanici.sendKeys("30050");

        WebElement onaySifre = driver.findElement(new By.ByCssSelector(".form-control[id='password']"));
        onaySifre.click();
        onaySifre.sendKeys("1");

        WebElement onayGiris = driver.findElement(By.id("login_button"));
        onayGiris.click();
        Thread.sleep(1500);

        WebElement isAkis = driver.findElement(By.xpath("//*[text()[contains(.,'İş Akış Yönetimi')]]"));
        isAkis.click();
        Thread.sleep(1000);

        WebElement listemdeBekleyen = driver.findElement(By.xpath("//*[text()[contains(.,'Listemde Bekleyen İşler')]]"));
        listemdeBekleyen.click();
        Thread.sleep(2500);

        WebElement referNo = driver.findElement(new By.ByCssSelector("input[orionid='referans_no']"));
        referNo.click();
        referNo.sendKeys(getRefId);
        Thread.sleep(1000);

        WebElement sorgula = driver.findElement(new By.ByCssSelector("button[orionid='orion-id-008'] span[class='btntext']"));
        sorgula.click();
        Thread.sleep(1000);

        WebElement uzerineAl = driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div/div[3]/div/div/div/table/tbody/tr[1]/th/div"));
        uzerineAl.click();

        WebElement evetButton = driver.findElement(new By.ByCssSelector("button[type='button'] i[class='fa fa-check']"));
        evetButton.click();
        Thread.sleep(1500);

        WebElement onaylaButton = driver.findElement(new By.ByCssSelector("span[class='glyphicon glyphicon-ok']"));
        onaylaButton.click();

        WebElement onayEvet = driver.findElement(new By.ByCssSelector("button[type='button'] i[class='fa fa-check']"));
        onayEvet.click();
        Thread.sleep(1000);

        WebElement basariliMesaji = driver.findElement(By.xpath("//*[@id='modal-body-text']"));
        System.out.println(basariliMesaji.getText());
        Thread.sleep(1500);

        WebElement fiyatlamaNo = driver.findElement(By.xpath("//*[@id='modal-body-text']/b"));
        String fiyatlamaNoAl = fiyatlamaNo.getText();
        System.out.println(fiyatlamaNoAl);
        Thread.sleep(1500);



    }
}
