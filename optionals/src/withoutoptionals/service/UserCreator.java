package withoutoptionals.service;

import withoutoptionals.aggregate.User;

import java.util.ArrayList;
import java.util.List;

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
        if (null == friend || "".equals(friend)) {
            throw new IllegalArgumentException(String.format("Invalid friend %s", friend));
        }
        User user = fakeDatabase.findUser();
        List<String> updatedFriends = (null != user.getFriends()) ? user.getFriends() : new ArrayList<>();
        updatedFriends = addFriend(updatedFriends, friend);
        User userWithFriendAdded = User.UserBuilder.of(user)
                .friends(updatedFriends)
                .build();
        return fakeDatabase.update(userWithFriendAdded);
    }

    public User addMultipleFriends(final List<String> friends) {
        if (null == friends) {
            throw new IllegalArgumentException("Friends is null");
        }
        User user = fakeDatabase.findUser();
        List<String> updatedFriends = (null != user.getFriends()) ? user.getFriends() : new ArrayList<>();
        updatedFriends.addAll(friends);
        User userWithFriendAdded = User.UserBuilder.of(user)
                .friends(updatedFriends)
                .build();
        return fakeDatabase.update(userWithFriendAdded);
    }

    private List<String> addFriend(List<String> friends, final String friend) {
        if (friend == null) {
            throw new IllegalArgumentException("Friend is null");
        }
        friends.add(friend);
        return friends;
    }

}
