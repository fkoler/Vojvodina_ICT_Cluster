package com.iktobuka.project_web_app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.iktobuka.project_web_app.entities.UserEntity;
import com.iktobuka.project_web_app.entities.UserEntity.UserRole;

@RestController
@RequestMapping(value = "/project/users")
public class UserController {
	public List<UserEntity> getDB() {
		List<UserEntity> users = new ArrayList<>();

		users.add(new UserEntity(1, "Lemmy", "Kilmister", "lemmykilmister", "aceOfSpades1980", "lemmy@kilmister.io",
				UserRole.ROLE_ADMIN));
		users.add(new UserEntity(2, "James", "Hetfield", "jameshetfield", "enterSandman1991", "james@hetfield.io",
				UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(3, "Dave", "Mustaine", "davemustaine", "symphonyOfDestruction1992", "dave@mustaine.io",
				UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(4, "Ozzy", "Osbourne", "ozzyosbourne", "crazyTrain1980", "ozzy@osbourne.io",
				UserRole.ROLE_CUSTOMER));
		users.add(
				new UserEntity(5, "Tony", "Iommi", "tonyiommi", "ironMan1970", "tony@iommi.io", UserRole.ROLE_SELLER));
		users.add(new UserEntity(6, "Rob", "Halford", "robhalford", "breakingTheLaw1980", "rob@halford.io",
				UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(7, "Bruce", "Dickinson", "brucedickinson", "numberOfTheBeast1982",
				"bruce@dickinson.io", UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(8, "Dimebag", "Darrell", "dimebagdarrell", "walk1993", "dimebag@darrell.io",
				UserRole.ROLE_SELLER));
		users.add(new UserEntity(9, "Tom", "Araya", "tomaraya", "rainingBlood1986", "tom@araya.io",
				UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(10, "Kerry", "King", "kerryking", "angelOfDeath1986", "kerry@king.io",
				UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(11, "Chuck", "Schuldiner", "chuckschuldiner", "spiritualHealing1990",
				"chuck@schuldiner.io", UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(12, "Tony", "Dolan", "tonydolan", "calmBeforeTheStorm1985", "tony@dolan.io",
				UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(13, "King", "Diamond", "kingdiamond", "them1988", "king@diamond.io",
				UserRole.ROLE_CUSTOMER));
		users.add(
				new UserEntity(14, "Doro", "Pesch", "doropesch", "fight1987", "doro@pesch.io", UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(15, "Ronnie", "James Dio", "ronniejamesdio", "holyDiver1983", "ronnie@dio.io",
				UserRole.ROLE_SELLER));
		users.add(new UserEntity(16, "Quorthon", "Bathory", "quorthonbathory", "underTheSignOfTheBlackMark1987",
				"quorthon@bathory.io", UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(17, "Joey", "DeMaio", "joeydemaio", "battleHymns1982", "joey@demaio.io",
				UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(18, "Dave", "Murray", "davemurray", "killers1981", "dave@murray.io",
				UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(19, "Lars", "Ulrich", "larsulrich", "rideTheLightning1984", "lars@ulrich.io",
				UserRole.ROLE_CUSTOMER));
		users.add(new UserEntity(20, "Janick", "Gers", "janickgers", "fearOfTheDark1992", "janick@gers.io",
				UserRole.ROLE_CUSTOMER));

		return users;
	}

	List<UserEntity> users = getDB();

	@GetMapping("/")
	public List<UserEntity> getUsers() {
		return users;
	}

	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable int id) {
		for (UserEntity user : users) {
			if (user.getId() == id) {
				return user;
			}
		}

		return new UserEntity();
	}

	@PostMapping("/users")
	public UserEntity addUser(@RequestBody UserEntity newUser) {
		int newId = users.size() + 1;
		newUser.setId(newId);
		newUser.setUserRole(UserRole.ROLE_CUSTOMER);
		users.add(newUser);

		return newUser;
	}

	@PutMapping("/{id}")
	public UserEntity updateUser(@PathVariable int id, @RequestBody UserEntity updatedUser) {
		for (UserEntity user : users) {
			if (user.getId() == id) {
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				user.setUsername(updatedUser.getUsername());
				user.setEmail(updatedUser.getEmail());

				return user;
			}
		}

		return null;
	}

	@PutMapping("/change/{id}/role/{role}")
	public UserEntity updateUserRole(@PathVariable int id, @PathVariable UserRole role) {
		for (UserEntity user : users) {
			if (user.getId() == id) {
				user.setUserRole(role);

				return user;
			}
		}

		return null;
	}

	@PutMapping("/changePassword/{id}")
	public UserEntity changePassword(@PathVariable int id, @RequestParam String oldPassword,
			@RequestParam String newPassword) {
		for (UserEntity user : users) {
			if (user.getId() == id) {
				if (user.getPassword().equals(oldPassword)) {
					user.setPassword(newPassword);

					return user;
				} else {
					return null;
				}
			}
		}

		return null;
	}

	@DeleteMapping("/{id}")
	public UserEntity deleteUser(@PathVariable int id) {
		for (UserEntity user : users) {
			if (user.getId() == id) {
				users.remove(user);
				System.out.println(
						"User '" + user.getFirstName() + " " + user.getLastName() + "' is successfully removed");

				return user;
			}
		}

		System.out.println("Operation failed");
		return null;
	}

	@GetMapping("/by-username/{username}")
	public UserEntity getUserByUsername(@PathVariable String username) {
		for (UserEntity user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		System.out.println("User '" + username + "' doesn't exist");

		return null;
	}
}
