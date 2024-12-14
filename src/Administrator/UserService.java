package Administrator;

import Main.Config;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Base64;

public class UserService {
    private static final String FILE_PATH = Config.getUserPath();
    private List<User> users;
    private final Object fileLock = new Object();

    public UserService() {
        this.users = new ArrayList<>();
        loadUsers();
        // Add default admin user if no users exist
        if (users.isEmpty()) {
            createDefaultAdmin();
        }
    }

    private void createDefaultAdmin() {
        try {
            User admin = new User("AM001", "admin123", "Jinan@POTS.biz.my", "System Administrator");
            admin.addRole(Role.ADMIN);
            users.add(admin);
            saveUsers();
            System.out.println("Created default admin user");
        } catch (Exception e) {
            System.err.println("Failed to create default admin: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        synchronized (fileLock) {
            if (findUserByUsername(user.getUsername()) != null) {
                throw new IllegalArgumentException("Username already exists");
            }
            users.add(user);
            saveUsers();
        }
    }

    public User findUserByUsername(String username) {
        synchronized (fileLock) {
            return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
        }
    }

    public List<User> getAllUsers() {
        synchronized (fileLock) {
            return new ArrayList<>(users);
        }
    }

    public List<User> getUsersByRole(Role role) {
        synchronized (fileLock) {
            return users.stream()
                .filter(u -> u.getRoles().contains(role))
                .collect(Collectors.toList());
        }
    }

    public void updateUser(User user) {
        synchronized (fileLock) {
            User existingUser = findUserByUsername(user.getUsername());
            if (existingUser == null) {
                throw new IllegalArgumentException("User does not exist");
            }
            users.remove(existingUser);
            users.add(user);
            saveUsers();
        }
    }

    public void deleteUser(String username) {
        synchronized (fileLock) {
            users.removeIf(u -> u.getUsername().equals(username));
            saveUsers();
        }
    }

    public void saveUsers() {
        synchronized (fileLock) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
                writer.println("# User Data - Do not edit manually");
                writer.println("# Format: username|passwordHash|salt|email|fullName|isActive|lastLogin|roles");
                
                for (User user : users) {
                    try {
                        StringBuilder line = new StringBuilder();
                        line.append(user.getUsername()).append("|");
                        line.append(Base64.getEncoder().encodeToString(user.passwordHash)).append("|");
                        line.append(Base64.getEncoder().encodeToString(user.salt)).append("|");
                        line.append(user.getEmail()).append("|");
                        line.append(user.getFullName()).append("|");
                        line.append(user.isActive()).append("|");
                        line.append(user.getLastLogin() != null ? user.getLastLogin().toString() : "null").append("|");
                        line.append(user.getRoles().stream()
                            .map(Role::name)
                            .collect(Collectors.joining(",")));
                        writer.println(line);
                    } catch (Exception e) {
                        System.err.println("Error saving user: " + user.getUsername());
                        e.printStackTrace();
                    }
                }
                System.out.println("Successfully saved " + users.size() + " users to file");
            } catch (IOException e) {
                System.err.println("Failed to save users to file: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException("Failed to save users", e);
            }
        }
    }

    private void loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("Users file not found. Will create new file.");
            users = new ArrayList<>();
            return;
        }

        synchronized (fileLock) {
            users = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;
                // Skip header lines
                reader.readLine(); 
                reader.readLine();
                
                while ((line = reader.readLine()) != null) {
                    try {
                        if (line.trim().isEmpty() || line.startsWith("#")) continue;
                        
                        String[] parts = line.split("\\|");
                        if (parts.length >= 8) {
                            User user = new User(
                                parts[0], // username
                                "", // password is not loaded
                                parts[3], // email
                                parts[4]  // fullName
                            );
                            
                            // Set password hash and salt
                            user.passwordHash = Base64.getDecoder().decode(parts[1]);
                            user.salt = Base64.getDecoder().decode(parts[2]);
                            
                            // Set active status
                            if (parts.length > 5) {
                                // field exists but might be empty
                                try {
                                    boolean isActive = Boolean.parseBoolean(parts[5]);
                                    if (!isActive) {
                                        // set user as inactive - method should be added to User class
                                        user.setActive(false);
                                    }
                                } catch (Exception e) {
                                    System.err.println("Error parsing active status for user: " + user.getUsername());
                                }
                            }
                            
                            // Set roles
                            if (parts.length > 7 && !parts[7].isEmpty()) {
                                Arrays.stream(parts[7].split(","))
                                    .map(String::trim)
                                    .filter(s -> !s.isEmpty())
                                    .map(roleName -> {
                                        try {
                                            return Role.valueOf(roleName);
                                        } catch (IllegalArgumentException e) {
                                            System.err.println("Invalid role found: " + roleName);
                                            return null;
                                        }
                                    })
                                    .filter(Objects::nonNull)
                                    .forEach(user::addRole);
                            }
                            
                            users.add(user);
                            System.out.println("Loaded user: " + user.getUsername());
                        }
                    } catch (Exception e) {
                        System.err.println("Error parsing user line: " + line);
                        e.printStackTrace();
                    }
                }
                System.out.println("Successfully loaded " + users.size() + " users from file");
            } catch (IOException e) {
                System.err.println("Failed to load users file: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException("Failed to load users", e);
            }
        }
    }

    public boolean verifyPassword(String username, String password) {
        try {
            User user = findUserByUsername(username);
            if (user == null) {
                System.out.println("User not found: " + username);
                return false;
            }
            
            if (!user.isActive()) {
                System.out.println("User is inactive: " + username);
                return false;
            }
            
            byte[] hashToCheck = user.hashPassword(password, user.salt);
            boolean matches = Arrays.equals(hashToCheck, user.passwordHash);
            System.out.println("Password verification for user " + username + ": " + (matches ? "successful" : "failed"));
            return matches;
        } catch (Exception e) {
            System.err.println("Error during password verification: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        synchronized (fileLock) {
            try {
                User user = findUserByUsername(username);
                if (user == null) return false;
                
                // Verify old password
                if (!verifyPassword(username, oldPassword)) return false;
                
                // Update password
                user.salt = user.generateSalt();
                user.passwordHash = user.hashPassword(newPassword, user.salt);
                saveUsers();
                return true;
            } catch (Exception e) {
                System.err.println("Error changing password: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }
}