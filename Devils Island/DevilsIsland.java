import java.io.*;
import java.util.Scanner;
public class DevilsIsland
{
	static Scanner sc = new Scanner(System.in);
	static int man = 3,devil = 3;      // Man and Devil at Island 1
	static int Man = 0,Devil = 0;      // Man and Devil at Island 2
	static char ch;
	static byte input;
	static byte choice;
	public static void main(String[] args)
	{
		start();
	}
	static void start()
	{
		System.out.print("\n\n\tDEVILS LAKE\n1. Play\n2. Instructions\n3. Exit\n");
		gameDisplay();      //main display
	}
	static void gameDisplay()
	{
		boolean b = true;
		System.out.print("\nEnter your choice: ");
		choice = sc.nextByte();
		switch(choice)
		{
			case 1: islandMan1();
					break;
			case 2: instructions();
					break;
			case 3: System.exit(0);
					break;
			default: System.out.print("INVALID CHOICE!!!\n");
					b = false;
		}
		if(!b)
			gameDisplay();
	}
	static void islandMan1()				// Island 1 man
	{
		displayStats();
		if(man==0)
			islandDevil1();
		else
		{
			System.out.print("How many MAN   will come from ISLAND 1   : ");
			input = sc.nextByte();
			if(input>=0 && input<=2)
			{
				if(input<=man)
				{
					man=man-input;      //Island 1 man
					Man=Man+input;		//Island 2 man
				}
				else
				{
					System.out.println("Enter valid number of men at Island 1 !!!!");
					islandMan1();
				}
			}
			else
			{
				System.out.println("Enter value between 0 and 2 !!!!\n\n");
				islandMan1();
			}
			islandDevil1();
		}
	}
	static void islandDevil1()      //Island 1 Devil
	{
		if(input!=2)	// if(input==2) then, No need to ask for devil as Man = 2
		{
			System.out.print("How many DEVIL will come from ISLAND 1   : ");
			input = sc.nextByte();
			if(input>=0 && input<=2)
			{
				if(input<=devil)
				{
					devil=devil-input;		//Island 1 devil
					Devil=Devil+input;		//Island 2 devil
				}
				else
				{
					System.out.println("Enter valid number of devil at Island 1 !!!!");
					islandDevil1();
				}
			}
			else
			{
				System.out.print("Enter value between 0 and 2 !!!!\n\n");;
				islandDevil1();
			}
		}	
		checkStatus();
		islandMan2();
	}
	
	static void islandMan2()				// Island 2 Man
	{
		displayStats();
		if(Man==0)
			islandDevil2();
		else
		{
			System.out.print("\nHow many MAN   will come from ISLAND 2   : ");
			input = sc.nextByte();
			if(input>=0 && input<=2)
			{
				if(input<=Man)
				{
					Man = Man-input;
					man = man+input;
				}
				else
				{
					System.out.println("Enter valid number of men at Island 2 !!!!");
					islandMan2();
				}
			}
			else
			{
				System.out.print("Enter value between 0 and 2 !!!!\n\n");
				islandMan2();
			}
			islandDevil2();
		}
	}
	static void islandDevil2()     //Island 2 Devil
	{
		if(input==0 && Devil==1)	//If no man wants to go from island 2 and only 1 devil is on the island
		{
			Devil=Devil-1;
			devil=devil+1;
		}	
		else
		{
			System.out.print("How many DEVIL will come from ISLAND 2   : ");
			input = sc.nextByte();
			if(input>=0 && input<=2)
			{
				if(input<=Devil)
				{
					Devil=Devil-input;
					devil=devil+input;
				}
				else
				{
					System.out.println("Enter valid number of devil at Island 2 !!!!");
					islandDevil2();
				}
			}
			else
			{
				System.out.print("Enter value between 0 and 2 !!!!\n\n");
				islandDevil2();
			}
		}
		checkStatus();
		islandMan1();
	}
	static void instructions()
	{
		System.out.print("\n\tINSTRUCTIONS\n");
		System.out.print("\n1. The objective is to bring all men and devils to the island 1.");
		System.out.print("\n2. Only two passengers are allowed to be in the boat at a time.");
		System.out.print("\n3. There should be atleast one passenger to operate the boat.");
		System.out.print("\n4. Note that the number of devils should not exceed the number of men at either    side.\n");
		gameDisplay();
	}
	static void playAgain()
	{
		System.out.print("\n\nWant to play game again (y/n): ");
		ch = sc.next().charAt(0);
		if(ch=='y')
		{	
			man = 3;
			devil = 3;
			Man = 0;
			Devil = 0;
			start();
		}
		else
		{
			System.exit(0);
		}
	}
	static void displayStats()
	{
		System.out.println("\n\nIsland 1:\tIsland 2:\nMan  : "+man+"\tMan  : "+Man+"\nDevil: "+devil+"\tDevil: "+Devil+"\n");
	}
	static void checkStatus()
	{
		if((devil>man && man!=0) || (Devil>Man && Man!=0))
		{
			displayStats();
			System.out.println("\n\n*^*^*^*^*^*^*^*^*^ GAME OVER ^*^*^*^**^*^*^*^*^*^*^");
			playAgain();
		}
		else
		{
			if(Devil==3 && Man==3)
			{
				displayStats();
				System.out.println("\n\n*^*^*^*^*^*^*^*^*^ YOU WON THE GAME ^*^*^*^**^*^*^*^*^*^*^");
				playAgain();
			}
		}
	}
}