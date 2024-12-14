package Administrator;

import Main.Config;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Set;

public class UserSession {
    private static UserSession instance;
    private String username;
    private String fullName;
    private Set<Role> roles;
    private LocalDateTime loginTime;
    private static final String SESSION_FILE = Config.getSessionPath();
    
    private UserSession() {
        loadSession();
    }
    
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    public void startSession(User user) {
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.roles = user.getRoles();
        this.loginTime = LocalDateTime.now();
        saveSession();
    }
    
    public void endSession() {
        this.username = null;
        this.fullName = null;
        this.roles = null;
        this.loginTime = null;
        deleteSession();
    }
    
    private void saveSession() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SESSION_FILE))) {
            writer.println("# Session Data - Do not edit manually");
            writer.println(username);
            writer.println(fullName);
            writer.println(roles.stream()
                    .map(Role::name)
                    .reduce((a, b) -> a + "," + b)
                    .orElse(""));
            writer.println(loginTime.toString());
        } catch (IOException e) {
            System.err.println("Error saving session: " + e.getMessage());
        }
    }
    
    private void loadSession() {
        File file = new File(SESSION_FILE);
        if (!file.exists()) {
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(SESSION_FILE))) {
            // Skip header
            reader.readLine();
            
            username = reader.readLine();
            fullName = reader.readLine();
            String rolesStr = reader.readLine();
            if (rolesStr != null && !rolesStr.isEmpty()) {
                roles = java.util.Arrays.stream(rolesStr.split(","))
                        .map(Role::valueOf)
                        .collect(java.util.stream.Collectors.toSet());
            }
            String timeStr = reader.readLine();
            if (timeStr != null) {
                loginTime = LocalDateTime.parse(timeStr);
            }
        } catch (IOException e) {
            System.err.println("Error loading session: " + e.getMessage());
        }
    }
    
    private void deleteSession() {
        File file = new File(SESSION_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
    
    // Getters
    public String getUsername() {
        return username;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public Set<Role> getRoles() {
        return roles != null ? java.util.Collections.unmodifiableSet(roles) : java.util.Collections.emptySet();
    }
    
    public Role getPrimaryRole() {
        if (roles == null || roles.isEmpty()) {
            return null;
        }
        // Return the highest priority role (ADMIN > other roles)
        return roles.contains(Role.ADMIN) ? Role.ADMIN : roles.iterator().next();
    }
    
    public LocalDateTime getLoginTime() {
        return loginTime;
    }
    
    public boolean isLoggedIn() {
        return username != null && loginTime != null;
    }
}