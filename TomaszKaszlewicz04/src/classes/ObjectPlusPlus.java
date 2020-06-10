package classes;


import java.io.PrintStream;
import java.util.*;

public abstract class ObjectPlusPlus extends ObjectPlus {
    
    // Stores information about all connections of this object.
    protected Hashtable<String, HashMap<Object, ObjectPlusPlus>> associations = new Hashtable<>();

	// Stores information about all connections of this object.
    private static Set<ObjectPlusPlus> allParts = new HashSet<>();
    
    public ObjectPlusPlus() {
        super();
    }

    public void addQualifiedAssociation(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier) {
        this.addAssociation(roleName, reverseRoleName, targetObject, qualifier, 2);
    }

    public void addBinaryAssociation(String roleName, String reverseRoleName, ObjectPlusPlus targetObject) {
        this.addQualifiedAssociation(roleName, reverseRoleName, targetObject, targetObject);
    }

    public void addAssociationWithAttributeCls(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, ObjectPlusPlus associationObj) {
        this.addBinaryAssociation(roleName, reverseRoleName, associationObj);
        targetObject.addBinaryAssociation(reverseRoleName, roleName, associationObj);
    }

    public void showAssociationsForRole(String roleName, PrintStream stream) throws Exception {
        HashMap<Object, ObjectPlusPlus> associations;

        if (!this.associations.containsKey(roleName)) {
            throw new Exception("No links for the role: " + roleName);
        }

        associations = this.associations.get(roleName);

        stream.println(this.getClass().getSimpleName() + " associations for role: " + roleName);
        this.printAssociationsForRole(associations, stream);
    }

    private void addAssociation(String roleName, String reverseRoleName, ObjectPlusPlus target, Object qualifier, int counter) {
        HashMap<Object, ObjectPlusPlus> associationsForRole;

        if (counter < 1) {
            return;
        }

        if (this.associations.containsKey(roleName)) {
            associationsForRole = this.associations.get(roleName);
        } else {
            associationsForRole = new HashMap<>();
            this.associations.put(roleName, associationsForRole);
        }

        if (!associationsForRole.containsKey(qualifier)) {
            associationsForRole.put(qualifier, target);
            target.addAssociation(reverseRoleName, roleName, this, this, counter - 1);
        }
    }

    public void addPart(String roleName, String reverseRoleName, ObjectPlusPlus part) throws Exception {

        if (allParts.contains(part)) {
            throw new Exception("Part already has a parent and cannot be shared");
        }

        this.addBinaryAssociation(roleName, reverseRoleName, part);
        allParts.add(part);
    }

    private void printAssociationsForRole(Map<Object, ObjectPlusPlus> associations, PrintStream stream) {
        for (Map.Entry<Object, ObjectPlusPlus> association : associations.entrySet()) {

            if (association.getKey().equals(association.getValue())) {
                stream.println("\tAssociation: " + association.getValue());
            } else {
                stream.println("\tQualifier: " + association.getKey());
                stream.println("\t\tAssociation: " + association.getValue());
            }
        }
    }
}
