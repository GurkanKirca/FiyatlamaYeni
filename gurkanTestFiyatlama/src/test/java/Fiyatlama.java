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

public class Fiyatlama {

    public static void main(String[] args) throws InterruptedException {

//SİZİN CHROME DRIVER NERDEYSE ORAYI SEÇMELİSİNİZ

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
        Thread.sleep(5500);

        WebElement fiyatlamaKontrol = driver.findElement(new By.ByCssSelector("h1[class='page-header']"));
        String fiyatlamaKontrolText = fiyatlamaKontrol.getText();
        String expectedKontrolText = "Fiyatlama Tanımı";

        Assert.assertEquals(fiyatlamaKontrolText, expectedKontrolText);
        {
            System.out.println("Doğru Fiyatlama Ekranı");

        }

        WebElement fiyatlamaadi = driver.findElement(new By.ByCssSelector("div[class='orion-widget-container orion-inline'] input[orionid='name']"));
        fiyatlamaadi.click();
        Thread.sleep(1500);
        fiyatlamaadi.sendKeys("GRKN OTOMASYON");

        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        Format f = new SimpleDateFormat("dd/MM/yyyy");
        date.add(Calendar.YEAR, 1);
        System.out.println(f.format(date.getTime()));

        WebElement bitisTar = driver.findElement(new By.ByCssSelector("div[class='orion-widget-container orion-buttonedit-container orion-inline'] input[orionid='endDate']"));
        bitisTar.click();
        bitisTar.sendKeys(f.format(date.getTime()));

        //Eşit Taksitli Ödeme 1, Esnek Ödeme 2
        WebElement odemeTipi = driver.findElement(new By.ByCssSelector("select[orionid='paymentType'] option[value='1']"));
        odemeTipi.click();

        //haftada 01, ayda 02, yılda 03
        WebElement periyodTipi = driver.findElement(new By.ByCssSelector("select[orionid='maturityPeriodType'] option[value='03']"));
        periyodTipi.click();

        WebElement dosyaMasrafi = driver.findElement(new By.ByCssSelector("input[orionid='fileExpense']"));
        dosyaMasrafi.click();
        dosyaMasrafi.sendKeys("25");

        //tutar 0, oran 1
        WebElement dosyaMasrafiOran = driver.findElement(new By.ByCssSelector("select[orionid='fileExpenseType'] option[value='1']"));
        dosyaMasrafiOran.click();

        WebElement aciklama = driver.findElement(new By.ByCssSelector("textarea[orionid='description']"));
        aciklama.click();
        aciklama.sendKeys("GRKN OTOMASYON FIYATLAMA");

        WebElement urunAnaGrubu = driver.findElement(new By.ByCssSelector("select[orionid='productGroupCode'] option[value='01']"));
        urunAnaGrubu.click();
        Thread.sleep(500);

        WebElement urun = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div[2]/div/div[2]/div[4]/div[1]/div[8]"));
        urun.click();
        Thread.sleep(500);

        WebElement urunTumuSec = driver.findElement(new By.ByCssSelector("i[class='fa fa-check-square-o']"));
        urunTumuSec.click();

        WebElement satisKanali = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div[2]/div/div[2]/div[4]/div[1]/div[12]"));
        satisKanali.click();
        Thread.sleep(500);

        WebElement satisKanalTumuSec = driver.findElement(new By.ByCssSelector("i[class='fa fa-check-square-o']"));
        satisKanalTumuSec.click();

        WebElement musteriTipi = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div[2]/div/div[2]/div[4]/div[2]/div[4]"));
        musteriTipi.click();
        Thread.sleep(500);

        WebElement musteriTipiTumuSec = driver.findElement(new By.ByCssSelector("i[class='fa fa-check-square-o']"));
        musteriTipiTumuSec.click();

        WebElement basvuruTipi = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div[2]/div/div[2]/div[4]/div[2]/div[8]"));
        basvuruTipi.click();
        Thread.sleep(500);

        WebElement basvuruTipiTumuSec = driver.findElement(new By.ByCssSelector("i[class='fa fa-check-square-o']"));
        basvuruTipiTumuSec.click();

        WebElement kkdfMuafiyet = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div[2]/div/div[2]/div[4]/div[2]/div[12]"));
        kkdfMuafiyet.click();
        Thread.sleep(500);

        WebElement kkdfMuafiyetTumu = driver.findElement(new By.ByCssSelector("i[class='fa fa-check-square-o']"));
        kkdfMuafiyetTumu.click();

        WebElement minVadeAraligi = driver.findElement(new By.ByCssSelector("input[orionid='minMaturity']"));
        minVadeAraligi.click();
        minVadeAraligi.sendKeys("1");

        WebElement maxVadeAraligi = driver.findElement(new By.ByCssSelector("input[orionid='maxMaturity']"));
        maxVadeAraligi.click();
        maxVadeAraligi.sendKeys("50");
        Thread.sleep(500);

        WebElement minTutarAraligi = driver.findElement(new By.ByCssSelector("input[orionid='minAmount']"));
        minTutarAraligi.click();
        minTutarAraligi.sendKeys("1");

        WebElement maxTutarAraligi = driver.findElement(new By.ByCssSelector("input[orionid='maxAmount']"));
        maxTutarAraligi.click();
        maxTutarAraligi.sendKeys("1000000");
        Thread.sleep(500);

        WebElement sozlesmeMarji = driver.findElement(new By.ByCssSelector("input[orionid='contractInterestRate']"));
        sozlesmeMarji.click();
        sozlesmeMarji.sendKeys("50");

        WebElement fiyatKosullariEkle = driver.findElement(new By.ByCssSelector("button[orionid='btnAddPricingCondition']"));
        fiyatKosullariEkle.click();
        Thread.sleep(500);

        WebElement kaydetButton = driver.findElement(new By.ByCssSelector("button[orionid='btnSavePricing']"));
        kaydetButton.click();

        WebElement islemNote = driver.findElement(new By.ByCssSelector("textarea[id='modal-body-notetext']"));
        islemNote.click();
        islemNote.sendKeys("Fiyatlama Onayi Ltf.");
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