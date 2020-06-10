package classes;

import Exceptions.XORException;
import Exceptions.SubsetException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class ObjectPlus4 extends ObjectPlusPlus {

    protected List<String> rolesXOR = new LinkedList<>();

    public void addXORRole(String roleName) {
        rolesXOR.add(roleName);
    }

    public boolean relationExists(String roleName, ObjectPlusPlus target) throws SubsetException {
        HashMap<Object, ObjectPlusPlus> objectAssociations;

        if(!associations.containsKey(roleName)) {
            throw new SubsetException(roleName);
        }

        objectAssociations = associations.get(roleName);
        return objectAssociations.containsKey(target);
    }

    public void addAssociationSubset(String roleName, String reverseRoleName, String parentRoleName, ObjectPlusPlus target) throws SubsetException {
        if(relationExists(parentRoleName, target)) {
            addBinaryAssociation(roleName, reverseRoleName, target);
        } else {
            throw new SubsetException(roleName);
        }

    }

    public void addAssociationXOR(String roleName, String reverseRoleName, ObjectPlusPlus target) throws XORException {
        if(rolesXOR.contains(roleName)) {
            for(String role : rolesXOR) {
                if (this.associations.keySet().contains(role)) {
                    throw new XORException("Role " + role + " has XOR constraint and association with " + role + " already exist");
                }
            }
        }

        addBinaryAssociation(roleName, reverseRoleName, target);
    }
}
