package withoutoptionals;

import withoutoptionals.aggregate.User;
import withoutoptionals.service.UserCreator;

import java.util.Arrays;

public class WithoutOptionals {

    public static void main(String[] args) {
        UserCreator userCreator = new UserCreator();

        // CREATE USER
        User userCreated = userCreator.createUser("theUsername", "thePassword", "theEmail");
        System.out.println("User created: " + userCreated.toString());

        // ADD FRIEND
        User userWithFriendAdded = userCreator.addSingleFriend("theFirstFriend");
        System.out.println("Added friend to user: " + userWithFriendAdded.toString());

        // ADD MULTIPLE FRIENDS
        User userWithLotsOfFriends = userCreator.addMultipleFriends(Arrays.asList("Coco Jambo", "Solaire de Astora", "Pingu"));
        System.out.println("Added multiple friends to user: " + userWithLotsOfFriends.toString());
    }

}
