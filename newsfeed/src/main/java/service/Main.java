package service;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.util.DigestUtils;

import dao.UserDao;
import manager.User;

/*Main class*/
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the command...");
		String command = sc.nextLine();;
		while (!command.equalsIgnoreCase("x") && !command.equalsIgnoreCase("exit")) {
			
			switch (command) {
			case "signup":
				User user = signup();
				UserDao.insertUserToDB(user);
				System.out.println("You registered successfully...");
				System.out.println();
				break;

			case "login":
				boolean check = loginCredential();
				if (check) {
					System.out.println("User login successfull");
				} else {
					System.out.println("Login unsuccessfull. Please check your credentials..");
				}
				break;
			default:
				System.out.println("Incorrect command. Only allowed commands are [signup], [login] and [exit]");

			}
			System.out.println();
			System.out.println("Please enter the command...");
			command = sc.nextLine();
		}
		sc.close();
	}

	private static User signup() {
		Scanner sc = new Scanner(System.in);
		User us = new User();
		us.setUserId(UUID.randomUUID().toString());
		System.out.println("Enter Name");

		us.setName(sc.nextLine());
		System.out.println("Enter ContactNo.");

		us.setContactNum(sc.nextLine());

		System.out.println("Enter Email");
		us.setEmail(sc.nextLine());

		System.out.println("Enter UserLogin");
		String user = sc.nextLine();
		while (UserDao.userExits(user)) {
			System.out.println("Please choose a different username. This is already taken...");
			user = sc.nextLine();
		}
		us.setLogOnName(user);

		System.out.println("Enter Password");
		String p = sc.nextLine();
		us.setPassword(DigestUtils.md5DigestAsHex(p.getBytes()));

		System.out.println("Enter Address");
		us.setAddress(sc.nextLine());
		return us;

	}

	private static boolean loginCredential() {
		Scanner sc1 = new Scanner(System.in);
		String currentLogInUser;
		String currentUserId = "";
		boolean flag = false;
		System.out.println("Enter User LogIn Id");

		currentLogInUser = sc1.nextLine();
		System.out.println("Enter Password");

		String Password1 = sc1.nextLine();
		String currentPassword = DigestUtils.md5DigestAsHex(Password1.getBytes());
		return UserDao.checkCredentials(currentLogInUser, currentPassword);

	}
}
