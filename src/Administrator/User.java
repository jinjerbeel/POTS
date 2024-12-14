package Administrator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;

// Roles enum
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

// Permissions enum
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

public class User implements Serializable {
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
        Map<Role, Set<Permission>> defaultPermissions = new HashMap<>();
        
        defaultPermissions.put(Role.ADMIN, EnumSet.of(
            Permission.MANAGE_USERS,
            Permission.MANAGE_ROLES,
            Permission.VIEW_ALL_REPORTS
        ));
        
        defaultPermissions.put(Role.PURCHASE_MANAGER, EnumSet.of(
            Permission.CREATE_PURCHASE_ORDER,
            Permission.APPROVE_PURCHASE_ORDER,
            Permission.VIEW_SUPPLIER_LIST,
            Permission.MANAGE_SUPPLIERS
        ));
        
        defaultPermissions.put(Role.SALES_MANAGER, EnumSet.of(
            Permission.CREATE_SALES_ORDER,
            Permission.MANAGE_CUSTOMERS,
            Permission.VIEW_SALES_REPORTS,
            Permission.MANAGE_PRICING
        ));
        
        defaultPermissions.put(Role.INVENTORY_MANAGER, EnumSet.of(
            Permission.UPDATE_INVENTORY,
            Permission.VIEW_STOCK_LEVELS,
            Permission.MANAGE_WAREHOUSES,
            Permission.CREATE_INVENTORY_REPORTS
        ));
        
        defaultPermissions.put(Role.FINANCE_MANAGER, EnumSet.of(
            Permission.MANAGE_ACCOUNTS,
            Permission.VIEW_FINANCIAL_REPORTS,
            Permission.PROCESS_PAYMENTS,
            Permission.MANAGE_BUDGETS
        ));
        
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