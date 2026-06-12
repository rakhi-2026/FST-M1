package activities;

	public class Activity5 {
	
		public static void main(String[] args) {
			MyBook newNovel = new MyBook();
			newNovel.setTitle("FeluDa");
			System.out.println("The title is: " + newNovel.getTitle());
	
		}
	
	}

	abstract class Book {
		
		String title;
		public abstract void setTitle(String s);
		
		public String getTitle() {
			return title;
		}
	
	}

	 class MyBook extends Book{
		
		public static void main (String[] args) {
			MyBook newNovel = new MyBook();
			newNovel.setTitle("FeluDa");
			System.out.println("The title is: " + newNovel.getTitle());
			
		}
		public void setTitle(String s) {
		    title = s;
		}
		
	}

