package threadsafe;

public class ThreadLocalWithUserContext implements Runnable {

    private static ThreadLocal<Context> userContext
            = new ThreadLocal<>();
    private Integer userId;
    private UserRepository userRepository = new UserRepository();

    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserId(userId);
        userContext.set(new Context(userName));
        System.out.println("thread context for given userId: "
                + userId + " is: " + userContext.get());
    }

    // standard constructor
}