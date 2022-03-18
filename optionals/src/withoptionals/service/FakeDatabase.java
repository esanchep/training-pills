package withoptionals.service;

import withoptionals.aggregate.User;

public class FakeDatabase {

    private User user;

    public User save(User user) {
        return persist(user);
    }

    public User findUser() {
        return this.user;
    }

    public User update(final User user) {
        return persist(user);
    }

    private User persist(final User user) {
        this.user = user;
        return user;
    }

}
