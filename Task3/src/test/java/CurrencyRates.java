import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CurrencyRates extends TestManager{
    static double buyRatePrivatBank=0;
    static double buyRateUkrsibBank;
    static double buyRateAvalBank;
    static double buyRateOshchadBank;
    static double buyRateNBU;
    static double sellRatePrivatBank;
    static double sellRateUkrsibBank;
    static double sellRateAvalBank;
    static double sellRateOshchadBank;
    @Test
    /*public void ratesPrivatBank() {
        driver.get("https://next.privat24.ua/exchange-rates");
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Ваш живий Інтернет-Банк");
        buyRatePrivatBank = Double.parseDouble(driver.findElement(By.cssSelector("div[class^=root_qprFh5AA1a]:nth-of-type(2)>div[class^=rate_]:first-of-type")).getText());
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        sellRatePrivatBank = Double.parseDouble(driver.findElement(By.cssSelector("div[class^=root_qprFh5AA1a]:nth-of-type(2)>div[class^=rate_]:nth-of-type(2)")).getText());
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        System.out.println("Privat buy rate = "+buyRatePrivatBank);
        System.out.println("Privat sell rate = "+sellRatePrivatBank);
        String s = driver.findElement(By.cssSelector("div[class^=root_qprFh5AA1a]:nth-of-type(2)")).getText();
        System.out.println("sosi"+s+"sossi");
    }*/
    public void ratesPrivatBank() {
        /*int loopcount = 0;
        do {
            driver.manage().window().maximize();
            driver.get("https://www.privat24.ua");
            String title = driver.getTitle();
            Assertions.assertEquals(title, "Ваш живий Інтернет-Банк");
//        String rates = driver.findElement(By.cssSelector("div.rates_2g6teezjyl")).getText();
//        String rates = driver.findElement(By.cssSelector("div[class^=rates_]")).getText();
//        String[] buysell = rates.split("\n");
//        System.out.println("sdfdsf"+buysell[0]+"sdfd");
//        System.out.print("sdfdsf"+buysell[2]+"sdfd");
//        Якщо падає, перевірь, чи не помінялися назви класів і id
//        while (!driver.findElement(By.cssSelector("div[class^=rates_]>span:first-of-type")).isEnabled()) {
//        }
            //if (driver.findElement(By.cssSelector("div[class^=rates_]>span:first-of-type")).isEnabled())
            try {
                buyRatePrivatBank = Double.parseDouble(driver.findElement(By.cssSelector("div[class^=rates_]>span:first-of-type")).getText());
                driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
            } catch (Exception ignored) {
            }
            if (buyRatePrivatBank != 0) break;
            loopcount++;
        } while (loopcount<=10);
        sellRatePrivatBank = Double.parseDouble(driver.findElement(By.cssSelector("div[class^=rates_]>span:nth-of-type(3)")).getText());
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        System.out.println("Privat buy rate = "+buyRatePrivatBank);
        System.out.println("Privat sell rate = "+sellRatePrivatBank);
         */
        driver.get("https://www.privat24.ua");
        if (driver.getCurrentUrl().equals("https://next.privat24.ua/")) {
            driver.findElement(By.cssSelector("button.sc-bwzfXH.gjDPyc")).click();
        }
        String rates = driver.findElement(By.cssSelector("div.section-content.rate")).getText();
        String[] buysell = rates.split("/");
        buyRatePrivatBank = Double.parseDouble(buysell[0].trim());
        sellRatePrivatBank = Double.parseDouble(buysell[1].trim());
        System.out.println("Privat buy rate = "+buyRatePrivatBank);
        System.out.println("Privat sell rate = "+sellRatePrivatBank);
    }
    @Test
    public void ratesUkrsibBank() {
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Курс валют в кассах");
        //driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        //String s = driver.findElement(By.cssSelector("span[class = mobile-curr-name]:first-of-type")).getText();
        buyRateUkrsibBank = Double.parseDouble(driver.findElement(By.cssSelector("table.currency__table>tbody>tr>td:nth-of-type(2)")).getText());
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        sellRateUkrsibBank = Double.parseDouble(driver.findElement(By.cssSelector("table.currency__table>tbody>tr>td:nth-of-type(3)")).getText());
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        System.out.println("Ukrsib buy rate = "+buyRateUkrsibBank);
        System.out.println("Ukrsib sell rate = "+sellRateUkrsibBank);
    }
    @Test
    public void openAvalBank(){
        driver.get("https://www.aval.ua/ru");
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Райффайзен Банк Аваль. Официальный сайт | aval.ua");
        //driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        buyRateAvalBank = Double.parseDouble(driver.findElement(By.cssSelector("div.rate-numbers.rate-numbers-usd>span:first-of-type")).getText());
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        sellRateAvalBank = Double.parseDouble(driver.findElement(By.cssSelector("div.rate-numbers.rate-numbers-usd>span:nth-of-type(2)")).getText());
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        System.out.println("Aval buy rate = "+buyRateAvalBank);
        System.out.println("Aval sell rate = "+sellRateAvalBank);
    }
    @Test
    public void openOshchadBank(){
        driver.manage().window().maximize();
        driver.get("https://www.oschadbank.ua/ua");
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Головна | Ощадбанк");
        //driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);
        buyRateOshchadBank = Double.parseDouble(driver.findElement(By.cssSelector("strong.buy-USD")).getText());
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        sellRateOshchadBank = Double.parseDouble(driver.findElement(By.cssSelector("strong.sell-USD")).getText());
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        System.out.println("Oshchad buy rate = "+buyRateOshchadBank);
        System.out.println("Oshchad sell rate = "+sellRateOshchadBank);
    }
    @Test
    public void openNBU(){
        driver.get("http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Офіційний курс гривні щодо іноземних валют");
        //driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        String s = driver.findElement(By.cssSelector("table#exchangeRates>tbody>tr:nth-of-type(8)>td:nth-of-type(5)")).getText();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        s = s.replace(',','.');
        buyRateNBU = Double.parseDouble(s);
        System.out.println("NBU buy rate = "+buyRateNBU);
    }
    @AfterAll
    public static void Analysis() {
        System.out.println("RESULTS");
        Double averageBuyRate = (buyRateAvalBank+buyRateNBU+buyRateOshchadBank+buyRatePrivatBank+buyRateUkrsibBank)/5.0;
        Double averageSellRate = (sellRateAvalBank+sellRateOshchadBank+sellRatePrivatBank+sellRateUkrsibBank)/4.0;
        System.out.println("Average buy rate = "+averageBuyRate);
        System.out.println("Average sell rate = "+averageSellRate);
        int bankNumber=1;
        double minBuyRate = buyRateAvalBank;
        if (buyRateUkrsibBank<minBuyRate) {
            minBuyRate = buyRateUkrsibBank;
            bankNumber = 2;
        }
        else if (buyRatePrivatBank<minBuyRate) {
            minBuyRate = buyRatePrivatBank;
            bankNumber = 3;
        }
        else if (buyRateOshchadBank<minBuyRate) {
            minBuyRate = buyRateOshchadBank;
            bankNumber = 4;
        }
        else if (buyRateNBU<minBuyRate) {
            minBuyRate = buyRateNBU;
            bankNumber = 5;
        }
        System.out.println("The bank with the smallest buy rate is ");
        switch (bankNumber) {
            case 1:
                System.out.println("Aval Bank ("+buyRateAvalBank+")");
                break;
            case 2:
                System.out.println("Ukrsib Bank ("+buyRateUkrsibBank+")");
                break;
            case 3:
                System.out.println("Privat Bank ("+buyRatePrivatBank+")");
                break;
            case 4:
                System.out.println("Oschad Bank ("+buyRateOshchadBank+")");
                break;
            case 5:
                System.out.println("NBU ("+buyRateNBU+")");
                break;
            default:
                System.out.println("Avtoru 0 let");
        }
        bankNumber=1;
        double maxSellRate = sellRateAvalBank;
        if (sellRateUkrsibBank>maxSellRate) {
            maxSellRate = sellRateUkrsibBank;
            bankNumber = 2;
        }
        else if (sellRatePrivatBank>maxSellRate) {
            maxSellRate = sellRatePrivatBank;
            bankNumber = 3;
        }
        else if (sellRateOshchadBank>maxSellRate) {
            maxSellRate = sellRateOshchadBank;
            bankNumber = 4;
        }
        System.out.println("The bank with the biggest sell rate is ");
        switch (bankNumber) {
            case 1:
                System.out.println("Aval Bank ("+sellRateAvalBank+")");
                break;
            case 2:
                System.out.println("Ukrsib Bank ("+sellRateUkrsibBank+")");
                break;
            case 3:
                System.out.println("Privat Bank ("+sellRatePrivatBank+")");
                break;
            case 4:
                System.out.println("Oschad Bank ("+sellRateOshchadBank+")");
                break;
            default:
                System.out.println("Avtoru 0 let");
        }
    }
}
