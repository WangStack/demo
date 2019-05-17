package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cookiewoniu {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://www.huya.com/l");
		System.out.println(driver.manage().getCookies());

		// 通过fiddler抓包工具，找到get为“https://www.woniuxy.com/login/isLogined”的URL，在右侧窗口查看该请求的Cookie，
		// 找到重要的三个参数“JSESSIONID”和“token”和 “userId”

		String cookies = "__yamid_tt1=0.7929940566529801; __yamid_new=C7F1623F0C200001CC3E1BE028102E50; hd_newui=0.4915038377583987; videoLine=3; guid=0e74abbb7327cc5a3321f4bcf5bcb17b; videoBitRate=0; SoundValue=0.71; isInLiveRoom=; h_pr=1; yyuid=410653665; username=mxysmd20; password=17B89E34A0CE14628FBB4ACD42482083F6B2EC31; osinfo=5A8194DE40EDA94AA015C4356E0E9FFAE567A5AC; udb_l=CABteHlzbWQyMHmAMFsDcAAgIqTxo1qcf9GLKq4GIc78xVq-F-BkLKNl3yXHp3xyXtHoBpyj7ajNJykojPgtb_AEiNwQS7SnAakrHNCpWX_bYJ8I1-yU5FlD-FfdV2AbiDX5VxG-NBu1OUV87C9mMYbxqDUe1vRbXNWsvuDYIY4uAAAAAAMAAAAAAAAADQAxMjQuMTI3LjY3LjUxBAA1MjE2; udb_n=cfac24cc3cd85422fd1713c1289acc995c15739915be990ea533a334bbaf3aad2aee0eda1ff5bfb69e15207657640d4f; udb_c=AMB8MVBqAAJgANYfNN-CnMgr9m4DLbCL2cVx-afdf-QLhYPqF265cUFVa1DEF75lBnsZ3R2G9fsxeNhEzgN-auZ0mzVwYEQZD0ku06DikHtrO5cE0rhNBRNXag5lR658QOsh2kwJbYiuGA==; udb_oar=5FB5C9BE1FE4FE64046DF5163A4A1CBBB33DF21EF417950E39E8016CB28620FF0CE9767FE3F7037FA4CE11B70A2DDDA47D06F44AFF31D5CD3014D3642BFFBFF572D582CBEA2F022B4E7337CD3EC231695CC70B726AC03D1F8A19AD3AEAA6F7B8F02C08CC63F7B09B52F0FF2062AFA3F370A0A22E45792FC9C012D726E2E248C73B9FD6A2E698CC1726ABAA73E29578F72082E71DD5CF0902795E5CBCC6F5AA097EF92A9BDBDACDD9F8EE9974FC079C41D7E1131A778B70F9F3FCCAE7E7168E2907DC74175F3494EC0A365161058493F54A7400A47163CFE71AAC44F9E399F5BFCEB30EA82F184BB7F3F7538A72E45F35FCBD428F9F54BDDB5EE60AE5F0AE14432C4BB0A2269CE0C2E1BF910E8891D0F5D48F0360694102EBC427FCBB4F626FB72F788EEF2D86BAB37753B35EC0EEF56457C4D8426540EAD60661B9A614323F50; __yasmid=0.7929940566529801; Hm_lvt_51700b6c722f5bb4cf39906a596ea41f=1529653083,1529904299,1529905175,1529908786; Hm_lpvt_51700b6c722f5bb4cf39906a596ea41f=1529908786; PHPSESSID=omngtur7kss5ult3s8lcf0abe4; __yaoldyyuid=410653665; _yasids=__rootsid%3DC809E59161F000013EAB181E352D1E77; h_unt=1529908784; udb_passdata=1";
		cookies.replaceAll(" ", "");
		String[] split = cookies.split(";");

		for (String string : split) {
			String[] split2 = string.split("=");
			Cookie cookie = new Cookie(split2[0], split2[1]);
			driver.manage().addCookie(cookie);
		}
		driver.navigate().refresh();
	}
}
