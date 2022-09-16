import java.io.FileReader;
import java.util.Random;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Two {

	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			String cla = UUID.randomUUID().toString();
			int leftLimit = 48;
	        int rightLimit = 122; 
	        int targetStringLength = 12;
	        Random random = new Random();
	        driver.get("https://main.edvora.me/l");
			
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("au");
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("pass");
		    
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[2]/button")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[2]/button")).click();
			driver.get("https://classrooms.edvora.me/");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@id=\"menu-button-3\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"menu-list-3-menuitem-4\"]")).click();
			String[] icon = {"/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[1]","/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[2]",
					"/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[3]","/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[4]","/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[5]"
					,"/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[6]","/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[7]"};
			
			int rnd = new Random().nextInt(icon.length);
			String rndd = icon[rnd];
			WebElement ico = driver.findElement(By.xpath(rndd));
			ico.click();
			
			driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[1]/button[2]")).click();
			
			String[] color = {"/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[1]","/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[2]",
			"/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[3]","/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[4]",
			"/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[5]","/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[6]",
			"/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[7]","/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[8]",
			"/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[9]","/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[2]/div/div[2]/div[10]"};
			int rndd1 = new Random().nextInt(color.length);
			String rnddd = color[rndd1];
			WebElement col = driver.findElement(By.xpath(rnddd));
			col.click();
	        
	        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[1]/div[2]/div[1]/div/input")).sendKeys(cla);
	        System.out.println("The Classroom Name is :"+cla);
	        String sec = random.ints(leftLimit, rightLimit + 1)
	                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	                .limit(targetStringLength)
	                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	                .toString();
	        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[1]/div[2]/div[2]/div/input")).sendKeys(sec);
	        String code = random.ints(leftLimit, rightLimit + 1)
	                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	                .limit(targetStringLength)
	                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	                .toString();
	        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/section/div[2]/div[1]/div[1]/div[2]/div[3]/div/input")).sendKeys(code);
	        System.out.println("The Section is :"+sec);
	        System.out.println("The Subject code is :"+code);
	        
	        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/section/div[2]/div[2]/div/button")).click();
	        Thread.sleep(2000);

            JSONObject obj = new JSONObject();
            obj.put("Classroom",cla);    
            obj.put("Section",sec);    
            obj.put("Joincode",code);    
            
            JSONObject jsonObjectdecode = (JSONObject)obj;
            String clname = (String)jsonObjectdecode.get("Classroom");
            String sect = (String)jsonObjectdecode.get("Section");
            String jcod = (String)jsonObjectdecode.get("Joincode");
	        System.out.println("The Section is :"+clname);
	        System.out.println("The Subject code is :"+sect);
            
	        driver.findElement(By.xpath("//*[text()='"+ cla +"']")).click();
	        Thread.sleep(3000);
	        
	        driver.findElement(By.cssSelector("button.css-1malju0:nth-child(2) > svg:nth-child(1)")).click();
	        String page = driver.getPageSource();
	        
	        WebElement cll= driver.findElement(By.xpath("/html/body/div/div/main/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div[1]/div"));
	        String clll = cll.getText();
	        WebElement secc= driver.findElement(By.xpath("/html/body/div/div/main/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div"));
	        String seccc = secc.getText();
	        WebElement ccode= driver.findElement(By.xpath("/html/body/div/div/main/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div[3]/div"));
	        String cccode = ccode.getText();
	        if (page.contains(clll) & page.contains(seccc) & page.contains(cccode) ) {
	            System.out.println("The Classroom was Available");
	}
	        else {
	        	System.out.println("Classroom Not Availble");
	        }

}
}
