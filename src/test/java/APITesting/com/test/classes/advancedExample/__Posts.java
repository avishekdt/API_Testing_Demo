package APITesting.com.test.classes.advancedExample;

public class __Posts {

	private String id, title, author;
	private _Info[] info;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public _Info[] getInfo(){
		return info;
	}
	
	public void setInfo(_Info[] info)
	{
		this.info = info;
	}
}
