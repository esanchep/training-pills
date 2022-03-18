package bad.optionals.use;

public class BadOptionalsExecutor {

    public static void main(String[] args) {
        BadOptionalsUse badOptionalsUse = new BadOptionalsUse();

        badOptionalsUse.asSubstituteForNullChecks(null);

        badOptionalsUse.asListMembers();

    }
}
