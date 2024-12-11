/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Administrator;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;

// Roles hardcoded... todo move to config file
enum Role {
    ADMIN("Admin"),
    PURCHASE_MANAGER("Purchase Manager"),
    SALES_MANAGER("Sales Manager"),
    INVENTORY_MANAGER("Inventory Manager"),
    FINANCE_MANAGER("Finance Manager");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

// Permissions hardcoded.... not sure if movable to config...
enum Permission {
    // Admin permissions
    MANAGE_USERS,
    MANAGE_ROLES,
    VIEW_ALL_REPORTS,
    
    // Purchase Manager permissions
    CREATE_PURCHASE_ORDER,
    APPROVE_PURCHASE_ORDER,
    VIEW_SUPPLIER_LIST,
    MANAGE_SUPPLIERS,
    
    // Sales Manager permissions
    CREATE_SALES_ORDER,
    MANAGE_CUSTOMERS,
    VIEW_SALES_REPORTS,
    MANAGE_PRICING,
    
    // Inventory Manager permissions
    UPDATE_INVENTORY,
    VIEW_STOCK_LEVELS,
    MANAGE_WAREHOUSES,
    CREATE_INVENTORY_REPORTS,
    
    // Finance Manager permissions
    MANAGE_ACCOUNTS,
    VIEW_FINANCIAL_REPORTS,
    PROCESS_PAYMENTS,
    MANAGE_BUDGETS
}

class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final String username;
    byte[] passwordHash;
    byte[] salt;
    private final Set<Role> roles;
    private final Map<Role, Set<Permission>> rolePermissions;
    private final String email;
    private final String fullName;
    private LocalDateTime lastLogin;
    private boolean isActive;

    public User(String username, String password, String email, String fullName) {
        this.username = username;
        this.salt = generateSalt();
        this.passwordHash = hashPassword(password, salt);
        this.email = email;
        this.fullName = fullName;
        this.roles = new HashSet<>();
        this.rolePermissions = new HashMap<>();
        this.isActive = true;
        initializeDefaultPermissions();
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    byte[] hashPassword(String password, byte[] salt) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return factory.generateSecret(spec).getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    private void initializeDefaultPermissions() {
        // Initialize default permissions for each role
        Map<Role, Set<Permission>> defaultPermissions = new HashMap<>();
        
        // Admin permissions
        Set<Permission> adminPerms = EnumSet.of(
            Permission.MANAGE_USERS,
            Permission.MANAGE_ROLES,
            Permission.VIEW_ALL_REPORTS
        );
        defaultPermissions.put(Role.ADMIN, adminPerms);
        
        // Purchase Manager permissions
        Set<Permission> purchasePerms = EnumSet.of(
            Permission.CREATE_PURCHASE_ORDER,
            Permission.APPROVE_PURCHASE_ORDER,
            Permission.VIEW_SUPPLIER_LIST,
            Permission.MANAGE_SUPPLIERS
        );
        defaultPermissions.put(Role.PURCHASE_MANAGER, purchasePerms);
        
        // Sales Manager permissions
        Set<Permission> salesPerms = EnumSet.of(
            Permission.CREATE_SALES_ORDER,
            Permission.MANAGE_CUSTOMERS,
            Permission.VIEW_SALES_REPORTS,
            Permission.MANAGE_PRICING
        );
        defaultPermissions.put(Role.SALES_MANAGER, salesPerms);
        
        // Inventory Manager permissions
        Set<Permission> inventoryPerms = EnumSet.of(
            Permission.UPDATE_INVENTORY,
            Permission.VIEW_STOCK_LEVELS,
            Permission.MANAGE_WAREHOUSES,
            Permission.CREATE_INVENTORY_REPORTS
        );
        defaultPermissions.put(Role.INVENTORY_MANAGER, inventoryPerms);
        
        // Finance Manager permissions
        Set<Permission> financePerms = EnumSet.of(
            Permission.MANAGE_ACCOUNTS,
            Permission.VIEW_FINANCIAL_REPORTS,
            Permission.PROCESS_PAYMENTS,
            Permission.MANAGE_BUDGETS
        );
        defaultPermissions.put(Role.FINANCE_MANAGER, financePerms);
        
        this.rolePermissions.putAll(defaultPermissions);
    }

    public void addRole(Role role) {
        roles.add(role);
        if (!rolePermissions.containsKey(role)) {
            rolePermissions.put(role, EnumSet.noneOf(Permission.class));
        }
    }

    public void removeRole(Role role) {
        roles.remove(role);
        rolePermissions.remove(role);
    }

    public boolean hasPermission(Permission permission) {
        return roles.stream()
            .map(rolePermissions::get)
            .filter(Objects::nonNull)
            .anyMatch(permissions -> permissions.contains(permission));
    }

    public void updateLastLogin() {
        this.lastLogin = LocalDateTime.now();
    }

    // Getters
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getFullName() { return fullName; }
    public Set<Role> getRoles() { return Collections.unmodifiableSet(roles); }
    public boolean isActive() { return isActive; }
    public LocalDateTime getLastLogin() { return lastLogin; }
}

class UserService {
    private static final String FILE_PATH = "Users.txt";
    private List<User> users;
    private final Object fileLock = new Object();

    public UserService() {
        this.users = new ArrayList<>();
        loadUsers();
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

    public List<User> getUsersByRole(Role role) {
        synchronized (fileLock) {
            return users.stream()
                .filter(u -> u.getRoles().contains(role))
                .collect(Collectors.toList());
        }
    }

    public void saveUsers() {
        synchronized (fileLock) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
                writer.println("# User Data - Do not edit manually");
                writer.println("# Format: username|passwordHash|salt|email|fullName|isActive|lastLogin|roles");
                
                for (User user : users) {
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
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to save users", e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
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
                    if (line.trim().isEmpty() || line.startsWith("#")) continue;
                    
                    String[] parts = line.split("\\|");
                    if (parts.length >= 8) {
                        // Create user with empty password as we'll set hash directly
                        User user = new User(
                            parts[0], // username
                            "", // password is not loaded
                            parts[3], // email
                            parts[4]  // fullName
                        );
                        
                        // Set password hash and salt
                        user.passwordHash = Base64.getDecoder().decode(parts[1]);
                        user.salt = Base64.getDecoder().decode(parts[2]);
                        
                        // Set roles
                        if (!parts[7].isEmpty()) {
                            Arrays.stream(parts[7].split(","))
                                .map(Role::valueOf)
                                .forEach(user::addRole);
                        }
                        
                        users.add(user);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to load users", e);
            }
        }
    }

    public boolean verifyPassword(String username, String password) {
        User user = findUserByUsername(username);
        if (user == null) return false;
        
        byte[] hashToCheck = user.hashPassword(password, user.salt);
        return Arrays.equals(hashToCheck, user.passwordHash);
    }
}
