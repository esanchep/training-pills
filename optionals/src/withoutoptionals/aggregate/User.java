package withoutoptionals.aggregate;

import withoutoptionals.value.object.Friends;
import withoutoptionals.value.object.Email;
import withoutoptionals.value.object.Password;
import withoutoptionals.value.object.Username;

import java.util.List;

public class User {

    private final Username username;
    private final Password password;
    private final Email email;
    private final Friends friends;

    private  User(final String username, final String password, final String email, final List<String> friends) {
        this.username = new Username(username);
        this.password = new Password(password);
        this.email = new Email(email);
        this.friends = new Friends(friends);
    }

    public String getUsername() {
        return username.value();
    }

    public String getPassword() {
        return password.value();
    }

    public String getEmail() {
        return email.value();
    }

    public List<String> getFriends() {
        return friends.value();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {\n" +
                "  username: " + username.value() + "\n" +
                "  password: " + password.value() + "\n" +
                "  email: " + email.value() + "\n" +
                "  friends: " + friends.toString() + "\n" +
                " }";
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String username;
        private String password;
        private String email;
        private List<String> friends;

        public static UserBuilder of(User user) {
            return new UserBuilder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .friends(user.getFriends());
        }

        public UserBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public UserBuilder friends(final List<String> friends) {
            this.friends = friends;
            return this;
        }

        public User build() {
            return new User(username, password, email, friends);
        }
    }
}
