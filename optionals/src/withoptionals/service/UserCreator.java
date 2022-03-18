package withoptionals.service;

import withoptionals.aggregate.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserCreator {

    private final FakeDatabase fakeDatabase;

    public UserCreator() {
        fakeDatabase = new FakeDatabase();
    }

    public User createUser(final String username, final String password, final String email) {
        final User user = User.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
        return fakeDatabase.save(user);
    }

    public User addSingleFriend(final String friend) {
        User user = fakeDatabase.findUser();
        List<String> updatedFriends = addFriend(user.getFriends(), friend);
        User userWithFriendAdded = User.UserBuilder.of(user)
                .friends(updatedFriends)
                .build();
        return fakeDatabase.update(userWithFriendAdded);
    }

    public User addMultipleFriends(final List<String> friends) {
        List<String> definedFriends = Optional.of(friends)
                .orElseThrow(() -> new IllegalArgumentException("Friends is null"));
        User user = fakeDatabase.findUser();
        List<String> updatedFriends = user.getFriends();
        updatedFriends.addAll(definedFriends);
        User userWithFriendAdded = User.UserBuilder.of(user)
                .friends(updatedFriends)
                .build();
        return fakeDatabase.update(userWithFriendAdded);
    }

    private List<String> addFriend(List<String> friends, final String friend) {
        friends.add(Optional.of(friend)
                .orElseThrow(() -> new IllegalArgumentException("Friend is null")));
        return friends;
    }

}
