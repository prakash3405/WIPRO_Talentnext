import java.util.*;
public class VideoLauncher {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VideoStore v=new VideoStore();
		Scanner sc=new Scanner(System.in);
		int ch;
		boolean x=true;
		while(x) {
			System.out.println("MAIN MENU\n=========\n");
			System.out.print("1.Add Videos:\n2.Check out Video:\n3.Return Video:\n4.Receive Rating:\n5.List Inventory\n6.Exit:\n");
			System.out.print("Enter your choice(1..6):");
			ch=sc.nextInt();
			String name;
			switch(ch) {
			case 1: 
				System.out.print("Enter the name of video you want to add: ");
				name= sc.next();
				v.addVideo(name);
				System.out.println("video "+ name + " added successfully.");
				break;
					
			case 2: 
				System.out.print("Enter the name of video you want to check out: ");
				name = sc.next();
				if(v.checkVideo(name) == 0) {
					System.out.println("Video does not exist");
				}
				else if(v.checkVideo(name) == -1) {
					System.out.println("Store is empty");
				}
				else {
					v.doCheckout(name);
					System.out.println("video "+ name + " checked out successfully.");
				}
				break;
					
			case 3: 
				System.out.print("Enter the name of video you want to return: ");
				name = sc.next();
				if(v.checkVideo(name) == 0) {
					System.out.println("Video does not exist");
				}
				else if(v.checkVideo(name) == -1) {
					System.out.println("Store is empty");
				}
				else {
					v.doReturn(name);
					System.out.println("video "+ name + " returned successfully.");
				}			
				break;
				
			case 4: 
				System.out.print("Enter the name of video you want to rate: ");
					name = sc.next();
					if(v.checkVideo(name) == 0) {
						System.out.println("Video does not exist");
					}
					else if(v.checkVideo(name) == -1) {
						System.out.println("Store is empty");
					}
					else{
						System.out.print("Enter the rating for this video: ");
						int rating = sc.nextInt();
						v.receiveRating(name, rating);
						System.out.println("Rating "+rating+" has been mapped to video "+ name +".");
					}
					break;
					
			case 5: 
				v.listInventory();
				break;
				
			default:
				System.out.println("Exiting...!! Thanks for using the application.");
				x=false;
				break;
		}
	}

}
}